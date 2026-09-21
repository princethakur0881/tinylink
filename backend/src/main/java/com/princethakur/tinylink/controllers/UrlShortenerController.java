package com.princethakur.tinylink.controllers;

import com.princethakur.tinylink.dto.ShortenUrlRequest;
import com.princethakur.tinylink.dto.ShortenUrlResponse;
import com.princethakur.tinylink.dto.UrlAnalyticsResponse;
import com.princethakur.tinylink.dto.UrlStatsResponse;
import com.princethakur.tinylink.services.RateLimitService;
import com.princethakur.tinylink.services.UrlShortenerService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.lang.ref.ReferenceQueue;
import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("/api")
@Slf4j
@RequiredArgsConstructor
public class UrlShortenerController {

    private final UrlShortenerService urlShortenerService;
    private final RateLimitService rateLimitService;


    @PostMapping("/shorten")
    public ResponseEntity<?> shortenUrl(@Valid @RequestBody ShortenUrlRequest request, HttpServletRequest httpRequest) {

        String clientIp = getClientIp(httpRequest);
        if (!rateLimitService.isAllowed(clientIp)) {
            return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS)
                    .body(Map.of(
                            "error", "Rate Limit exceeded",
                            "remainingRequest", rateLimitService.getRemainingRequests(clientIp),
                            "timeUntilReset", rateLimitService.getTimeUntilReset(clientIp)
                    ));
        }
        try {
            ShortenUrlResponse response = urlShortenerService.shortenUrl(request, clientIp);
            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of("error", "Internal server error"));
        }

    }

    @GetMapping("/{shortCode}")
    public ResponseEntity<Void> redirectToUrl(@PathVariable String shortCode, HttpServletRequest request, HttpServletResponse response) {
        String clintIp = getClientIp(request);
        String userAgent = request.getHeader("User-Agent");
        String referrer = request.getHeader("Referrer");


        Optional<String> originalUrl = urlShortenerService.getOriginalUrl(shortCode);

        if (originalUrl.isPresent()) {
            urlShortenerService.recordClick(shortCode, clintIp, userAgent, referrer);
            response.setHeader("location", originalUrl.get());
            return ResponseEntity.status(HttpStatus.FOUND).build();

        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @GetMapping("/stats/{shortCode}")
    public ResponseEntity<?> getUrlStats(@PathVariable String shortCode) {
        Optional<UrlStatsResponse> stats = urlShortenerService.getUrlStats(shortCode);

        if (stats.isPresent()) {
            return ResponseEntity.ok(stats.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("Error", "Short code not Found"));
        }
    }

    @GetMapping("/analytics/{shortCode}")
    public ResponseEntity<?> getUrlAnalytics(@PathVariable String shortCode) {
        Optional<UrlAnalyticsResponse> analytics = urlShortenerService.getUrlAnalytics(shortCode);

        if (analytics.isPresent()) {
            return ResponseEntity.ok(analytics.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("Error", "Short code not found"));
        }
    }

    @DeleteMapping("/{shortCode}")
    public ResponseEntity<?> deleteUrl(@PathVariable String shortCode) {
        boolean deleted = urlShortenerService.deleteUrl(shortCode);

        if (deleted) {
            return ResponseEntity.ok(Map.of("Message", "URL deleted succesfully"));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("Error", "Short code not found"));
        }
    }


    private String getClientIp(HttpServletRequest httpRequest) {
        String xForwardedFor = httpRequest.getHeader("X-Forwarded_for");
        if (xForwardedFor != null && !xForwardedFor.isEmpty()) {
            return xForwardedFor.split(",")[0].trim();
        }
        String xrealIp = httpRequest.getHeader("X-Real-IP");
        if (xrealIp != null && !xrealIp.isEmpty()) {
            return xrealIp;
        }
        return httpRequest.getRemoteAddr();
    }
}
