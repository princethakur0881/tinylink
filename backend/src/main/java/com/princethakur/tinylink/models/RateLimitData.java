package com.princethakur.tinylink.models;


import lombok.*;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RateLimitData {

    private int minuteCount;
    private int hourCount;


    //10:00 --> 10:01:30
    private LocalDateTime minuteWindowStart;
    private LocalDateTime hourWindowStart;

}
