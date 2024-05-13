package src.objects.customerdao;

import src.objects.orderdao.Order;

import java.sql.SQLException;
import java.time.LocalDateTime;

public class TestCustomer {
    public static void main(String[] args) throws SQLException {
        CustomerCRUD customerCRUD = new CustomerCRUD();

        for (Customer customer : customerCRUD.getEntities()) {
            System.out.println(customer);
        }

        System.out.println();

        System.out.println(customerCRUD.read(2));

        System.out.println();

        Customer customer = new Customer(0,"Said","Luckman", 23);

        customer.setId(customerCRUD.create(customer));

        System.out.println();

        System.out.println(customerCRUD.read(customer.getId()));

        System.out.println();

        customerCRUD.delete(customer.getId());

        System.out.println();

        for (Customer customer1 : customerCRUD.getEntities()) {
            System.out.println(customer1);
        }

        System.out.println();

        Customer customer1 = customerCRUD.read(6);

        customer1.setAge(50);

        customerCRUD.update(customer1);

        for (Customer customer2 : customerCRUD.getEntities()) {
            System.out.println(customer2);
        }

    }
}
