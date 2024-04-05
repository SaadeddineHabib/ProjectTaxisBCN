package src.objects;

import java.util.ArrayList;
import java.util.List;

public class OrderManager {
    private List<Order> orders;

    public OrderManager() {
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

    public void showOrders() {
        System.out.println("##### ORDERS LIST ####");
        for (Order order : orders) {
            System.out.println(order);
        }
        System.out.println();
    }

    @Override
    public String toString() {
        return "Orders{" +
                "orders=" + orders +
                '}';
    }

}
