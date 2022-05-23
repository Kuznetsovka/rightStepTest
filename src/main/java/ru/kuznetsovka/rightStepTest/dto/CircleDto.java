package ru.kuznetsovka.rightStepTest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.kuznetsovka.rightStepTest.domain.Color;

import static java.lang.Math.PI;
import static java.lang.Math.pow;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CircleDto implements FigureDto {
    private int id;
    private double radius;
    private Color color;
    private double area;
    private double perimeter;

    public CircleDto(double radius, Color color) {
        this.radius = radius;
        this.color = color;
    }

    public double getArea() {
        return pow(radius,2) * PI;
    }

    public double getPerimeter() {
        return 2 * PI * radius;
    }
}
