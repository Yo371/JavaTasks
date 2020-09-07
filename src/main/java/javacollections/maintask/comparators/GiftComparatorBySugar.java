package javacollections.maintask.comparators;

import javacollections.maintask.candies.Candy;

import java.util.Comparator;

public class GiftComparatorBySugar implements Comparator<Candy> {
    @Override
    public int compare(Candy o1, Candy o2) {
        return o1.getAmountOfSugar() - o2.getAmountOfSugar();
    }
}
