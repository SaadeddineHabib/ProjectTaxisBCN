package src.objects.carmodeldao;

import src.sqlitedatabase.SqliteConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CarModelCRUD {

    private static Connection con = SqliteConnection.getConnection();
    public CarModel read(int idEntity) throws SQLException {

        String query = "select * from CarModel where CarModelId = ?";
        PreparedStatement ps = con.prepareStatement(query);

        ps.setInt(1, idEntity);
        CarModel carModel = new CarModel();
        ResultSet rs = ps.executeQuery();
        boolean check = false;


        while (rs.next()) {
            check = true;
            carModel.setId(rs.getInt("CarModelId"));
            carModel.setBrand(rs.getInt("Brand"));
            carModel.setName(rs.getString("Name"));
        }

        if (check) {
            return carModel;
        } else
            return null;
    }

}
