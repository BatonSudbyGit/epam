package jdbc.main.functions;

import jdbc.main.classes.Friendships;
import jdbc.main.classes.Likes;
import jdbc.main.classes.Posts;
import jdbc.main.classes.Users;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Utils {

    public static int checkInputInt() {
        try {
            Scanner mainInput = new Scanner(System.in);
            return mainInput.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("You entered incorrect number. Try again.");
            return checkInputInt();
        }
    }

    public static void addAllDateIntoTables() {
        Users.addNewUser();
        Friendships.addNewFriendship();
        Posts.addNewPost();
        Likes.addNewLike();

    }
}
