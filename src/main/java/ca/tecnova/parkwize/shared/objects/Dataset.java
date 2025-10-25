package ca.tecnova.parkwize.shared.objects;

public class Dataset {

    private String dataset;
    private String businessId;
    private int companyId;

    public Dataset(String dataset, String businessId, int comapnyId) {
        this.dataset = dataset;
        this.businessId = businessId;
        this.companyId = comapnyId;
    }

    public String getDataset() {
        return dataset;
    }

    public void setDataset(String dataset) {
        this.dataset = dataset;
    }

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    @Override
    public String toString() {
        return "Dataset{" +
                "dataset='" + dataset + '\'' +
                ", businessId='" + businessId + '\'' +
                ", companyId='" + companyId + '\'' +
                '}';
    }
}
