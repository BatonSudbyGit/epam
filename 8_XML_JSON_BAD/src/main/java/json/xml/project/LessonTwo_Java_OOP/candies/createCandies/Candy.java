package json.xml.project.LessonTwo_Java_OOP.candies.createCandies;

import json.xml.project.LessonTwo_Java_OOP.instances.CandyCreator;
import json.xml.project.LessonTwo_Java_OOP.json.xml.project.BaseDataObject;
import json.xml.project.LessonTwo_Java_OOP.json.xml.project.emums.Enums;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "Candy")
public class Candy extends Enums implements CandyCreator, BaseDataObject {
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

    public Candy() {
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

    public void setPrice(int price) {
        this.price = price;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setTaste(String taste) {
        this.taste = taste;
    }

    @Override
    public int getPriceCandy() {
        return 0;
    }

    @Override
    public int getWeightCandy() {
        return 0;
    }
}