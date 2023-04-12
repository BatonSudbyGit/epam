package jdbc.main.classes;

import jdbc.main.constants.Constants;
import jdbc.main.databases.connection.DatabaseConnection;

import java.time.LocalDate;

public class Users extends DatabaseConnection {

    public static StringBuilder createNewUser() {
        StringBuilder newUser = new StringBuilder();
        for (int i = 0; i < 20; i++) {
            newUser.append("('");
            newUser.append(Constants.NAMES_OF_USERS[(int)(Math.random() * Constants.NAMES_OF_USERS.length)]);
            newUser.append("','");
            newUser.append(Constants.SURNAMES_OF_USERS[(int)(Math.random() * Constants.SURNAMES_OF_USERS.length)]);
            newUser.append("','");
            newUser.append(createBirthdate());
            newUser.append("'),");
        }
        newUser.replace(newUser.length() - 1, newUser.length(), ";");
        return newUser;
    }

    public static LocalDate createBirthdate() {
        int yearOfBirth = (int) (Math.random() * (2010 - 1970) + 1970);
        int monthOfBirth = (int) (Math.random() * 11 + 1);
        int dayOfBirth = (int) (Math.random() * 27 + 1);
        return LocalDate.of(yearOfBirth, monthOfBirth, dayOfBirth);
    }

    public static void addNewUser() {
        createStatement();
        for (int i = 0; i < 40; i++) {
            executeUpdate(Constants.SET_NEW_USER + createNewUser());
            executeUpdate(Constants.SET_NEW_USER + createNewUser());
            executeUpdate(Constants.SET_NEW_USER + createNewUser());
            executeUpdate(Constants.SET_NEW_USER + createNewUser());
            executeUpdate(Constants.SET_NEW_USER + createNewUser());
        }
        closeConnectionAndStatement();
    }
}