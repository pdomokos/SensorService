package com.example.SensorService.repositories;

import com.example.SensorService.domain.TempSensor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITempSensorRepository extends JpaRepository<TempSensor, Short> {
}
