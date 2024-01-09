import java.time.LocalTime;
import java.util.*;

public class main {

    public static void showmenu(){
        System.out.println("What kind of cab would you like to order?");
        System.out.println("1.- Regular");
        System.out.println("2.- Special");
        System.out.println("3.- Exit");
        System.out.println("Enter the number of the desired option: ");
    }

    public static String getCurrentTime() {
        LocalTime currentTime = LocalTime.now();
        int hour = currentTime.getHour();
        return currentTime.toString();
    }

    public static int numberTaxis = 50;

    public static String[][] taxis = new String[numberTaxis][4];
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
// VARIABLES-------------------------------------------------------------------------------------------
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


        System.out.println("Welcome to Taximanager");

        String time = getCurrentTime();
        int separate = time.indexOf(':');
        hours = Integer.parseInt(time.substring(0, separate));
        minutes = Integer.parseInt(time.substring(separate+1, separate+3));


        if (hours >= 8 && hours < 22){
            dayShift = true;
        } else{
            nightShift = true;
            numberTaxis /= 2;
        }

        System.out.println( numberTaxis);
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

        //MENU
        do {
            showmenu();
            menuoption = input.nextInt();
            switch (menuoption){
                case 1:
                    System.out.println(Arrays.toString(taxis[0]));
                    for (int i = 1; i <= taxis.length-1; i++) {
                        if (taxis[i][3].equals("R")) {
                            if (taxis[i][2].equals("F")) {
                                System.out.println(Arrays.toString(taxis[i]));
                                contfree++;
                            }
                        }
                    }
                    System.out.println("There are " + contfree + " regular taxis");
                    break;
                case 2:
                    for (int i = 0; i < taxis.length; i++) {
                        if (taxis[i][3].equals("S")) {
                            if (taxis[i][2].equals("F")) {
                                System.out.println(Arrays.toString(taxis[i]));
                                contfree++;
                            }
                        }
                    }
                    System.out.println("There are " + contfree + " special taxis");
                    break;

                case 3:
                    System.out.println("Byebye");
                    break;
            }
        } while (menuoption != 0);
    }

}
