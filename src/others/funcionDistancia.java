package src.others;

import java.util.Scanner;

public class funcionDistancia {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int area = 8;
        int[][] map = new int[area][area];

        for (int i = 0; i < area; i++) {
            for (int j = 0; j < area; j++) {
                map[i][j] = (int) (Math.random() * 3);
            }
        }

        printMap(map);

        int[] positionTaxi = positionTaxi(map);
        int[] positionClient = positionClient(map);

        int distance = distance(positionTaxi, positionClient);
        int timeMinutes = distance * 5; // Cada paso toma 5 minutos

        System.out.println("The location of your taxi is: (" + positionTaxi[0] + ", " + positionTaxi[1] + ")");
        System.out.println("Your location is: (" + positionClient[0] + ", " + positionClient[1] + ")");
        System.out.println("The distance in between is " + distance );
        System.out.println("The estimated time of arrival is: " + timeMinutes + " minutes.");

        sc.close();
    }

    public static void printMap(int[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[] positionTaxi(int[][] map) {
        int[] position = new int[2];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == 1) {
                    position[0] = i;
                    position[1] = j;
                    return position;
                }
            }
        }
        return position;
    }

    public static int[] positionClient(int[][] map) {
        int[] position = new int[2];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == 2) {
                    position[0] = i;
                    position[1] = j;
                    return position;
                }
            }
        }
        return position;
    }

    public static int distance(int[] taxi, int[] client) {
        return Math.abs(taxi[0] - client[0]) + Math.abs(taxi[1] - client[1]);
    }


}