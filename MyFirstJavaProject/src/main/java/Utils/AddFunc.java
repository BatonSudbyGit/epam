package Utils;


import java.util.Scanner;

//TaskOne
public class AddFunc {
    public static int[] createMassiveOfRandomNumbers() {
        int[] numbers = new int[20];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = (int) (Math.random() * 20 - 10);
        }
        return numbers;
    }


    public static String createNewLine() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();

    }

    public static Scanner createNewInt(){
        Scanner scanner = new Scanner(System.in);
        return scanner;
    }

}
