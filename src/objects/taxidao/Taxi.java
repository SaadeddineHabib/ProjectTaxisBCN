package src.objects.taxidao;

public class Taxi {
    private int taxiId;
    private int  carModel;
    private int taxiStatus;
    private int taxiType;

    public Taxi(int taxiId, int carModel, int taxiStatus, int taxiType) {
        this.taxiId = taxiId;
        this.carModel = carModel;
        this.taxiStatus = taxiStatus;
        this.taxiType = taxiType;
    }

    public Taxi() {
    }

    public int getTaxiId() {
        return taxiId;
    }

    public void setTaxiId(int taxiId) {
        this.taxiId = taxiId;
    }

    public int getCarModel() {
        return carModel;
    }

    public void setCarModel(int carModel) {
        this.carModel = carModel;
    }

    public int getTaxiStatus() {
        return taxiStatus;
    }

    public void setTaxiStatus(int taxiStatus) {
        this.taxiStatus = taxiStatus;
    }

    public int getTaxiType() {
        return taxiType;
    }

    public void setTaxiType(int taxiType) {
        this.taxiType = taxiType;
    }

    @Override
    public String toString() {
        return "Taxi{" +
                "taxiId=" + taxiId +
                ", carModel=" + carModel +
                ", taxiStatus=" + taxiStatus +
                ", taxiType=" + taxiType +
                '}';
    }
}
