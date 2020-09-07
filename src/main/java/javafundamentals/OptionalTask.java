package javafundamentals;

import java.util.*;

public class OptionalTask {
    public static void main(String[] args) {


        //int[] array = new int[]{212, 46554, 4567, 1661, 4666444, 22};
        System.out.println("How numbers in array do you want to have?");
        Scanner scanner = new Scanner(System.in);
        int[] array;
        try{
            int n = scanner.nextInt();
            array = new int[n];
            System.out.println("Type the numbers");
            for (int i = 0; i < n; i++) {
                array[i] = scanner.nextInt();
            }
        }catch (InputMismatchException e){
            array = null;
            System.out.println("Invalid typed number");
        }

        if(array != null){
            //1. Найти самое короткое и самое длинное число. Вывести найденные числа и их длину.
            printTheLongestNumber(array);
            printTheSmallestNumber(array);

            //2.   Вывести числа в порядке возрастания (убывания) значений их длины.
            printInAscendingOrder(array);
            printInDescendingOrder(array);


            //3. Вывести на консоль те числа, длина которых меньше (больше) средней длины по всем числам, а также длину.
            printNumbersWithSmallerAverageLength(array);
            printNumbersWithBiggerAverageLength(array);

            //5. Найти количество чисел, содержащих только четные цифры,
            // а среди оставшихся — количество чисел с равным числом четных и нечетных цифр.
            printNumbersContainsOnlyEven(array);
            printNumbersContainsEquals(array);

            //6. Найти число, цифры в котором идут в строгом порядке возрастания.
            // Если таких чисел несколько, найти первое из них.
            printFirstNumberContainsAscdendingOrder(array);
        }

    }

    public static int getLengthOfNumber(int number) {
        int count = (number == 0) ? 1 : 0;
        while (number != 0) {
            count++;
            number /= 10;
        }
        return count;
    }

    public static void printTheSmallestNumber(int[] array){
        int minLength = getLengthOfNumber(array[0]);
        int smallestNumber = array[0];

        for (int i = 0; i < array.length; i++) {
            if(getLengthOfNumber(array[i]) < minLength){
                minLength = getLengthOfNumber(array[i]);
                smallestNumber = array[i];
            }
        }
        System.out.println("The smallest number = " + smallestNumber + "(length = " + minLength + ")");
    }

    public static void printTheLongestNumber(int[] array){
        int maxLength = 0;
        int longestNumber = array[0];

        for (int i = 0; i < array.length; i++) {
            if(getLengthOfNumber(array[i]) > maxLength){
                maxLength = getLengthOfNumber(array[i]);
                longestNumber = array[i];
            }
        }
        System.out.println("The longest number = " + longestNumber + "(length = " + maxLength + ")");
    }

    public static void printInAscendingOrder(int[] array){
        int tempNumber;
        for(int j = 0; j < array.length - 1; j++) {
            for(int i = 0; i < array.length - 1 - j; i++) {
                if(getLengthOfNumber(array[i]) > getLengthOfNumber(array[i+1])) {
                    tempNumber = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = tempNumber;
                }
            }
        }
        Arrays.stream(array).forEach(System.out::println);
    }

    public static void printInDescendingOrder(int[] array){
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int number : array)
            arrayList.add(number);

        Collections.sort(arrayList, (o1, o2) -> getLengthOfNumber(o1) < getLengthOfNumber(o2)? 1:
                getLengthOfNumber(o1) > getLengthOfNumber(o2)? -1 : 0);

        System.out.println(arrayList);
    }

    public static double getAverageLength(int[] array){
        double average = 0;

        for (int number : array)
            average += getLengthOfNumber(number);

        return Math.round(average / array.length);
    }

    public static void printNumbersWithBiggerAverageLength(int[] array){
        double average = getAverageLength(array);
        System.out.println("Average length " + average);
        System.out.println("Numbers longer than average");
        for(int num : array) {
            if(getLengthOfNumber(num) > average)
                System.out.println(num);
        }
    }
    public static void printNumbersWithSmallerAverageLength(int[] array){
        double average = getAverageLength(array);
        System.out.println("Average length " + average);
        System.out.println("Numbers whose length is less than average");
        for(int num : array) {
            if(getLengthOfNumber(num) < average)
                System.out.println(num);
        }
    }

    public static void printNumbersContainsOnlyEven(int[] array){
        boolean isEven = true;
        int temp, countEven = 0;
        System.out.print("Contains only even numbers = ");

        for (int number : array) {
            temp = number;
            while(number != 0){
                if(number % 10 % 2 != 0){
                    isEven = false;
                    break;
                }
                number /= 10;
            }
            if(isEven){
                System.out.print(temp + ", ");
                countEven ++;
            }
            isEven = true;
        }
        System.out.println("total of these numbers = " + countEven);
    }

    public static void printNumbersContainsEquals(int[] array){
        System.out.print("Contains equal numbers of odds and evens = ");
        int temp;
        int countOdd = 0, total = 0, countEven = 0;
        for (int number : array) {
            temp = number;
            while(number != 0){
                if(number % 10 % 2 != 0)
                    countOdd++;
                else
                    countEven++;

                number /= 10;
            }
            if(countEven == countOdd) {
                System.out.print(temp + ", ");
                total++;
            }
            countEven = countOdd = 0;
        }
        System.out.println("total of these numbers = " + total);
    }

    public static void printFirstNumberContainsAscdendingOrder(int[] array){
        for(int number : array){
            if(ascendingCheck(number)){
                System.out.println("Number in ascending order = " + number);
                break;
            }
        }
    }

    public static boolean ascendingCheck(int num){
        if(num == 0) return false;
        int numbers[] = new int[getLengthOfNumber(num)];
        int index = 0;
        while(num != 0){
            numbers[index++] = num % 10;
            num /= 10;
        }

        for (int i = 0; i < numbers.length - 1; i++) {
            if(!(numbers[i] > numbers[i + 1]))
                return false;
        }
        return true;
    }
}
