package src.objects;

public class Order {
    private String ServiceID;
    private Taxi taxi;
    private State state;
    private String DateStartService;
    private String DateEndService;
    private String LocationStartService;
    private String LocationEndService;

    enum State {
        STARTED, CANCELED, FINISHED;
    }

    public Order(String serviceID, Taxi taxi, State state, String dateStartService, String dateEndService, String locationStartService, String locationEndService) {
        ServiceID = serviceID;
        this.taxi = taxi;
        this.state = state;
        DateStartService = dateStartService;
        DateEndService = dateEndService;
        LocationStartService = locationStartService;
        LocationEndService = locationEndService;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public String getServiceID() {
        return ServiceID;
    }

    public void setServiceID(String serviceID) {
        ServiceID = serviceID;
    }

    public Taxi getTaxi() {
        return taxi;
    }

    public void setTaxi(Taxi taxi) {
        this.taxi = taxi;
    }

    public String getDateStartService() {
        return DateStartService;
    }

    public void setDateStartService(String dateStartService) {
        DateStartService = dateStartService;
    }

    public String getDateEndService() {
        return DateEndService;
    }

    public void setDateEndService(String dateEndService) {
        DateEndService = dateEndService;
    }

    public String getLocationStartService() {
        return LocationStartService;
    }

    public void setLocationStartService(String locationStartService) {
        LocationStartService = locationStartService;
    }

    public String getLocationEndService() {
        return LocationEndService;
    }

    public void setLocationEndService(String locationEndService) {
        LocationEndService = locationEndService;
    }

    @Override
    public String toString() {
        return "Order{" +
                "ServiceID='" + ServiceID + '\'' +
                ", taxi=" + taxi +
                ", state=" + state +
                ", DateStartService='" + DateStartService + '\'' +
                ", DateEndService='" + DateEndService + '\'' +
                ", LocationStartService='" + LocationStartService + '\'' +
                ", LocationEndService='" + LocationEndService + '\'' +
                '}';
    }
}
