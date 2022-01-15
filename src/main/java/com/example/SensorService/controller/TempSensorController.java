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
import java.util.Optional;

@RequiredArgsConstructor
@RequestMapping("/api/v1/sensor")
@RestController
public class TempSensorController {

    private final ITempSensorService tempSensorService;
    private final ITempSensorMapper tempSensorMapper;

    @GetMapping("/")
    public ResponseEntity<List<TempSensorDto>> findAll() {
        return new ResponseEntity<>(tempSensorService.findAll(), HttpStatus.OK);
    }

    @GetMapping({"/{id}"})
    public ResponseEntity<TempSensorDto> find(@PathVariable Short id) {
        return ResponseEntity.of(tempSensorService.findById(id).map(tempSensorMapper::map));
    }

    @PostMapping("/create")
    public ResponseEntity<TempSensorDto> create(@RequestBody TempSensor tempSensor){
        return new ResponseEntity<>(tempSensorService.insert(tempSensor), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<TempSensorDto> update(@PathVariable("id") Short id, @RequestBody TempSensor tempSensor){
        return new ResponseEntity<>(tempSensorService.update(id, tempSensor), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Short id){
        tempSensorService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}


