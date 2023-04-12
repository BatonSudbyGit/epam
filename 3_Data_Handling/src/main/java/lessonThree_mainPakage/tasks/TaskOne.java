package lessonThree_mainPakage.tasks;
import lessonThree_mainPakage.primaryPakage.AllFunctions;
import java.awt.*;

public class TaskOne {
//Changing a number to a binary system.
    public static void createBinary() {
        System.out.println("In this task, we need to translate a positive number into binary code, " +
                "return it as a string.\nEnter the number :");
        int getBinary = AllFunctions.scannerInt();
        String stringBinary = Integer.toBinaryString(getBinary);
        System.out.println("Input's number is : " + getBinary + ". " + "\nBinary's value is : " + stringBinary + ".");
    }
//Changing the format of color.
    public static String color(String changeString) {
        System.out.println("In this task, we need to convert the color entered in '#FB12F2' format to " +
                "'rgb(251, 18, 242)' format.\nEnter the void :");
        Color changeColor = new Color(
            Integer.valueOf(changeString.substring(1, 3),16),
            Integer.valueOf(changeString.substring(3, 5),16),
            Integer.valueOf(changeString.substring(5,7),16));
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("rgb(");
        stringBuffer.append(changeColor.getRed());
        stringBuffer.append(",");
        stringBuffer.append(changeColor.getGreen());
        stringBuffer.append(",");
        stringBuffer.append(changeColor.getBlue());
        stringBuffer.append(")");
        System.out.println("Needs value is : " + stringBuffer);
        return stringBuffer.toString();
    }
//Change the case of all letters.
    public static void changeLetterCase(){
        System.out.println("In this task, we need to change the case of all letters to the opposite in the line." +
                "\nEnter the string :");
        String inputString = AllFunctions.scannerString();
        StringBuilder finishedString = new StringBuilder();
        char[] mainString = inputString.toCharArray();
        for (char i : mainString) {
            if (Character.isLowerCase(i)) {
                i = Character.toUpperCase(i);
            }
            else {
                i = Character.toLowerCase(i);
            }

            finishedString.append(i);
        }
        System.out.println("Needs values is : " + finishedString);
    }
//Print the array elements by X number.
    public static void inputArray() {
        System.out.println("In this task, we need to print an array of numbers, the elements should go in portions of X elements separated by " +
                "a comma and a space, each portion on a new line.\nEnter the numbers without space :");
        String inputString = AllFunctions.scannerString();
        System.out.println("Enter the amount of the rows :");
        int value = AllFunctions.scannerInt();
        StringBuffer stringBufferOne = new StringBuffer();
        int count = 0;
        for (String i:inputString.split("")) {
            stringBufferOne.append(i);
            stringBufferOne.append(", ");
            count ++ ;
            if (count % value == 0){
                stringBufferOne.append("\n");
            }
        }
        System.out.println("Needs values is : \n" + stringBufferOne);
    }
}