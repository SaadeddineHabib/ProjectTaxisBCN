package src.objects.taxidao;

import java.sql.SQLException;

public class TestTaxi {
    public static void main(String[] args) throws SQLException {
        TaxiCRUD taxiCRUD = new TaxiCRUD();

        for (Taxi taxi : taxiCRUD.getEntities()) {
            System.out.println(taxi);
        }

        System.out.println();

        System.out.println(taxiCRUD.read(13));

        System.out.println();

        Taxi taxi = new Taxi(0, 1,1,1);

        taxi.setTaxiId(taxiCRUD.create(taxi));

        System.out.println();

        System.out.println(taxiCRUD.read(taxi.getTaxiId()));

        System.out.println();

        taxiCRUD.delete(taxi.getTaxiId());

        System.out.println();

        for (Taxi taxi1 : taxiCRUD.getEntities()) {
            System.out.println(taxi1);
        }

        System.out.println();

        Taxi taxi1 = taxiCRUD.read(5);

        taxi1.setTaxiStatus(0);
        taxi1.setCarModel(5);

        taxiCRUD.update(taxi1);

        for (Taxi taxi2 : taxiCRUD.getEntities()) {
            System.out.println(taxi2);
        }

    }
}
