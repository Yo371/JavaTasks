package javacollections.maintask.candies;

import java.util.Objects;

public abstract class Candy {
    private String name;
    private int amountOfSugar;
    private int weight;

    public Candy(String name, int amountOfSugar, int weight) {
        this.name = name;
        this.amountOfSugar = amountOfSugar;
        this.weight = weight;
    }

    public Candy() {
    }

    public static Candy getInstanceByName(String name){
        return name.toLowerCase().equals("chocolatecandy") ? new ChocolateCandy() :
                name.toLowerCase().equals("caramelcandy") ? new CaramelCandy() :
                        name.toLowerCase().equals("sweetmeatcandy") ? new SweetMeatCandy() : null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmountOfSugar() {
        return amountOfSugar;
    }

    public void setAmountOfSugar(int amountOfSugar) {
        this.amountOfSugar = amountOfSugar;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Candy candy = (Candy) o;
        return amountOfSugar == candy.amountOfSugar &&
                weight == candy.weight &&
                Objects.equals(name, candy.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, amountOfSugar, weight);
    }

}
