package com.example.SensorService.domain.dto;

import com.example.SensorService.domain.TempState;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

import java.io.Serial;
import java.io.Serializable;

@Jacksonized
@Builder
@Data
public class ChartDto implements Serializable {
    @Serial
    private static final long serialVersionUID = 7467532826348544L;

    private Double value1;
    private Double value2;
    private Double value3;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="Europe/Budapest")
    private Long dateOfMeasure;
    private TempState tempState1;
    private TempState tempState2;
    private TempState tempState3;
}
