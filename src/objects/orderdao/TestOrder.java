package src.objects.orderdao;

import src.objects.taxidao.Taxi;
import src.objects.taxidao.TaxiCRUD;

import java.sql.SQLException;
import java.time.LocalDateTime;

public class TestOrder {
    public static void main(String[] args) throws SQLException {
        OrderCRUD orderCRUD = new OrderCRUD();

        for (Order order : orderCRUD.getEntities()) {
            System.out.println(order);
        }

        System.out.println();

        System.out.println(orderCRUD.read(2));

        System.out.println();

        Order order = new Order(0, 30,2,1,
                LocalDateTime.of(2018,3,24,5,6),
                LocalDateTime.of(2018,3,24,12,6),
                "4.2", "4.9");

        order.setOrderId(orderCRUD.create(order));

        System.out.println();

        System.out.println(orderCRUD.read(order.getOrderId()));

        System.out.println();

        orderCRUD.delete(order.getOrderId());

        System.out.println();

        for (Order order1 : orderCRUD.getEntities()) {
            System.out.println(order1);
        }

        System.out.println();

        Order order1 = orderCRUD.read(7);

        order1.setState(3);

        orderCRUD.update(order1);

        for (Order order2 : orderCRUD.getEntities()) {
            System.out.println(order2);
        }

    }
}
