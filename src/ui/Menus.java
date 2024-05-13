package src.ui;

import java.time.LocalTime;

public class Menus {
    public String showOrderMenu() {
        return """

                1. Add order
                2. Remove order
                3. Show one order
                4. Show orders
                 
                0. Return to Main menu

                Enter the number of the desired option:\s
                """;
    }

    public String showCustomerMenu() {
        LocalTime now = LocalTime.now();
        return """
                            
                ----Main Menu----
               
                1.- Add customer
                2.- Remove customer
                3.- Show one customer
                4.- Show customers
      
                0.- Return to Main menu"
                
                Enter the number of the desired option:\s
                """;
    }
    public String showTaxiMenu() {
        LocalTime now = LocalTime.now();
        return """
                            
                ----Main Menu----
               
                1.- Add taxi
                2.- Remove taxi
                3.- Show one taxi
                4.- Show taxis
      
                0.- Return to Main menu"
                
                Enter the number of the desired option:\s
                """;
    }
    public String showMainMenu() {
        LocalTime now = LocalTime.now();
        return """
                            
                ----Main Menu----
               
                1.- Add taxi
                2.- Remove taxi
                3.- Show specific taxis
                4.- Show taxis
                5.- Enter Orders menu
      
                0.- Exit"
                
                Enter the number of the desired option:\s
                """;
    }
}
