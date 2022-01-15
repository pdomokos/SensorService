package com.example.SensorService.services;

import com.example.SensorService.domain.Temp;
import com.example.SensorService.domain.TempSearchCriteria;
import com.example.SensorService.domain.dto.TempDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ITempService {
    List<TempDto> findAll(TempSearchCriteria tempSearchCriteria, Pageable pageable);

    List<TempDto> findAll();

    Temp insert(Temp temp);

    List<Temp> insert(List<Temp> tempList);
}
