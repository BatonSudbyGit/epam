package Tasks;

import Utils.AddFunc;

import java.util.Arrays;
// Arrays of numbers
public class TaskOne {

    public static void subTaskOne() {
        int[] numbers = AddFunc.createMassiveOfRandomNumbers();
        int indexOfNumbers = 0;
        for (int i = 2; i < numbers.length; i += 2) {
            indexOfNumbers = indexOfNumbers + numbers[i];
        }
        System.out.println(Arrays.toString(numbers));
        System.out.println(indexOfNumbers);
    }
    //Change the negative numbers to zero

    public static void subTaskTwo() {
        int[] numbers = AddFunc.createMassiveOfRandomNumbers();
        System.out.println(Arrays.toString(numbers));
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < 0) {
                numbers[i] = 0;
            }
        }
        System.out.println(Arrays.toString(numbers));
    }

    // tripling the number before the negative
    public static void subTaskThree() {
        int[] numbers = AddFunc.createMassiveOfRandomNumbers();
        System.out.println(Arrays.toString(numbers));
        for (int i = 1; i < numbers.length; i++) {
            if ((numbers[i - 1] > 0) && (numbers[i] < 0)) {
                numbers[i - 1] *= 3;
            }
        }
        System.out.println(Arrays.toString(numbers));
    }

    //4. In numbers's array input out all the elements hwo meet there more than once
    // В массиве целых чисел вывести все элементы, которые встречаются больше одного раза и индексы которых нечётные.
    public static void subTaskFour() {
        int[] numbers = AddFunc.createMassiveOfRandomNumbers();
        System.out.println(Arrays.toString(numbers));
        for (int i = 0; i < numbers.length - 1; i++ ) {
            for (int n = i + 1; n < numbers.length; n++) {
                if (n % 2 != 0 && numbers[n] == numbers[i] && (n != i)) {
                    System.out.println(numbers[n]);;
                }
            }
        }
    }
    // we miss five's task
    // пятое задание пропускаем

    //6. calculate factorial
    // вычислить факториал

    public static void subTaskSix() {
        int[]numbers = AddFunc.createMassiveOfRandomNumbers();
        System.out.println(numbers[5]);
        int fact = 1;
        for (int i = 1; i <= numbers[5] ; i++) {;
            fact *= i;
        }
        System.out.println(fact);
    }
}




