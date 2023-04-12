package json.xml.project.LessonTwo_Java_OOP.json.xml.project.emums;

import json.xml.project.LessonTwo_Java_OOP.json.xml.project.BaseDataObject;
import json.xml.project.LessonTwo_Java_OOP.json.xml.project.DataGenerator;

public class Enums implements DataGenerator {

    @Override
    public BaseDataObject generateData() {
        return null;
    }

    public enum SIZE {
        SMALL("Small"),
        MEDIUM("Medium"),
        BID("Big");

        private String enumSize;

        SIZE(String enumSize) {
            this.enumSize = enumSize;
        }

        public String getEnumSize() {
            return enumSize;
        }

        public static String randomSize(){
            String[] size = {SMALL.getEnumSize(), MEDIUM.getEnumSize(), BID.getEnumSize()};
            return size[(int) (Math.random() * size.length)];
        }
    }

    public enum TASTE {
        CANDY_WITH_TOPPING("Candy with topping"),
        CHOCOLATE_CANDY("Chocolate's candy"),
        LOLLIPOP("Lollipop"),
        CARAMEL("Caramel");

        private String enumTaste;

        TASTE(String enumTaste) {
            this.enumTaste = enumTaste;
        }

        public String getEnumTaste() {
            return enumTaste;
        }
        public static String randomTaste(){
            String[] taste = {CANDY_WITH_TOPPING.getEnumTaste(), CHOCOLATE_CANDY.getEnumTaste(),
                    LOLLIPOP.getEnumTaste(), CARAMEL.getEnumTaste()};
            return taste[(int) (Math.random() * taste.length)];
        }
    }

    public enum CANDY_WITH_TOPPING_TASTE {
        CANDY_WITH_TOPPING("Candy with topping");

        private String enumCandyWithToppingTaste;

        CANDY_WITH_TOPPING_TASTE(String enumCandyWithToppingTaste) {
            this.enumCandyWithToppingTaste = enumCandyWithToppingTaste;
        }

        public String getEnumCandyWithToppingTaste() {
            return enumCandyWithToppingTaste;
        }
        public static String randomCandyWithToppingTaste() {
            String[] candyWithToppingTaste = {CANDY_WITH_TOPPING.getEnumCandyWithToppingTaste()};
            return candyWithToppingTaste[(int) (Math.random() * candyWithToppingTaste.length)];
        }
    }

    public enum CARAMEL_TASTE {
        CARAMEL_TASTE("Caramel");

        private String enumCaramelTaste;

        CARAMEL_TASTE(String enumCaramelTaste) {
            this.enumCaramelTaste = enumCaramelTaste;
        }

        public String getEnumCaramelTaste() {
            return enumCaramelTaste;
        }

        public static String randomCaramelTaste() {
            String[] caramelTaste = {CARAMEL_TASTE.getEnumCaramelTaste()};
            return caramelTaste[(int) (Math.random() * caramelTaste.length)];
        }
    }

    public enum CHOCOLATE_TASTE {
        CHOCOLATE_TASTE("Chocolate");

        private String enumChocolateTaste;

        CHOCOLATE_TASTE(String enumChocolateTaste) {
            this.enumChocolateTaste = enumChocolateTaste;
        }

        public String getEnumChocolateTaste() {
            return enumChocolateTaste;
        }

        public static String randomChocolateTaste() {
            String[] chocolateTaste = {CHOCOLATE_TASTE.getEnumChocolateTaste()};
            return chocolateTaste[(int) (Math.random() * chocolateTaste.length)];
        }
    }

    public enum LOLLIPOP_TASTE {
        STRAWBERRY("Strawberry"),
        APPLE("Apple"),
        WATERMELON("Watermelon");

        private String enumLollipopTaste;

        LOLLIPOP_TASTE(String enumLollipopTaste) {
            this.enumLollipopTaste = enumLollipopTaste;
        }

        public String getEnumLollipopTaste() {
            return enumLollipopTaste;
        }

        public static String randomLollipopTaste() {
            String[] lollipopTaste = {STRAWBERRY.getEnumLollipopTaste(), APPLE.getEnumLollipopTaste(),
                    WATERMELON.getEnumLollipopTaste()};
            return lollipopTaste[(int) (Math.random() * lollipopTaste.length)];
        }
    }

    public enum TOPPING {
        CHOCOLATES_TOPPING("Chocolate's topping"),
        CARAMELS_TOPPING("Caramel's topping"),
        NUTS("Nuts");

        private String enumTopping;

        TOPPING(String enumTopping) {
            this.enumTopping = enumTopping;
        }

        public String getEnumTopping() {
            return enumTopping;
        }

        public static String randomTopping() {
            String[] topping = {CHOCOLATES_TOPPING.getEnumTopping(), CARAMELS_TOPPING.getEnumTopping(),
                    NUTS.getEnumTopping()};
            return topping[(int) (Math.random() * topping.length)];
        }
    }

    public enum CARAMEL {
        SALTED_CARAMEL("Salted Caramel"),
        CARAMEL("Caramel"),
        MILKS_CARAMEL("Milk's Caramel");

        private String enumCaramel;

        CARAMEL(String enumCaramel) {
            this.enumCaramel = enumCaramel;
        }

        public String getEnumCaramel() {
            return enumCaramel;
        }

        public static String randomCaramel() {
            String[] caramel = {SALTED_CARAMEL.getEnumCaramel(), CARAMEL.getEnumCaramel(),
                    MILKS_CARAMEL.getEnumCaramel()};
            return caramel[(int) (Math.random() * caramel.length)];
        }
    }

    public enum CHOCOLATE {
        BLACK_CHOCOLATE("Black Chocolate"),
        WHITE_CHOCOLATE("White Chocolate"),
        MILKS_CHOCOLATE("Milk's Chocolate");

        private String enumChocolate;

        CHOCOLATE(String enumChocolate) {
            this.enumChocolate = enumChocolate;
        }

        public String getEnumChocolate() {
            return enumChocolate;
        }

        public static String randomChocolate() {
            String[] chocolate = {BLACK_CHOCOLATE.getEnumChocolate(), WHITE_CHOCOLATE.getEnumChocolate(),
                    MILKS_CHOCOLATE.getEnumChocolate()};
            return chocolate[(int) (Math.random() * chocolate.length)];
        }
    }

    public enum LOLLIPOP {
        PINK("Pink"),
        YELLOW("Yellow"),
        RAINBOW("Rainbow");
        private String enumLollipop;

        LOLLIPOP(String enumLollipop) {
            this.enumLollipop = enumLollipop;
        }

        public String getEnumLollipop() {
            return enumLollipop;
        }

        public static String randomLollipop() {
            String[] lollipop = {PINK.getEnumLollipop(), YELLOW.getEnumLollipop(), RAINBOW.getEnumLollipop()};
            return lollipop[(int) (Math.random() * lollipop.length)];
        }
    }

    public enum SPECIAL_TASTE {
        CHOCOLATES_TOPPING("Chocolate's topping"),
        CARAMELS_TOPPING("Caramel's topping"),
        NUTS("Nuts"),
        WHITE_CHOCOLATES_TOPPING("White Chocolate's topping"),
        MILKS_CHOCOLATE_TOPPING("Milk's Chocolate's topping"),
        SALED_CHOCOLATE_TOPPING("Salted Caramel's topping");

        private String enumSpecialTaste;

        SPECIAL_TASTE(String enumSpecialTaste) {
            this.enumSpecialTaste = enumSpecialTaste;
        }

        public String getEnumSpecialTaste() {
            return enumSpecialTaste;
        }

        public static String randomSpecialTaste() {
            String[] specialTaste = {CHOCOLATES_TOPPING.getEnumSpecialTaste(), CARAMELS_TOPPING.getEnumSpecialTaste(),
                    NUTS.getEnumSpecialTaste(), WHITE_CHOCOLATES_TOPPING.getEnumSpecialTaste(),
                    MILKS_CHOCOLATE_TOPPING.getEnumSpecialTaste(), SALED_CHOCOLATE_TOPPING.getEnumSpecialTaste()};
            return specialTaste[(int) (Math.random() * specialTaste.length)];
        }
    }
}
