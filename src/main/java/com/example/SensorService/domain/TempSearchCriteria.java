package com.example.SensorService.domain;

import lombok.Data;

import java.util.List;

@Data
public class TempSearchCriteria {
    private List<TempState> tempStateList;
}
