package ca.tecnova.parkwize.shared.objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;

public class OrganizationPayment {

    @JsonProperty("OrganizationId")
    private Integer organizationId;

    @JsonProperty("CompanyId")
    private Integer companyId;

    @JsonProperty("FiscalPeriod")
    private String fiscalPeriod;

    @JsonProperty("ParkId")
    private Integer parkId;

    @JsonProperty("Amount")
    private BigDecimal amount;

    public Integer getOrganizationId() {
        return organizationId;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public Integer getParkId() {
        return parkId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public LocalDateTime getFiscalPeriodAsDateTime() {
        if (fiscalPeriod == null || fiscalPeriod.length() != 6) {
            return null;
        }

        try {
            int year = Integer.parseInt(fiscalPeriod.substring(0, 4));
            int month = Integer.parseInt(fiscalPeriod.substring(4, 6));

            YearMonth yearMonth = YearMonth.of(year, month);
            LocalDate firstDayOfMonth = yearMonth.atDay(1);

            return firstDayOfMonth.atStartOfDay();
        } catch (NumberFormatException | DateTimeException e) {
            return null;
        }
    }

}
