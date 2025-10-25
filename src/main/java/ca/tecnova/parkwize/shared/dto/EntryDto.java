package ca.tecnova.parkwize.shared.dto;

import java.sql.Timestamp;

public record EntryDto(
        Long accessId,
        int zoneId,
        int parkId,
        Long ticketId,
        String kioskId,
        Timestamp entryDate,
        String vehicleId
) { }
