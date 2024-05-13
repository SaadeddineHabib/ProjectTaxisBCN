package src.objects.customerdao;

import src.objects.DaoEntity;
import src.objects.orderdao.Order;
import src.sqlitedatabase.SqliteConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CustomerCRUD implements DaoEntity<Customer> {

    private static Connection con = SqliteConnection.getConnection();

    @Override
    public int create(Customer entity) throws SQLException {
        String query = "insert into Customer (FirstName, LastName, Age) VALUES (?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(query);

        ps.setString(1, entity.getName());
        ps.setString(2, entity.getLastName());
        ps.setInt(3, entity.getAge());
        ps.executeUpdate();

        ResultSet rs = ps.getGeneratedKeys();
        rs.next();
        return rs.getInt(1);
    }

    @Override
    public Customer read(int idEntity) throws SQLException {

        String query = "select * from Customer where CustomerId = ?";
        PreparedStatement ps = con.prepareStatement(query);

        ps.setInt(1, idEntity);
        Customer customer = new Customer();
        ResultSet rs = ps.executeQuery();
        boolean check = false;


        while (rs.next()) {
            check = true;
            customer.setId(rs.getInt("CustomerId"));
            customer.setName(rs.getString("FirstName"));
            customer.setLastName(rs.getString("LastName"));
            customer.setAge(rs.getInt("Age"));

        }

        if (check) {
            return customer;
        } else
            return null;
    }

    @Override
    public void update(Customer entity) throws SQLException {

        String query = "update Customer set " +
                "  FirstName = ?" +
                ", LastName = ?" +
                ", Age = ? where CustomerId = ?";
        PreparedStatement ps = con.prepareStatement(query);


        ps.setString(1, entity.getName());
        ps.setString(2, entity.getLastName());
        ps.setInt(3, entity.getAge());
        ps.setInt(4, entity.getId());
        ps.executeUpdate();
    }

    @Override
    public void delete(int idEntity) throws SQLException {
        String query = "delete from Customer where CustomerId =?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, idEntity);
        ps.executeUpdate();
    }

    @Override
    public List<Customer> getEntities() throws SQLException {
        String query = "select * from Customer";
        PreparedStatement ps = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        List<Customer> customers = new ArrayList<>();


        while (rs.next()) {
            Customer customer = new Customer();
            customer.setId(rs.getInt("CustomerId"));
            customer.setName(rs.getString("FirstName"));
            customer.setLastName(rs.getString("LastName"));
            customer.setAge(rs.getInt("Age"));

            customers.add(customer);
        }
        return customers;
    }
}
