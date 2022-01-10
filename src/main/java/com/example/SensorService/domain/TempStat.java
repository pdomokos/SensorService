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
public class TempStat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Double min;
    private Double max;
    private Double average;
    private Double median;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date dayOfStat;
    private Integer tempCount;
    @ManyToOne(fetch = FetchType.LAZY)
    private TempSensor tempSensor;
}
