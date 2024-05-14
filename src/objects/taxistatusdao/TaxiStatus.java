package src.objects.taxistatusdao;

public class TaxiStatus {
    private int taxiStatusId;
    private String name;

    public TaxiStatus(int taxiStatusId, String name) {
        this.taxiStatusId = taxiStatusId;
        this.name = name;
    }

    public TaxiStatus() {
    }

    public int getTaxiStatusId() {
        return taxiStatusId;
    }

    public void setTaxiStatusId(int taxiStatusId) {
        this.taxiStatusId = taxiStatusId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "TaxiStatus{" +
                "taxiStatusId=" + taxiStatusId +
                ", name='" + name + '\'' +
                '}';
    }
}
