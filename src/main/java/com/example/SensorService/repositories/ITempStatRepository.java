package com.example.SensorService.repositories;

import com.example.SensorService.domain.TempStat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITempStatRepository extends JpaRepository<TempStat, Long> {
}
