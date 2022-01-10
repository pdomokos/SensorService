package com.example.SensorService.services;

import com.example.SensorService.domain.TempStat;
import com.example.SensorService.repositories.ITempStatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class TempStatService implements ITempStatService {

    private final ITempStatRepository tempStatRepository;

    @Override
    public List<TempStat> findAll() {
        return tempStatRepository.findAll();
    }

    @Override
    public Optional<TempStat> findById(Long id) {
        return tempStatRepository.findById(id);
    }

    @Override
    public TempStat insert(TempStat tempStat) {
        return tempStatRepository.save(tempStat);
    }

    @Override
    public void delete(Long id) {
        tempStatRepository.delete(tempStatRepository.findById(id).orElseThrow());
    }
}
