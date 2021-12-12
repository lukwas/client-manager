package pl.lukwas.clientmanager.config;


import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import javax.validation.ClockProvider;
import java.time.Clock;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Component
@Primary
public class TestClockProvider implements ClockProvider {

    private Clock clock;

    public TestClockProvider() {
        this.clock = Clock.systemUTC();
    }

    public void setClock(LocalDateTime dateTime) {
        clock = Clock.fixed(dateTime.atZone(ZoneOffset.systemDefault()).toInstant(), ZoneOffset.systemDefault());
    }

    @Override
    public Clock getClock() {
        return clock;
    }


}
