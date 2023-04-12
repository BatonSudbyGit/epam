package jdbc.main.menus;

import jdbc.main.databases.AllTables;
import jdbc.main.databases.connection.DatabaseConnection;
import jdbc.main.databases.requests.SqlRequests;
import jdbc.main.functions.Utils;

public class Menus extends Utils {

    public static void mainMenu() {
        System.out.println("This is a main menu of the application.\nYou need to change and enter " +
                "one of numbers to continue working:\n1.Create the tables\n2.Fill all the tables with data" +
                "\n3.Make request (Display a list of unique names of users who had more than 100 friends in " +
                "March 2015 and the average number of likes of each post (for the entire period) " +
                "is in the range (3 - 15))");
        switch (checkInputInt()){
            case 1:
                createTablesMenu();
                break;
            case 2:
                addAllDateIntoTables();
                mainMenu();
                break;
            case 3:
                    SqlRequests.requestAboutUsers();
                    mainMenu();
                break;
            default:
                System.out.println("You entered incorrect number. Try again(between 1 and 3)");
                mainMenu();
        }

    }

    public static void createTablesMenu() {
        System.out.println("This is a menu for create the tables.\nYou need to change and enter " +
                "one of numbers to continue working:\n1.Create all the tables\n2.Create the table 'Users'" +
                "\n3.Create the table 'Friendship'\n4.Create the table 'Posts'\n5.Create the table 'Likes'" +
                "\n6.Come back to the main menu\n7.Quit");
        switch (checkInputInt()){
            case 1:
                DatabaseConnection.executeUpdate("DROP TABLE users;");
                DatabaseConnection.executeUpdate("DROP TABLE friendships;");
                DatabaseConnection.executeUpdate("DROP TABLE likes;");
                DatabaseConnection.executeUpdate("DROP TABLE posts;");
                AllTables.createAllTables();
                System.out.println("The tables were created successfully");
                mainMenu();
                break;
            case 2:
                DatabaseConnection.executeUpdate("DROP TABLE users;");
                AllTables.createTableUsers();
                createTablesMenu();
                break;
            case 3:
                DatabaseConnection.executeUpdate("DROP TABLE friendship;");
                AllTables.createTableFriendship();
                createTablesMenu();
                break;
            case 4:
                DatabaseConnection.executeUpdate("DROP TABLE posts;");
                AllTables.createTablePosts();
                createTablesMenu();
                break;
            case 5:
                DatabaseConnection.executeUpdate("DROP TABLE likes;");
                AllTables.createTableLikes();
                createTablesMenu();
                break;
            case 6:
                mainMenu();
                break;
            case 7:
                break;
            default:
                System.out.println("You entered incorrect number. Try again(between 1 and 7)");
                createTablesMenu();
        }
        DatabaseConnection.closeConnectionAndStatement();
    }
}
