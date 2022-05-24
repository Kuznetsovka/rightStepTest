package ru.kuznetsovka.rightStepTest.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kuznetsovka.rightStepTest.domain.Circle;
import ru.kuznetsovka.rightStepTest.domain.Color;
import ru.kuznetsovka.rightStepTest.domain.Rectangle;
import ru.kuznetsovka.rightStepTest.dto.CircleDto;
import ru.kuznetsovka.rightStepTest.dto.FigureDto;
import ru.kuznetsovka.rightStepTest.dto.RectangleDto;
import ru.kuznetsovka.rightStepTest.mapper.CircleMapper;
import ru.kuznetsovka.rightStepTest.mapper.RectangleMapper;
import ru.kuznetsovka.rightStepTest.repository.CircleRepository;
import ru.kuznetsovka.rightStepTest.repository.RectangleRepository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class FigureServiceImpl implements FigureService {
    private final CircleMapper circleMapper = CircleMapper.MAPPER;
    private final RectangleMapper rectangleMapper = RectangleMapper.MAPPER;
    private final CircleRepository circleRepository;
    private final RectangleRepository rectangleRepository;

    public FigureServiceImpl(CircleRepository circleRepository, RectangleRepository rectangleRepository) {
        this.circleRepository = circleRepository;
        this.rectangleRepository = rectangleRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<RectangleDto> getAllRectangles() {
        log.info("Запрос всех прямоугольников");
        return rectangleMapper.fromRectangleList(rectangleRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public List<CircleDto> getAllCircles() {
        log.info("Запрос всех кругов");
        return circleMapper.fromCircleList(circleRepository.findAll());
    }

    @Override
    @Transactional
    public Circle saveCircle(CircleDto circleDto) {
        log.info("Сохранение круга:" + circleDto);
        return circleRepository.save(circleMapper.toCircle(circleDto));
    }

    @Override
    @Transactional
    public Rectangle saveRectangle(RectangleDto rectangleDto) {
        log.info("Сохранение прямоугольника:" + rectangleDto);
        return rectangleRepository.save(rectangleMapper.toRectangle(rectangleDto));
    }

    @Override
    public List<CircleDto> getAllCirclesByAscRadius() {
        log.info("Получение всех кругов в порядке возрастания радиусов");
        return getAllCircles().stream().sorted(Comparator.comparing(CircleDto::getRadius)).collect(Collectors.toList());
    }

    @Override
    public List<FigureDto> getAllFiguresByColorByAscArea(Color color) {
        List<FigureDto> lists = getAllFiguresByColor(color);
        log.info("Получение всех фигур цвета " + color + " в порядке возрастания площади");
        return lists.stream().sorted(Comparator.comparing(FigureDto::getArea)).collect(Collectors.toList());
    }

    @Override
    public List<FigureDto> getAllFiguresByColor(Color color) {
        List<FigureDto> figureDtos = new ArrayList<>();
        figureDtos.addAll(rectangleMapper.fromRectangleList(rectangleRepository.findAllByColor(color)));
        figureDtos.addAll(circleMapper.fromCircleList(circleRepository.findAllByColor(color)));
        log.info("Получение всех фигур цвета " + color);
        return figureDtos;
    }

    @Override
    public List<RectangleDto> getAllRectanglesByAscDiagonals() {
        log.info("Получение всех прямоугольников в порядке возрастания площади");
        return getAllRectangles().stream().sorted(Comparator.comparing(RectangleDto::getDiagonal)).collect(Collectors.toList());
    }
}
