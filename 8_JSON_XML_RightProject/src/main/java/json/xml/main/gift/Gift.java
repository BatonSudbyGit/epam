package json.xml.main.gift;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.JsonAdapter;
import json.xml.main.BaseDataObject;
import json.xml.main.LocalDateTimeSerializer;
import json.xml.main.parsers.JavaAdapter;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@XmlAccessorType(XmlAccessType.NONE)
@XmlSeeAlso(Gift.Candy.class)
@XmlRootElement(name = "Gift")
public class Gift implements BaseDataObject {

    private List<Candy> candy;

    public List<Candy> getCandy() {
        return candy;
    }

    public void setCandy(List<Candy> candy) {
        this.candy = candy;
    }

    @XmlRootElement(name = "Candy")
    public static class Candy extends Gift implements BaseDataObject {

        @XmlElement(name = "name")
        @Expose
        private String name;

        @XmlElement(name = "production")
        @Expose
        private String production;

        @XmlElement(name = "typeAndTaste")
        @Expose
        private List<String> typeAndTaste;

        @XmlElement(name = "cost")
        @Expose
        private int cost;

        @XmlElement(name = "energy")
        @Expose
        private int energy;

        @XmlElement(name = "buyTime")
        @XmlJavaTypeAdapter(JavaAdapter.LocalDateAdapter.class)
        @Expose
        @JsonAdapter(LocalDateTimeSerializer.class)
        private LocalDateTime buyTime;

        public Candy() {
        }

        public Candy(String name, String production, List<String> typeAndTaste,
                     int cost, int energy) {
            this.name = name;
            this.production = production;
            this.typeAndTaste = typeAndTaste;
            this.cost = cost;
            this.energy = energy;
            this.buyTime = LocalDateTime.now();
        }

        public String getProduction() {
            return production;
        }

        public void setProduction(String production) {
            this.production = production;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<String> getTypeAndTaste() {
            return typeAndTaste;
        }

        public void setTypeAndTaste(List<String> typeAndTaste) {
            this.typeAndTaste = typeAndTaste;
        }

        public int getCost() {
            return cost;
        }

        public void setCost(int cost) {
            this.cost = cost;
        }

        public int getEnergy() {
            return energy;
        }

        public void setEnergy(int energy) {
            this.energy = energy;
        }

        public String getBuyTime() {
            int year = (int) (Math.random() * (2019 - 2021) + 2021);
            int month = (int) (Math.random() * 11 + 1);
            int day = (int) (Math.random() * 27 + 1);
            int hour = (int) (Math.random() + 23);
            int minute = (int) (Math.random() + 59);
            return LocalDateTime.of(year, month, day, hour, minute).toString();
        }

        public void setBuyTime(LocalDateTime buyTime) {
            this.buyTime = buyTime;
        }

        @Override
        public String toString() {
            return "Candy " + getName() + ":{Candy Manufacturer = " + getProduction() +
                    "},{Type and taste = " + getTypeAndTaste() + "},{Cost = " + cost + "}," +
                    "{Energy = " + getEnergy() + "},{Production date = " + buyTime + '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Candy candy = (Candy) o;
            return cost == candy.cost && energy == candy.energy && Objects.equals(production, candy.production) && Objects.equals(name, candy.name) && Objects.equals(typeAndTaste, candy.typeAndTaste) && Objects.equals(buyTime, candy.buyTime);
        }

        @Override
        public int hashCode() {
            return Objects.hash(production, name, typeAndTaste, cost, energy, buyTime);
        }
    }
}