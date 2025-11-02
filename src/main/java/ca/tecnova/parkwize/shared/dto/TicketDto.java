package ca.tecnova.parkwize.shared.dto;

import ca.tecnova.parkwize.shared.objects.ZonePricingMaximum;
import ca.tecnova.parkwize.shared.objects.ZonePricingUnit;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

public record TicketDto(
        Long ticketId,
        int companyId,
        int subscriberId,
        int organizationId,
        String customerId,
        Timestamp issueDate,
        Timestamp beginDate,
        Timestamp endDate,
        String paidBy,
        String paidByOrganizationId,
        BigDecimal rebateAmount,
        int rebateTimeAllowed,
        int ticketStateId,
        int ticketTypeId,
        List<ZonePricingMaximum> zonePricingMaximums,
        List<ZonePricingUnit> zonePricingUnits
) { }
