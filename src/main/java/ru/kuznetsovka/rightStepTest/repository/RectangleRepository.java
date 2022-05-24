package ru.kuznetsovka.rightStepTest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kuznetsovka.rightStepTest.domain.Color;
import ru.kuznetsovka.rightStepTest.domain.Rectangle;

import java.util.List;

@Repository
public interface RectangleRepository extends JpaRepository<Rectangle, Long> {
    List<Rectangle> findAllByColor(Color color);
}