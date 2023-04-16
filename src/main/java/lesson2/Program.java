package lesson2;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Program {

    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {
        //showFloatNumber(); // task1
        //task2();
        for (int i = 0; i < 10; i++){
            System.out.printf("\n *** Итерация %d *** \n\n", i + 1);

            task3();
        }
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


    /**
     *  Если необходимо, исправьте данный код
     *
     *  try {
     *    int d = 0;
     *    double catchedRes1 = intArray[8] / d;
     *    System.out.println("catchedRes1 = " + catchedRes1);
     * } catch (ArithmeticException e) {
     *    System.out.println("Catching exception: " + e);
     * }
     *
     */
    static void task3(){
        try {
            divideArrayElem(generateArray());
        }

        catch (ArrayIndexOutOfBoundsException | ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }

    static void divideArrayElem(int[] intArray) {
        if (intArray == null) { // если массив пуст
            throw new NullPointerException("Массив должен быть заполнен");
        }
        int d = random.nextInt(10); // сделали делитель рандомным
        int i = random.nextInt(10); // индекс массива также задаем рандомно
        System.out.printf("Делитель: %d\nИндекс делимого: %d\n", d, i);
        if (d == 0) { // если делитель равен нулю
            throw new ArithmeticException("Делить на ноль нельзя!");
        }
        if (i >= intArray.length) { // если индекс превышает размер массива
            throw new ArrayIndexOutOfBoundsException("Индекс массива не должен превышать размер массива");
        }
        else {
            double catchedRes1 = (double) intArray[i] / d;
            System.out.printf("%d / %d = %f\n", intArray[i], d, catchedRes1);
        }
    }

    /**
     * Метод генерации целочисленного массива
     * @return Одномерный массив
     */
    static int[] generateArray () {
        int [] array = new int[random.nextInt(1,10)];
            System.out.print("Массив целых чисел: ");
            for (int i = 0; i < array.length; i++) {
                array[i] = random.nextInt(-10, 10);
                System.out.printf("%d ", array[i]);
            }
        System.out.println();
        return array;
    }


}

