package javacollections.maintask;

import javacollections.maintask.candies.*;
import javacollections.maintask.gift.GiftWithCandies;

import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        //Создание ассортимента
        ArrayList<Candy> arrayList = new ArrayList<>();
        arrayList.add(new ChocolateCandy("KitKat",32,50));
        arrayList.add(new ChocolateCandy("Spartak",30,25));
        arrayList.add(new ChocolateCandy("Snickers",28,70));
        arrayList.add(new ChocolateCandy("Mars",33,45));
        arrayList.add(new CaramelCandy("Dushes",25,15));
        arrayList.add(new ChocolateCandy("Twix",20,55));
        arrayList.add(new SweetMeatCandy("Barbaris",13,10));


        AssortmentOfSweets  assortmentOfSweets = new AssortmentOfSweets();
        assortmentOfSweets.addCollectionOfSweets(arrayList);
        //создание подарка на основании переданного ассортимента
        GiftWithCandies giftWithCandies = new GiftWithCandies(assortmentOfSweets);
        giftWithCandies.addCandyByNameAndWeight("Barbaris", 30);
        giftWithCandies.addCandyByName("Twix");
        giftWithCandies.addCandyByName("Mars");
        giftWithCandies.addCandyByName("Snickers");
        giftWithCandies.addCandyByName("KitKat");
        giftWithCandies.addCandyByNameAndWeight("Spartak", 100);

        giftWithCandies.sortByWeight();
        System.out.println("Sorted by weight");
        System.out.println(giftWithCandies);
        System.out.println("Total weight " + giftWithCandies.getTotalWeight());
        System.out.println("Candies with sugar between 20 and 30");
        System.out.println(giftWithCandies.findCandyByRangeOfSugar(20,30));



    }
}
