package com.example.SensorService.domain.dto;

import com.example.SensorService.domain.SensorState;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;
import java.io.Serial;
import java.io.Serializable;

@Jacksonized
@Builder
@Data
public class TempSensorDto implements Serializable {
    @Serial
    private static final long serialVersionUID = 4652346735426623L;

    private Short id;
    private String name;
    private String description;
    private Double maxAlarm;
    private Double minAlarm;
    private SensorState sensorState;

}
