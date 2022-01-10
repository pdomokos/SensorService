package com.example.SensorService.services;

import com.example.SensorService.domain.TempStat;

import java.util.List;
import java.util.Optional;

public interface ITempStatService {
    List<TempStat> findAll();

    Optional<TempStat> findById(Long id);

    TempStat insert(TempStat tempStat);

    void delete(Long id);
}
