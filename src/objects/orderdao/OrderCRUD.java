package src.objects.orderdao;

import src.objects.DaoEntity;
import src.sqlitedatabase.SqliteConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class OrderCRUD implements DaoEntity<Order> {

    private static Connection con = SqliteConnection.getConnection();

    public LocalDateTime convertStringToLocalDateSqlite(String date) {
        if (date == null) {
            return LocalDateTime.of(9999, 12, 31, 23, 59, 59);
        }
        return LocalDateTime.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
    }

    public String convertLocalDateSqliteToString(LocalDateTime localDateTime) {
        return localDateTime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
    }


    @Override
    public int create(Order entity) throws SQLException {
        String query = "insert into [Order] (AssignedTaxi, OrderStatus, Customer," +
                "StartOrderDate, EndOrderDate, StartLocationOrder, EndLocationOrder) VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(query);

        String dateStartOrderToString = convertLocalDateSqliteToString(entity.getDateStartOrder());
        String dateEndOrderToString = convertLocalDateSqliteToString(entity.getDateEndOrder());

        ps.setInt(1, entity.getTaxi());
        ps.setInt(2, entity.getState());
        ps.setInt(3, entity.getCustomer());
        ps.setString(4, dateStartOrderToString);
        ps.setString(5, dateEndOrderToString);
        ps.setString(6, entity.getLocationStartOrder());
        ps.setString(7, entity.getLocationEndOrder());
        ps.executeUpdate();

        ResultSet rs = ps.getGeneratedKeys();
        rs.next();
        return rs.getInt(1);
    }

    @Override
    public Order read(int idEntity) throws SQLException {

        String query = "select * from [Order] where OrderId= ?";
        PreparedStatement ps = con.prepareStatement(query);

        ps.setInt(1, idEntity);
        Order order = new Order();
        ResultSet rs = ps.executeQuery();
        boolean check = false;


        while (rs.next()) {
            check = true;
            order.setOrderId(idEntity);
            LocalDateTime dateStartOrder = convertStringToLocalDateSqlite(rs.getString("StartOrderDate"));
            LocalDateTime dateEndOrder = convertStringToLocalDateSqlite(rs.getString("EndOrderDate"));

            order.setOrderId(rs.getInt("OrderId"));
            order.setTaxi(rs.getInt("AssignedTaxi"));
            order.setState(rs.getInt("OrderStatus"));
            order.setCustomer(rs.getInt("Customer"));
            order.setDateStartOrder(dateStartOrder);
            order.setDateEndOrder(dateEndOrder);
            order.setLocationStartOrder(rs.getString("StartLocationOrder"));
            order.setLocationEndOrder(rs.getString("EndLocationOrder"));
        }

        if (check) {
            return order;
        } else
            return null;
    }

    @Override
    public void update(Order entity) throws SQLException {

        String query = "update [Order] set AssignedTaxi = ?" +
                ", OrderStatus = ?" +
                ", Customer = ?" +
                ", StartOrderDate = ?" +
                ", EndOrderDate = ?" +
                ", StartLocationOrder = ?" +
                ", EndLocationOrder = ? where OrderId = ?";
        PreparedStatement ps = con.prepareStatement(query);

        String dateStartOrderToString = convertLocalDateSqliteToString(entity.getDateStartOrder());
        String dateEndOrderToString = convertLocalDateSqliteToString(entity.getDateEndOrder());

        ps.setInt(1, entity.getTaxi());
        ps.setInt(2, entity.getState());
        ps.setInt(3, entity.getCustomer());
        ps.setString(4, dateStartOrderToString);
        ps.setString(5, dateEndOrderToString);
        ps.setString(6, entity.getLocationStartOrder());
        ps.setString(7, entity.getLocationEndOrder());
        ps.setInt(8, entity.getOrderId());
        ps.executeUpdate();
    }

    @Override
    public void delete(int idEntity) throws SQLException {
        String query = "delete from [Order] where OrderId =?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, idEntity);
        ps.executeUpdate();
    }

    @Override
    public List<Order> getEntities() throws SQLException {
        String query = "select * from [Order]";
        PreparedStatement ps = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        List<Order> orders = new ArrayList<>();


        while (rs.next()) {
            Order order = new Order();

            LocalDateTime dateStartOrder = convertStringToLocalDateSqlite(rs.getString("StartOrderDate"));
            LocalDateTime dateEndOrder = convertStringToLocalDateSqlite(rs.getString("EndOrderDate"));


            order.setOrderId(rs.getInt("OrderId"));
            order.setTaxi(rs.getInt("AssignedTaxi"));
            order.setState(rs.getInt("OrderStatus"));
            order.setCustomer(rs.getInt("Customer"));
            order.setDateStartOrder(dateStartOrder);
            order.setDateEndOrder(dateEndOrder);
            order.setLocationStartOrder(rs.getString("StartLocationOrder"));
            order.setLocationEndOrder(rs.getString("EndLocationOrder"));

            orders.add(order);
        }
        return orders;
    }
}
