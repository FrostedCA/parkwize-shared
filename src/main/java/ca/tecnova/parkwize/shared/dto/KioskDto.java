package ca.tecnova.parkwize.shared.dto;

public record KioskDto(
        String id,
        String name,
        String businessId,
        String fetchUrl,
        int companyId
) {
    @Override
    public String toString() {
        return "KioskDto{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", businessId='" + businessId + '\'' +
                ", fetchUrl='" + fetchUrl + '\'' +
                ", companyId=" + companyId +
                '}';
    }
}
