package ru.kuznetsovka.rightStepTest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kuznetsovka.rightStepTest.domain.Circle;

@Repository
public interface CircleRepository extends JpaRepository<Circle, Long> {

}