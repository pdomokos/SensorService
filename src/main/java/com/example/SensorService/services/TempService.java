package com.example.SensorService.services;

import com.example.SensorService.domain.Temp;
import com.example.SensorService.domain.TempSearchCriteria;
import com.example.SensorService.domain.TempSpecification;
import com.example.SensorService.domain.TempState;
import com.example.SensorService.repositories.ITempRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@RequiredArgsConstructor
@Service
public class TempService implements ITempService {

    private final ITempRepository tempRepository;

    @Override
    public Page<Temp> findAll(TempSearchCriteria tempSearchCriteria, Pageable pageable) {
        if (tempSearchCriteria.getTempStateList() == null) {
            tempSearchCriteria.setTempStateList(Arrays.asList(TempState.VALID, TempState.ALARM));
        }
        return tempRepository.findAll(TempSpecification.builder().criteria(tempSearchCriteria).build(), pageable);
    }

    @Override
    public Temp insert(Temp temp) {
        return tempRepository.save(temp);
    }

}
