package lessonThree_mainPakage.primaryPakage;

import java.util.*;

public class StartProgram {
    public static void main(String[] args) {
        check("я — бесценных слов мот и транжир.");
    }

    public static void check(String inputString) {
//        inputString = "я — бесценных слов мот и транжир.";
        Set <String> set = new TreeSet<>();
        Map <String, String> map = new HashMap<>();
        String[] array = inputString.replaceAll("[.—\\s]", "").split("");
        int counter = 0;
        String tempString ;
        for (int i = 0; i < array.length; i++) {
            tempString = array[i];
            for (int j = 0; j < array.length; j++) {
                if (tempString.equals(array[j])) {
                    counter++;
                    //set.add("Буква : " + tempString + " встречается " + counter + " раз \n");
                }
            }
            System.out.println("Буква : " + tempString + " встречается " + counter + " раз");
            counter = 0;
        }
        System.out.println(set);
    }
}