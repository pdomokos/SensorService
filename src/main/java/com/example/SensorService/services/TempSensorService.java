package com.example.SensorService.services;

import com.example.SensorService.domain.TempSensor;
import com.example.SensorService.repositories.ITempSensorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class TempSensorService implements ITempSensorService {

    private final ITempSensorRepository tempSensorRepository;

    @Override
    public List<TempSensor> findAll() {
        return tempSensorRepository.findAll();
    }

    @Override
    public Optional<TempSensor> findById(Short id) {
        return tempSensorRepository.findById(id);
    }

    @Override
    public TempSensor insert(TempSensor tempSensor) {
        return tempSensorRepository.save(tempSensor);
    }

    @Override
    public TempSensor update(Short id, TempSensor tempSensor) {
        TempSensor s = tempSensorRepository.findById(id).orElseThrow();
        s.setName(tempSensor.getName());
        s.setMinAlarm(tempSensor.getMinAlarm());
        s.setMaxAlarm(tempSensor.getMaxAlarm());
        s.setDescription(tempSensor.getDescription());
        s.setSensorState(tempSensor.getSensorState());
        return tempSensorRepository.save(s);
    }

    @Override
    public void delete(Short id) {
        tempSensorRepository.delete(tempSensorRepository.findById(id).orElseThrow());
    }
}
