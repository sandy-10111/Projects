package com.system.manager.repository;
import com.system.manager.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findByCardId(String cardId);
}
