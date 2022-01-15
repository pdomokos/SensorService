package com.example.SensorService.domain.dto;

import com.example.SensorService.domain.TempState;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Jacksonized
@Builder
@Data
public class TempDto implements Serializable {
    @Serial
    private static final long serialVersionUID = 4243646778567433L;

    private Double value;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="Europe/Budapest")
    private Date dateOfMeasure;
    private Short tempSensorId;
    private TempState tempState;
}
