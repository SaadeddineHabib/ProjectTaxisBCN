package src.ui;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ui {
    public Scanner sc = new Scanner(System.in);
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

    public void runOrdersPanel() {
        int opcio = getControlledIntegerInput(menus.showOrderMenu());
        while (opcio != 0) {
            switch (opcio) {
                case 1:
                    createOrder();
                    break;
                case 2:

                    break;
                case 3:
                    showSpecifiedOrder();
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
                    createTaxi();
                    break;
                case 2:
                    removeTaxi();
                    break;
                case 3:
                    showOneTaxi();
                    break;
                case 4:
                    break;
                case 5:
                    runOrdersPanel();
                    break;
            }
            opcio = getControlledIntegerInput(menus.showMainMenu());
        }
    }


    public void createTaxi() {


    }

    public void showOneTaxi() {

    }


    public void showTaxis() {
        System.out.println("##### TAXIS LIST ####");


        System.out.println();
    }

    public void removeTaxi() {

    }


    public void createOrder() {


    }

    public void showSpecifiedOrder() {

    }

}
