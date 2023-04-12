package json.xml.project.LessonTwo_Java_OOP.candies.createCandies;

import json.xml.project.LessonTwo_Java_OOP.instances.CandyCreator;
import json.xml.project.LessonTwo_Java_OOP.json.xml.project.DataGenerator;

//import static json.xml.project.LessonTwo_Java_OOP.instances.ConstForCandies.*;

//Create the chocolate's candy for changing.
public class Chocolate extends Candy implements CandyCreator, DataGenerator {
    private String chocolate;

    public Chocolate(int price, int weight, String size, String taste, String chocolate) {
        super(price, weight, size, taste);
        this.chocolate = chocolate;
    }

    public Chocolate() {
    }

    public void setChocolate(String chocolate) {
        this.chocolate = chocolate;
    }

    public String getChocolate() {
        return chocolate;
    }

    @Override
    public int getPriceCandy() {
        return this.getPrice();
    }

    @Override
    public int getWeightCandy() {
        return this.getWeight();
    }

    @Override
    public String toString() {
        return "Candy {Taste = " + this.getTaste() + " } {Chocolate = " + this.getChocolate() + " } {Size = " + getSize() +
                "} {Weight = " + this.getWeight() + "} {Price = " + this.getPrice() + " rubles}";
    }

    /*
    @Override
    public Candy buyNewCandy() {
        return new Chocolate((int)(Math.random() * 10 + 1),(int)(Math.random() * 15 + 1), SIZE.randomSize(),
                CHOCOLATE_TASTE.randomChocolateTaste(), CHOCOLATE.randomChocolate());
        /*
        return new Chocolate((int)(Math.random() * 10 + 1),(int)(Math.random() * 15 + 1),
                SIZE[(int)(Math.random() * SIZE.length)], TASTEFORCHOCOLATE[(int)(Math.random() * TASTEFORCHOCOLATE.length)],
                CHOCOLATE[(int)(Math.random() * CHOCOLATE.length)]);
        */

    @Override
    public Candy generateData() {
        return new Chocolate((int)(Math.random() * 10 + 1),(int)(Math.random() * 15 + 1), SIZE.randomSize(),
                CHOCOLATE_TASTE.randomChocolateTaste(), CHOCOLATE.randomChocolate());
    }

    //Исправить
    //@Override
    public Candy buyNewCandy() {
        return null;
    }
}
/*
    @Override
    public Candy generateData() {
        return new Chocolate((int)(Math.random() * 10 + 1),(int)(Math.random() * 15 + 1), SIZE.randomSize());
    }
 */