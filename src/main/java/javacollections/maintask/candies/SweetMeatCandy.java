package javacollections.maintask.candies;

public class SweetMeatCandy extends Candy {
    public SweetMeatCandy(String name, int amountOfSugar, int weight) {
        super(name, amountOfSugar, weight);
    }

    public SweetMeatCandy() {
    }

    @Override
    public String toString() {
        return "Sweet Meat Candy " + getName() +
                ", amount of Sugar=" + getAmountOfSugar() +
                ", weight=" + getWeight();
    }
}
