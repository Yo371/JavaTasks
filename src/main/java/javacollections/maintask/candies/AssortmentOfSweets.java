package javacollections.maintask.candies;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class AssortmentOfSweets {
    private Set<Candy> candySet = new HashSet<>();

    public AssortmentOfSweets(Candy ... candies) {
        candySet.addAll(Arrays.asList(candies));
    }

    public AssortmentOfSweets(Collection<Candy> candies) {
            this.addCollectionOfSweets(candies);
    }

    public AssortmentOfSweets() {
    }

    public Set<Candy> getCandySet() {
        return candySet;
    }

    public void setCandySet(Set<Candy> candySet) {
        this.candySet = candySet;
    }

    public void loadAssortmentFromFile(File file) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

        String line;
        String splitLine[];
        Candy candy;
        while ((line = bufferedReader.readLine()) != null){
            splitLine = line.split(" ");
            candy = Candy.getInstanceByName(splitLine[0]);
            if(candy != null){
                candy.setName(splitLine[1]);
                candy.setAmountOfSugar(Integer.parseInt(splitLine[2]));
                candy.setWeight(Integer.parseInt(splitLine[3]));
                candySet.add(candy);
            }
        }
        bufferedReader.close();
    }

    public void addCandy(Candy candy){
        candySet.add(candy);
    }

    public void addCollectionOfSweets(Collection<Candy> candies){
        this.candySet.addAll(candies);
    }

    public void addOtherAssortment(AssortmentOfSweets assortment){
        addCollectionOfSweets(assortment.getCandySet());
    }

    public Candy getCandyByName(String name){
        Set<Candy> candies = candySet.stream().filter(o -> o.getName().toUpperCase().equals(name.toUpperCase()))
                .collect(Collectors.toSet());
        return candies.iterator().hasNext() ? candies.iterator().next() : null;
    }


    public String getNamesOfAssortment(){
        StringBuilder stringBuilder = new StringBuilder();
        candySet.forEach(o -> stringBuilder.append(o.getName() + "|"));
        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        StringBuilder assortmentsStringBuilder = new StringBuilder();
        candySet.forEach(o -> assortmentsStringBuilder.append( o.getName() + " Sugar " + o.getAmountOfSugar() +
                " Weight " + o.getWeight() + "\n"));
        return assortmentsStringBuilder.toString();
    }
}
