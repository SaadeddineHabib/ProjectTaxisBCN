package src.objects.taxidao;

import src.objects.DaoEntity;
import src.sqlitedatabase.SqliteConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TaxiCRUD implements DaoEntity<Taxi> {

    private static Connection con = SqliteConnection.getConnection();

    @Override
    public int create(Taxi entity) throws SQLException {
        String query = "insert into Taxi (CarModel, TaxiStatus, TaxiType) VALUES (?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, entity.getCarModel());
        ps.setInt(2, entity.getTaxiStatus());
        ps.setInt(3, entity.getTaxiType());
        ps.executeUpdate();
        ResultSet rs = ps.getGeneratedKeys();
        rs.next();
        return rs.getInt(1);
    }

    @Override
    public Taxi read(int idEntity) throws SQLException {
        String query = "select * from Taxi where TaxiId= ?";
        PreparedStatement ps = con.prepareStatement(query);

        ps.setInt(1, idEntity);
        Taxi taxi = new Taxi();
        ResultSet rs = ps.executeQuery();
        boolean check = false;

        while (rs.next()) {
            check = true;
            int taxiId = rs.getInt("TaxiId");
            int model = rs.getInt("CarModel");
            int status = rs.getInt("TaxiStatus");
            int type = rs.getInt("TaxiType");

            taxi.setTaxiId(taxiId);
            taxi.setCarModel(model);
            taxi.setTaxiStatus(status);
            taxi.setTaxiType(type);
        }

        if (check) {
            return taxi;
        } else
            return null;
    }

    @Override
    public void update(Taxi entity) throws SQLException {
        String query = "update Taxi set TaxiType=?, TaxiStatus= ?, CarModel=?  where TaxiId = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, entity.getCarModel());
        ps.setInt(2, entity.getTaxiStatus());
        ps.setInt(3, entity.getTaxiType());
        ps.setInt(4, entity.getTaxiId());
        ps.executeUpdate();
    }

    @Override
    public void delete(int idEntity) throws SQLException {
        String query = "delete from Taxi where TaxiId =?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, idEntity);
        ps.executeUpdate();
    }

    @Override
    public List<Taxi> getEntities() throws SQLException {
        String query = "select * from Taxi";
        PreparedStatement ps = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        List<Taxi> taxis = new ArrayList<>();

        while (rs.next()) {
            Taxi taxi = new Taxi();
            int taxiId = rs.getInt("TaxiId");
            int model = rs.getInt("CarModel");
            int status = rs.getInt("TaxiStatus");
            int type = rs.getInt("TaxiType");

            taxi.setTaxiId(taxiId);
            taxi.setCarModel(model);
            taxi.setTaxiStatus(status);
            taxi.setTaxiType(type);
            taxis.add(taxi);
        }
        return taxis;
    }
}
