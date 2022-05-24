package ru.kuznetsovka.rightStepTest.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kuznetsovka.rightStepTest.domain.Color;
import ru.kuznetsovka.rightStepTest.dto.CircleDto;
import ru.kuznetsovka.rightStepTest.dto.FigureDto;
import ru.kuznetsovka.rightStepTest.dto.RectangleDto;
import ru.kuznetsovka.rightStepTest.service.FigureService;

import java.util.List;


@org.springframework.web.bind.annotation.RestController
@Slf4j
@RequestMapping("/")
public class RestController {
  private final FigureService figureService;

  @Autowired
  public RestController(FigureService figureService) {
    this.figureService = figureService;
  }

  @GetMapping(value = "/circles",produces = "application/json")
  public List<CircleDto> getAllCirclesByAscRadius() {
    return figureService.getAllCirclesByAscRadius();
  }

  @GetMapping(value = "/rectangles",produces = "application/json")
  public List<RectangleDto> getAllRectanglesByAscDiagonals() {
    return figureService.getAllRectanglesByAscDiagonals();
  }

  @GetMapping(value = "/rectangles",produces = "application/json" , params = {"c"})
  public List<FigureDto> getAllFiguresByColorByAscArea(@RequestParam("c") Color color) {
    return figureService.getAllFiguresByColorByAscArea(color);
  }
}
