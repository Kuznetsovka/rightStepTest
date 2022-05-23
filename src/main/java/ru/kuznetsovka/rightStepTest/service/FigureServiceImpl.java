package ru.kuznetsovka.rightStepTest.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kuznetsovka.rightStepTest.domain.Circle;
import ru.kuznetsovka.rightStepTest.domain.Color;
import ru.kuznetsovka.rightStepTest.domain.Rectangle;
import ru.kuznetsovka.rightStepTest.dto.CircleDto;
import ru.kuznetsovka.rightStepTest.dto.RectangleDto;
import ru.kuznetsovka.rightStepTest.mapper.CircleMapper;
import ru.kuznetsovka.rightStepTest.mapper.RectangleMapper;
import ru.kuznetsovka.rightStepTest.repository.CircleRepository;
import ru.kuznetsovka.rightStepTest.repository.RectangleRepository;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FigureServiceImpl implements FigureService {
    private final CircleMapper circleMapper = CircleMapper.MAPPER;
    private final RectangleMapper rectangleMapper = RectangleMapper.MAPPER;
    private final CircleRepository circleRepository;
    private final RectangleRepository rectangleRepository;

    public FigureServiceImpl(CircleRepository circleRepository, RectangleRepository rectangleRepository) {
        this.circleRepository = circleRepository;
        this.rectangleRepository = rectangleRepository;
        init();
    }

    private void init(){
        saveCircle(new CircleDto(10,Color.BLUE));
        saveCircle(new CircleDto(2.1,Color.BLUE));
        saveCircle(new CircleDto(0.5,Color.BLUE));
        RectangleDto rectangleDto = RectangleDto.builder()
                .length(3.1)
                .width(2.1)
                .color(Color.BLUE)
                .build();
        saveRectangle(rectangleDto);
    }

    @Override
    public List<CircleDto> getAllCirclesByAscRadius() {
        return getAllCircles().stream().sorted(Comparator.comparing(CircleDto::getRadius)).collect(Collectors.toList());
    }

    @Override
    public List<RectangleDto> getAllRectanglesByAscDiagonals() {
        return getAllRectangles().stream().sorted(Comparator.comparing(RectangleDto::getDiagonal)).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<RectangleDto> getAllRectangles() {
        return rectangleMapper.fromRectangleList(rectangleRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public List<CircleDto> getAllCircles() {
        return circleMapper.fromCircleList(circleRepository.findAll());
    }

    @Override
    @Transactional
    public Circle saveCircle(CircleDto circleDto) {
        return circleRepository.save(circleMapper.toCircle(circleDto));
    }

    @Override
    @Transactional
    public Rectangle saveRectangle(RectangleDto rectangleDto) {
        return rectangleRepository.save(rectangleMapper.toRectangle(rectangleDto));
    }
}
