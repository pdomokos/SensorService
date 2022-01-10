package com.example.SensorService.services.events;

import com.example.SensorService.domain.Temp;
import lombok.Builder;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

import java.io.Serial;

@Getter
public class TempAlarmEvent extends ApplicationEvent {

    @Serial
    private static final long serialVersionUID = 4322652365462552L;
    private final Temp temp;

    @Builder
    public TempAlarmEvent(Object source, Temp temp) {
        super(source);
        this.temp = temp;
    }
}
