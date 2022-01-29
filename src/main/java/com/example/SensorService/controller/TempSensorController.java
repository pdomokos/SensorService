package com.example.SensorService.controller;

import com.example.SensorService.domain.TempSensor;
import com.example.SensorService.domain.dto.TempSensorDto;
import com.example.SensorService.domain.mapper.ITempSensorMapper;
import com.example.SensorService.services.ITempSensorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/v1/sensor")
@RestController
public class TempSensorController {

    private final ITempSensorService tempSensorService;
    private final ITempSensorMapper tempSensorMapper;

    @GetMapping("/")
    public ResponseEntity<List<TempSensorDto>> findAll() {
        return ResponseEntity.ok(tempSensorMapper.toDtoList(tempSensorService.findAll()));
    }

    @GetMapping({"/{id}"})
    public ResponseEntity<TempSensorDto> find(@PathVariable Short id) {
        return ResponseEntity.of(tempSensorService.findById(id).map(tempSensorMapper::toDto));
    }

    @PostMapping("/create")
    public ResponseEntity<TempSensorDto> create(@RequestBody TempSensor tempSensor) {
        return new ResponseEntity<>(tempSensorMapper.toDto(tempSensorService.insert(tempSensor)), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<TempSensorDto> update(@PathVariable("id") Short id, @RequestBody TempSensor tempSensor) {
        return ResponseEntity.ok(tempSensorMapper.toDto(tempSensorService.update(id, tempSensor)));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Short id) {
        tempSensorService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}


