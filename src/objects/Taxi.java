package src.objects;

public class Taxi {
    private String ID;
    private Model carModel;
    private Status taxiStatus;
    private Type taxiType;

    public enum Model {
        TOYOTA, HONDA, FORD, NISSAN, CHEVROLET
    }

    public enum Status {
        BREAK, FREE, BUSY
    }

    public enum Type {
        REGULAR, SPECIAL
    }

    public Taxi(String ID, Model carModel, Status taxiStatus, Type taxiType) {
        this.ID = ID;
        this.carModel = carModel;
        this.taxiStatus = taxiStatus;
        this.taxiType = taxiType;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public Model getCarModel() {
        return carModel;
    }

    public void setCarModel(Model carModel) {
        this.carModel = carModel;
    }

    public Status getTaxiStatus() {
        return taxiStatus;
    }

    public void setTaxiStatus(Status taxiStatus) {
        this.taxiStatus = taxiStatus;
    }

    public Type getTaxiType() {
        return taxiType;
    }

    public void setTaxiType(Type taxiType) {
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
