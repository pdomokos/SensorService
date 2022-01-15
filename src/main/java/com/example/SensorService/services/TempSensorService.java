package com.example.SensorService.services;

import com.example.SensorService.domain.TempSensor;
import com.example.SensorService.domain.dto.TempSensorDto;
import com.example.SensorService.domain.mapper.ITempSensorMapper;
import com.example.SensorService.repositories.ITempSensorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class TempSensorService implements ITempSensorService {

    private final ITempSensorRepository tempSensorRepository;
    private final ITempSensorMapper tempSensorMapper;

    @Override
    public List<TempSensorDto> findAll() {
        return tempSensorMapper.toDtoList(tempSensorRepository.findAll());
    }

    @Override
    public Optional<TempSensor> findById(Short id) {
        return (tempSensorRepository.findById(id));

    }

    @Override
    public TempSensorDto insert(TempSensor tempSensor) {
        return tempSensorMapper.map(tempSensorRepository.save(tempSensor));
    }

    @Override
    public TempSensorDto update(Short id, TempSensor tempSensor){
        TempSensor s = tempSensorRepository.findById(id).orElseThrow();
        s.setName(tempSensor.getName());
        s.setMinAlarm(tempSensor.getMinAlarm());
        s.setMaxAlarm(tempSensor.getMaxAlarm());
        s.setDescription(tempSensor.getDescription());
        s.setSensorState(tempSensor.getSensorState());
        return tempSensorMapper.map(tempSensorRepository.save(s));
    }

    @Override
    public void delete(Short id) {
            tempSensorRepository.delete(tempSensorRepository.findById(id).orElseThrow());
    }
}
