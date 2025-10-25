package ca.tecnova.parkwize.shared.objects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ZonePricingUnit {
    @JsonProperty("Id")
    private int id;

    @JsonProperty("Minutes")
    private int minutes;

    @JsonProperty("Pricing")
    private double pricing;

    @JsonProperty("RowState")
    private String rowState;

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public double getPricing() {
        return pricing;
    }

    public void setPricing(double pricing) {
        this.pricing = pricing;
    }

    public String getRowState() {
        return rowState;
    }

    public void setRowState(String rowState) {
        this.rowState = rowState;
    }

    @Override
    public String toString() {
        return "ZonePricingUnit{" +
                "id=" + id +
                ", minutes=" + minutes +
                ", pricing=" + pricing +
                ", rowState='" + rowState + '\'' +
                '}';
    }
}
