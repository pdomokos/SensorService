package com.example.SensorService.domain.mapper;

import com.example.SensorService.domain.TempSensor;
import com.example.SensorService.domain.dto.TempSensorDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ITempSensorMapper {

    List<TempSensorDto> toDtoList(List<TempSensor> tempSensorList);

    TempSensorDto map(TempSensor value);
}
