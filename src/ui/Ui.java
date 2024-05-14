package src.ui;

import src.objects.carmodeldao.CarModel;
import src.objects.carmodeldao.CarModelCRUD;
import src.objects.customerdao.Customer;
import src.objects.customerdao.CustomerCRUD;
import src.objects.orderdao.Order;
import src.objects.orderdao.OrderCRUD;
import src.objects.orderstatusdao.OrderState;
import src.objects.orderstatusdao.OrderStateCRUD;
import src.objects.taxidao.Taxi;
import src.objects.taxidao.TaxiCRUD;
import src.objects.taxistatusdao.TaxiStatus;
import src.objects.taxistatusdao.TaxiStatusCRUD;
import src.objects.taxitypedao.TaxiType;
import src.objects.taxitypedao.TaxiTypeCRUD;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Ui {
    public Scanner sc = new Scanner(System.in);
    private static TaxiCRUD taxiCRUD = new TaxiCRUD();
    private static OrderCRUD orderCRUD = new OrderCRUD();
    private static CustomerCRUD customerCRUD = new CustomerCRUD();
    private static CarModelCRUD carModelCRUD = new CarModelCRUD();
    private static TaxiStatusCRUD taxiStatusCRUD = new TaxiStatusCRUD();
    private static TaxiTypeCRUD taxiTypeCRUD = new TaxiTypeCRUD();
    private static OrderStateCRUD orderStateCRUD = new OrderStateCRUD();

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
                    showOneCustomer();
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
        Taxi taxi = null;

        int taxiId = getControlledIntegerInput("Introdueix el id del taxi que vols veure: ");
        taxi = taxiCRUD.read(taxiId);

        while (taxi == null) {
            System.out.println("Error! El id no s'ha trobat");
            taxiId = getControlledIntegerInput("Introdueix el id del taxi que vols veure: ");
            taxi = taxiCRUD.read(taxiId);
        }
        System.out.println();
        System.out.println(taxi);
    }

    private void createNewTaxi() throws SQLException {
        CarModel carModel = null;
        TaxiStatus taxiStatus = null;
        TaxiType type = null;

        int taxiModelId = getControlledIntegerInput("Introdueix el id del model del taxi: ");
        int taxisStatusId = getControlledIntegerInput("Introdueix el id del estat del taxi: ");
        int taxisTypeId = getControlledIntegerInput("Introdueix el id del tipus de taxi: ");

        carModel = carModelCRUD.read(taxiModelId);
        taxiStatus = taxiStatusCRUD.read(taxisStatusId);
        type = taxiTypeCRUD.read(taxisTypeId);

        while (carModel == null || taxiStatus == null  || type == null ) {
            System.out.println("Error! Dades incorrecte sisplau introdueix ids existents en la base de dades");
            taxiModelId = getControlledIntegerInput("Introdueix el id del model del taxi: ");
            taxisStatusId = getControlledIntegerInput("Introdueix el id del estat del taxi: ");
            taxisTypeId = getControlledIntegerInput("Introdueix el id del tipus de taxi: ");

            carModel = carModelCRUD.read(taxiModelId);
            taxiStatus = taxiStatusCRUD.read(taxisStatusId);
            type = taxiTypeCRUD.read(taxisTypeId);
        }


        System.out.println("Creat taxi: " + taxiCRUD.create(new Taxi(0, taxiModelId, taxisStatusId, taxisTypeId)));
    }

    private void modifyOneTaxi() throws SQLException {
        CarModel carModel = null;
        TaxiStatus taxiStatus = null;
        TaxiType type = null;
        Taxi taxi = null;

        int taxiId = getControlledIntegerInput("Introdueix el id del taxi que vols modificar: ");
        taxi = taxiCRUD.read(taxiId);

        while (taxi == null) {
            System.out.println("Error! El id no s'ha trobat");
            taxiId = getControlledIntegerInput("Introdueix el id del taxi que vols modificar: ");
            taxi = taxiCRUD.read(taxiId);
        }

        int taxiModelId = getControlledIntegerInput("Introdueix el nou id del model del taxi: ");
        int taxisStatusId = getControlledIntegerInput("Introdueix el nou id del estat del taxi: ");
        int taxisTypeId = getControlledIntegerInput("Introdueix el nou id del tipus de taxi: ");


        while (carModel == null || taxiStatus == null  || type == null ) {
            System.out.println("Error! Dades incorrecte sisplau introdueix ids existents en la base de dades");
            taxiModelId = getControlledIntegerInput("Introdueix el id del model del taxi: ");
            taxisStatusId = getControlledIntegerInput("Introdueix el id del estat del taxi: ");
            taxisTypeId = getControlledIntegerInput("Introdueix el id del tipus de taxi: ");

            carModel = carModelCRUD.read(taxiModelId);
            taxiStatus = taxiStatusCRUD.read(taxisStatusId);
            type = taxiTypeCRUD.read(taxisTypeId);
        }

        taxi.setCarModel(taxiModelId);
        taxi.setTaxiStatus(taxisStatusId);
        taxi.setTaxiType(taxisTypeId);

        taxiCRUD.update(taxi);
    }

    public void deleteOneTaxi() throws SQLException {
        Taxi taxi = null;

        int taxiId = getControlledIntegerInput("Introdueix el id del taxi que vols eliminar: ");
        taxi = taxiCRUD.read(taxiId);

        while (taxi == null) {
            System.out.println("Error! El id no s'ha trobat");
            taxiId = getControlledIntegerInput("Introdueix el id del taxi que vols eliminar: ");
            taxi = taxiCRUD.read(taxiId);
        }

        taxiCRUD.delete(taxi.getTaxiId());
    }


    private void showOrders() throws SQLException {
        for (Order order : orderCRUD.getEntities()) {
            System.out.println(order);
        }
    }

    private void showOneOrder() throws SQLException {
        Order order = null;

        int idOrder = getControlledIntegerInput("Introdueix quin order vols veure: ");
        order = orderCRUD.read(idOrder);

        while (order == null) {
            System.out.println("Error! El id no s'ha trobat");
            idOrder = getControlledIntegerInput("Introdueix quin order vols veure: ");
            order = orderCRUD.read(idOrder);
        }

        System.out.println();
        System.out.println(order);
    }

    private void createNewOrder() throws SQLException {
        Taxi taxi = null;
        OrderState orderState = null;
        Customer customer = null;

        int orderTaxiId = getControlledIntegerInput("Introdueix el id del taxi: ");
        int orderStatusId = getControlledIntegerInput("Introdueix el id del estat del order: ");
        int orderCustomerId = getControlledIntegerInput("Introdueix el id de client: ");

        taxi = taxiCRUD.read(orderTaxiId);
        orderState = orderStateCRUD.read(orderStatusId);
        customer = customerCRUD.read(orderCustomerId);

        while (taxi == null || orderState == null || customer == null) {
            System.out.println("Error! Dades incorrecte sisplau introdueix ids existents en la base de dades");
            orderTaxiId = getControlledIntegerInput("Introdueix el id del taxi: ");
            orderStatusId = getControlledIntegerInput("Introdueix el id del estat del order: ");
            orderCustomerId = getControlledIntegerInput("Introdueix el id de client: ");

            taxi = taxiCRUD.read(orderTaxiId);
            orderState = orderStateCRUD.read(orderStatusId);
            customer = customerCRUD.read(orderCustomerId);

        }

        sc.nextLine();
        System.out.print("Introdueix la data de comenci del servei en aquest format(dd/mm/yyyy hh:mm:ss): ");
        LocalDateTime dateStartOrder = orderCRUD.convertStringToLocalDateSqlite(sc.nextLine());
        System.out.print("Introdueix la data de fi del servei en aquest format(dd/mm/yyyy hh:mm:ss): ");
        LocalDateTime dateEndOrder = orderCRUD.convertStringToLocalDateSqlite(sc.nextLine());
        System.out.print("Introdueix la localitzacio de comenci del servei en aquest format (x.y): ");
        String locationStartOrder = sc.nextLine();
        System.out.print("Introdueix la localitzacio de fi del servei en aquest format (x.y): ");
        String locationEndOrder = sc.nextLine();

        System.out.println("Creat order: " + orderCRUD.create(new Order(0, orderTaxiId, orderStatusId, orderCustomerId,
                dateStartOrder, dateEndOrder, locationStartOrder, locationEndOrder)));
    }

    private void modifyOneOrder() throws SQLException {
        Taxi taxi = null;
        OrderState orderState = null;
        Customer customer = null;
        Order order = null;

        int orderId = getControlledIntegerInput("Introdueix el id de order que vols modificar: ");
        order = orderCRUD.read(orderId);

        while (order == null) {
            System.out.println("Error! El id no s'ha trobat");
            orderId = getControlledIntegerInput("Introdueix el id de order que vols modificar: ");
            order = orderCRUD.read(orderId);
        }

        int orderTaxiId = getControlledIntegerInput("Introdueix el nou id del taxi: ");
        int orderStatusId = getControlledIntegerInput("Introdueix el nou id del estat del order: ");
        int orderCustomerId = getControlledIntegerInput("Introdueix el nou id client de order: ");

        taxi = taxiCRUD.read(orderTaxiId);
        orderState = orderStateCRUD.read(orderStatusId);
        customer = customerCRUD.read(orderCustomerId);

        while (taxi == null || orderState == null || customer == null) {
            System.out.println("Error! Dades incorrecte sisplau introdueix ids existents en la base de dades");
            orderTaxiId = getControlledIntegerInput("Introdueix el id del taxi: ");
            orderStatusId = getControlledIntegerInput("Introdueix el id del estat del order: ");
            orderCustomerId = getControlledIntegerInput("Introdueix el id de client: ");

            taxi = taxiCRUD.read(orderTaxiId);
            orderState = orderStateCRUD.read(orderStatusId);
            customer = customerCRUD.read(orderCustomerId);

        }

        sc.nextLine();
        System.out.print("Introdueix la data de comenci del servei en aquest format(dd/mm/yyyy hh:mm:ss): ");
        LocalDateTime dateStartOrder = orderCRUD.convertStringToLocalDateSqlite(sc.nextLine());
        System.out.print("Introdueix la data de fi del servei en aquest format(dd/mm/yyyy hh:mm:ss): ");
        LocalDateTime dateEndOrder = orderCRUD.convertStringToLocalDateSqlite(sc.nextLine());
        System.out.print("Introdueix la localitzacio de comenci del servei en aquest format (x.y): ");
        String locationStartOrder = sc.nextLine();
        System.out.print("Introdueix la localitzacio de fi del servei en aquest format (x.y): ");
        String locationEndOrder = sc.nextLine();

        order.setState(orderStatusId);
        order.setTaxi(orderTaxiId);
        order.setCustomer(orderCustomerId);
        order.setLocationStartOrder(locationStartOrder);
        order.setLocationEndOrder(locationEndOrder);
        order.setDateStartOrder(dateStartOrder);
        order.setDateEndOrder(dateEndOrder);

        orderCRUD.update(new Order(orderId, orderTaxiId, orderStatusId, orderCustomerId,
                dateStartOrder, dateEndOrder, locationStartOrder, locationEndOrder));
    }

    public void deleteOneOrder() throws SQLException {
        Order order = null;

        int idOrder = getControlledIntegerInput("Introdueix quin order vols eliminar: ");
        order = orderCRUD.read(idOrder);

        while (order == null) {
            System.out.println("Error! El id no s'ha trobat");
            idOrder = getControlledIntegerInput("Introdueix quin order vols eliminar: ");
            order = orderCRUD.read(idOrder);
        }

        orderCRUD.delete(order.getOrderId());
    }

    //TODO: FALTA CUSTOMERS

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
        sc.nextLine();
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
        sc.nextLine();
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
