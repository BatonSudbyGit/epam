package json.xml.project.LessonTwo_Java_OOP.candies.present;

import json.xml.project.LessonTwo_Java_OOP.candies.createCandies.Candy;
import json.xml.project.LessonTwo_Java_OOP.candies.factory.INewPresentFactory;
import json.xml.project.LessonTwo_Java_OOP.instances.CandyCreator;
import json.xml.project.LessonTwo_Java_OOP.json.xml.project.BaseDataObject;
import json.xml.project.LessonTwo_Java_OOP.json.xml.project.DataGenerator;

//Create special candy for the New Year Present.
public class SpecialCandyForPresent extends Candy implements CandyCreator, INewPresentFactory, DataGenerator {
    private String specialTaste;

    public SpecialCandyForPresent(int price, int weight, String size, String taste, String specialTaste) {
        super(price, weight, size, taste);
        this.specialTaste = specialTaste;
    }

    public SpecialCandyForPresent() {
    }

    public String getSpecialTaste() {
        return specialTaste;
    }

    @Override
    public int getPriceCandy() {
        return this.getPrice();
    }

    @Override
    public int getWeightCandy() {
        return this.getWeight();
    }

    //@Override
    public Candy buyNewCandy() {
        return null;
    }

    @Override
    public String toString() {
        return "Candy {Type = " + this.getTaste() + " } {Taste = " + this.getSpecialTaste() + " } {Size = " + getSize() +
                "} {Weight = " + this.getWeight() + "} {Price = " + this.getPrice() + " rubles}";
    }

    @Override
    public Candy generateData() {
        return new SpecialCandyForPresent((int)(Math.random() * 10 + 1),(int)(Math.random() * 15 + 1),
                SIZE.randomSize(),TASTE.randomTaste(),
                SPECIAL_TASTE.randomSpecialTaste());
    }

    @Override
    public BaseDataObject buyNewPresent() {
        return null;
    }
}