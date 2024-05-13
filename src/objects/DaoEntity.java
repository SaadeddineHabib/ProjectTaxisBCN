package src.objects;

import java.sql.SQLException;
import java.util.List;

public interface DaoEntity<T>{

    int create(T entity) throws SQLException;

    T read(int idEntity) throws SQLException;

    void update(T entity) throws SQLException;

    void delete(int idEntity) throws SQLException;

    List<T> getEntities() throws SQLException;

}
