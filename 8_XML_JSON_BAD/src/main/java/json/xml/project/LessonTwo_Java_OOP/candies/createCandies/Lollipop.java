package json.xml.project.LessonTwo_Java_OOP.candies.createCandies;

import json.xml.project.LessonTwo_Java_OOP.instances.CandyCreator;
import json.xml.project.LessonTwo_Java_OOP.json.xml.project.DataGenerator;

//Create the lollipop's candy for changing.
public class Lollipop extends Candy implements CandyCreator, DataGenerator {
    private String lollipop;

    public Lollipop(int price, int weight, String size, String taste, String lollipop) {
        super(price, weight, size, taste);
        this.lollipop = lollipop;
    }

    public Lollipop() {
    }

    public void setLollipop(String lollipop) {
        this.lollipop = lollipop;
    }

    public String getLollipop() {
        return lollipop;
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
        return "Candy {Taste = " + this.getTaste() + " } {Lollipop = " + this.getLollipop() + " } {Size = " + getSize() +
                "} {Weight = " + this.getWeight() + "} {Price = " + this.getPrice() + " rubles}";
    }

    //изменить имплеентацию
    //@Override
    public Candy buyNewCandy() {
        return null;
    }

    @Override
    public Candy generateData() {
        return new Lollipop((int)(Math.random() * 10 + 1),(int)(Math.random() * 15 + 1),
                SIZE.randomSize(),LOLLIPOP_TASTE.randomLollipopTaste(),
                LOLLIPOP.randomLollipop());
    }
}