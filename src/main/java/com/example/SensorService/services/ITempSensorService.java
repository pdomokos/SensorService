package com.example.SensorService.services;

import com.example.SensorService.domain.TempSensor;

import java.util.List;
import java.util.Optional;

public interface ITempSensorService {
    List<TempSensor> findAll();

    Optional<TempSensor> findById(Short id);

    TempSensor insert(TempSensor tempSensor);

    TempSensor update(Short id, TempSensor tempSensor);

    void delete(Short id);
}
