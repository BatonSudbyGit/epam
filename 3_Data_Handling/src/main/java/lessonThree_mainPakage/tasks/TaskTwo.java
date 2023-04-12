package lessonThree_mainPakage.tasks;

import lessonThree_mainPakage.primaryPakage.AllFunctions;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskTwo {
//Compared to the first characters.
    public static void matchFirstLetters() {
        System.out.println("In this task, we need to consisting of a first and last name, determine whether the first and " +
                "last names begin with the same letter, for example 'Sarah Smith'.\nEnter the string : ");
        String inputString = AllFunctions.scannerString();
        Pattern pattern = Pattern.compile("[A-Z][a-z]{1,20}\\s[A-Z][a-z]{1,20}");
        Matcher matcher = pattern.matcher(inputString);
        System.out.println(((matcher.matches()) && inputString.split(" ")[0].substring(0,1).equals(inputString.split(" ")[1].substring(0,1))));
    }
//Turn all the words backwards.
    public static void reverseString(String string){
        System.out.println("Needs string is : ");
        for (String i:string.split(" ")) {
            System.out.print(new StringBuilder(i).reverse() + " ");
        }
    }
//Converts string characters.
    public static void convertToUpper(String string) {
        System.out.println("In this task you need to convert string from lowerCaseName to LOWER_CASE_NAME.");
        string = string.trim()
                .replaceAll("([A-Z])", "_$1");
        System.out.println("The main string : " + string);
        StringBuilder finishedString = new StringBuilder();
        char[] mainString = string.toCharArray();
        for (char i : mainString) {
            if (Character.isLowerCase(i)) {
                i = Character.toUpperCase(i);
            }
            finishedString.append(i);
        }
        System.out.println("Needs string is : " + finishedString);
    }
//Converts string characters.
    public static void convertToLower(String string) {
        System.out.println("In this task you need to convert string from UPPER_CASE_NAME to upperCaseName.");
        System.out.println("The main string : " + string);
        string.toLowerCase();

        char[] mainString = string.toCharArray();
        for (int i = 0; i < mainString.length; i++) {
            if (mainString[i] == '_'){
                mainString[i + 1] = Character.toLowerCase(mainString[i + 1]);
            }
            else if (Character.isLowerCase(mainString[i])){
                mainString[i] = Character.toUpperCase(mainString[i]);
            }
            else {
                mainString[i] = Character.toLowerCase(mainString[i]);
            }
        }
        string = String.valueOf(mainString);
        String needsString = string.replaceAll("_", "");
        System.out.println("Needs string is : " + needsString);
    }
//Find names that start and end with A, return as an array.
    public static void findName(ArrayList<String> list){
        System.out.println("In this task you need to find names that start and end with A, return as an array. " +
                "If there are no such names in the string, return a message about it.\nEnter the names : ");
        String inputString = AllFunctions.scannerString();
        String[] splitString = inputString.split("[\\s+]");
        Pattern pattern = Pattern.compile("^[A-a].*[A-a]$");
        for (String i:splitString) {
            Matcher matcher = pattern.matcher(i);
            if (matcher.find()) {
                System.out.println(i);
                list.add(i);
            }
        }
        if (!list.isEmpty()) {
            System.out.println("The names hwo you needs is : " + list);
        }
        else {
            System.out.println("We have no needs names.");
        }
    }
}