package ru.kuznetsovka.rightStepTest.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import ru.kuznetsovka.rightStepTest.domain.Circle;
import ru.kuznetsovka.rightStepTest.domain.Rectangle;
import ru.kuznetsovka.rightStepTest.dto.CircleDto;
import ru.kuznetsovka.rightStepTest.dto.FigureDto;
import ru.kuznetsovka.rightStepTest.dto.RectangleDto;
import ru.kuznetsovka.rightStepTest.repository.CircleRepository;
import ru.kuznetsovka.rightStepTest.repository.RectangleRepository;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static ru.kuznetsovka.rightStepTest.domain.Color.*;

@DataJpaTest
class FigureServiceImplTest {
    private FigureService  figureService;

    @Autowired
    private CircleRepository circleRepository;
    @Autowired
    private RectangleRepository rectangleRepository;
    @Autowired
    TestEntityManager testEntityManager;

    @BeforeEach
    void setUp() {
        this.testEntityManager.persistAndFlush(
                Rectangle.builder()
                        .color(RED)
                        .length(10)
                        .width(20)
                        .build());
        this.testEntityManager.persistAndFlush(
                Rectangle.builder()
                        .color(RED)
                        .length(1)
                        .width(2)
                        .build());
        this.testEntityManager.persistAndFlush(
                Rectangle.builder()
                        .color(GREEN)
                        .length(10)
                        .width(20)
                        .build());
        this.testEntityManager.persistAndFlush(
                Circle.builder()
                         .color(RED)
                         .radius(20)
                         .build());
        this.testEntityManager.persistAndFlush(
                Circle.builder()
                        .color(BLUE)
                        .radius(10)
                        .build());
        figureService = new FigureServiceImpl(circleRepository,rectangleRepository) {
        };
    }

    @BeforeEach
    void cleanTable() {
        circleRepository.deleteAll();
        rectangleRepository.deleteAll();
    }
    @Test
    void getAllCirclesByAscRadius() {
        List<CircleDto> circles = figureService.getAllCirclesByAscRadius();
        CircleDto lastCircles = circles.get(circles.size() - 1);
        assertThat(lastCircles).extracting(CircleDto::getRadius).isEqualTo(20.0);
    }

    @Test
    void getAllFiguresByColorByAscArea() {
        List<FigureDto> figures = figureService.getAllFiguresByColor(RED);
        FigureDto lastFigure = figures.get(figures.size() - 1);
        assertThat(lastFigure).extracting(FigureDto::getArea).isEqualTo(1256.6370614359173);
        assertThat(figures).extracting(FigureDto::getColor).containsAll(Collections.singleton(RED));
    }

    @Test
    void getAllRectanglesByAscDiagonals() {
        List<RectangleDto> rectangles = figureService.getAllRectanglesByAscDiagonals();
        RectangleDto lastRectangle = rectangles.get(rectangles.size() - 1);
        assertThat(lastRectangle).extracting(dto -> String.format("%.1f", dto.getDiagonal())).isEqualTo("22,4");
    }
}