package com.princethakur.tinylink.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShortenUrlRequest {
    @NotBlank(message = "Original URL is required")
    @Pattern(regexp = "^https?://.*", message = "URL must be valid ,its not valid")
    private String originalUrl;

    private String customAlias;

    private LocalDateTime expiresAt;
}
