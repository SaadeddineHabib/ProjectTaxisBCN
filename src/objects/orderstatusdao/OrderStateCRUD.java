package src.objects.orderstatusdao;

import src.sqlitedatabase.SqliteConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderStateCRUD {

    private static Connection con = SqliteConnection.getConnection();

    public OrderState read(int idEntity) throws SQLException {

        String query = "select * from OrderStatus where OrderStatusId = ?";
        PreparedStatement ps = con.prepareStatement(query);

        ps.setInt(1, idEntity);
        OrderState orderState = new OrderState();
        ResultSet rs = ps.executeQuery();
        boolean check = false;


        while (rs.next()) {
            check = true;
            orderState.setOrderStatusId(rs.getInt("OrderStatusId"));
            orderState.setName(rs.getString("Name"));
        }

        if (check) {
            return orderState;
        } else
            return null;
    }

}
