package tech.xoslu.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.xoslu.backend.entities.Payment;
import tech.xoslu.backend.entities.PaymentStatus;
import tech.xoslu.backend.entities.PaymentType;
import tech.xoslu.backend.entities.Student;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    List<Payment> findByStudentCode(String code);
    List<Payment> findByStatus(PaymentStatus status);
    List<Payment> findByType(PaymentType type);
}
