package com.example.SensorService.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Temp {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Double value;
    @JsonFormat(pattern="dd-MMM-yyyy HH:mm:ss")
    private Date dateOfMeasure;
    @ManyToOne(fetch = FetchType.LAZY)
    private TempSensor tempSensor;
    private TempState tempState;

}
