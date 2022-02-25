package com.example.SensorService.controller;

import com.example.SensorService.domain.TempSearchCriteria;
import com.example.SensorService.domain.dto.ChartDto;
import com.example.SensorService.domain.dto.TempDto;
import com.example.SensorService.domain.mapper.ITempMapper;
import com.example.SensorService.services.ITempService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

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

    @GetMapping("/chartPage")
    public ResponseEntity<List<ChartDto>> findChartPage(TempSearchCriteria tempSearchCriteria, @PageableDefault(sort = {"dateOfMeasure"}, direction = Sort.Direction.DESC, size = 6048) final Pageable pageable) {
        return ResponseEntity.ok(tempService.findAll(tempSearchCriteria, pageable).map(tempMapper::toDto)
                .stream()
                .collect(groupingBy(TempDto::getDateOfMeasure))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(this::getChartDto)
                .collect(Collectors.toList()));
    }

    private ChartDto getChartDto(Map.Entry<Date, List<TempDto>> e) {
        Optional<TempDto> sensor1 = e.getValue().stream()
                .filter(f -> f.getTempSensorId() == 1).findFirst();
        Optional<TempDto> sensor2 = e.getValue().stream()
                .filter(f -> f.getTempSensorId() == 2).findFirst();
        Optional<TempDto> sensor3 = e.getValue().stream()
                .filter(f -> f.getTempSensorId() == 3).findFirst();

        ChartDto.ChartDtoBuilder builder = ChartDto.builder();
        builder.dateOfMeasure(e.getKey().getTime());
        sensor1.ifPresent(tempDto -> builder.value1(tempDto.getValue())
                .tempState1(tempDto.getTempState()));
        sensor2.ifPresent(tempDto -> builder.value2(tempDto.getValue())
                .tempState2(tempDto.getTempState()));
        sensor3.ifPresent(tempDto -> builder.value3(tempDto.getValue())
                .tempState3(tempDto.getTempState()));
        return builder.build();
    }
}
