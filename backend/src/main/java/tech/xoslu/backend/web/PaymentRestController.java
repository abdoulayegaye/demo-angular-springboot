package tech.xoslu.backend.web;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tech.xoslu.backend.dtos.NewPaymentDTO;
import tech.xoslu.backend.dtos.PaymentDTO;
import tech.xoslu.backend.entities.Payment;
import tech.xoslu.backend.entities.PaymentStatus;
import tech.xoslu.backend.entities.PaymentType;
import tech.xoslu.backend.entities.Student;
import tech.xoslu.backend.mappers.PaymentMapper;
import tech.xoslu.backend.repositories.PaymentRepository;
import tech.xoslu.backend.repositories.StudentRepository;
import tech.xoslu.backend.services.PaymentService;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin("*")
public class PaymentRestController {

    private StudentRepository studentRepository;
    private PaymentRepository paymentRepository;
    private PaymentService paymentService;
    private PaymentMapper paymentMapper;

    public PaymentRestController(StudentRepository studentRepository, PaymentRepository paymentRepository,
                                PaymentService paymentService, PaymentMapper paymentMapper) {
        this.studentRepository = studentRepository;
        this.paymentRepository = paymentRepository;
        this.paymentService = paymentService;
        this.paymentMapper = paymentMapper;
    }

    @GetMapping(path = "/payments")
    public List<PaymentDTO> allPayments() {
        return paymentRepository.findAll().stream().map(PaymentMapper::toDto).toList();
    }

    @GetMapping(path = "/students/{code}/payments")
    public List<Payment> paymentsByStudent(@PathVariable String code) {
        return paymentRepository.findByStudentCode(code);
    }

    @GetMapping(path = "/payments/byType")
    public List<Payment> paymentsByType(@RequestParam PaymentType type) {
        return paymentRepository.findByType(type);
    }

    @GetMapping(path = "/payments/byStatus")
    public List<Payment> paymentsByStatus(@RequestParam PaymentStatus status) {
        return paymentRepository.findByStatus(status);
    }

    @GetMapping(path = "/payments/{id}")
    public Payment getPaymentById(@PathVariable Long id) {
        return paymentRepository.findById(id).get();
    }

    @GetMapping("/students")
    public List<Student> allStudents() {
        return studentRepository.findAll();
    }

    @GetMapping("/students/{code}")
    public Student getStudentsByCode(@PathVariable String code) {
        return studentRepository.findByCode(code);
    }

    @GetMapping("/studentsByProgramId")
    public List<Student> getStudentsByProgramId(@RequestParam String programId) {
        return studentRepository.findByProgramId(programId);
    }

    @PutMapping("/payments/{id}")
    public Payment updatePaymentStatus(@RequestParam PaymentStatus status, @PathVariable Long id) {
        return paymentService.updatePaymentStatus(status, id);
    }

    @PostMapping(path = "/payments", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Payment savePayment(@RequestParam("file") MultipartFile file, NewPaymentDTO newPaymentDTO) throws IOException {
        return paymentService.savePayment(file, newPaymentDTO);
    }

    @GetMapping(path = "/paymentFile/{paymentId}", produces = MediaType.APPLICATION_PDF_VALUE)
    public byte[] getPaymentFile(@PathVariable Long paymentId) throws IOException {
        return paymentService.getPaymentFile(paymentId);
    }
}

