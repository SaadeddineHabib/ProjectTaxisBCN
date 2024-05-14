package src.ui;

public class Menus {
    public String showOrderMenu() {
        return """
                                
                ----Order Menu----

                1. Add order
                2. Remove order
                3. Modify order
                4. Show one order
                5. Show orders
                 
                0. Return to Main menu

                Enter the number of the desired option:\s""";
    }

    public String showCustomerMenu() {
        return """
                            
                ----Customer Menu----
                               
                1.- Add carModel
                2.- Remove carModel
                3.- Modify carModel
                4.- Show one carModel
                5.- Show carModels
                      
                0.- Return to Main menu
                                
                Enter the number of the desired option:\s""";
    }

    public String showTaxiMenu() {
        return """
                            
                ----Taxi Menu----
                               
                1.- Add taxi
                2.- Remove taxi
                3.- Modify taxi
                4.- Show one taxi
                5.- Show taxis
                      
                0.- Return to Main menu
                                
                Enter the number of the desired option:\s""";
    }

    public String showMainMenu() {
        return """
                            
                ----Main Menu----
                                
                1.- Enter taxi management menu
                2.- Enter order management menu
                3.- Enter carModel management menu
                      
                0.- Exit
                                
                Enter the number of the desired option:\s""";
    }
}
