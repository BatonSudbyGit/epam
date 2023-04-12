package lessonFive_Exeptions.candies.createCandies;

import lessonFive_Exeptions.candies.factory.ICandyFactory;
import lessonFive_Exeptions.instances.CandyCreator;
import static lessonFive_Exeptions.instances.ConstForCandies.*;

public class Lollipop extends Candy implements CandyCreator, ICandyFactory {
    private String lollipop;

    public Lollipop(int price, int weight, String size, String taste, String lollipop) {
        super(price, weight, size, taste);
        this.lollipop = lollipop;
    }

    public Lollipop() {
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

    @Override
    public Candy buyNewCandy() {
        return new Lollipop((int)(Math.random() * 10 + 1),(int)(Math.random() * 15 + 1),
                SIZE[(int)(Math.random() * SIZE.length)],LOLLIPOPTASTE[(int)(Math.random() * LOLLIPOPTASTE.length)],
                LOLLIPOP[(int)(Math.random() * LOLLIPOP.length)]);
    }
}
