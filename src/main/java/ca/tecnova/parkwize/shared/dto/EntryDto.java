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
) {
    public EntryDto(Long accessId, int zoneId, int parkId, Long ticketId, String kioskId, Timestamp entryDate, String vehicleId) {
        this.accessId = accessId;
        this.zoneId = zoneId;
        this.parkId = parkId;
        this.ticketId = ticketId;
        this.kioskId = kioskId;
        this.entryDate = entryDate;
        this.vehicleId = vehicleId;
    }
}
