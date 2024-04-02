package src.objects;

import java.util.ArrayList;
import java.util.List;

public class Orders {
    private List<Order> orders;

    public Orders() {
        orders = new ArrayList<>();
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public void removeOrder(Order order) {
        orders.remove(order);
    }

    public void modifyFieldOrder(String  serviceId, String nombreCampo) {
        Order order = findSpecifiedOrder(serviceId);
        if (order != null){
            // Todo: comprovar si existe campo
        }
    }

    public Order findSpecifiedOrder(String serviceId) {
        Order order = null;
        for (Order orderToFind : orders) {
            if (orderToFind.getServiceID().equals(serviceId)) {
                order = orderToFind;
                break;
            }
        }
        return order;

    }

    @Override
    public String toString() {
        return "Orders{" +
                "orders=" + orders +
                '}';
    }

}
