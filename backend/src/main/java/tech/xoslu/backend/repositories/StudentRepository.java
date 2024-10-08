package tech.xoslu.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.xoslu.backend.entities.Student;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, String> {
    Student findByCode(String code);
    List<Student> findByProgramId(String programId);
}
