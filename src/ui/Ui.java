package src.ui;

import src.objects.Order;
import src.objects.OrderManager;
import src.objects.Taxi;
import src.objects.TaxiManager;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ui {
    public Scanner sc = new Scanner(System.in);

    public static Menus menus = new Menus();
    public OrderManager orderManager = new OrderManager();
    public TaxiManager taxiManager = new TaxiManager();

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

    public void runOrdersPanel() {
        int opcio = getControlledIntegerInput(menus.showOrderMenu());
        while (opcio != 0) {
            switch (opcio) {
                case 1:
                    createOrder();
                    break;
                case 2:
                    orderManager.showOrders();
                    break;
                case 3:
                    showSpecifiedOrder();
                    break;
            }
            opcio = getControlledIntegerInput(menus.showOrderMenu());
        }
    }

    public void runProgram() {
        // Datos precarrgados
        taxiManager.addTaxi(new Taxi("T1", Taxi.Model.FORD, Taxi.Status.BREAK, Taxi.Type.REGULAR));
        taxiManager.addTaxi(new Taxi("T2", Taxi.Model.TOYOTA, Taxi.Status.BREAK, Taxi.Type.REGULAR));
        taxiManager.addTaxi(new Taxi("T3", Taxi.Model.CHEVROLET, Taxi.Status.BREAK, Taxi.Type.REGULAR));
        taxiManager.addTaxi(new Taxi("T4", Taxi.Model.TOYOTA, Taxi.Status.FREE, Taxi.Type.SPECIAL));
        taxiManager.addTaxi(new Taxi("T5", Taxi.Model.NISSAN, Taxi.Status.FREE, Taxi.Type.SPECIAL));
        taxiManager.addTaxi(new Taxi("T6", Taxi.Model.HONDA, Taxi.Status.FREE, Taxi.Type.SPECIAL));

        orderManager.addOrder(new Order("S1", taxiManager.getTaxis().get(0), Order.State.STARTED, "", "", "", ""));
        orderManager.addOrder(new Order("S2", taxiManager.getTaxis().get(1), Order.State.FINISHED, "", "", "", ""));
        orderManager.addOrder(new Order("S3", taxiManager.getTaxis().get(2), Order.State.FINISHED, "", "", "", ""));
        orderManager.addOrder(new Order("S4", taxiManager.getTaxis().get(3), Order.State.STARTED, "", "", "", ""));
        orderManager.addOrder(new Order("S5", taxiManager.getTaxis().get(4), Order.State.CANCELED, "", "", "", ""));
        orderManager.addOrder(new Order("S6", taxiManager.getTaxis().get(5), Order.State.CANCELED, "", "", "", ""));


        int opcio = getControlledIntegerInput(menus.showMainMenu());
        while (opcio != 0) {
            switch (opcio) {
                case 1:
                    createTaxi();
                    break;
                case 2:
                    removeTaxi();
                    break;
                case 3:
                    taxiManager.showRegularTaxis();
                    break;
                case 4:
                    taxiManager.showSpecialTaxis();
                    break;
                case 5:
                    taxiManager.showTaxis();
                    break;
                case 6:
                    showSpecificTaxi();
                    break;
                case 7:
                    runOrdersPanel();
                    break;
            }
            opcio = getControlledIntegerInput(menus.showMainMenu());
        }
    }


    public void createTaxi() {
        for (int i = 0; i < Taxi.Model.values().length; i++) {
            System.out.printf("%s-. %s%n", i + 1, Taxi.Model.values()[i]);

        }
        System.out.print("Select a taxi car model: ");
        int inputModel = getControlledIntegerInput("");
        Taxi.Model taxiModel = switch (inputModel) {
            case 1 -> Taxi.Model.TOYOTA;
            case 2 -> Taxi.Model.HONDA;
            case 3 -> Taxi.Model.FORD;
            case 4 -> Taxi.Model.NISSAN;
            case 5 -> Taxi.Model.CHEVROLET;
            default -> null;
        };

        for (int i = 0; i < Taxi.Type.values().length; i++) {
            System.out.printf("%s-. %s%n", i + 1, Taxi.Type.values()[i]);

        }
        System.out.print("Select a taxi type: ");
        int inputType = getControlledIntegerInput("");
        Taxi.Type taxiType = switch (inputType) {
            case 1 -> Taxi.Type.REGULAR;
            case 2 -> Taxi.Type.SPECIAL;
            default -> null;
        };

        String id = "T" + (taxiManager.getTaxis().size() + 1);

        if (taxiType != null || taxiModel != null) {
            System.out.println("Taxi added correctly");
            taxiManager.addTaxi(new Taxi(id, taxiModel, Taxi.Status.FREE, taxiType));
        } else {
            System.out.println("Error! You must enter a valid taxi model and taxi type.");
        }

        System.out.println();

    }

    public void showSpecificTaxi() {
        if (taxiManager.getTaxis().isEmpty()) {
            System.out.println("The database is empty!.");
        } else {
            System.out.print("Enter the id of the taxi: ");
            String id = sc.next().toUpperCase();
            Taxi taxi = taxiManager.findSpecifiedTaxi(id);

            if (taxi != null) {
                System.out.println(taxi);
            } else {
                System.out.println("Taxi not found");
            }
        }

        System.out.println();
    }

    public void removeTaxi() {
        if (taxiManager.getTaxis().isEmpty()) {
            System.out.println("The database is empty!.");
        } else {
            System.out.print("Enter the id of the taxi: ");
            String id = sc.next().toUpperCase();
            Taxi taxi = taxiManager.findSpecifiedTaxi(id);

            if (taxi != null) {
                System.out.println("Taxi removed correctly");
                taxiManager.removeTaxi(taxi);
            } else {
                System.out.println("Taxi not found");
            }
        }

        System.out.println();
    }


    public void createOrder() {
        System.out.print("Enter the id of the taxi: ");
        String id = sc.next().toUpperCase();
        Taxi taxi = taxiManager.findSpecifiedTaxi(id);

        if (taxi != null) {
            System.out.println("Order added correctly");
            String idOrder = "S" + (orderManager.getOrders().size() + 1);
            orderManager.addOrder(new Order(idOrder, taxi, Order.State.STARTED, "", "", "", ""));
        } else {
            System.out.println("Taxi not found");
        }

    }

    public void showSpecifiedOrder() {
        if (taxiManager.getTaxis().isEmpty()) {
            System.out.println("The database is empty!.");
        } else {
            System.out.print("Enter the id of the order: ");
            String id = sc.next().toUpperCase();
            Order order = orderManager.findSpecifiedOrder(id);

            if (order != null) {
                System.out.println(order);
            } else {
                System.out.println("Order not found");
            }
        }
    }

}
