package javacollections.maintask;


import javacollections.maintask.candies.*;
import javacollections.maintask.gift.GiftWithCandies;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ConsoleAppGiftCollector {
    public static void main(String[] args) {

        File file = new File("src\\main\\java\\javacollections\\data\\assortment.txt");

        AssortmentOfSweets assortmentOfSweets = new AssortmentOfSweets();


        try {
            //инициализация ассортимента конфет из файла
            assortmentOfSweets.loadAssortmentFromFile(file);
            //создание пустого подарка на основании переданного ассортимента с возможностью добавления конфет
            GiftWithCandies giftWithCandies = new GiftWithCandies(assortmentOfSweets);

            Scanner scanner = new Scanner(System.in);
            int typedByUser, typedWeight;
            String typedName;
            boolean added;
            System.out.println("Let's collect your gift");
            do {
                System.out.println("Available candies in the assortments");
                System.out.println(giftWithCandies.getAssortmentOfSweets().getNamesOfAssortment());
                System.out.println("1. Add candy by name\n2. Add candies by name and weight\n" +
                        "3. Show candies with entered range of sugar\n4. Show me my sorted collected gift");
                System.out.println("- For exit type any letter -");
                typedByUser = scanner.hasNextInt() ? scanner.nextInt() : 0;

                switch (typedByUser) {
                    case 1:
                        System.out.println("Type the name of avaliable candy");
                        typedName = scanner.next();
                        added = giftWithCandies.addCandyByName(typedName);
                        if (added) System.out.println("Done");
                        else System.out.println("Failed");
                        break;
                    case 2:
                        System.out.println("Type the name of the candy and weight");
                        typedName = scanner.next();
                        typedWeight = scanner.hasNextInt() ? scanner.nextInt() : 0;
                        added = giftWithCandies.addCandyByNameAndWeight(typedName, typedWeight);
                        if (added) System.out.println("Done");
                        else System.out.println("Failed");
                        break;
                    case 3:
                        System.out.println("Type the range of sugar");
                        int from = scanner.hasNextInt() ? scanner.nextInt() : 0;
                        int to = scanner.hasNextInt() ? scanner.nextInt() : 0;
                        ArrayList<Candy> listOfFoundCandies = giftWithCandies.findCandyByRangeOfSugar(from, to);
                        if(!listOfFoundCandies.isEmpty()) System.out.println(listOfFoundCandies);
                        else System.out.println("Failed or not found");

                        break;
                    case 4:
                        giftWithCandies.sortByName();
                        System.out.println(giftWithCandies);
                        System.out.println("Total weight = " + giftWithCandies.getTotalWeight());
                        break;
                }
            } while (typedByUser <= 4 && typedByUser > 0);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
