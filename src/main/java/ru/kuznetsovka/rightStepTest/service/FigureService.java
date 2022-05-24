package ru.kuznetsovka.rightStepTest.service;

import org.springframework.transaction.annotation.Transactional;
import ru.kuznetsovka.rightStepTest.domain.Circle;
import ru.kuznetsovka.rightStepTest.domain.Color;
import ru.kuznetsovka.rightStepTest.domain.Rectangle;
import ru.kuznetsovka.rightStepTest.dto.CircleDto;
import ru.kuznetsovka.rightStepTest.dto.FigureDto;
import ru.kuznetsovka.rightStepTest.dto.RectangleDto;

import java.util.List;

public interface FigureService {

    List<FigureDto> getAllFiguresByColorByAscArea(Color color);

    List<FigureDto> getAllFiguresByColor(Color color);

    @Transactional(readOnly = true)
    List<RectangleDto> getAllRectanglesByAscDiagonals();

    @Transactional(readOnly = true)
    List<RectangleDto> getAllRectangles();

    @Transactional(readOnly = true)
    List<CircleDto> getAllCircles();

    @Transactional
    Circle saveCircle(CircleDto circleDto);

    @Transactional
    Rectangle saveRectangle(RectangleDto rectangleDto);

    List<CircleDto> getAllCirclesByAscRadius();
}
