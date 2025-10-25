package ca.tecnova.parkwize.shared.objects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ZonePricingMaximum {
    @JsonProperty("Minutes")
    private int minutes;

    @JsonProperty("Pricing")
    private double pricing;

    @JsonProperty("RowState")
    private String rowState;

    // Getters and setters
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
        return "ZonePricingMaximum{" +
                "minutes=" + minutes +
                ", pricing=" + pricing +
                ", rowState='" + rowState + '\'' +
                '}';
    }
}
