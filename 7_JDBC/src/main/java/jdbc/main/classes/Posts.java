package jdbc.main.classes;

import jdbc.main.constants.Constants;
import jdbc.main.databases.connection.DatabaseConnection;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Posts extends DatabaseConnection {

    public static StringBuilder createNewPost() {
        StringBuilder newPost = new StringBuilder();
        for (int i = 0; i < 20; i++) {
            newPost.append("('");
            newPost.append((int) (Math.random() * 1000 + 1));
            newPost.append("','");
            newPost.append(Constants.POSTS[(int) (Math.random() * 10)]);
            newPost.append("','");
            newPost.append(createTimestamp(2010, 2020));
            newPost.append("'),");
        }
        newPost.replace(newPost.length() - 1, newPost.length(), ";");
        return newPost;
    }

    public static void addNewPost() {
        createStatement();
        for (int i = 0; i < 10; i++) {//1500
            executeUpdate(Constants.SET_NEW_POST + createNewPost());
            executeUpdate(Constants.SET_NEW_POST + createNewPost());
            executeUpdate(Constants.SET_NEW_POST + createNewPost());
            executeUpdate(Constants.SET_NEW_POST + createNewPost());
            executeUpdate(Constants.SET_NEW_POST + createNewPost());
        }
        closeConnectionAndStatement();
    }

    public static String createTimestamp(int firstYear, int secondYear) {
        int yearOfWriting = (int) (Math.random() * (firstYear - secondYear) + secondYear);
        int monthOfWriting = (int) (Math.random() * 11 + 1);
        int dayOfWriting = (int) (Math.random() * 27 + 1);
        int hourOfWriting = (int) (Math.random() * 24);
        int minuteOfWriting = (int) (Math.random() * 59);
        return LocalDateTime.of(yearOfWriting, monthOfWriting, dayOfWriting, hourOfWriting, minuteOfWriting)
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
    }
}