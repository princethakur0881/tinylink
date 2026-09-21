package com.princethakur.tinylink.config;


import com.princethakur.tinylink.services.UrlShortenerService;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class CleanUpScheduler {
    private final UrlShortenerService urlShortenerService;


    @Scheduled(fixedRateString = "#{${tinylink.cache.cleanup.interval-minutes} * 60 * 100}")
    public void setCleanupExpiredUrls() {
        try {
            log.debug("Runnig scheduled cleanup of expired URLs");
            urlShortenerService.cleanupExpiredUrls();
        } catch (Exception e) {
            log.warn("Error during scheduled cleanup", e);
        }
    }
}
