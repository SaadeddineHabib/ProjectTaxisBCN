package src.menu;

import java.time.LocalTime;

public class Menus {
    public String showOrderMenu() {
        return "\n\n1. Add order" +
                "\n2. Show all orders" +
                "\n3. Show specified order" +
                "\n\n0. Return to Main menu"  +
                "\n\nEnter the number of the desired option: ";
    }
    public String showMainMenu() {
        LocalTime now = LocalTime.now();
        return "Current time is " + now.toString().substring(0, 8) +
                "\n\n----Main Menu----" +
                "\n\n1.- Add taxi" +
                "\n2.- Remove taxi" +
                "\n3.- Show regular taxis"  +
                "\n4.- Show special taxis" +
                "\n5.- Show taxis" +
                "\n6.- Show specific taxis" +
                "\n7.- Enter Orders menu"  +
                "\n\n0.- Exit" +
                "\n\nEnter the number of the desired option: ";
    }
}
