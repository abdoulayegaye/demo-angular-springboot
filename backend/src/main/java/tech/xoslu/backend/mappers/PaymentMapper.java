package tech.xoslu.backend.mappers;

import org.springframework.stereotype.Service;
import tech.xoslu.backend.dtos.PaymentDTO;
import tech.xoslu.backend.entities.Payment;

@Service
public class PaymentMapper {
    public static PaymentDTO toDto(Payment payment) {
        return new PaymentDTO(
                payment.getId(),
                payment.getPaymentDate(),
                payment.getAmount(),
                payment.getType(),
                payment.getStatus(),
                payment.getStudent().getFirstName() + " " + payment.getStudent().getLastName()
        );
    }
}
