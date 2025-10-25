package ca.tecnova.parkwize.shared.objects;

public class Kiosk {

    private String id;
    private String name;
    private String fetchUrl;
    private String businessId;

    public Kiosk() {}

    public Kiosk(String id, String name, String fetchUrl, String businessId) {
        this.id = id;
        this.name = name;
        this.fetchUrl = fetchUrl;
        this.businessId = businessId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFetchUrl() {
        return fetchUrl;
    }

    public void setFetchUrl(String fetchUrl) {
        this.fetchUrl = fetchUrl;
    }

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }

    @Override
    public String toString() {
        return "Kiosk{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", fetchUrl='" + fetchUrl + '\'' +
                '}';
    }
}
