package json.xml.project.LessonTwo_Java_OOP.candies.createCandies;

import json.xml.project.LessonTwo_Java_OOP.instances.CandyCreator;
import json.xml.project.LessonTwo_Java_OOP.json.xml.project.DataGenerator;


//Create the candy with topping for changing.
public class CandyWithTopping extends Candy implements CandyCreator, DataGenerator {
    private String topping;

    public CandyWithTopping(int price, int weight, String size, String taste, String topping) {
        super(price, weight, size, taste);
        this.topping = topping;
    }

    public CandyWithTopping() {
    }

    public void setTopping(String topping) {
        this.topping = topping;
    }

    public String getTopping() {
        return this.topping;
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
        return "Candy {Taste = " + this.getTaste() + "} {Topping = " + this.getTopping() + "} {Weight = " + this.getWeight() + "} {Price = " + this.getPrice() + " rubles}";
    }

    //@Override
    public Candy buyNewCandy() {
        return null;
                //new CandyWithTopping((int) (Math.random() * 15 + 1), (int) (Math.random() * 20 + 1 ),
               // SIZE.randomSize(), CANDY_WITH_TOPPING_TASTE.randomCandyWithToppingTaste(),
               // TOPPING.randomTopping());
    }

    @Override
    public Candy generateData() {
        return new CandyWithTopping((int) (Math.random() * 15 + 1), (int) (Math.random() * 20 + 1 ),
                SIZE.randomSize(), CANDY_WITH_TOPPING_TASTE.randomCandyWithToppingTaste(),
                TOPPING.randomTopping());
    }
}