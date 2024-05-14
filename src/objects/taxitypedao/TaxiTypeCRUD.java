package src.objects.taxitypedao;

import src.sqlitedatabase.SqliteConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TaxiTypeCRUD {
    private static Connection con = SqliteConnection.getConnection();

    public TaxiType read(int idEntity) throws SQLException {

        String query = "select * from TaxiType where TaxiTypeId = ?";
        PreparedStatement ps = con.prepareStatement(query);

        ps.setInt(1, idEntity);
        TaxiType taxiType = new TaxiType();
        ResultSet rs = ps.executeQuery();
        boolean check = false;


        while (rs.next()) {
            check = true;
            taxiType.setTaxiTypeId(rs.getInt("taxiTypeId"));
            taxiType.setName(rs.getString("Name"));
        }

        if (check) {
            return taxiType;
        } else
            return null;
    }

}
