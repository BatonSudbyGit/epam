package lessonFive_Exeptions.candies.createCandies;

import lessonFive_Exeptions.candies.factory.ICandyFactory;
import lessonFive_Exeptions.instances.CandyCreator;

public abstract class Candy implements CandyCreator, ICandyFactory {
    private int price;
    private int weight;
    private String size;
    private String taste;

    public Candy(int price, int weight, String size,String taste) {
        this.price = price;
        this.weight = weight;
        this.size = size;
        this.taste = taste;
    }

    protected Candy() {
    }

    public int getPrice() {
        return price;
    }

    public int getWeight() {
        return weight;
    }

    public String getSize() {
        return size;
    }

    public String getTaste() {
        return taste;
    }
}
