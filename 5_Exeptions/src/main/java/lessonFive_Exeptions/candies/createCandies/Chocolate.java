package lessonFive_Exeptions.candies.createCandies;

import lessonFive_Exeptions.candies.factory.ICandyFactory;
import lessonFive_Exeptions.instances.CandyCreator;
import static lessonFive_Exeptions.instances.ConstForCandies.*;

public class Chocolate extends Candy implements CandyCreator, ICandyFactory {
    private String chocolate;

    public Chocolate(int price, int weight, String size, String taste, String chocolate) {
        super(price, weight, size, taste);
        this.chocolate = chocolate;
    }

    public Chocolate() {
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

    @Override
    public Candy buyNewCandy() {
        return new Chocolate((int)(Math.random() * 10 + 1),(int)(Math.random() * 15 + 1),
                SIZE[(int)(Math.random() * SIZE.length)],TASTEFORCHOCOLATE[(int)(Math.random() * TASTEFORCHOCOLATE.length)],
                CHOCOLATE[(int)(Math.random() * CHOCOLATE.length)]);
    }
}
