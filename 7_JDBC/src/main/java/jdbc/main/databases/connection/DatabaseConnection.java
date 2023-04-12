package jdbc.main.databases.connection;

import jdbc.main.constants.Constants;

import java.sql.*;

public class DatabaseConnection {

    protected static Statement statement;
    protected static Connection connection;

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(Constants.MYSQL_URL + Constants.DATABASE_NAME, Constants.MYSQL_USERNAME,
                Constants.MYSQL_PASSWORD);
    }

    public static void startConnection() {
        try {
            connection = getConnection();
        } catch (SQLException e) {
            System.out.println("Where was no connection in 'DriverManager'");
        }
    }

    public static void closeConnectionAndStatement() {
        if (connection != null) {
            try {
                connection.close();
            }catch (SQLException e) {
                System.out.println("'connection' weren't close");
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                System.out.println("'statement' wasn't close");
            }
        }
    }

    public static void createStatement() {
        try {
            startConnection();
            statement = connection.createStatement();
        } catch (SQLException e) {
            System.out.println("'statement' wasn't created");
        }
    }

    public static void executeUpdate(String sqlRequest) {
        try {
            createStatement();
            statement.executeUpdate(sqlRequest);
        } catch (SQLException e) {
            System.out.println("'statement.executeUpdate' with request " + sqlRequest + "isn't work");
        }
    }
    //-----------Уточнить по этому----------//
    public static ResultSet executeQuery(String sqlRequest) {
        try {
            createStatement();
            statement.executeQuery(sqlRequest);
        } catch (SQLException e) {
            System.out.println("'statement.executeQuery' with request " + sqlRequest + "isn't work");
        }
        return null;
    }

    public static void createNewDatabase() {

        //Register JDBC driver
        try {
            Class.forName(Constants.MYSQL_DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println("SQL Driver is not registered");
        }
        //Connection to MySQL
        startConnectionForCreateNewDatabase(Constants.MYSQL_URL,
                Constants.MYSQL_USERNAME, Constants.MYSQL_PASSWORD);

        //Create database
        startConnection();
        executeUpdate(Constants.VEpamke_DATABASE);
        System.out.println("Database successfully created");
        closeConnectionAndStatement();

    }
/*
    public static void createNewDatabase() { // MAY CHANGE THE NAME OF METHOD
        //-------Work with JDBC driver---------//

        //Register JDBC driver
        try {
            Class.forName(Constants.MYSQL_DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println("SQL Driver is not registered");
        }

        //Connection to MySQL
        try {
            connection =  DriverManager.getConnection(Constants.MYSQL_URL,
                        Constants.MYSQL_USERNAME, Constants.MYSQL_PASSWORD);
        } catch (SQLException e) {
            System.out.println("Where was no connection in 'DriverManager'");
        }

        //Create database
        try {
            statement = connection.createStatement();
            statement.executeUpdate(Constants.VEpamke_DATABASE);
            System.out.println("Database successfully created");
        } catch (SQLException e) {
            System.out.println("The creation of the database wasn't successfully completed");
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                }catch (SQLException e) {
                    System.out.println("'connection' weren't close");
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    System.out.println("'statement' wasn't close");
                }
            }
        }
    }

 */
    public static Connection getConnectionForCreateNewDatabase(String url, String username, String password) throws SQLException {
            return DriverManager.getConnection(url, username, password);
    }

    public static void startConnectionForCreateNewDatabase(String url, String username, String password) {
        try {
            connection = getConnectionForCreateNewDatabase(url, username, password);
        } catch (SQLException e) {
            System.out.println("Where was no connection in 'DriverManager'");
        }
    }
}