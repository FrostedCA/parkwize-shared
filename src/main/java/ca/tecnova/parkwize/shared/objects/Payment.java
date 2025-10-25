package ca.tecnova.parkwize.shared.objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Payment implements ITableObject {

    @JsonProperty("Id")
    private Long paymentId;

    @JsonProperty("AccessId")
    private Long accessId;

    @JsonProperty("KioskId")
    private String kioskId;

    @JsonProperty("PaymentDate")
    private Timestamp paymentDate;

    @JsonProperty("PaymentMethodId")
    private int paymentMethod;

    @JsonProperty("TotalAmount")
    private BigDecimal totalAmount;

    @JsonProperty("Amount")
    private BigDecimal amount;

    @JsonProperty("GST")
    private String gst;

    @JsonProperty("PST")
    private String pst;

    public Long getPaymentId() {
        return paymentId;
    }

    public Long getAccessId() {
        return accessId;
    }

    public String getKioskId() {
        return kioskId;
    }

    public Timestamp getPaymentDate() {
        return paymentDate;
    }

    public int getPaymentMethod() {
        return paymentMethod;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public String getGst() {
        return gst;
    }

    public String getPst() {
        return pst;
    }

    @Override
    public Map<String, Object> getMap() {
        Map<String, Object> map = new HashMap<>();

        map.put("payment_id", this.getPaymentId());
        map.put("access_id", this.getAccessId());
        map.put("kiosk_id", this.getKioskId());
        map.put("payment_date", this.getPaymentDate());
        map.put("payment_method", this.getPaymentMethod());
        map.put("amount", this.getAmount());
        map.put("gst", this.getGst());
        map.put("pst", this.getPst());
        map.put("total_amount", this.getTotalAmount());

        return map;
    }
}
