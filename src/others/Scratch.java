package src.others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


public class Scratch {


    public static Random rand = new Random();
    public static int numberOfservices = 0;
    public static Scanner inputReader = new Scanner(System.in);
    public static ArrayList<ArrayList<String>> orders = new ArrayList<ArrayList<String>>();
    public static ArrayList<String> array = new ArrayList<>();
    public static int numberTaxis = 50;
    public static String[][] taxis = new String[numberTaxis][4];


    public static String readUserInput() {
        return inputReader.next();
    }


    public static void showSpecfiedOrder() {
        System.out.println("Please enter the ID of the Order");
        String orderId = readUserInput();
        System.out.println(orders);
        for (int i = 0; i < orders.size(); i++) {
            for (int j = 0; j < orders.get(i).size() ; j++) {
                if (orderId.equals(orders.get(i).get(j))){
                    System.out.println(orders.get(i));
                }
            }
        }


    }


    public static void showOrderMenu(){
        System.out.println("\n1. Add order");
        System.out.println("2. Show all orders");
        System.out.println("3. Show specifed order");
        System.out.println("\n0. Return to src.Main menu");
    }


    public static void addArrayListTo2DArraylist(ArrayList<String> ArrayList) {
        orders.add(ArrayList);
    }


    public static void setDefaultDataOrderTaxis(ArrayList<String> ArrayList) {
        ArrayList.add("ServiceID");
        ArrayList.add("Taxi");
        ArrayList.add("Person");
        ArrayList.add("State");
        ArrayList.add("DateStartService");
        ArrayList.add("DateEndService");
        ArrayList.add("LocationStartService");
        ArrayList.add("LocationEndService");
    }




    public static int getFreeTaxi() {
        int indexRandomTaxi = 0;
        for (int i = 1; i < taxis.length; i++) {
            if (taxis[i][2].equals("F")) {
                indexRandomTaxi = i;
                break;
            } else {
                indexRandomTaxi = -1;
                // TODO: setOrderToWait(); ES UNA FUNCION PARA PONER EN ESPERA EL SERVICIO
            }
        }




        return indexRandomTaxi;
    }


    public static ArrayList<String> CreateOrder() {
        ArrayList<String> service = new ArrayList<>();
        numberOfservices++;
        service.add(("S"+numberOfservices));
        int indexRowTaxi = getFreeTaxi();
        for (int i = 0; i < taxis.length ; i++) {
            System.out.println(Arrays.toString(taxis[i]));
        }
        if (indexRowTaxi != -1) {
            service.add(taxis[indexRowTaxi][0]);
            taxis[indexRowTaxi][2] = "O";
        } else {
            // TODO: setOrderToWait()
        }


        // TODO:  cancel the order when there aren't free taxi.


        service.add("person1(it must change by the ID of person)");
        service.add("Running");
        return service;
    }






    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean dayShift = false, nightShift = false;
        int hours, minutes, taxiRegular;
        int taxiSpecial = 0;
        Random rand = new Random();
        String[] carmodels = {"Toyota", "Honda", "Ford", "Nissan", "Chevrolet"};
        String[] taxi_status = {"O", "F", "B"};


        int menuoption = 0;
        char neededTaxi;
        int contfree = 0;


        taxis[0] = new String[]{"ID", "Car Model", "Taxi_status", "Taxi_Type"};


        for (int i = 1; i <= taxis.length-1; i++) {
            taxis[i][0] = Integer.toString(i);
            taxis[i][1] = carmodels[rand.nextInt(carmodels.length)];
            taxis[i][2] = taxi_status[rand.nextInt(taxi_status.length)];
            if (i % 10 == 0){
                taxis[i][3] = "S";
            } else {
                taxis[i][3] = "R";
            }
        }


        setDefaultDataOrderTaxis(array);
        addArrayListTo2DArraylist(array);


        showOrderMenu();
        int option = sc.nextInt();
        while (option != 0) {
            switch (option) {
                case 1:
                    ArrayList<String> service = CreateOrder();
                    addArrayListTo2DArraylist(service);
                    break;
                case 2:
                    for (int i = 0; i < orders.size(); i++) {
                        System.out.println(orders.get(i));
                    }
                    break;
                case 3:
                    showSpecfiedOrder();
                    break;
                case 0:
                    System.out.println("thx and bye");
                    break;
            }
            showOrderMenu();
            option = sc.nextInt();
        }


    }


}



