package src.menu;

import src.objects.Order;
import src.objects.Orders;
import src.objects.Taxi;
import src.objects.Taxis;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ui {
    public Scanner sc = new Scanner(System.in);

    public static Menus menus = new Menus();
    public Orders orders = new Orders();
    public Taxis taxis = new Taxis();

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
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
            }
            opcio = getControlledIntegerInput(menus.showOrderMenu());
        }
    }

    public void runProgram() {
        int opcio = getControlledIntegerInput(menus.showMainMenu());
        while (opcio != 0) {
            switch (opcio) {
                case 1:
//                    createTaxi();
                    break;
                case 2:
                    break;
                case 3:
                    runOrdersPanel();
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
            }
            opcio = getControlledIntegerInput(menus.showMainMenu());
        }
    }


////    public void createTaxi() {
////        System.out.println("Select a taxi car model: ");
////        for (int i = 0; i < Taxi.models.values().length; i++) {
////            System.out.println(Taxi.models.values()[i]);
////
////        }
////        // Hay que ver como automatizarlo
////        int inputModel = getControlledIntegerInput("");
////        Enum taxiModel = switch (inputModel) {
////            case 1 -> Taxi.models.TOYOTA;
////            case 2 -> Taxi.models.HONDA;
////            case 3 -> Taxi.models.FORD;
////            case 4 -> Taxi.models.NISSAN;
////            case 5 -> Taxi.models.CHEVROLET;
////            default -> null;
////        };
////
////        System.out.println("Select a taxi type : ");
////        for (int i = 0; i < Taxi.type.values().length; i++) {
////            System.out.println(Taxi.models.values()[i]);
////
////        }
////        // Hay que ver como automatizarlo
////        int inputType = getControlledIntegerInput("");
////        Enum taxiType = switch (inputType) {
////            case 1 -> Taxi.type.REGULAR;
////            case 2 -> Taxi.type.SPECIAL;
////            default -> null;
////        };
////
////        taxis.addTaxi(new Taxi());
////
//
//    }

    public void showOrders() {
        Orders orders = new Orders();
        System.out.println("##### ORDERS LLIST ####");
        for (Order order : orders.getOrders()) {
            System.out.println(order);
        }
        System.out.println();
    }


}
