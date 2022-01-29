package com.example.SensorService.controller;

import com.example.SensorService.domain.TempSearchCriteria;
import com.example.SensorService.domain.dto.TempDto;
import com.example.SensorService.domain.mapper.ITempMapper;
import com.example.SensorService.services.ITempService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/api/v1/temp")
@RestController
public class TempController {

    private final ITempService tempService;
    private final ITempMapper tempMapper;

    @GetMapping("/page")
    public ResponseEntity<Page<TempDto>> findPage(TempSearchCriteria tempSearchCriteria, @PageableDefault(sort = {"dateOfMeasure"}, direction = Sort.Direction.DESC, size = 6048) final Pageable pageable) {
        return ResponseEntity.ok(tempService.findAll(tempSearchCriteria, pageable).map(tempMapper::toDto));
    }
}
