package src.objects;

public class Taxi {
    private String ID;
    private Enum carModel;
    private Enum taxiStatus;
    private Enum taxiType;

    public enum models {
        TOYOTA, HONDA, FORD, NISSAN, CHEVROLET
    }

    public enum status {
        BREAK, FREE, BUSY
    }

    public enum type {
        REGULAR, SPECIAL
    }

    public Taxi(String ID, Enum carModel, Enum taxiStatus, Enum taxiType) {
        this.ID = ID;
        this.carModel = carModel;
        this.taxiStatus = taxiStatus;
        this.taxiType = taxiType;
    }

    public Enum getCarModel() {
        return carModel;
    }

    public void setCarModel(Enum carModel) {
        this.carModel = carModel;
    }

    public Enum getTaxiStatus() {
        return taxiStatus;
    }

    public void setTaxiStatus(Enum taxiStatus) {
        this.taxiStatus = taxiStatus;
    }

    public Enum getTaxiType() {
        return taxiType;
    }

    public void setTaxiType(Enum taxiType) {
        this.taxiType = taxiType;
    }

    public String getID() {
        return ID;

    }

    @Override
    public String toString() {
        return "Objetos.Taxi: [ID: " + this.ID + ", model:" + this.carModel + ", status: " + this.taxiStatus + " and type:" + this.taxiType + " ]";
    }
}
