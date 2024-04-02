import src.menu.Ui;

public class Main {
    public static void main(String[] args) {
        Ui ui = new Ui();
        ui.runProgram();

    }
//    public static int numberOfservices = 0;
//    public static Scanner inputReader = new Scanner(System.in);
//    public static ArrayList<ArrayList<String>> orders = new ArrayList<ArrayList<String>>();
//    public static ArrayList<String> array = new ArrayList<>();
//    public static Random rand = new Random();
//    public static int hours = getCurrentTime();
//    public static boolean dayShift = hours >= 8 && hours < 22;
//    public static int numberTaxis = dayShift ? 50 : 25;
//    public static ArrayList<Taxi> taxis = new ArrayList<>();
//
//    public static String taxiType;
//
//    public static String readUserInput() {
//        return inputReader.next();
//    }
//
//    public static int getFreeTaxi() {
//        int indexRandomTaxi = 0;
//        boolean isFound = false;
//        for (int i = 1; i < taxis.size() && !isFound; i++) {
//            for (int j = 0; j < taxis[i].length && !isFound; j++) {
//                if (taxis[i][3].equals(taxiType) && taxis[i][2].equals("F")) {
//                    indexRandomTaxi = i;
//                    isFound = true;
//                } else {
//                    indexRandomTaxi = -1;
//                }
//                break;
//            }
//        }
//
//        return indexRandomTaxi;
//    }
//
//
//    public static void CreateOrder() {
//        ArrayList<String> service = new ArrayList<>();
//        System.out.print("\nWhich type of taxi do you like?\nEnter R for regular and S for special: ");
//        char taxiType = inputReader.next().toUpperCase().charAt(0);
//        while (!taxiType == 'R' && !taxiType == 'S') {
//            System.out.print("\nError! You must enter R or S!\nEnter R for regular and S for special: ");
//            taxiType = inputReader.next().toUpperCase();
//        }
//
//        numberOfservices++;
//        service.add(("S" + numberOfservices));
//        int indexFreeTaxi = getFreeTaxi();
//        if (indexFreeTaxi != -1) {
//            service.add(taxis[indexFreeTaxi][0]);
//            taxis[indexFreeTaxi][2] = "O";
//            service.add("person1(it must change by the ID of person)");
//            service.add("Running");
//            addArrayListTo2DArraylist(service);
//        } else {
//            System.out.println("All taxi are taken");
//            // TODO: Put the setWaitList
//        }
//
//
//    }
//
//    public static void showMainMenu() {
//        LocalTime now = LocalTime.now();
//        System.out.println("Current time is " + now.toString().substring(0, 8));
//        System.out.println("\n----Main Src.Menu----");
//        System.out.println("\n1.- Show regular taxis");
//        System.out.println("2.- Show special taxis");
//        System.out.println("3.- Enter Orders menu");
//        System.out.println("\n0.- Exit");
//        System.out.print("\nEnter the number of the desired option: ");
//    }
//
//    private static void displayTypeTaxi(String type) {
//        int countFreeRegularTaxis = 0;
//        System.out.println(Arrays.toString(taxis[0]));
//        for (int i = 1; i < taxis.length; i++) {
//            if (taxis[i][3].equals(type)) {
//                System.out.println(Arrays.toString(taxis[i]));
//                countFreeRegularTaxis++;
//            }
//        }
//        System.out.println("\nThere are " + countFreeRegularTaxis + " " + (type.equals("R") ? "regular" : "special") + " taxis");
//    }
//
//    private static void createDBTaxis() {
//
//        String[] carModels = {"Toyota", "Honda", "Ford", "Nissan", "Chevrolet"};
//        char[] taxiStatus = {'O', 'F', 'B'};
//
//        for (int i = 1; i < numberTaxis; i++) {
//            String id = "ID00" + Integer.toString(i);
//            String carModel = carModels[rand.nextInt(carModels.length)];
//            char Status = taxiStatus[1];
//            char Type = (i % 10 == 0) ? 'S' : 'R';
//            Taxi taxi = new Taxi(id, carModel, Status, Type);
//            taxis.add(taxi);
//        }
//    }
//
//    private static int getCurrentTime() {
//        LocalTime now = LocalTime.now();
//        int hours = now.getHour();
//        return hours;
//    }
//
//    private static StringBuilder[][] createMap() {
//        StringBuilder[][] map = new StringBuilder[20][20];
//        return map;
//    }
//
//    public static int openOrderPanel() {
//        showOrderMenu();
//        int option = inputReader.nextInt();
//        while (option != 0) {
//            switch (option) {
//                case 1:
//                    CreateOrder();
//                    break;
//                case 2:
//                    for (int i = 0; i < orders.size(); i++) {
//                        System.out.println(orders.get(i));
//                    }
//                    break;
//                case 3:
//                    showSpecifiedOrder();
//                    break;
//                case 0:
//                    System.out.println("thx and bye");
//                    break;
//            }
//            showOrderMenu();
//            option = inputReader.nextInt();
//        }
//
//        return option;
//    }
//
//    public static void main(String[] args) {
//        createDBTaxis();
//        setDefaultDataOrderTaxis(array);
//        addArrayListTo2DArraylist(array);
//        int menuOption;
//        int menuOrderOption = 0;
//        do {
//            showMainMenu();
//            menuOption = inputReader.nextInt();
//            switch (menuOption) {
//                case 1:
//                    displayTypeTaxi("R");
//                    break;
//                case 2:
//                    displayTypeTaxi("S");
//                    break;
//                case 3:
//                    System.out.println("\n----Src.Menu Orders----");
//                    menuOrderOption = openOrderPanel();
//                    break;
//                case 0:
//                    System.out.println("Byebye");
//                    break;
//            }
//        } while (menuOption != 0 || menuOrderOption != 0);
//    }


}
