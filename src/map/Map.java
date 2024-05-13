package src.map;

import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Map {
    private StringBuilder[][] map;

    public Map(){
        map=new StringBuilder[5][5];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = new StringBuilder();
            }
        
    }}

    public StringBuilder[][] getMap() {
        return map;
    }

    public void addItem(String ID, int x, int y){
 
        map[x][y].append(ID+" ");
    }

    public void refreshMap() {
        List<String> items = new ArrayList<>();
    
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (!map[i][j].toString().equals("")) {
                    String[] itemsInPosition = map[i][j].toString().split(" ");
                    for (String item:itemsInPosition){
                        items.add(item);
                    }
                    map[i][j] = new StringBuilder(); 
                }
            }
        }
    
        Collections.shuffle(items);
    
        Random random = new Random();
    
        for (String item : items) {
            int x = random.nextInt(5);
            int y = random.nextInt(5);
            addItem(item, x, y);
        }
    }

    public void showMap() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] != null) {
                    System.out.print("["+map[i][j].toString()+"] ");
                } else if (map[i][j].toString().equals(" ")) {
                    System.out.print("[]");
                }{
                }
                
            }
            System.out.println();
        }
    }

}
