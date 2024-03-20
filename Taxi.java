public class Taxi {
    private String ID;
    private String carModel;
    private char taxiStatus;
    private char taxiType;

    public Taxi(String ID, String carModel, char taxiStatus, char taxiType){
        this.ID = ID;
        this.carModel = carModel;
        this.taxiStatus = taxiStatus;
        this.taxiType = taxiType;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }
    public void setID(String iD) {
        ID = iD;
    }
    public void setTaxiStatus(char taxiStatus) {
        this.taxiStatus = taxiStatus;
    }
    public void setTaxiType(char taxiType) {
        this.taxiType = taxiType;
    }
    public String getCarModel() {
        return carModel;
    }
    public String getID() {
        return ID;
    }public char getTaxiStatus() {
        return taxiStatus;
    }
    public char getTaxiType() {
        return taxiType;
    }
    @Override
    public String toString() {
        return "Taxi: [ID: " + this.ID +", model:" + this.carModel + ", status: " +this.taxiStatus+" and type:"+this.taxiType+" ]";
    }
}
