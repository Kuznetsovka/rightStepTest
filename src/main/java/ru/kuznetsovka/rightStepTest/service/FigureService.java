package ru.kuznetsovka.rightStepTest.service;

import org.springframework.transaction.annotation.Transactional;
import ru.kuznetsovka.rightStepTest.domain.Circle;
import ru.kuznetsovka.rightStepTest.domain.Rectangle;
import ru.kuznetsovka.rightStepTest.dto.CircleDto;
import ru.kuznetsovka.rightStepTest.dto.RectangleDto;

import java.util.List;

public interface FigureService {

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
