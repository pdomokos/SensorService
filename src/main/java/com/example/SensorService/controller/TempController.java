package com.example.SensorService.controller;

import com.example.SensorService.domain.Temp;
import com.example.SensorService.domain.TempSearchCriteria;
import com.example.SensorService.services.ITempService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RequestMapping("/api/v1/temp")
@RestController
public class TempController{

    private final ITempService tempService;

    @GetMapping("/")
    public ResponseEntity<Page<Temp>> findAll(TempSearchCriteria tempSearchCriteria, @PageableDefault(value = 2016) Pageable pageable) {
        return new ResponseEntity<>(tempService.findAll(tempSearchCriteria, pageable), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Temp> create(@RequestBody Temp temp){
        return new ResponseEntity(tempService.insert(temp), HttpStatus.CREATED);
    }

    @PostMapping("/createTemps")
    public ResponseEntity<List<Temp>> createTemps(@RequestBody List<Temp> tempList){
        return new ResponseEntity(tempService.insert(tempList), HttpStatus.CREATED);
    }

}
