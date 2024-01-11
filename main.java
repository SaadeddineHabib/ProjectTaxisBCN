import java.util.*;
import java.time.LocalTime;

public class main {

    public static int numberOfservices = 0;
    public static Scanner inputReader = new Scanner(System.in);
    public static ArrayList<ArrayList<String>> orders = new ArrayList<ArrayList<String>>();
    public static ArrayList<String> array = new ArrayList<>();
    public static Random rand = new Random();
    public static int hours = getCurrentTime();
    public static boolean dayShift = hours >= 8 && hours < 22;
    public static int numberTaxis = dayShift ? 50 : 25;
    public static String[][] taxis = new String[numberTaxis][4];

    public static String readUserInput() {
        return inputReader.next();
    }

    public static void showSpecifiedOrder() {
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
        System.out.println("3. Show specified order");
        System.out.println("\n0. Return to Main menu");
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
        System.out.print("\nWhich type of taxi do you like?\nEnter R for regular and S for special: ");
        String taxiType = inputReader.next().toUpperCase();
        numberOfservices++;
        service.add(("S"+numberOfservices));
        int indexRowTaxi = getFreeTaxi();
        // TODO: comprovar porque cuando pongo input S de especial no me asigna un taxi especial.
        if (indexRowTaxi != -1 && taxis[indexRowTaxi][3].equals(taxiType)) {
            service.add(taxis[indexRowTaxi][0]);
            taxis[indexRowTaxi][2] = "O";
        }


        service.add("person1(it must change by the ID of person)");
        service.add("Running");
        return service;
    }

    public static void showMainMenu() {
        LocalTime now = LocalTime.now();
        System.out.println("Current time is " + now.toString().substring(0, 8));
        System.out.println("\n----Main Menu----");
        System.out.println("\n1.- Show regular taxis");
        System.out.println("2.- Show special taxis");
        System.out.println("3.- Enter Orders menu");
        System.out.println("\n0.- Exit");
        System.out.print("\nEnter the number of the desired option: ");
    }
    private static void displayTypeTaxi(String type) {
        int countFreeRegularTaxis = 0;
        System.out.println(Arrays.toString(taxis[0]));
        for (int i = 1; i < taxis.length; i++) {
            if (taxis[i][3].equals(type)) {
                System.out.println(Arrays.toString(taxis[i]));
                countFreeRegularTaxis++;
            }
        }
        System.out.println("\nThere are " + countFreeRegularTaxis + " " + (type.equals("R") ? "regular" : "special") + " taxis");
    }

    private static void createDBTaxis(){

        String[] carModels = {"Toyota", "Honda", "Ford", "Nissan", "Chevrolet"};
        String[] taxiStatus = {"O", "F", "B"};
        taxis[0] = new String[]{"ID", "Car Model", "Taxi_status", "Taxi_Type"};

        for (int i = 1; i < taxis.length; i++) {
            taxis[i][0] = Integer.toString(i);
            taxis[i][1] = carModels[rand.nextInt(carModels.length)];
            taxis[i][2] = taxiStatus[rand.nextInt(taxiStatus.length)];
            taxis[i][3] = (i % 10 == 0) ? "S" : "R";
         }
    }

    private static int getCurrentTime(){
        LocalTime now = LocalTime.now();
        int hours = now.getHour();
        return hours;
    }

    private static StringBuilder[][] createMap(){
        StringBuilder[][] map = new StringBuilder[20][20];
        return map;
    }
    public static int openOrderPanel() {
        setDefaultDataOrderTaxis(array);
        addArrayListTo2DArraylist(array);

        showOrderMenu();
        int option = inputReader.nextInt();
        while (option != 0) {
            switch (option) {
                case 1:
                    if (getFreeTaxi() != -1) {
                        ArrayList<String> service = CreateOrder();
                        addArrayListTo2DArraylist(service);
                    } else {
                        System.out.println("All taxi are taken.");
                    }
                    break;
                case 2:
                    for (int i = 0; i < orders.size(); i++) {
                        System.out.println(orders.get(i));
                    }
                    break;
                case 3:
                    showSpecifiedOrder();
                    break;
                case 0:
                    System.out.println("thx and bye");
                    break;
            }
            showOrderMenu();
            option = inputReader.nextInt();
        }

        return option;
    }
    public static void main(String[] args) {
        createDBTaxis();
        int menuOption;
        int menuOrderOption = 0;
        do {
            showMainMenu();
            menuOption = inputReader.nextInt();
            switch (menuOption) {
                case 1:
                    displayTypeTaxi("R");
                    break;
                case 2:
                    displayTypeTaxi("S");
                    break;
                case 3:
                    System.out.println("\n----Menu Orders----");
                    menuOrderOption = openOrderPanel();
                    break;
                case 0:
                    System.out.println("Byebye");
                    break;
            }
        } while (menuOption != 0 || menuOrderOption != 0);
    }


}
