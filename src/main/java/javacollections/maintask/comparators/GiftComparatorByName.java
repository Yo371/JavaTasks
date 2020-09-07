package javacollections.maintask.comparators;

import javacollections.maintask.candies.Candy;

import java.util.Comparator;

public class GiftComparatorByName implements Comparator<Candy> {
    @Override
    public int compare(Candy o1, Candy o2) {
        return o1.getName().toUpperCase().compareTo(o2.getName().toUpperCase());
    }
}
