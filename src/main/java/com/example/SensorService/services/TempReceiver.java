package com.example.SensorService.services;

import com.example.SensorService.domain.Temp;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

//@RabbitListener(queues = "temp")
public class TempReceiver {

    @RabbitListener(queues = "temp")
    public void receive(Temp temp) {
        System.out.println(temp.toString());
    }
}
