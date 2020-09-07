package javafundamentals;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainTask {
    public static void main(String[] args) {
        //1. Поприветствовать пользователя введенного через командную строку
        greetFromCommandLine(args);

        //2. Вывести аргументы командной строки в обратном порядке
        printArgsInReverseOrder(args);

        //3. Вывести заданное кол-во чисел с переходом и без перехода на новую строку
        printRandomNumbers(5);
        printRandomNumbersInLine(3);


        //4. Ввести целые числа как аргументы командной строки, подсчитать их сумму (произведение)
        // и вывести результат на консоль.
        System.out.println("\nsum = " + sum(args) + ", multiplied = " + multiply(args));

        //5.  Ввести число от 1 до 12. Вывести на консоль название месяца,
        // соответствующего данному числу. Осуществить проверку корректности ввода чисел.
        System.out.println("\nEnter number > 0 and < 13");
        String monthString = new Scanner(System.in).next();
        try{
            int month = Integer.parseInt(monthString);
            printMonthByNumber(month);
        }catch (NumberFormatException e){
            System.out.println("Typed data is not a number");
        }


    }

    public static void greetFromCommandLine(String ... args){
        if (args.length != 0)
            System.out.println( "Welcome " + args[0] + " !!!" );
    }

    public static void printArgsInReverseOrder(String ... args){
        for (int i = 0; i < args.length; i++)
            System.out.println(args[args.length - 1 - i]);
    }

    public static void printRandomNumbers(int amount){
        int[] numbersArray = new int[amount];
        for (int i = 0; i < amount; i++) {
            numbersArray[i] = (int)(Math.random() * 30) + 10;
            System.out.println(numbersArray[i]);
        }

    }

    public static void printRandomNumbersInLine(int amount){
        int[] numbersArray = new int[amount];
        for (int i = 0; i < amount; i++) {
            numbersArray[i] = (int)(Math.random() * 30) + 10;
            System.out.print(numbersArray[i] + " ");
        }
    }

    public static int sum(String ... args){
        if(args.length > 0){
            try{
                int sum = 0;
                for (String arg : args)
                    sum += Integer.parseInt(arg);
                return sum;
            }catch (NumberFormatException e){
                System.out.println("\nargs are not the numbers");
                return 0;
            }
        }else return 0;
    }

    public static int multiply(String ... args){
        if(args.length > 0){
            try {
                int multiplied = 1;
                for (int i = 0; i < args.length; i++)
                    multiplied *= Integer.parseInt(args[i]);
                return multiplied;
            }catch (NumberFormatException e){
                System.out.println("args are not the numbers");
                return 0;
            }
        }else return 0;
    }

    public static void printMonthByNumber(int month){
        if(month > 0 && month < 13){
            switch (month){
                case 1: System.out.println("January");
                    break;
                case 2: System.out.println("February");
                    break;
                case 3: System.out.println("March");
                    break;
                case 4: System.out.println("April");
                    break;
                case 5: System.out.println("May");
                    break;
                case 6: System.out.println("June");
                    break;
                case 7: System.out.println("July");
                    break;
                case 8: System.out.println("August");
                    break;
                case 9: System.out.println("September");
                    break;
                case 10: System.out.println("October");
                    break;
                case 11: System.out.println("November");
                    break;
                case 12: System.out.println("December");
                    break;
            }
        }else
            System.out.println("Invalid number");
    }
}
