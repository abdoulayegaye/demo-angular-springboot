package tech.xoslu.backend;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import tech.xoslu.backend.entities.Payment;
import tech.xoslu.backend.entities.PaymentStatus;
import tech.xoslu.backend.entities.PaymentType;
import tech.xoslu.backend.entities.Student;
import tech.xoslu.backend.repositories.PaymentRepository;
import tech.xoslu.backend.repositories.StudentRepository;

import java.time.LocalDate;
import java.util.Random;
import java.util.UUID;

@SpringBootApplication
public class BackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository,
                                        PaymentRepository paymentRepository) {
        return args -> {
            studentRepository.save(Student.builder().
                    id(UUID.randomUUID().toString()).
                    firstName("Abdoulaye").
                    lastName("GAYE").
                    code("1234").
                    programId("DITI").
                    build());
            studentRepository.save(Student.builder().
                    id(UUID.randomUUID().toString()).
                    firstName("Aissatou").
                    lastName("SARR").
                    code("1233").
                    programId("IAGE").
                    build());
            studentRepository.save(Student.builder().
                    id(UUID.randomUUID().toString()).
                    firstName("Fatou").
                    lastName("DIOP").
                    code("1235").
                    programId("RT").
                    build());
            studentRepository.save(Student.builder().
                    id(UUID.randomUUID().toString()).
                    firstName("Moussa").
                    lastName("FALL").
                    code("1236").
                    programId("GL").
                    build());

            PaymentType[] paymentTypes = PaymentType.values();
            Random random = new Random();
            studentRepository.findAll().forEach(student -> {
                for (int i = 0; i < 10; i++) {
                    int index = random.nextInt(paymentTypes.length);
                    Payment payment = Payment.builder()
                            .amount(1000+(int)(Math.random()*20000))
                            .type(paymentTypes[index])
                            .status(PaymentStatus.CREATED)
                            .paymentDate(LocalDate.now())
                            .student(student)
                            .build();
                    paymentRepository.save(payment);
                }
            });
        };
    }
}
