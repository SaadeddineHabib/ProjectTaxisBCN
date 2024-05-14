package src.objects.taxitypedao;

public class TaxiType {
    private int taxiTypeId;
    private String name;

    public TaxiType(int taxiTypeId, String name) {
        this.taxiTypeId = taxiTypeId;
        this.name = name;
    }

    public TaxiType() {
    }

    public int getTaxiTypeId() {
        return taxiTypeId;
    }

    public void setTaxiTypeId(int taxiTypeId) {
        this.taxiTypeId = taxiTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "TaxiType{" +
                "taxiTypeId=" + taxiTypeId +
                ", name='" + name + '\'' +
                '}';
    }
}
