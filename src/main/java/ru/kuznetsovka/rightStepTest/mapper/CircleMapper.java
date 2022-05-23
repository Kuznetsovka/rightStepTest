package ru.kuznetsovka.rightStepTest.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.kuznetsovka.rightStepTest.domain.Circle;
import ru.kuznetsovka.rightStepTest.dto.CircleDto;

import java.util.List;

@Mapper
public interface CircleMapper {
  CircleMapper MAPPER = Mappers.getMapper(CircleMapper.class);

  Circle toCircle(CircleDto dto);
  List<Circle> toCircleList(List<CircleDto> circles);

  @InheritInverseConfiguration
  CircleDto fromCircle(Circle circle);

  List<CircleDto> fromCircleList(List<Circle> circles);
}
