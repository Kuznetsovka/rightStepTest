package ru.kuznetsovka.rightStepTest.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kuznetsovka.rightStepTest.dto.CircleDto;
import ru.kuznetsovka.rightStepTest.exception.FigureNotFoundException;
import ru.kuznetsovka.rightStepTest.service.FigureService;

import java.util.List;


@org.springframework.web.bind.annotation.RestController
@RequestMapping("/")
public class RestController {
  private final FigureService figureService;


  @Autowired
  public RestController(FigureService figureService) {
    this.figureService = figureService;
  }

  @GetMapping(value = "/circles",produces = "application/json")
  public List<CircleDto> getAllHumidifiers() {
    return figureService.getAllCirclesByAscRadius();
  }

  @ExceptionHandler
  public ResponseEntity<?> handleException(FigureNotFoundException exception) {
    return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
  }
}
