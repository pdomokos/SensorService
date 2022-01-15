package com.example.SensorService.services;

import com.example.SensorService.domain.TempSensor;
import com.example.SensorService.domain.dto.TempSensorDto;

import java.util.List;
import java.util.Optional;

public interface ITempSensorService {
    List<TempSensorDto> findAll();

    Optional<TempSensor> findById(Short id);

    TempSensorDto insert(TempSensor tempSensor);

    TempSensorDto update(Short id, TempSensor tempSensor);

    void delete(Short id);
}
