package ca.tecnova.parkwize.shared.objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Access implements ITableObject {

    @JsonProperty("Id")
    private Long accessId;

    @JsonProperty("ZoneId")
    private int zoneId;

    @JsonProperty("ParkId")
    private int parkId;

    @JsonProperty("TicketId")
    private Long ticketId;

    @JsonProperty("KioskEntryId")
    private String kioskEntryId;

    @JsonProperty("KioskEntryDate")
    private String kioskEntryDate;

    @JsonProperty("KioskEntryVehicleId")
    private String vehicleEntryId;

    @JsonProperty("KioskExitId")
    private String kioskExitId;

    @JsonProperty("KioskExitDate")
    private String kioskExitDate;

    @JsonProperty("KioskExitVehicleId")
    private String vehicleExitId;

    public Long getAccessId() {
        return accessId;
    }

    public int getZoneId() {
        return zoneId;
    }

    public int getParkId() {
        return parkId;
    }

    public Long getTicketId() {
        return ticketId;
    }

    public String getKioskEntryId() {
        return kioskEntryId;
    }

    public String getKioskEntryDate() {
        return kioskEntryDate;
    }

    public String getKioskExitId() {
        return kioskExitId;
    }

    public String getKioskExitDate() {
        return kioskExitDate;
    }

    public String getVehicleEntryId() {
        return vehicleEntryId;
    }

    public String getVehicleExitId() {
        return vehicleExitId;
    }

    @Override
    public String toString() {
        return "Access{" +
                "accessId='" + accessId + '\'' +
                ", zoneId='" + zoneId + '\'' +
                ", parkId='" + parkId + '\'' +
                ", ticketId='" + ticketId + '\'' +
                ", kioskEntryId='" + kioskEntryId + '\'' +
                ", kioskEntryDate='" + kioskEntryDate + '\'' +
                ", vehicleEntryId='" + vehicleEntryId + '\'' +
                ", kioskExitId='" + kioskExitId + '\'' +
                ", kioskExitDate='" + kioskExitDate + '\'' +
                ", vehicleExitId='" + vehicleExitId + '\'' +
                '}';
    }

    @Override
    public Map<String, Object> getMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("access_id", this.getAccessId());
        map.put("kiosk_id", this.getKioskEntryId());
        map.put("ticket_id", this.getTicketId());
        map.put("entry_time", this.getKioskEntryDate());
        map.put("vehicle_plate", this.getVehicleEntryId());
        return map;
    }

    public Map<String, Object> getExitsMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("access_id", this.getAccessId());
        map.put("kiosk_id", this.getKioskExitId());
        map.put("ticket_id", this.getTicketId());
        map.put("exit_time", this.getKioskExitDate());
        map.put("vehicle_plate", this.getVehicleExitId());
        return map;
    }
}
