package lessonFive_Exeptions.candies.present;

import lessonFive_Exeptions.candies.createCandies.Candy;
import lessonFive_Exeptions.candies.factory.ICandyFactory;
import lessonFive_Exeptions.candies.factory.INewPresentFactory;
import lessonFive_Exeptions.instances.CandyCreator;
import static lessonFive_Exeptions.instances.ConstForCandies.*;

public class SpecialCandyForPresent extends Candy implements CandyCreator, ICandyFactory, INewPresentFactory {
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

    @Override
    public Candy buyNewCandy() {
        return null;
    }

    @Override
    public String toString() {
        return "Candy {Type = " + this.getTaste() + " } {Taste = " + this.getSpecialTaste() + " } {Size = " + getSize() +
                "} {Weight = " + this.getWeight() + "} {Price = " + this.getPrice() + " rubles}";
    }

    @Override
    public Candy buyNewPresent() {
        return new SpecialCandyForPresent((int)(Math.random() * 10 + 1),(int)(Math.random() * 15 + 1),
                SIZE[(int)(Math.random() * SIZE.length)],TASTE[(int)(Math.random() * TASTE.length)],
                SPECIALTASTE[(int)(Math.random() * SPECIALTASTE.length)]);
    }
}
