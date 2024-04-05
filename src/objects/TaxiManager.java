package src.objects;

import java.util.ArrayList;
import java.util.List;

public class TaxiManager {

    int numberId = 0;

    private List<Taxi> taxis;

    public TaxiManager() {
        taxis = new ArrayList<>();
    }

    public List<Taxi> getTaxis() {
        return taxis;
    }
    public int getNumberId() {
        return numberId;
    }

    public void addTaxi(Taxi taxi) {
        taxis.add(taxi);
    }

    public void removeTaxi(Taxi taxi) {
        taxis.remove(taxi);
    }

    public Taxi findSpecifiedTaxi(String taxiId) {
        Taxi taxi = null;
        for (Taxi taxiToFind : taxis) {
            if (taxiToFind.getID().equals(taxiId)) {
                taxi = taxiToFind;
                break;
            }
        }
        return taxi;

    }

    public void showRegularTaxis() {
        System.out.println("##### REGULAR TAXIS LIST ####");
        for (Taxi taxi : taxis) {
            if (taxi.getTaxiType().equals(Taxi.Type.REGULAR)) {
                System.out.println(taxi);
            }
        }
        System.out.println();
    }

    public void showSpecialTaxis() {
        System.out.println("##### SPECIAL TAXIS LIST ####");
        for (Taxi taxi : taxis) {
            if (taxi.getTaxiType().equals(Taxi.Type.SPECIAL)) {
                System.out.println(taxi);
            }
        }
        System.out.println();
    }

    public void showTaxis() {
        System.out.println("##### TAXIS LIST ####");
        for (Taxi taxi : taxis) {
            System.out.println(taxi);
        }
        System.out.println();
    }

    @Override
    public String toString() {
        return "Taxis{" +
                "taxis=" + taxis +
                '}';
    }
}
