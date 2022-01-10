package com.example.SensorService.domain;

import lombok.Data;

@Data
public class TempMessage{
    double value;
    String dateOfMeasure;
    TempSensor tempSensor;
    TempState tempState;
 }
