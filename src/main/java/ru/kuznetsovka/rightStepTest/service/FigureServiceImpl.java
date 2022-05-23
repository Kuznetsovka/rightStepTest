package ru.kuznetsovka.rightStepTest.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kuznetsovka.rightStepTest.dto.CircleDto;
import ru.kuznetsovka.rightStepTest.mapper.CircleMapper;
import ru.kuznetsovka.rightStepTest.mapper.RectangleMapper;
import ru.kuznetsovka.rightStepTest.repository.CircleRepository;

import java.util.List;

@Service
public class FigureServiceImpl implements FigureService {
    private final CircleMapper circleMapper = CircleMapper.MAPPER;
    private final RectangleMapper rectangleMapper = RectangleMapper.MAPPER;
    private CircleRepository circleRepository;
    @Override
    @Transactional(readOnly = true)
    public List<CircleDto> getAllCircles() {
        return circleMapper.fromCircleList(circleRepository.findAll());
    }
}
