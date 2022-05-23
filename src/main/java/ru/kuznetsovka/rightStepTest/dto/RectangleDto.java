package ru.kuznetsovka.rightStepTest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.kuznetsovka.rightStepTest.domain.Color;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RectangleDto implements FigureDto {
    private int id;
    private double length;
    private double width;
    private Color color;
    private double area;
    private double perimeter;
    private double diagonal;

    public double getArea() {
        return this.length * this.width;
    }

    public double getPerimeter() {
        return 2 * this.length + 2 * this.width;
    }

    public double getDiagonal() {
        return sqrt(pow(this.length,2) + pow(this.width,2));
    }
}
