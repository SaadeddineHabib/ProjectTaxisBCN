package src.objects;

import java.util.ArrayList;
import java.util.List;

public class Taxis {

    int numberId = 0;

    private List<Taxi> taxis;

    public Taxis() {
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

    @Override
    public String toString() {
        return "Taxis{" +
                "taxis=" + taxis +
                '}';
    }
}
