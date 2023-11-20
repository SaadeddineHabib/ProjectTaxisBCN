import java.util.*;

public class main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Hello, please select the current time. (Day shift: from 08h to 22h and Night shift from 22h to 08h). Hours and minutes have to be separated by :. Example - hh:mm");
        boolean dayShift = false, nightShift = false;
        int hours, minutes, taxiRegular;
        int taxiSpecial = 0;
        Random rand = new Random();
        String[] carmodels = {"Toyota", "Honda", "Ford", "Nissan", "Chevrolet"};
        String[] taxi_status = {"O", "F", "B"};
        while (true){
            String time = input.nextLine();
            try {
                int separate = time.indexOf(':');
                hours = Integer.parseInt(time.substring(0, separate));
                minutes = Integer.parseInt(time.substring(separate+1));
                break;
            }catch (Exception e){
                System.out.println("Something went wrong. Please try again: ");
            }
        }

        int numberTaxis = input.nextInt();
        String[][] taxis = new String[numberTaxis][4];

        for (int i = 0; i < taxis.length; i++) {
            taxis[i][0] = Integer.toString(i + 1);
            taxis[i][1] = carmodels[rand.nextInt(carmodels.length)];
            taxis[i][2] = taxi_status[rand.nextInt(taxi_status.length)];
            if ((i+1) % 10 == 0){
                taxis[i][3] = "S";
            } else {
                taxis[i][3] = "R";
            }
        }

        int contfree = 0;
        for (int i = 0; i < taxis.length; i++) {
            if (taxis[i][2].equals("F")) {
                System.out.println(Arrays.toString(taxis[i]));
                contfree++;
            }
        }
        System.out.println("There are " + contfree + " free taxis");


    }

}
