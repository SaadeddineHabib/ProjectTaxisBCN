package src.ui;

import src.objects.customerdao.Customer;
import src.objects.customerdao.CustomerCRUD;
import src.objects.orderdao.Order;
import src.objects.orderdao.OrderCRUD;
import src.objects.taxidao.Taxi;
import src.objects.taxidao.TaxiCRUD;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Ui {
    public Scanner sc = new Scanner(System.in);
    private static TaxiCRUD taxiCRUD = new TaxiCRUD();
    private static OrderCRUD orderCRUD = new OrderCRUD();
    private static CustomerCRUD customerCRUD = new CustomerCRUD();
    public static Menus menus = new Menus();

    public int getControlledIntegerInput(String textToDisplay) {
        int intInput;
        while (true) {
            try {
                System.out.print(textToDisplay);
                intInput = sc.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Error! Introdueix un numero valid.");
                sc.nextLine();
            }
        }
        return intInput;
    }

    public void runOrderPanel() throws SQLException {
        int opcio = getControlledIntegerInput(menus.showOrderMenu());
        while (opcio != 0) {
            switch (opcio) {
                case 1:
                    createNewOrder();
                    break;
                case 2:
                    deleteOneOrder();
                    break;
                case 3:
                    modifyOneOrder();
                    break;
                case 4:
                    showOneOrder();
                    break;
                case 5:
                    showOrders();
                    break;
            }
            opcio = getControlledIntegerInput(menus.showOrderMenu());
        }
    }


    public void runTaxiPanel() throws SQLException {
        int opcio = getControlledIntegerInput(menus.showTaxiMenu());
        while (opcio != 0) {
            switch (opcio) {
                case 1:
                    createNewTaxi();
                    break;
                case 2:
                    deleteOneTaxi();
                    break;
                case 3:
                    modifyOneTaxi();
                    break;
                case 4:
                    showOneTaxi();
                    break;
                case 5:
                    showTaxis();
                    break;
            }
            opcio = getControlledIntegerInput(menus.showTaxiMenu());
        }
    }

    public void runCustomerPanel() throws SQLException {
        int opcio = getControlledIntegerInput(menus.showCustomerMenu());
        while (opcio != 0) {
            switch (opcio) {
                case 1:
                    createNewCustomer();
                    break;
                case 2:
                    deleteOneCustomer();
                    break;
                case 3:
                    modifyOneCustomer();
                    break;
                case 4:
                    showOneOrder();
                    break;
                case 5:
                    showCustomers();
                    break;
            }
            opcio = getControlledIntegerInput(menus.showCustomerMenu());
        }
    }


    public void runProgram() throws SQLException {

        int opcio = getControlledIntegerInput(menus.showMainMenu());
        while (opcio != 0) {
            switch (opcio) {
                case 1:
                    runTaxiPanel();
                    break;
                case 2:
                    runOrderPanel();
                    break;
                case 3:
                    runCustomerPanel();
                    break;
            }
            opcio = getControlledIntegerInput(menus.showMainMenu());
        }
    }

    private void showTaxis() throws SQLException {
        for (Taxi taxi : taxiCRUD.getEntities()) {
            System.out.println(taxi);
        }
    }

    private void showOneTaxi() throws SQLException {
        int idTaxi = getControlledIntegerInput("Introdueix quin Taxi vols veure: ");

        System.out.println(taxiCRUD.read(idTaxi));
    }

    private void createNewTaxi() throws SQLException {
        int taxiModelId = getControlledIntegerInput("Introdueix el id del model del taxi: ");
        int taxisStatusId = getControlledIntegerInput("Introdueix el id del estat del taxi: ");
        int taxisTypeId = getControlledIntegerInput("Introdueix el id del tipus de taxi: ");

        System.out.println("Creat taxi: " + taxiCRUD.create(new Taxi(0, taxiModelId, taxisStatusId, taxisTypeId)));
    }

    private void modifyOneTaxi() throws SQLException {
        int taxiId = getControlledIntegerInput("Introdueix el nou id del taxi: ");
        int taxiModelId = getControlledIntegerInput("Introdueix el nou id del model del taxi: ");
        int taxisStatusId = getControlledIntegerInput("Introdueix el nou id del estat del taxi: ");
        int taxisTypeId = getControlledIntegerInput("Introdueix el nou id del tipus de taxi: ");

        taxiCRUD.update(new Taxi(taxiId, taxiModelId, taxisStatusId, taxisTypeId));
    }

    public void deleteOneTaxi() throws SQLException {
        int taxiId = getControlledIntegerInput("Introdueix el id del taxi: ");
        taxiCRUD.delete(taxiId);
    }


    private void showOrders() throws SQLException {
        for (Order order : orderCRUD.getEntities()) {
            System.out.println(order);
        }
    }

    private void showOneOrder() throws SQLException {
        int idOrder = getControlledIntegerInput("Introdueix quin order vols veure: ");

        System.out.println(orderCRUD.read(idOrder));
    }

    private void createNewOrder() throws SQLException {
        int orderTaxiId = getControlledIntegerInput("Introdueix el id del taxi: ");
        int orderStatusId = getControlledIntegerInput("Introdueix el id del estat del order: ");
        int orderCustomerId = getControlledIntegerInput("Introdueix el id de client: ");

        System.out.print("Introdueix la data de comenci del servei en aquest format(dd/mm/yy hh:mm:ss): ");
        LocalDateTime dateStartOrder = orderCRUD.convertStringToLocalDateSqlite(sc.nextLine());
        System.out.print("Introdueix la data de fi del servei en aquest format(dd/mm/yy hh:mm:ss): ");
        LocalDateTime dateEndOrder = orderCRUD.convertStringToLocalDateSqlite(sc.nextLine());
        System.out.print("Introdueix la localitzacio de comenci del servei en aquest format (x.y): ");
        String LocationStartOrder = sc.nextLine();
        System.out.print("Introdueix la localitzacio de fi del servei en aquest format (x.y): ");
        String LocationEndOrder = sc.nextLine();


        System.out.println("Creat order: " + orderCRUD.create(new Order(0, orderTaxiId, orderStatusId, orderCustomerId,
                dateStartOrder, dateEndOrder, LocationStartOrder, LocationEndOrder)));
    }

    private void modifyOneOrder() throws SQLException {
        int orderId = getControlledIntegerInput("Introdueix el id de order que vols modificar: ");

        int orderTaxiId = getControlledIntegerInput("Introdueix el nou id del model del taxi: ");
        int orderStatusId = getControlledIntegerInput("Introdueix el nou id del estat del taxi: ");
        int orderCustomerId = getControlledIntegerInput("Introdueix el nou id del tipus de taxi: ");

        System.out.print("Introdueix la data de comenci del servei en aquest format(dd/mm/yy hh:mm:ss): ");
        LocalDateTime dateStartOrder = orderCRUD.convertStringToLocalDateSqlite(sc.nextLine());
        System.out.print("Introdueix la data de fi del servei en aquest format(dd/mm/yy hh:mm:ss): ");
        LocalDateTime dateEndOrder = orderCRUD.convertStringToLocalDateSqlite(sc.nextLine());
        System.out.print("Introdueix la localitzacio de comenci del servei en aquest format (x.y): ");
        String LocationStartOrder = sc.nextLine();
        System.out.print("Introdueix la localitzacio de fi del servei en aquest format (x.y): ");
        String LocationEndOrder = sc.nextLine();

        orderCRUD.update(new Order(orderId, orderTaxiId, orderStatusId, orderCustomerId,
                dateStartOrder, dateEndOrder, LocationStartOrder, LocationEndOrder));
    }

    public void deleteOneOrder() throws SQLException {
        int orderId = getControlledIntegerInput("Introdueix el id del order: ");
        orderCRUD.delete(orderId);
    }

    private void showCustomers() throws SQLException {
        for (Customer customer : customerCRUD.getEntities()) {
            System.out.println(customer);
        }
    }

    private void showOneCustomer() throws SQLException {
        int idCustomer = getControlledIntegerInput("Introdueix quin client vols veure: ");
        System.out.println(customerCRUD.read(idCustomer));
    }

    private void createNewCustomer() throws SQLException {
        System.out.print("Introdueix el nom del client: ");
        String customerName = sc.nextLine();
        System.out.print("Introdueix el cognom del client: ");
        String customerLastname = sc.nextLine();
        int customerAge = getControlledIntegerInput("Introdueix la edat del client: ");

        System.out.println("Creat customer: " + customerCRUD.create(new Customer(0, customerName, customerLastname, customerAge)));
    }

    private void modifyOneCustomer() throws SQLException {
        int idCustomer = getControlledIntegerInput("Introdueix quin client vols modificar: ");
        System.out.print("Introdueix el nom del client: ");
        String customerName = sc.nextLine();
        System.out.print("Introdueix el cognom del client: ");
        String customerLastname = sc.nextLine();
        int customerAge = getControlledIntegerInput("Introdueix la edat del client: ");

        customerCRUD.update(new Customer(idCustomer, customerName, customerLastname, customerAge));
    }

    public void deleteOneCustomer() throws SQLException {
        int customerId = getControlledIntegerInput("Introdueix el id del customer: ");
        customerCRUD.delete(customerId);
    }

}
