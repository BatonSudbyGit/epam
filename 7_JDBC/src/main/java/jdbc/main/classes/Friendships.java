package jdbc.main.classes;

import jdbc.main.constants.Constants;
import jdbc.main.databases.connection.DatabaseConnection;

public class Friendships extends DatabaseConnection {

    public static StringBuilder createNewFriendship() {
        StringBuilder newFriendship = new StringBuilder();
        for (int i = 0; i < 20; i++) {
            newFriendship.append("('");
            newFriendship.append((int) (Math.random() * 1000 + 1));
            newFriendship.append("','");
            newFriendship.append((int) (Math.random() * 1000 + 1));
            newFriendship.append("','");
            newFriendship.append(Posts.createTimestamp(2010, 2020));
            newFriendship.append("'),");
        }
        newFriendship.replace(newFriendship.length() - 1, newFriendship.length(), ";");
        return newFriendship;
    }

    public static void addNewFriendship() {
        createStatement();
        for (int i = 0; i < 10; i++) {//5000
            executeUpdate(Constants.SET_NEW_FRIENDSHIP + createNewFriendship());
            executeUpdate(Constants.SET_NEW_FRIENDSHIP + createNewFriendship());
            executeUpdate(Constants.SET_NEW_FRIENDSHIP + createNewFriendship());
            executeUpdate(Constants.SET_NEW_FRIENDSHIP + createNewFriendship());
            executeUpdate(Constants.SET_NEW_FRIENDSHIP + createNewFriendship());
        }
        closeConnectionAndStatement();
    }
}