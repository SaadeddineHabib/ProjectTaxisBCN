package src.objects.taxistatusdao;

import src.sqlitedatabase.SqliteConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TaxiStatusCRUD {

    private static Connection con = SqliteConnection.getConnection();

    public TaxiStatus read(int idEntity) throws SQLException {

        String query = "select * from TaxiStatus where TaxiStatusId = ?";
        PreparedStatement ps = con.prepareStatement(query);

        ps.setInt(1, idEntity);
        TaxiStatus taxiStatus = new TaxiStatus();
        ResultSet rs = ps.executeQuery();
        boolean check = false;


        while (rs.next()) {
            check = true;
            taxiStatus.setTaxiStatusId(rs.getInt("TaxiStatusId"));
            taxiStatus.setName(rs.getString("Name"));
        }

        if (check) {
            return taxiStatus;
        } else
            return null;
    }

}
