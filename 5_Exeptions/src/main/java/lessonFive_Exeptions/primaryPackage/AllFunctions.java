package lessonFive_Exeptions.primaryPackage;

import lessonFive_Exeptions.candies.createCandies.Candy;
import lessonFive_Exeptions.candies.factory.CandyFactory;
import lessonFive_Exeptions.candies.factory.NewPresentFactory;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AllFunctions {
    public static ArrayList<Candy> listOfCandies = new ArrayList();;

    public AllFunctions() {
    }
    //Checking for input numbers
    public static int checkInputInt () {
        try {
            Scanner mainInput = new Scanner(System.in);
            return mainInput.nextInt();
        }catch (InputMismatchException e){
            System.out.println("Incorrect input , try again!");
            return checkInputInt();
        }
     /*       String input = mainInput.nextLine();

        int result;
        if (input.matches("\\d+")) {
            result = Integer.parseInt(input);
        } else {
            System.out.println("You entered an incorrect character! \nYou need to enter a number. Please try again.");
            result = checkInputInt();
        }

        return result;

      */
    }
    //Main menu of the program.
    public static void mainMenu(){
        System.out.println("This is a main menu.You need to change what will do next : " +
                "\n1.Buy a ready-made set.\n2.Buy the right amount of candy.");
        switch (checkInputInt()){
            case 1:
                buyNewPresent(listOfCandies);
                mainMenu();
                break;
            case 2:
                buyNewCandies(listOfCandies);
                break;
            default:
                System.out.println("You entered an incorrect number!\nChange between 1 and 2.\n");
        }
        mainMenu();
    }
    //Chose the candies and buy the right amount.
    public static void buyNewCandies(ArrayList<Candy> listOfCandies){
        System.out.println("Here you can change amount of candies and it's type! " +
                "\nEnter amount of candies you want to buy :");
        int numberOfCandy = checkInputInt();
        System.out.println("Enter number of candy you want to buy :\n1.Candy with topping\n2.Chocolate\n3.Caramel" +
                "\n4.Lollipop");
        int candyType = checkInputInt();
        CandyFactory.getNewCandies(numberOfCandy,listOfCandies,candyType);
        listOfCandies.stream().forEach(System.out::println);
        findPriceOrWeight();
        mainMenu();
    }
    //Change and buy the ready-made Present.
    public static void buyNewPresent(ArrayList<Candy> listOfCandies) {
        System.out.println("Here you can change the ready-made New Year Present!\nChange the present :" +
                "\n1.Small present(10 Candies).\n2.Medium present(20 Candies).\n3.Big present(30 Candies).\n");
        int presentType = checkInputInt();
        NewPresentFactory.getNewPresent(listOfCandies,presentType);
        listOfCandies.stream().forEach(System.out::println);
        findPriceOrWeight();
        mainMenu();
    }
    //Search for the right candy at the price.
    public static void findPrice() {
        System.out.println("What cost candy do you need?");
        int priceCandy = checkInputInt();
        System.out.println("The candy you're looking for :");
        for (int i = 0; i < listOfCandies.size(); i++) {
            if ((listOfCandies.get(i)).getPriceCandy() == priceCandy) {
                System.out.println((listOfCandies.get(i)).toString());
            }
            else if (priceCandy == 0){
                System.out.println("You entered 0. Try again!");
                findPrice();
            }
            else if (priceCandy > 10){
                System.out.println("No candies with the specified price were found.\nTry again!");
                findPrice();
            }
        }
        System.out.println("Thank You!\n ");
        System.out.println("It's full. You can do in again." +
                "\n");
        mainMenu();
    }
    //Search for the right candy at the weight.
    public static void findWeight(){
        System.out.println("What weight candy do you need?");
        int weightCandy = checkInputInt();
        System.out.println("The candy you're looking for :");
        for (int i = 0; i < listOfCandies.size(); i++) {
            if (listOfCandies.get(i).getWeightCandy() == weightCandy){
                System.out.println(listOfCandies.get(i).toString());
            }
            else if (weightCandy == 0){
                System.out.println("You entered 0. Try again!");
                findWeight();
            }
            else if (weightCandy > 15){
                System.out.println("No candies with the specified weight were found.\nTry again!");
                findWeight();
            }
        }
        System.out.println("Thank You!\n ");
        System.out.println("It's full. You can do in again." +
                "\n ");
        mainMenu();
    }

    public static void findPriceOrWeight() {
        System.out.println("This is a menu in which you can choose a candy by weight or price :" +
                "\n1.Find candy to weight.\n2.Find candy to price.");
        switch (checkInputInt()) {
            case 1:
                findWeight();
                break;
            case 2:
                findPrice();
                break;
            default:
                System.out.println("You entered an incorrect number!\nChange between 1 and 2.");
        }
        findPriceOrWeight();
    }
}
