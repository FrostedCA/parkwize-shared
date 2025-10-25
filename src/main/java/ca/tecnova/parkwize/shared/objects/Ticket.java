package ca.tecnova.parkwize.shared.objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Ticket implements ITableObject {

    @JsonProperty("Id")
    private Long ticketId;

    @JsonProperty("CompanyId")
    private int companyId;

    @JsonProperty("TicketStateId")
    private int ticketStateId;

    @JsonProperty("CustomerId")
    private String customerId;

    @JsonProperty("TicketTypeId")
    private int ticketTypeId;

    @JsonProperty("BeginDate")
    private Timestamp beginDate;

    @JsonProperty("EndDate")
    private Timestamp endDate;

    @JsonProperty("IssueDate")
    private Timestamp issueDate;

    @JsonProperty("RebateAmount")
    private BigDecimal rebateAmount;

    @JsonProperty("RebateTimeAllowed")
    private int rebateTimeAllowed;

    @JsonProperty("PaidBy")
    private String paidBy;

    @JsonProperty("PaidByOrganizationId")
    private String paidByOrgId;

    @JsonProperty("ZonePrincingMaximums")
    private List<ZonePricingMaximum> zonePricingMaximums;

    @JsonProperty("ZonePrincingUnits")
    private List<ZonePricingUnit> zonePricingUnits;

    public Long getTicketId() {
        return ticketId;
    }

    public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public int getTicketStateId() {
        return ticketStateId;
    }

    public void setTicketStateId(int ticketStateId) {
        this.ticketStateId = ticketStateId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public int getTicketTypeId() {
        return ticketTypeId;
    }

    public void setTicketTypeId(int ticketTypeId) {
        this.ticketTypeId = ticketTypeId;
    }

    public Timestamp getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Timestamp beginDate) {
        this.beginDate = beginDate;
    }

    public Timestamp getEndDate() {
        return endDate;
    }

    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
    }

    public Timestamp getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Timestamp issueDate) {
        this.issueDate = issueDate;
    }

    public BigDecimal getRebateAmount() {
        return rebateAmount;
    }

    public void setRebateAmount(BigDecimal rebateAmount) {
        this.rebateAmount = rebateAmount;
    }

    public int getRebateTimeAllowed() {
        return rebateTimeAllowed;
    }

    public void setRebateTimeAllowed(int rebateTimeAllowed) {
        this.rebateTimeAllowed = rebateTimeAllowed;
    }

    public String getPaidBy() {
        return paidBy;
    }

    public void setPaidBy(String paidBy) {
        this.paidBy = paidBy;
    }

    public String getPaidByOrgId() {
        return paidByOrgId;
    }

    public void setPaidByOrgId(String paidByOrgId) {
        this.paidByOrgId = paidByOrgId;
    }

    public List<ZonePricingMaximum> getZonePricingMaximums() {
        return zonePricingMaximums;
    }

    public void setZonePricingMaximums(List<ZonePricingMaximum> zonePricingMaximums) {
        this.zonePricingMaximums = zonePricingMaximums;
    }

    public List<ZonePricingUnit> getZonePricingUnits() {
        return zonePricingUnits;
    }

    public void setZonePricingUnits(List<ZonePricingUnit> zonePricingUnits) {
        this.zonePricingUnits = zonePricingUnits;
    }

    @Override
    public Map<String, Object> getMap() {
        Map<String, Object> ticketMap = new HashMap<>();
        ticketMap.put("ticket_id", this.getTicketId());
        ticketMap.put("ticket_state_id", this.getTicketStateId());
        ticketMap.put("ticket_type_id", this.getTicketTypeId());
        ticketMap.put("begin_date", this.getBeginDate());
        ticketMap.put("end_date", this.getEndDate());
        ticketMap.put("issue_date", this.getIssueDate());
        ticketMap.put("rebate_amount", this.getRebateAmount());
        ticketMap.put("rebate_time_allowed", this.getRebateTimeAllowed());
        ticketMap.put("paid_by", this.getPaidByOrgId());
        return ticketMap;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketId='" + ticketId + '\'' +
                ", companyId='" + companyId + '\'' +
                ", ticketStateId='" + ticketStateId + '\'' +
                ", customerId='" + customerId + '\'' +
                ", ticketTypeId='" + ticketTypeId + '\'' +
                ", beginDate='" + beginDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", issueDate='" + issueDate + '\'' +
                ", rebateAmount='" + rebateAmount + '\'' +
                ", rebateTimeAllowed='" + rebateTimeAllowed + '\'' +
                ", paidBy='" + paidBy + '\'' +
                ", paidByOrgId='" + paidByOrgId + '\'' +
                '}';
    }
}
