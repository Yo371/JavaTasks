package javacollections.maintask.candies;

public class ChocolateCandy extends Candy {
    public ChocolateCandy(String name, int amountOfSugar, int weight) {
        super(name, amountOfSugar, weight);
    }

    public ChocolateCandy() {
    }

    @Override
    public String toString() {
        return "Chocolate Candy " + getName() +
                ", amount of Sugar=" + getAmountOfSugar() +
                ", weight=" + getWeight();
    }
}
