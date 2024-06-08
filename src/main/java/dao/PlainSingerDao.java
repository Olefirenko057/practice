package dao;

import entities.Singer;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class PlainSingerDao implements SingerDao {
//    private static Logger logger = (Logger) LoggerFactory.getLogger(PlainSingerDao.class);
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException();
        }
    }
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:rnysql://localhost:3306/rnusicdb?useSSL=true",
                "prospring5", "prospring5"
        );
    }

    private void closeConnection(Connection connection) {
        if(connection ==  null) {
            return;
        }
        try {
            connection.close();
        } catch (SQLException ex) {
            throw new RuntimeException();
        }
    }
    @Override
    public List<Singer> findAll() {
        List<Singer> result = new ArrayList<>();
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement statement = connection.prepareStatement("select * from singer");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Singer singer = new Singer();
                singer.setId(resultSet.getLong("id"));
                singer.setFirstName(resultSet.getString("first_name"));
                singer.setLastName(resultSet.getString("last_name"));
                singer.setDate(resultSet.getDate("birth_date"));
                result.add(singer);
            }
            statement.close();
        } catch (SQLException ex) {

        } finally {
            closeConnection(connection);
        }
        return result;
    }

    @Override
    public List<Singer> findByFirstName() {
        return null;
    }

    @Override
    public String findLastNameById() {
        return null;
    }

    @Override
    public String findFirstNameById() {
        return null;
    }

    @Override
    public void insert(Singer singer) {
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement statement = connection.prepareStatement
                    ("insert into Singer " + "(first_name,last_name,birth_date) values (?,?,?)",Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, singer.getFirstName());
            statement.setString(2, singer.getLastName());
            statement.setDate(3,singer.getDate());
            statement.execute();
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if(generatedKeys.next()) {
                singer.setId(generatedKeys.getLong(1));
            }
            statement.close();
        } catch (SQLException ex) {

        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public void update(Singer singer) {

    }

    @Override
    public void delete(long singerId) {
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(
                    "delete from Singer where id=?");
            statement.setLong(1,singerId);
            statement.execute();
            statement.close();
        } catch (SQLException ex) {

        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public List<Singer> findAllWithDetail() {
        return null;
    }

    @Override
    public void insertWithDetail(Singer singer) {

    }
}
