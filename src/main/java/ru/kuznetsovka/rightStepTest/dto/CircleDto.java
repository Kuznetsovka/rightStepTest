package ru.kuznetsovka.rightStepTest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.kuznetsovka.rightStepTest.domain.Color;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CircleDto extends FigureDto {
    private double radius;
    private Color color;
    private double area;
    private double perimeter;
}
