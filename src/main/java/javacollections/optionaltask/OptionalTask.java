package javacollections.optionaltask;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class OptionalTask {
    public static void main(String[] args) {

        //1.   Ввести строки из файла, записать в список. Вывести строки в файл в обратном порядке.
        File file = new File("src\\main\\java\\javacollections\\data\\lines.txt");

        try {
            ArrayList<String> listOfLInes = getListOfLinesFromFile(file);
            System.out.println("original lines from file");
            System.out.println(listOfLInes);
            writeListToFileInReversedOrder(file, listOfLInes);
            listOfLInes = getListOfLinesFromFile(file);
            System.out.println("Writed in file and reversed");
            System.out.println(listOfLInes);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //4.   Занести стихотворение в список. Провести сортировку по возрастанию длин строк.

        ArrayList<String> linesOfPoem = new ArrayList<>();
        linesOfPoem.add("Someone would probably get hurt");
        linesOfPoem.add("Get buried in the dirt");
        linesOfPoem.add("Tiny little secrets");
        linesOfPoem.add("And if they were dug up");
        Collections.sort(linesOfPoem, (o1, o2) -> o1.length() - o2.length());

        //5. Не используя вспомогательных объектов,
        // переставить отрицательные элементы данного списка в конец, а положительные — в начало списка.
        ArrayList<Integer> listOfNumbers = new ArrayList<>();
        listOfNumbers.add(-1);
        listOfNumbers.add(-3);
        listOfNumbers.add(5);
        listOfNumbers.add(2);
        listOfNumbers.add(-9);

        for (int i = 0, count = 0; count < listOfNumbers.size(); i++, count++) {
            if(listOfNumbers.get(i) < 0){
                listOfNumbers.add(listOfNumbers.size() - 1, listOfNumbers.remove(i));
                i--;
            }
        }
        System.out.println(listOfNumbers);


    }


    public static ArrayList<String> getListOfLinesFromFile(File file) throws IOException {
        ArrayList<String> listOfLines = new ArrayList<>();
        String line;

        BufferedReader bf = new BufferedReader(new FileReader(file));
        while ((line = bf.readLine()) != null){
            listOfLines.add(line);
        }
        bf.close();
        return listOfLines;
    }

    public static void writeListToFileInReversedOrder(File file, ArrayList<String> arrayList) throws IOException {
        FileWriter fileWriter = new FileWriter(file);

        for (int i = 0; i < arrayList.size(); i++) {
            fileWriter.write(arrayList.get(arrayList.size() - 1 - i) + "\n");
        }
        fileWriter.close();
    }

}
