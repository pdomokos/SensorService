package com.example.SensorService.services;

import com.example.SensorService.domain.Temp;
import com.example.SensorService.domain.TempSearchCriteria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ITempService {
    Page<Temp> findAll(TempSearchCriteria tempSearchCriteria, Pageable pageable);

    Temp insert(Temp temp);

}
