package ca.tecnova.parkwize.shared.dto;

import java.math.BigDecimal;
import java.sql.Timestamp;

public record PaymentDto(
        Long paymentId,
        Long accessId,
        Timestamp paymentDate,
        int paymentMethodId,
        BigDecimal totalAmount,
        BigDecimal amount,
        String kioskId
) { }
