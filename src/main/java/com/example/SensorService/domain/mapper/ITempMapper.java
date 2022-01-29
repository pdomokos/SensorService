package com.example.SensorService.domain.mapper;

import com.example.SensorService.domain.Temp;
import com.example.SensorService.domain.dto.TempDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ITempMapper {

    @Mapping(target = "tempSensorId", source = "tempSensor.id")
    TempDto toDto(Temp value);
}
