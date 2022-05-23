package ru.kuznetsovka.rightStepTest.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.kuznetsovka.rightStepTest.domain.Rectangle;
import ru.kuznetsovka.rightStepTest.dto.RectangleDto;

import java.util.List;

@Mapper
public interface RectangleMapper {
  RectangleMapper MAPPER = Mappers.getMapper(RectangleMapper.class);

  Rectangle toRectangle(RectangleDto dto);

  List<Rectangle> toRectangleList(List<RectangleDto> rectangles);

  @InheritInverseConfiguration
  RectangleDto fromRectangle(Rectangle rectangle);

  List<RectangleDto> fromRectangleList(List<Rectangle> rectangles);
}
