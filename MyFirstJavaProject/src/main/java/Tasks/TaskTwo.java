package Tasks;
import java.lang.reflect.Array;
import java.util.Arrays;
import Utils.AddFunc;

import java.util.Objects;
import java.util.Scanner;

public class TaskTwo {
    // Create new string
    public static String createNewLine() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
    // Input number of strings and strings
    public static String[] createStringFromInput() {
        System.out.println("Enter the number of strings");
        String[] firstString = new String[Integer.parseInt(AddFunc.createNewLine())];
        for (int i = 0; i < firstString.length; i++) {
            System.out.println("Enter the string");
            firstString[i] = createNewLine();
        }
        return firstString;

    }
    //Fond the shortest string and miss is empty. If have no one, say about it.
    // Найти самую короткую строку, не учитывая пустые строки. Если не найдено ни одной, вернуть сообщение об этом.
    public static void findShortestString() {
        String[] line = createStringFromInput();
        String minString = line[0];
        for (int i = 0; i < line.length; i++) {
            if (line[i].length() < minString.length() && line[i].length() != 0 ) {
                minString = line[i];
            }
        }
        if (!minString.equals("")) {
            System.out.println("The shortest string is : " + minString);
        }
        else {
            System.out.println("We have no needs string");
        }
    }

    //  Find strings hwo more than average and it's length
    //	Найти те строки, длина которых больше средней, а также длину. Вывести их на консоль.
    public static void findMediumStrings() {
        String[] line = createStringFromInput();
        String averageLine = line[0];
        double average = 0;
        for (int i = 0; i < line.length; i++) {
            average += line[i].length();
        }
        average /= (line.length);
        for (int i = 0; i < line.length; i++) {
            if (line[i].length() > average) {
                averageLine = line[i];
                System.out.println("String hwo more than average is : " + (i += 1));
                System.out.println("Value of 'more than average' is : " + averageLine);
            }
        }
        System.out.println("Average value : " + average);
    }

    // 3. Find string consists of number. If it's more then one , find first. If it's no one , say about it
    // Найти строку, состоящую только из цифр. Если таких строк больше одной, найти вторую из них. Если нет ни одной, вернуть сообщение об этом.
    public static void findStringСonsistNumbers() {
        String[] numberStrings = createStringFromInput();
        int count = 0;
        String needsString = numberStrings[0];
            for (int i = 0; i < numberStrings.length; i++) {
                boolean result = numberStrings[i].matches("[0-9]+");
                boolean letters = numberStrings[i].matches("[a-zA-Z]+");
                if (numberStrings[i].length() >= 1 && result) {
                    count++;
                }
                if (count == 2 && !letters) {
                    needsString = numberStrings[i];
                    break;
                }
                else if (count == 1 && !letters) {
                    needsString = numberStrings[i];

                }
            }
        if (!needsString.equals("")) {
            System.out.println("String who we need is : " + needsString);
        }
        else {
            System.out.println("We have no needs string");
        }

    }
    //4. In array of string count only unique symbol's string miss is empty
    // В массиве строк подсчитать строки, состоящие только из уникальных символов, игнорируя пустые строки.
    public static void findUniqueString() {
        String[] inputString = createStringFromInput();
        int count = 0;
        for (int i = 0; i < inputString.length; i++) {
            if (inputString[i].length() == 1){
                count++;
                continue;
            }
            String[] splitedString = inputString[i].split("");
            for (int j = 0; j < splitedString.length - 1; j++) {
                for (int k = j + 1; k < splitedString.length; k++) {
                    if (splitedString[j].equals(splitedString[k])) {
                        break;
                    }
                    if (k == splitedString.length - 1 ) {
                        count++ ;
                    }
                }
                break;
            }
        }
        System.out.println("Number of string : " + count);
    }
}