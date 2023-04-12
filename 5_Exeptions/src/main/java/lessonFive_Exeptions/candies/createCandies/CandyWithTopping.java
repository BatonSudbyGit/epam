package lessonFive_Exeptions.candies.createCandies;

import lessonFive_Exeptions.candies.factory.ICandyFactory;
import lessonFive_Exeptions.instances.CandyCreator;
import static lessonFive_Exeptions.instances.ConstForCandies.*;
import static lessonFive_Exeptions.instances.ConstForCandies.TASTEFORCADYWITHTOPPING;

public class CandyWithTopping extends Candy implements CandyCreator, ICandyFactory {
    private String topping;

    public CandyWithTopping(int price, int weight, String size, String taste, String topping) {
        super(price, weight, size, taste);
        this.topping = topping;
    }

    public CandyWithTopping() {
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

    @Override
    public Candy buyNewCandy() {
        return new CandyWithTopping((int) (Math.random() * 15 + 1), (int) (Math.random() * 20 + 1 ),
                SIZE[(int) (Math.random() * SIZE.length)], TASTEFORCADYWITHTOPPING[(int) (Math.random() * TASTEFORCADYWITHTOPPING.length)],
                TOPPING[(int) (Math.random() * TOPPING.length)]);
    }
}
