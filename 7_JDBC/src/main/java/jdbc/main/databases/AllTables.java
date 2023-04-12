package jdbc.main.databases;

import jdbc.main.constants.Constants;
import jdbc.main.databases.connection.DatabaseConnection;

import java.sql.SQLException;

public class AllTables extends DatabaseConnection {

    //Create table Users
    public static void createTableUsers() {
        startConnection();
        createStatement();
        executeUpdate("CREATE TABLE " + Constants.TABLENAME_USERS + " (id INTEGER not NULL AUTO_INCREMENT, " +
                "name VARCHAR(40) not NULL, surname VARCHAR(40) NOT NULL, birthdate DATE not NULL, PRIMARY KEY (id))");
        closeConnectionAndStatement();
        /*try {
            connection =  getConnection();
            statement = connection.createStatement();
            statement.executeUpdate("CREATE TABLE " + Constants.TABLENAME_USERS + " (id INTEGER not NULL, name VARCHAR(40), " +
                    "surname VARCHAR(40), birthdate INTEGER not NULL, PRIMARY KEY (id))");
        } catch (SQLException e) {
            System.out.println("Table 'Users' was not created");
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                System.out.println("'statement' wasn't close");
            }

        }
         */
    }

    //Create table Friendship
    public static void createTableFriendship() {
        startConnection();
        createStatement();
        executeUpdate("CREATE TABLE " + Constants.TABLENAME_FRIENDSHIP +
                " (userID1 INTEGER not NULL, userID2 INTEGER NOT NULL,"
                + " timestamp DATETIME NOT NULL)");
        closeConnectionAndStatement();
        /*try {
            connection =  getConnection();
            statement = connection.createStatement();
            statement.executeUpdate("CREATE TABLE " + Constants.TABLENAME_FRIENDSHIP +
                    " (userID1 INTEGER not NULL, userID2 INTEGER not NULL,"
                    + " timestamp INTEGER not NULL, PRIMARY KEY (userID1))");
        } catch (SQLException e) {
            System.out.println("Table 'Friendship' was not created");
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                System.out.println("'statement' wasn't close");
            }

        }
         */
    }

    //Create table Posts
    public static void createTablePosts() {
       startConnection();
       createStatement();
       executeUpdate("CREATE TABLE " + Constants.TABLENAME_POSTS + " (id INTEGER not NULL AUTO_INCREMENT, " +
                       "userID INTEGER not NULL, text VARCHAR(1000) not NULL, " +
                       "timestamp DATETIME not NULL, PRIMARY KEY ( id ))");
       closeConnectionAndStatement();
       /* try {
            connection =  getConnection();
            statement = connection.createStatement();
            statement.executeUpdate("CREATE TABLE " + Constants.TABLENAME_POSTS + " (id INTEGER not NULL, " +
                    "userID INTEGER not NULL, text VARCHAR(1000), timestamp INTEGER not NULL, PRIMARY KEY (id))");
        } catch (SQLException e) {
            System.out.println("Table 'Posts' was not created");
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                System.out.println("'statement' wasn't close");
            }
        }

        */
    }

    //Create table Likes
    public static void createTableLikes() {
        //try {
            //connection =  getConnection();
            //statement = connection.createStatement();
        startConnection();
        createStatement();
        executeUpdate("CREATE TABLE " + Constants.TABLENAME_LIKES + " (postID INTEGER not NULL, " +
                    "userID INTEGER not NULL, timestamp DATETIME not NULL)");
        closeConnectionAndStatement();
        //} catch (SQLException e) {
           // System.out.println("Table 'Likes' was not created");
        //}
       // if (statement != null) {
            //try {
             //   statement.close();
            //} catch (SQLException e) {
            //    System.out.println("'statement' wasn't close");
           /// }
       // }
    }

    //Create tables method
    public static void createAllTables() {
        createTableUsers();
        createTableFriendship();
        createTablePosts();
        createTableLikes();
    }
}