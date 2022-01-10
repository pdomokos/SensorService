package com.example.SensorService.repositories;

import com.example.SensorService.domain.Temp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ITempRepository extends JpaRepository<Temp, Long>, JpaSpecificationExecutor<Temp> {
}
