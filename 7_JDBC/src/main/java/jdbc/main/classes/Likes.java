package jdbc.main.classes;

import jdbc.main.constants.Constants;
import jdbc.main.databases.connection.DatabaseConnection;

public class Likes extends DatabaseConnection {

    public static StringBuilder createNewLike() {
        StringBuilder newLike = new StringBuilder();
        for (int i = 0; i < 20; i++) {
            newLike.append("('");
            newLike.append((int) (Math.random() * 10000 + 1));
            newLike.append("','");
            newLike.append((int) (Math.random() * 1000 + 1));
            newLike.append("','");
            newLike.append(Posts.createTimestamp(2010, 2020));
            newLike.append("'),");
        }
        newLike.replace(newLike.length() - 1, newLike.length(), ";");
        return newLike;
    }

    public static void addNewLike() {
        createStatement();
        for (int i = 0; i < 50; i++) {//2500
            executeUpdate(Constants.SET_NEW_LIKE + createNewLike());
            executeUpdate(Constants.SET_NEW_LIKE + createNewLike());
            executeUpdate(Constants.SET_NEW_LIKE + createNewLike());
            executeUpdate(Constants.SET_NEW_LIKE + createNewLike());
            executeUpdate(Constants.SET_NEW_LIKE + createNewLike());;
        }
        closeConnectionAndStatement();
    }
}