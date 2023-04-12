package tasks;

import primary_package.AllFunctions;

import java.time.Month;
import java.util.*;

public class TaskOne {

    //1.Generate a list of integers from 1 to X inclusive.
    public static void getIntArray() {
        System.out.println("In this task we will generate a list of integers from 1 to X inclusive." +
                "\nEnter the X value :");
        List<Integer> getIntList = new ArrayList();
        int inputInt = AllFunctions.scannerInt();
        for (int i = 0; i < inputInt; i++) {
            getIntList.add(i + 1);
        }
        System.out.println(getIntList);
    }
    //2.Remove duplicates from the collection.
    public static void deleteDuplicates() {
        ArrayList<String> mainList = new ArrayList<>();
        int numbers = AllFunctions.scannerInt();
        for (int i = 0; i < numbers; i++) {
            mainList.add(AllFunctions.scannerString());
        }
        Set<String> deleteDuplicatesSet = new HashSet<>(mainList);
        System.out.println(deleteDuplicatesSet);
    }
    //3.Create a new list using only items in odd positions of the original list.
    public static void getOddPositionsArray(){
        ArrayList<Integer> arrayList = new ArrayList<>();
        ArrayList<Integer> lastList = new ArrayList<>();
        int inputInt = AllFunctions.scannerInt();
        for (int i = 0; i < inputInt; i++) {
            arrayList.add((int)(Math.random()*9));
            if (i % 2 != 0){
                lastList.add(arrayList.get(i));
            }
        }
        System.out.println(arrayList);
        System.out.println("123" + lastList);
    }
    //4.
    public static void countUniqueCharacters(){
        List<String> firstList = new ArrayList<>();
        Set<String> lastString = new LinkedHashSet<>();
        int numbers = AllFunctions.scannerInt();
        for (int i = 0; i < numbers; i++) {
            firstList.add(AllFunctions.scannerString());
            for (String obj : firstList) {
                lastString.add(Arrays.toString(obj.split("")));
            }
        }
        System.out.println(firstList);
        System.out.println(lastString);
    }
    //5.
    public static void sortStringToLength(){
        List<String> stringList = new ArrayList<>();
        int numbers = AllFunctions.scannerInt();
        for (int i = 0; i < numbers; i++) {
            stringList.add(AllFunctions.scannerString());
        }
        stringList.sort(Collections.reverseOrder());
        stringList.sort(Comparator.reverseOrder());
        System.out.println("ArrayList in descending order: ");
        for (String i : stringList) {
            System.out.println(stringList);
            break;
        }
    }
    //6.
    public static void negativeNumberValue() {
        List<Integer> numberList = new ArrayList<>();
        int numbers = AllFunctions.scannerInt();
        int count = 0;
        for (int i = 0; i < numbers; i++) {
            numberList.add(AllFunctions.scannerInt());
            if ((numberList.get(i)) < 0) {
                count++;
            }
        }
        if (count > 0) {
            System.out.println("There are negative values in this list : ");
        } else {
            System.out.println("There aren't negative values in this list :");
        }
        System.out.println(numberList);
    }
    //7.
    public static boolean checkingPlacementBrackets(String str){
        if (str.length()%2!=0){
            return  false;
        }
        List<String> mainList = new ArrayList<>();
        mainList.add(str);
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (count < 0){
                return false;
            }
            String symbol = str.substring(i,i + 1);
            if (symbol.equals("(") || symbol.equals("{") || symbol.equals("[")){
                count++;
                continue;
            }
            if (symbol.equals(")") || symbol.equals("}") || symbol.equals("]")){
                count--;
            }
        }
        if (count == 0){
            return true;
        }
        else {
            return false;
        }
    }
    //8.
    public static void monthsLength(){
        Map<Month, Integer> months = new HashMap<>();
        for (int i = 1; i < 13; i++) {
            String numberOfMonth = String.valueOf(Month.of(i));
            months.put(Month.of(i),numberOfMonth.length());
        }
        System.out.println(months);
    }
    //9.
    public static void replacementKayAndValue(){
        Map<Month, Integer> months = new TreeMap<>();
        Map<Integer, Month> monthInverse = new HashMap<>();
        for (int i = 1; i < 13; i++) {
            months.put(Month.of(i),i);
        }
        System.out.println(months);
        for (Map.Entry<Month, Integer> valueOfMonth : months.entrySet()) {
            monthInverse.put(valueOfMonth.getValue(),valueOfMonth.getKey());
        }
        System.out.println(monthInverse);
    }
    //10.
    public static void transformListMap() {
        List<Map<String, String>> transformList = new ArrayList<>();
        Map<String, String> mapList = new TreeMap<>();
        String[] stringForMap = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten" };
        for (int i = 0; i < stringForMap.length; i++) {
            mapList.put(String.valueOf(i), stringForMap[i]);
            transformList.add(mapList);
        }
        List<String> allValues = new ArrayList<>();
        for (Map.Entry<String,String> stringEntry: mapList.entrySet()) {
            allValues.add(stringEntry.getValue());
        }
        System.out.println(transformList);
        System.out.println("Алфавит");
        Collections.sort(allValues);
        System.out.println(Arrays.toString(allValues.toArray()));
        Collections.sort(allValues, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length() - o1.length();
            }
        });
        System.out.println("Сортировка по длинне");
        System.out.println(allValues);
    }
}