package com.example.SensorService.domain.mapper;

import com.example.SensorService.domain.Temp;
import com.example.SensorService.domain.dto.TempDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ITempMapper {

    List<TempDto> toDtoList(List<Temp> tempList);
    List<TempDto> toDtoPage(Page<Temp> tempPage);

    @Mapping(target="tempSensorId", source="tempSensor.id")
    TempDto map(Temp value);
}
