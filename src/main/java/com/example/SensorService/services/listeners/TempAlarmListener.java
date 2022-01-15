package com.example.SensorService.services.listeners;

import com.example.SensorService.domain.Temp;
import com.example.SensorService.services.events.TempAlarmEvent;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TempAlarmListener implements ApplicationListener<TempAlarmEvent> {

    @Override
    public void onApplicationEvent(@NonNull TempAlarmEvent event) {
        Temp temp = event.getTemp();
        System.out.println("Alarm: "+temp.getValue());
        //TODO send notification with temp and sensor
    }
}
