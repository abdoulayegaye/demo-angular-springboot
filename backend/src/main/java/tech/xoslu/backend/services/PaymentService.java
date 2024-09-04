package tech.xoslu.backend.services;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import tech.xoslu.backend.dtos.NewPaymentDTO;
import tech.xoslu.backend.entities.Payment;
import tech.xoslu.backend.entities.PaymentStatus;
import tech.xoslu.backend.entities.PaymentType;
import tech.xoslu.backend.entities.Student;
import tech.xoslu.backend.repositories.PaymentRepository;
import tech.xoslu.backend.repositories.StudentRepository;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final StudentRepository studentRepository;

    public Payment updatePaymentStatus(PaymentStatus status, Long id) {
        Payment payment = paymentRepository.findById(id).get();
        payment.setStatus(status);
        return paymentRepository.save(payment);
    }

    public Payment savePayment(MultipartFile file, NewPaymentDTO newPaymentDTO) throws IOException {
        Path folderPath = Paths.get(System.getProperty("user.home"), "xoslu-data", "payments");
        if(!Files.exists(folderPath)){
            Files.createDirectories(folderPath);
        }
        String fileName = UUID.randomUUID().toString();
        Path filePath = Paths.get(System.getProperty("user.home"), "xoslu-data", "payments", fileName + ".pdf");
        Files.copy(file.getInputStream(), filePath);
        Student student = studentRepository.findByCode(newPaymentDTO.getStudentCode());
        Payment payment = Payment.builder()
                .paymentDate(newPaymentDTO.getDate())
                .student(student)
                .status(PaymentStatus.CREATED)
                .amount(newPaymentDTO.getAmount())
                .type(newPaymentDTO.getType())
                .file(filePath.toUri().toString())
                .build();
        return paymentRepository.save(payment);
    }

    public byte[] getPaymentFile(Long paymentId) throws IOException {
        Payment payment = paymentRepository.findById(paymentId).get();
        return Files.readAllBytes(Path.of(URI.create(payment.getFile())));
    }
}
