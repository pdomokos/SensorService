package com.example.SensorService.services;

import com.example.SensorService.domain.TempSensor;
import com.example.SensorService.repositories.ITempSensorRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
@SpringBootTest
class TempSensorServiceTest {

    private static final Short SENSOR_ID = 1;

    @Autowired
    private ITempSensorRepository tempSensorRepository;

    @Autowired
    private TempSensorService tempSensorService;

    @Test
    void findAll() {
    }

    @Test
    void findById() {
        TempSensor tempSensor = TempSensor.builder().id(SENSOR_ID).build();
        tempSensorRepository.save(tempSensor);

        Optional<TempSensor> result = tempSensorService.findById(SENSOR_ID);

        assertAll(
                () -> assertNotNull(result),
                () -> assertEquals(SENSOR_ID, result.orElseThrow().getId())
        );
    }

    @Test
    void insert() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}