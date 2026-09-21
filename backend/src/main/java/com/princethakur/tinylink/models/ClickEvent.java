package com.princethakur.tinylink.models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClickEvent {
    private LocalDateTime timeStamp;
    private String ipAdrress;
    private String userAgent;
    private String referrer;
    private String country;
    private String city;

}
