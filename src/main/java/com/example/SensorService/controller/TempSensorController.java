package com.example.SensorService.controller;

import com.example.SensorService.domain.TempSensor;
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

    @GetMapping("/")
    public ResponseEntity<List<TempSensor>> findAll() {
        return new ResponseEntity(tempSensorService.findAll(), HttpStatus.OK);
    }

    @GetMapping({"/{id}"})
    public ResponseEntity<TempSensor> find(@PathVariable Short id) {
        return new ResponseEntity(tempSensorService.findById(id), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<TempSensor> create(@RequestBody TempSensor tempSensor){
        return new ResponseEntity(tempSensorService.insert(tempSensor), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<TempSensor> update(@PathVariable("id") Short id, @RequestBody TempSensor tempSensor){
        return new ResponseEntity(tempSensorService.update(id, tempSensor), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Short id){
        tempSensorService.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}


