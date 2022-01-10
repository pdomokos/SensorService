package com.example.SensorService.domain;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class TempSensor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Short id;
    private String name;
    private String description;
    private Double maxAlarm;
    private Double minAlarm;
    private SensorState sensorState;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tempSensor")
    private List<Temp> temps;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tempSensor")
    private List<TempStat> tempStats;

}
