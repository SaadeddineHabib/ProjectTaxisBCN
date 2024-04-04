package src.objects;

import java.util.HashMap;

public class Coordinates {
    private HashMap<String, StringBuilder> coordinatesItems;

    public Coordinates(){
        coordinatesItems = new HashMap<>();
    }

    public void addItem(String ID, StringBuilder coordinatesofItem){
        if (checkCoordinatesIntegrity(coordinatesofItem)) {
            coordinatesItems.put(ID, coordinatesofItem);
        } else{
            StringBuilder defaultCoordinates = new StringBuilder("0,0");
            System.out.println("Coordinates will be 0,0 as per default, Please change it later");
            coordinatesItems.put(ID, defaultCoordinates);
        }
    }

    public boolean checkCoordinatesIntegrity(StringBuilder coordinatesofItem) {
        if (coordinatesofItem != null) {
            String[] parts = coordinatesofItem.toString().split(",");
            if (parts.length == 2) {
                int x = Integer.parseInt(parts[0].trim());
                int y = Integer.parseInt(parts[1].trim());
                if (x >= 0 && x <= 100) {
                    if (y >= 0 && y <= 100) {
                        return true;
                    }
                }
                System.out.println("x: " + x + ", y: " + y);
            } else {
                System.out.println("Invalid coordinates format. Only from 0 to 100 both x and y!");
            }
        } 
        return false;

    }

    public void getCoordinates(String ID) {
        StringBuilder coordinatesofItem = coordinatesItems.get(ID);
        if (coordinatesofItem != null) {
            String[] parts = coordinatesofItem.toString().split(",");
            if (parts.length == 2) {
                int x = Integer.parseInt(parts[0].trim());
                int y = Integer.parseInt(parts[1].trim());
                System.out.println("x: " + x + ", y: " + y);
            } else {
                System.out.println("Invalid coordinates format");
            }
        } else {
            System.out.println("ID not found");
        }
    }




}
