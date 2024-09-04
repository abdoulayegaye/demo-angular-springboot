package tech.xoslu.backend.dtos;

import tech.xoslu.backend.entities.PaymentStatus;
import tech.xoslu.backend.entities.PaymentType;

import java.time.LocalDate;

public record PaymentDTO(Long id, LocalDate date,
                         double amount, PaymentType type,
                         PaymentStatus status, String nomComplet) {
}
