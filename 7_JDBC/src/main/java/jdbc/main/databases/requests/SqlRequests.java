package jdbc.main.databases.requests;

import jdbc.main.databases.connection.DatabaseConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashSet;

public class SqlRequests extends DatabaseConnection{

    public static void requestAboutUsers()  {
        LinkedHashSet<String> listWithNames = new LinkedHashSet<>();
        DatabaseConnection.startConnection();
        String request = "SELECT * FROM (\n" +
                "SELECT users.id AS id, users.name AS name, users.surname AS surname, count_friends FROM (\n" +
                "SELECT friendships.userid1 AS userid1, COUNT(userid1) AS count_friends FROM friendships \n" +
                "WHERE timestamp < '2015-04-01' GROUP BY userid1 HAVING COUNT(userid1) > 100) AS friends_counter\n" +
                "JOIN users ON id = userid1) AS freinds \n" +
                "JOIN (SELECT posts.userid AS userid, COUNT(userid) AS post_counter FROM posts \n" +
                "GROUP BY userid) AS post_counter ON id=userid \n" +
                "JOIN (SELECT userid, (like_counter/COUNT(id)) AS avr_likes_post FROM (\n" +
                "SELECT userid, posts.id, like_counter FROM posts\n" +
                "JOIN (SELECT postid AS post, COUNT(likes.postid) AS like_counter FROM likes \n" +
                "GROUP BY likes.postid) AS inst ON post=posts.id) AS avg_numb_likes \n" +
                "GROUP BY userid) AS temp ON id=temp.userid\n" +
                "WHERE avr_likes_post >=  3 AND avr_likes_post < 15;";
        createStatement();
        ResultSet result = executeQuery(request);
        while (true){
            try {
                assert result != null;
                if (!result.next()) break;
            listWithNames.add(result.getString("name"));
            } catch (SQLException e) {
                System.out.println("There is no work adding information after request");
            }
        }
        System.out.println("Result of request:");
        System.out.println(listWithNames);
        DatabaseConnection.closeConnectionAndStatement();
    }
}