package com.example.SensorService.controller;

import com.example.SensorService.domain.TempStat;
import com.example.SensorService.services.ITempStatService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/api/v1/tempStat")
@RestController
public class TempStatController {

    private final ITempStatService tempStatService;

    @GetMapping("/")
    public ResponseEntity findAll() {
        return new ResponseEntity(tempStatService.findAll(), HttpStatus.OK);
    }

    @GetMapping({"/{id}"})
    public ResponseEntity<TempStat> find(@PathVariable Long id) {
        return new ResponseEntity(tempStatService.findById(id), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<TempStat> create(@RequestBody TempStat tempStat){
        return new ResponseEntity(tempStatService.insert(tempStat), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") long id){
        tempStatService.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
