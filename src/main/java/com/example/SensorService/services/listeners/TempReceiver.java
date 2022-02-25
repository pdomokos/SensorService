package com.example.SensorService.services.listeners;

import com.example.SensorService.domain.Temp;
import com.example.SensorService.domain.TempSensor;
import com.example.SensorService.domain.TempState;
import com.example.SensorService.domain.dto.TempDto;
import com.example.SensorService.services.ITempSensorService;
import com.example.SensorService.services.ITempService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Profile("default")
@Component
@RequiredArgsConstructor
public class TempReceiver implements RabbitListenerConfigurer {

    private final ITempService tempService;
    private final ITempSensorService tempSensorService;

    @Override
    public void configureRabbitListeners(RabbitListenerEndpointRegistrar rabbitListenerEndpointRegistrar) {
    }

    @RabbitListener(queues = "${RABBIT_QUEUE}")
    public void receivedMessage(TempDto tempDto) {
        System.out.println(tempDto);
        double value = tempDto.getValue();
        TempState state;
        Optional<TempSensor> tempSensorOptional = tempSensorService.findById(tempDto.getTempSensorId());
        if (tempSensorOptional.isPresent()) {
            TempSensor tempSensor = tempSensorOptional.get();
            if (value > -100.0 && value < 100.0) {
                state = TempState.VALID;
                if (tempSensor.getMinAlarm() != null && value < tempSensor.getMinAlarm()) {
                    state = TempState.ALARM;
                } else if (tempSensor.getMaxAlarm() != null && value > tempSensor.getMaxAlarm()) {
                    state = TempState.ALARM;
                }
            } else {
                state = TempState.INVALID;
            }
            Temp temp = Temp.builder()
                    .value(value)
                    .dateOfMeasure(tempDto.getDateOfMeasure())
                    .tempState(state)
                    .tempSensor(tempSensor)
                    .build();
            tempService.insert(temp);
        }
    }

}

