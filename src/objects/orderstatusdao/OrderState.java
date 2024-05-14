package src.objects.orderstatusdao;

public class OrderState {
    private int orderStatusId;
    private String name;

    public OrderState(int orderStatusId, String name) {
        this.orderStatusId = orderStatusId;
        this.name = name;
    }

    public OrderState() {
    }

    public int getOrderStatusId() {
        return orderStatusId;
    }

    public void setOrderStatusId(int orderStatusId) {
        this.orderStatusId = orderStatusId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "OrderState{" +
                "orderStatusId=" + orderStatusId +
                ", name='" + name + '\'' +
                '}';
    }
}
