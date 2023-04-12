package jdbc.main.constants;

public class Constants {
    //---------------May change the name of class--------------------//
    //Constants for DatabaseConnection
    public static final String MYSQL_URL = "jdbc:mysql://localhost:3306/";
    public static final String MYSQL_DRIVER = "com.mysql.jdbc.Driver";
    public static final String MYSQL_USERNAME = "name";
    public static final String MYSQL_PASSWORD = "root";
    public static final String VEpamke_DATABASE = "CREATE DATABASE VEpamke";
    public static final String DATABASE_NAME = "VEpamke";
    //Constants for databases
    public static final String TABLENAME_USERS = "Users";
    public static final String TABLENAME_FRIENDSHIP = "Friendships";
    public static final String TABLENAME_POSTS = "Posts";
    public static final String TABLENAME_LIKES = "Likes";
    //Constants for data about users
    public static final String[] NAMES_OF_USERS = {"Oliver", "Jack", "Harry", "Jacob", "Charlie", "Thomas",
            "George", "Oscar", "James", "William", "Noah", "Alfie", "Joshua", "Muhammad", "Henry", "Leo", "Archie",
            "Ethan", "Joseph", "Freddie", "Samuel", "Alexander", "Logan", "Amelia", "Olivia", "Isla", "Emily",
            "Poppy", "Ava", "Isabella", "Jessica", "Lily", "Sophie", "Grace", "Sophia", "Mia", "Evie", "Ruby",
            "Ella", "Scarlett", "Isabelle", "Chloe", "Sienna", "Freya", "Phoebe", "Sharlotte", "Daisy", "Alice"};
    public static final String[] SURNAMES_OF_USERS = {"Smith", "Johnson", "Williams", "Jones", "Brown", "Davis",
            "Miller", "Wilson", "Moore", "Taylor", "Anderson", "Thomas", "Jackson", "White", "Harris", "Martin",
            "Thompson", "Garcia", "Martinez", "Robinson", "Clark", "Rodriguez", "Lewis", "Lee", "Walker", "Hall",
            "Allen", "Young", "Hernandez", "King", "Wright", "Lopez", "Hill", "Scott", "Green", "Adams", "Baker",
            "Gonzalez", "Carter", "Peres", "Roberts", "Turner", "Phillips"};
    public static final String[] POSTS = {"Otters have a pocket in their skin where they store their favorite " +
            "pebbles, with which they break hard " +
            "shells of mollusks, foraging.",
            "According to the study, the average IQ of a person has increased by about 20% since the 1950s.",
            "Rats and giraffes can go without water longer than a camel.",
            "There are more lakes in Canada than in any other country.",
            "If you decide to go to Iceland, know that tipping in this country is an insult.",
            "Cotton candy was invented by a dentist.", "In medieval Germany, there was a belief that a kiss with " +
            "a donkey relieves toothache.",
            "Google earns about $700 per second.", "Among all dogs, chihuahuas have the largest brain relative " +
            "to their body.",
            "Chewing gum destroys almost as many bacteria in ten minutes as flossing.",
            "The national anthem of Greece has 158 verses."};
    //Constants for adding data into tables
    public static final String SET_NEW_USER = "INSERT INTO vepamke.users (name, surname, birthdate) VALUES ";
    public static final String SET_NEW_FRIENDSHIP = "INSERT INTO vepamke.friendships (userid1, userid2, timestamp) " +
            "VALUES ";
    public static final String SET_NEW_POST = "INSERT INTO vepamke.posts (userid, text, timestamp) VALUES ";
    public static final String SET_NEW_LIKE = "INSERT INTO vepamke.likes (postid, userid, timestamp) VALUES ";

}