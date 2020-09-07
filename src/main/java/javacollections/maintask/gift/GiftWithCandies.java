package javacollections.maintask.gift;

import javacollections.maintask.candies.AssortmentOfSweets;
import javacollections.maintask.candies.Candy;
import javacollections.maintask.comparators.GiftComparatorByName;
import javacollections.maintask.comparators.GiftComparatorBySugar;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

public class GiftWithCandies {
    private ArrayList<Candy> candyArrayList = new ArrayList<>();
    private AssortmentOfSweets assortmentOfSweets;

    public GiftWithCandies(AssortmentOfSweets assortmentOfSweets) {
        this.assortmentOfSweets = assortmentOfSweets;
    }

    public ArrayList<Candy> getCandyArrayList() {
        return candyArrayList;
    }

    public void setCandyArrayList(ArrayList<Candy> candyArrayList) {
        this.candyArrayList = candyArrayList;
    }

    public AssortmentOfSweets getAssortmentOfSweets() {
        return assortmentOfSweets;
    }

    public void setAssortmentOfSweets(AssortmentOfSweets assortmentOfSweets) {
        this.assortmentOfSweets = assortmentOfSweets;
    }


    public boolean addCandyByName(String name){
        if(isCandyExist(name)){
            candyArrayList.add(assortmentOfSweets.getCandyByName(name));
            return true;
        }else {
            return false;
        }
    }
    //в зависимости от веса будет добавлено кол-во конфет
    public boolean addCandyByNameAndWeight(String name, int weight){
        if(isCandyExist(name)){
            Candy candy = assortmentOfSweets.getCandyByName(name);
            if(weight >= candy.getWeight()){
                int amountOfCandies = weight / candy.getWeight();

                for (int i = 0; i < amountOfCandies ; i++)
                    candyArrayList.add(candy);

                return true;
            }else return false;

        }else{
            return false;
        }
    }

    public boolean addCandyByNameAndAmount(String name, int amount){
        if(isCandyExist(name) && amount > 0){
            Candy candy = assortmentOfSweets.getCandyByName(name);
            for (int i = 0; i < amount ; i++)
                candyArrayList.add(candy);

            return true;
        }else{
            return false;
        }
    }

    public ArrayList<Candy> findCandyByRangeOfSugar(int from, int to){
        ArrayList <Candy> suitableCandies = new ArrayList<>();
        if(from < to){
            suitableCandies = (ArrayList<Candy>) candyArrayList.stream()
                    .filter(o -> o.getAmountOfSugar() >= from && o.getAmountOfSugar() <= to)
                    .collect(Collectors.toList());
        }
        return suitableCandies;
    }

    public int getTotalWeight(){
        int totalWeight = 0;
        for(Candy candy : candyArrayList){
            totalWeight += candy.getWeight();
        }
        return totalWeight;
    }

    public void sortByName(){
        Collections.sort(candyArrayList, new GiftComparatorByName());
    }

    public void sortBySugar(){
        Collections.sort(candyArrayList, new GiftComparatorBySugar());
    }

    public void sortByWeight(){
        Collections.sort(candyArrayList, (o1, o2) -> o1.getWeight() - o2.getWeight());
    }

    private boolean isCandyExist(String name){
        if(assortmentOfSweets.getCandyByName(name) == null)
            return false;
        else
            return true;
    }



    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for(Candy candy : candyArrayList){
            stringBuilder.append(candy + "\n");
        }

        return stringBuilder.toString();
    }
}
