package projet.spring3.plain;

import projet.spring3.dao.ContactDao;
import projet.spring3.domain.Contact;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class PlainContactDao implements ContactDao {
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            // noop
        }
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/contact?autoReconnect=true&useSSL=false",
                "root", "password");
    }

    private void closeConnection(Connection connection) {
        if (connection == null) return;

        try {
            connection.close();
        } catch (SQLException ex) {
            // noop
        }
    }

    @Override
    public String findFirstNameById(Long id) {
        return null;
    }

    public List<Contact> findAll() {
        List<Contact> result = new ArrayList<Contact>();

        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement statement =
                    connection.prepareStatement("select * from contact");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Contact contact = new Contact();
                contact.setId(resultSet.getLong("id"));
                contact.setFirstName(resultSet.getString("first_name"));
                contact.setLastName(resultSet.getString("last_name"));
                contact.setBirthDate(resultSet.getDate("birth_date"));
                result.add(contact);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            closeConnection(connection);
        }
        return result;
    }
    public List<Contact> findByFirstName(String firstName) {
        return null;
    }
    public void insert(Contact contact) {
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(
                    "insert into Contact (first_name, last_name, birth_date) values (?, ?, ?)"
                    , Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, contact.getFirstName());
            statement.setString(2, contact.getLastName());
            statement.setDate(3, contact.getBirthDate());
            statement.execute();

            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                contact.setId(generatedKeys.getLong(1));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            closeConnection(connection);
        }
    }

    public void update(Contact contact) {
    }

    public void delete(Long contactId) {
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement statement = connection.prepareStatement("delete from contact where id=?");
            statement.setLong(1, contactId);
            statement.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public List<Contact> findAllWithDetail() {
        return null;
    }

    @Override
    public void insertWithDetail(Contact contact) {

    }


}