package tech.xoslu.backend.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tech.xoslu.backend.entities.PaymentType;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NewPaymentDTO {
    private LocalDate date;
    private double amount;
    private PaymentType type;
    private String studentCode;
}
