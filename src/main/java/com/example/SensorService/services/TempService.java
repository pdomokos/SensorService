package com.example.SensorService.services;

import com.example.SensorService.domain.Temp;
import com.example.SensorService.domain.TempSearchCriteria;
import com.example.SensorService.domain.TempSpecification;
import com.example.SensorService.domain.dto.TempDto;
import com.example.SensorService.domain.mapper.ITempMapper;
import com.example.SensorService.repositories.ITempRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TempService implements ITempService{

    private final ITempRepository tempRepository;
    private final ITempMapper tempMapper;

    @Override
    public List<TempDto> findAll(TempSearchCriteria tempSearchCriteria, Pageable pageable) {
        return tempMapper.toDtoPage(tempRepository.findAll(new TempSpecification(tempSearchCriteria), pageable));
    }

    @Override
    public List<TempDto> findAll() {
        return tempMapper.toDtoList(tempRepository.findAll());
    }

    @Override
    public Temp insert(Temp temp) {
        return tempRepository.save(temp);
    }

    @Override
    public List<Temp> insert(List<Temp> tempList) {
        return tempRepository.saveAll(tempList);
    }
}
