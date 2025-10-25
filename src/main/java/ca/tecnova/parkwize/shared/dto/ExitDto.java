package ca.tecnova.parkwize.shared.dto;

import java.sql.Timestamp;

public record ExitDto(
        Long accessId,
        int zoneId,
        int parkId,
        Long ticketId,
        String entryKioskId,
        String exitKioskId,
        Timestamp entryDate,
        Timestamp exitDate,
        String vehicleId
) { }
