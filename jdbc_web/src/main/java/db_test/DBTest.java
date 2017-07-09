package db_test;

import java.sql.*;

/**
 * Created by Татьяна on 08.06.2017.
 */
public class DBTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.h2.Driver");
        Connection connection =
                DriverManager.getConnection("jdbc:h2:file:D:/HillelCourse/JavaEE/PersonDB", "root", "root");

        printPersonInfo(connection);

        createNewRandomPersons(connection, "yyy");

        printPersonInfo(connection);

        connection.setAutoCommit(false);
        //connection.setTransactionIsolation();
        Savepoint svp1 = connection.setSavepoint("svp1");
        try {
            createNewRandomPersons(connection, "block_name_1");
            throw new RuntimeException();
        } catch (Exception e) {
            connection.rollback(svp1);
        }
    }

    private static void createNewRandomPersons(Connection connection, String baseName) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO PERSONS(NAME) VALUES(?)");
        for (int i = 0; i < 5; i++) {
            preparedStatement.setString(1, baseName + i);
            preparedStatement.addBatch();
        }
        preparedStatement.executeBatch();
    }

    private static void printPersonInfo(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM PERSON");
        while (resultSet.next()) {
            System.out.println("id="+resultSet.getString(1));
            System.out.println("name="+resultSet.getString(2));
        }
    }
}
