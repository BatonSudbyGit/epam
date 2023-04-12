package tasks;

import primary_package.AllFunctions;

import java.time.Month;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TaskThree {
    //1.Generate a list of integers from 1 to X inclusive.
    public static void getIntArrayStream(){
        System.out.println(Arrays.toString(IntStream.range(1, AllFunctions.scannerInt()+1).toArray()));
    }
    //2.Create a new list using only items in odd positions of the original list.
    public static void getOddPositionsArrayStream(){
        List<Integer> integers = new ArrayList<>();
        int number = AllFunctions.scannerInt();
        for (int i = 0; i < number; i++) {
            integers.add((int) (Math.random()*9));
        }
        System.out.println("The main array");
        System.out.println(integers);
        AtomicInteger index = new AtomicInteger(0);
        integers = integers.stream()
                .filter(n -> ((index.getAndIncrement()) % 2 != 0))
                .collect(Collectors.toList());
        System.out.println("Needs array");
        System.out.println(integers);
    }
    //3.In the list of strings, count strings consisting only of unique characters,ignoring empty strings.
    public static void countUniqueCharactersStream() {
        System.out.println("In this task we will  ");
        String[] stringList = AllFunctions.scannerString().split(",");
        System.out.println(Stream.of(stringList).filter(s-> s.length() > 0).collect(Collectors.toList())
               .stream().filter(s-> Stream.of(s.split("")).distinct()
                        .count() == Stream.of(s.split("")).count()).count());
        /*List<String> testList = new ArrayList<>();
        int count = 0;
        long value = 0;
        int number = AllFunctions.scannerInt();
        for (int i = 0; i < number; i++) {
            testList.add(AllFunctions.scannerString());
            for (String string: testList) {
                value = (Stream.of(string).filter(s-> s.length() > 0).collect(Collectors.toList())
                        .stream().filter(s ->Stream.of(s.split("")).distinct().count() == Stream.of(s.split(""))
                                .count()).count());
            }
            if (value==1){
                count++;
            }
        }
        System.out.println(count);

         */
    }
    //4.Sort the list of rows by length in descending order
    public static void sortStringToLengthStream(){
        System.out.println("In this task we will sort the list of rows by length in descending order." +
                "\nEnter the number of rows :");
        List<String> sortedList = new ArrayList<>();
        int number = AllFunctions.scannerInt();
        System.out.println("Enter words or numbers using the 'Enter' key :");
        for (int i = 0; i < number; i++) {
            sortedList.add(AllFunctions.scannerString());
        }
        sortedList = sortedList.stream()
                .sorted(Comparator.comparing(String::length).reversed())
                .collect(Collectors.toList());
        System.out.println("Sorted list :\n" + sortedList);
    }
    //5.Check that there are no negative values in the list of numbers.
    public static void negativeNumberValueStream(){
        System.out.println("In this task we will check that there are no negative values in the list of numbers." +
                "\nEnter the number of rows :");
        List<Integer> integerList = new ArrayList<>();
        int number = AllFunctions.scannerInt();
        System.out.println("Enter the numbers using the 'Enter' key : ");
        for (int i = 0; i < number; i++) {
            integerList.add(AllFunctions.scannerInt());
        }
        boolean result = integerList.stream()
                .anyMatch(n-> n < 0);
        System.out.println(result);
    }
    /*6.Generate a Map<Month,Integer> in witch the keys will be the elements of the java.time.Month
        enumeration.Month, and the values are the length of the name of this month.*/
    public static void monthsLengthStream(){
        System.out.println("In this task we will generate a Map<Month,Integer> in witch the keys will be the " +
                "elements of the java.time.Month enumeration,\nand the values are the length of the name of this month.");
        Map<Month,Integer> monthIntegerMap;
        List<Integer> monthsLength = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12);
        monthIntegerMap = monthsLength.stream()
                .collect(Collectors.toMap(Month::of,n->String.valueOf(Month.of(n)).length()));
        System.out.println(monthIntegerMap);
    }
    //7.Find the most frequent character in the string(excluding spaces).
    public static void findMostFrequentCharacterStream(){
        System.out.println("In this task we will find the most frequent character in the string." +
                "\nEnter words or numbers separated by commas in the format 'hey,dad,123,привет ets.' :");
        String[] list = AllFunctions.scannerString().split("");
        System.out.println("The most frequent character is : " + Stream.of(list)
                        .flatMapToInt(String::chars)
                        .mapToObj(c-> (char)c)
                        .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                        .entrySet().stream()
                        .max(Comparator.comparing(Map.Entry::getValue))
                        .map(Map.Entry::getKey)
                        .get());
    }
    /*8.Transform List<Map<String,String>> into a list of all values that are used in these Maps,
        sort buy length ,then alphabetically. */
    public static void transformListMapStream(){
        System.out.println("In this task we well transform List<Map<String,String>> into a list of all values that " +
                "are used in these Maps,\nsort buy length ,then alphabetically.\n");
        String[] stringForMap = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten" };
        Map<String, String> mapList = new HashMap<>();
        for (int i = 0; i < stringForMap.length; i++) {
            mapList.put(String.valueOf(i), stringForMap[i]);
        }
        List<Map.Entry<String,String>> transformMapList = new ArrayList(mapList.entrySet());
        //transformMapList = transformMapList.stream()
                //.sorted(Comparator.comparing(map-> map.get(String.valueOf(map))))
                        //.collect(Collectors.toList());
        System.out.println("Original 'List' :");
        System.out.println(transformMapList);
        System.out.println("Sorted by length :");
        Collections.sort(transformMapList, (o1, o2) -> o2.getValue().length() - o1.getValue().length());
        System.out.println(transformMapList);
        System.out.println("Sorted alphabetically :");
        Collections.sort(transformMapList,Comparator.comparing(Map.Entry::getValue));
        System.out.println(transformMapList);
    }
}