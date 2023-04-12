package json.xml.project.LessonTwo_Java_OOP.primaryPackage;

public class StartProgram {
    public static void main(String[] args) {
        AllFunctions allFunctions = new AllFunctions();
        System.out.println("This is a program in which you can choose a ready-made present or assemble a new one" +
                "\nLet's start!");
        allFunctions.mainMenu();
    }
}