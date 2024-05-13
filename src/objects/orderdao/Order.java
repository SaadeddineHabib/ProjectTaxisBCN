package src.objects.orderdao;

import src.objects.customerdao.Customer;
import src.objects.taxidao.Taxi;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Order {
    private int orderId;
    private int taxi;
    private int state;
    private int customer;
    private LocalDateTime DateStartOrder;
    private LocalDateTime DateEndOrder;
    private String LocationStartOrder;
    private String LocationEndOrder;

    public Order(int orderId, int taxi, int state, int customer, LocalDateTime dateStartOrder, LocalDateTime dateEndOrder, String locationStartOrder, String locationEndOrder) {
        this.orderId = orderId;
        this.taxi = taxi;
        this.state = state;
        this.customer = customer;
        DateStartOrder = dateStartOrder;
        DateEndOrder = dateEndOrder;
        LocationStartOrder = locationStartOrder;
        LocationEndOrder = locationEndOrder;
    }

    public Order() {
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getTaxi() {
        return taxi;
    }

    public void setTaxi(int taxi) {
        this.taxi = taxi;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getCustomer() {
        return customer;
    }

    public void setCustomer(int customer) {
        this.customer = customer;
    }

    public LocalDateTime getDateStartOrder() {
        return DateStartOrder;
    }

    public void setDateStartOrder(LocalDateTime dateStartOrder) {
        DateStartOrder = dateStartOrder;
    }

    public LocalDateTime getDateEndOrder() {
        return DateEndOrder;
    }

    public void setDateEndOrder(LocalDateTime dateEndOrder) {
        DateEndOrder = dateEndOrder;
    }

    public String getLocationStartOrder() {
        return LocationStartOrder;
    }

    public void setLocationStartOrder(String locationStartOrder) {
        LocationStartOrder = locationStartOrder;
    }

    public String getLocationEndOrder() {
        return LocationEndOrder;
    }

    public void setLocationEndOrder(String locationEndOrder) {
        LocationEndOrder = locationEndOrder;
    }

    @Override
    public String toString() {
        return "Order{" +
                "ServiceID='" + orderId + '\'' +
                ", taxi=" + taxi +
                ", state=" + state +
                ", DateStartService='" + DateStartOrder + '\'' +
                ", DateEndService='" + DateEndOrder + '\'' +
                ", LocationStartService='" + LocationStartOrder + '\'' +
                ", LocationEndService='" + LocationEndOrder + '\'' +
                '}';
    }
}
