import java.util.*;
import java.time.LocalTime;

public class main {

    public static void showMenu() {
        LocalTime now = LocalTime.now();
        System.out.println("Current time is " + now.toString().substring(0, 8));
        System.out.println("What kind of cab would you like to order?");
        System.out.println("1.- Regular");
        System.out.println("2.- Special");
        System.out.println("3.- Exit");
        System.out.println("Enter the number of the desired option: ");
    }
    private static void displayTaxis(String[][] taxis, String type) {
        int countFree = 0;
        System.out.println(Arrays.toString(taxis[0]));
        for (int i = 1; i < taxis.length; i++) {
            if (taxis[i][3].equals(type) && taxis[i][2].equals("F")) {
                System.out.println(Arrays.toString(taxis[i]));
                countFree++;
            }
        }
        System.out.println("There are " + countFree + " " + (type.equals("R") ? "regular" : "special") + " taxis");
    }

    private static String[][] taxis(int numberTaxis){
        Random rand = new Random();
    
        String[][] taxis = new String[numberTaxis][4];

        String[] carModels = {"Toyota", "Honda", "Ford", "Nissan", "Chevrolet"};
        String[] taxiStatus = {"O", "F", "B"};
        taxis[0] = new String[]{"ID", "Car Model", "Taxi_status", "Taxi_Type"};

        for (int i = 1; i < taxis.length; i++) {
            taxis[i][0] = Integer.toString(i);
            taxis[i][1] = carModels[rand.nextInt(carModels.length)];
            taxis[i][2] = taxiStatus[rand.nextInt(taxiStatus.length)];
            taxis[i][3] = (i % 10 == 0) ? "S" : "R";
         }
        return taxis;
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
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int hours = getCurrentTime();

        boolean dayShift = hours >= 8 && hours < 22;
        int numberTaxis = dayShift ? 50 : 25;

        String[][] taxis = taxis(numberTaxis);

        // Menú
        int menuOption;
        do {
            showMenu();
            menuOption = input.nextInt();
            switch (menuOption) {
                case 1:
                    displayTaxis(taxis, "R");
                    break;
                case 2:
                    displayTaxis(taxis, "S");
                    break;
                case 3:
                    System.out.println("Byebye");
                    break;
            }
        } while (menuOption != 3);
    }


}
