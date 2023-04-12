package json.xml.main.enums;


import json.xml.main.DataGenerator;
import json.xml.main.gift.Gift;

import java.util.ArrayList;
import java.util.List;

public class GetGiftClass implements DataGenerator {

    enum PRODUCTION{
        MARS("Mars"),
        CHOOPA_CHOOPS("Choopa-Choops"),
        KONTY("Konty");

        private final String enumProduction;

        PRODUCTION(String enumProduction) {
            this.enumProduction = enumProduction;
        }

        public String getEnumProduction() {
            return enumProduction;
        }

        public static String randomProduction(){
            String[] production = {MARS.getEnumProduction(), CHOOPA_CHOOPS.getEnumProduction(), KONTY.getEnumProduction()};
            return production[(int) (Math.random() * production.length)];
        }
    }

    enum TYPE {
        WITH_TOPPING("With topping"),
        CHOCOLATE("Chocolate"),
        LOLLIPOP("Lollipop"),
        CARAMEL("Caramel");

        private final String enumType;

        TYPE(String enumType) {
            this.enumType = enumType;
        }

        public String getEnumType() {
            return enumType;
        }
        public static String randomType(){
            String[] type = {WITH_TOPPING.getEnumType(), CHOCOLATE.getEnumType(),
                    LOLLIPOP.getEnumType(), CARAMEL.getEnumType()};
            return type[(int) (Math.random() * type.length)];
        }
    }

    enum NAME {
        CANDY_WITH_TOPPING("Candy with topping"),
        CHOCOLATE_CANDY("Chocolate's candy"),
        LOLLIPOP_CANDY("Lollipop's candy"),
        CARAMEL_CANDY("Caramel's candy");

        private final String enumName;

        NAME(String enumName) {
            this.enumName = enumName;
        }

        public String getEnumName() {
            return enumName;
        }

        public static String randomName() {
            String[] name = {CANDY_WITH_TOPPING.getEnumName(), CHOCOLATE_CANDY.getEnumName(),
                    LOLLIPOP_CANDY.getEnumName(), CARAMEL_CANDY.getEnumName()};
            return name[(int) (Math.random() * name.length)];
        }
    }

    enum TASTE {
        CHOCOLATES_TOPPING("Chocolate's topping"),
        CARAMELS_TOPPING("Caramel's topping"),
        NUTS("Nuts"),
        WHITE_CHOCOLATES_TOPPING("White Chocolate's topping"),
        MILKS_CHOCOLATE_TOPPING("Milk's Chocolate's topping"),
        SALTED_CHOCOLATE_TOPPING("Salted Caramel's topping");

        private final String enumTaste;

        TASTE(String enumTaste
        ) {
            this.enumTaste = enumTaste;
        }

        public String getEnumTaste() {
            return enumTaste;
        }

        public static String randomTaste() {
            String[] taste = {CHOCOLATES_TOPPING.getEnumTaste(), CARAMELS_TOPPING.getEnumTaste(),
                    NUTS.getEnumTaste(), WHITE_CHOCOLATES_TOPPING.getEnumTaste(),
                    MILKS_CHOCOLATE_TOPPING.getEnumTaste(), SALTED_CHOCOLATE_TOPPING.getEnumTaste()};
            return taste[(int) (Math.random() * taste.length)];
        }

    }

    //prod,name,type,taste,energy,cost
    @Override
    public Gift.Candy generateData() {
        return new Gift.Candy(NAME.randomName(), PRODUCTION.randomProduction(), List.of(TYPE.randomType(),
                TASTE.randomTaste()),(int) (Math.random() * (20 - 50) + 50),(int) (Math.random() * 20));
    }

    public Gift listOfCandy() {
        List<Gift.Candy> list = new ArrayList<>();
        for (int i = 0; i < 1; i++) {
            list.add(generateData());
        }
        Gift gift = new Gift();
        gift.setCandy(list);
        return gift;
    }
}