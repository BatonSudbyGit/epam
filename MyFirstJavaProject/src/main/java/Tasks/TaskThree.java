package Tasks;

import Utils.AddFunc;
 // Calculator
public class TaskThree {
    public static void calculator() {
        char calculateIt;
        double result = 0;
        System.out.println("Enter the first number : ");
        double firstString = AddFunc.createNewInt().nextDouble();
        System.out.println("What will we do ? " );
        calculateIt = AddFunc.createNewInt().next().charAt(0);
        System.out.println("Enter the second number : ");
        double secondString = AddFunc.createNewInt().nextDouble();
        switch (calculateIt){
            case '+' :
                result = firstString + secondString;
                System.out.println("Result of your task is : ");
                System.out.println(firstString + " + " + secondString + " = " + result);
                break;
            case '-' :
                result = firstString - secondString;
                System.out.println("Result of your task is : ");
                System.out.println(firstString + " - " + secondString + " = " + result);
                break;
            case '*' :
                result = firstString * secondString;
                System.out.println("Result of your task is : ");
                System.out.println(firstString + " * " + secondString + " = " + result);
                break;
            case '/' :
                if (firstString == 0 || secondString == 0){
                    System.out.println("You input zero!");
                    System.out.println("Please can again!");
                    break;
                }
                result = firstString / secondString;
                System.out.println("Result of your task is : ");
                System.out.println(firstString + " / " + secondString + " = " + result);
                break;
            default:
                System.out.println("You input incorrect value!");
                break;
        }
    }
}
