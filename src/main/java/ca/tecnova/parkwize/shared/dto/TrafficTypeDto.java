package ca.tecnova.parkwize.shared.dto;

import java.sql.Timestamp;

public record TrafficTypeDto(
        Long accessId,
        Long ticketId,
        int type,
        Timestamp entryDate
) { }
