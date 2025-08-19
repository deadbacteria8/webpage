package com.domain.clock;

import org.springframework.stereotype.Component;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;


@Component
public class SystemTime {

    private Clock clock;
    private final ZoneId STOCKHOLM_ZONE = ZoneId.of("Europe/Stockholm");

    public SystemTime(Clock clock) {
        this.clock = clock;
    }

    public Instant now() {
        return Instant.now(clock);
    }


    public ZonedDateTime stockholmNow() {
        return ZonedDateTime.now(clock).withZoneSameInstant(STOCKHOLM_ZONE);
    }
}
