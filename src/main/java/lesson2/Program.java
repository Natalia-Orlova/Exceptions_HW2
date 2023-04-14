package lesson2;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Program {

    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {
        //showFloatNumber(); // task1
        task2();

    }

    /**
     * Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float), и возвращает
     * введенное значение. Ввод текста вместо числа не должен приводить к падению приложения, вместо этого,
     * необходимо повторно запросить у пользователя ввод данных.
     */

    static void showFloatNumber () {
        while(true) {
            System.out.println("Введите дробное число: ");
            if (scanner.hasNextFloat()) {
                System.out.println(scanner.nextFloat());
                break;
            } else {
                System.out.println("Введено некорректное значение, потворите попытку.");
                scanner.nextLine();
            }
        }
    }

    /**
     * Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку.
     * Пользователю должно показаться сообщение, что пустые строки вводить нельзя.
     */

    static void task2() {
        try{
            isStringEmpty();
        }
        catch (IllegalArgumentException e){
            System.out.printf("Ошибка. %s", e.getMessage());
        }
    }
    static void isStringEmpty() {
        System.out.println("Введите строку: ");
        String string = scanner.nextLine();
        if (string.trim().isEmpty()) {
            throw new IllegalArgumentException("Пустые строки вводить нельзя!");
        } else {
            System.out.println(string);
        }
    }

}

