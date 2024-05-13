package src.others;

import src.objects.customerdao.Customer;

import java.util.List;

public class CustomerManager {
    int numberId = 0;

    private List<Customer> customers;

    public CustomerManager(int numberId, List<Customer> customers) {
        this.numberId = numberId;
        this.customers = customers;
    }

    public int getNumberId() {
        return numberId;
    }

    public List<Customer> getPersonas() {
        return customers;
    }

    public void addPersona(Customer customer) {
        customers.add(customer);
    }

    public void remuvePersonas(Customer customer) {
        customers.remove(customer);
    }

//    public Customer findSpecifiedCustomerForId(String customerId) {
//        Customer customer = null;
//        for (Customer customerToFind : customers) {
//            if (customerToFind.getId().equals(customerId)) {
//                customer = customerToFind;
//                break;
//            }
//        }
//
//        return customer;
//    }

    @Override
    public String toString() {
        return "Customers{" +
                "numberId=" + numberId +
                ", customers=" + customers +
                '}';
    }
}
