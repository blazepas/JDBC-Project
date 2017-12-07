package dao;

import com.util.ConnectionConfiguration;
import entities.Person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import static com.util.QueryConstants.INSERT_INTO_PERSON;

public class PersonDaoImpl implements PersonDao {
    @Override
    public void createPersonTable() {
        Connection connection = null;
        Statement statement = null;

        try {
            connection = ConnectionConfiguration.getConnection();
            statement = connection.createStatement();
            //Below SQL Create Table person

            statement.execute("CREATE TABLE person (id INTEGER primary key auto_increment, " +
                    " first_name varchar(55), " +
                    " second_name varchar(55))");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //STATEMENT CLOSE i CONNECTION CLOSE !
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    @Override
    public int insert(Person person) {
        // po korekcie
        int rowId = -1;

        try (Connection connection = ConnectionConfiguration.getConnection()) {
            try (PreparedStatement preparedStatement =
                         connection.prepareStatement(INSERT_INTO_PERSON)) {
                preparedStatement.setString(1, person.getFirstName());
                preparedStatement.setString(2, person.getSecondName());
                //Powyższy values(?,?) z parametrem 1 i 2 chroni przed SQLInjection
                rowId = preparedStatement.executeUpdate();
//            System.out.println("INSERT INTO person(first_name, second_name)" +
//                    "values(?,?)");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return rowId;
    }


    @Override
    public Person selectById(int id) {

        Connection connection = null;
        Statement statement = null;
        connection = ConnectionConfiguration.getConnection();
        try {
            statement = connection.createStatement();
        } catch (SQLException e1) {
            e1.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }

        return null;
    }


    @Override
    public List<Person> selectAll() {
        return null;
    }

    @Override
    public void update(int id) {

    }

    @Override
    public void delete(Person person, int id) {

    }
}
