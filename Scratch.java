import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Scratch {

    public static int numberOfservices = 0;
    public static Scanner inputReader = new Scanner(System.in);
    public static ArrayList<ArrayList<String>> pedidos = new ArrayList<ArrayList<String>>();
    public static ArrayList<String> array = new ArrayList<>();

    public static String readUserInput() {
        return inputReader.next();
    }

    public static void showSpecfedServie(ArrayList<ArrayList<String>> pedidos) {
        String serviceId = readUserInput();
        for (int i = 0; i < pedidos.size(); i++) {
            for (int j = 0; j < pedidos.get(i).size(); j++) {
                // TODO: hay que mostrar el servicio que nos dice.
            }
        }
        System.out.println();
    }

    public static void showServiceMenu(){
        System.out.println("\n1. Add service");
        System.out.println("2. Show all services");
        System.out.println("3. Show specifed service");
        System.out.println("\n0. Return to Main menu");
    }

    public static void addArrayListTo2DArraylist(ArrayList<ArrayList<String>> pedidos, ArrayList<String> ArrayList ) {
        pedidos.add(ArrayList);
    }

    public static void setDefaultDataServiceTaxis(ArrayList<String> ArrayList) {
        ArrayList.add("ServiceID");
        ArrayList.add("Taxi");
        ArrayList.add("Person");
        ArrayList.add("State");
        ArrayList.add("DateStartService");
        ArrayList.add("DateEndService");
        ArrayList.add("LocationStartService");
        ArrayList.add("LocationEndService");
    }

    public static ArrayList<String> CreateService(String[][] taxis, ArrayList<String> service ) {
        numberOfservices++;
        service.add(("S"+numberOfservices));
        Random rand = new Random();
        int indexRow = rand.nextInt(taxis.length);
        service.add(taxis[indexRow][0]);
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
        int numberTaxis = 50;
        int menuoption = 0;
        char neededTaxi;
        int contfree = 0;

        String[][] taxis = new String[numberTaxis][4];
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

        setDefaultDataServiceTaxis(array);
        addArrayListTo2DArraylist(pedidos, array);
        System.out.println(pedidos);

        showServiceMenu();
        int option = sc.nextInt();
        while (option != 0) {
            switch (option) {
                case 1:
                    ArrayList<String> service = CreateService(taxis, array);
                    addArrayListTo2DArraylist(pedidos, service);
                    break;
                case 2:
                    for (int i = 0; i < pedidos.size(); i++) {
                        System.out.println(pedidos.get(i));
                    }
                    break;
                case 3:
                    for (int i = 0; i < taxis.length; i++) {
                        System.out.println(Arrays.toString(taxis[i]));
                    }
                    break;
                case 0:
                    System.out.println("thx and bye");
                    break;
            }
            showServiceMenu();
            option = sc.nextInt();
        }

    }

}
