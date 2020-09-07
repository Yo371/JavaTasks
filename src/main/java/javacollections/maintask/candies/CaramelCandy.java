package javacollections.maintask.candies;

public class CaramelCandy extends Candy {
    public CaramelCandy(String name, int amountOfSugar, int weight) {
        super(name, amountOfSugar, weight);
    }

    public CaramelCandy() {
    }


    @Override
    public String toString() {
        return "Caramel Candy " + getName() +
                ", amount of Sugar=" + getAmountOfSugar() +
                ", weight=" + getWeight();
    }
}
