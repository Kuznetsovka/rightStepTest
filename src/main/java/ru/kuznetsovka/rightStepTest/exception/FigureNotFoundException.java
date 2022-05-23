package ru.kuznetsovka.rightStepTest.exception;

public class FigureNotFoundException extends RuntimeException {
  public FigureNotFoundException(String message) {
    super(message);
  }
}