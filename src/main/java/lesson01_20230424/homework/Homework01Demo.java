package lesson01_20230424.homework;

import java.util.Arrays;

public class Homework01Demo {
    public static void main(String[] args) {

        // 1. Рекурсивный факториал - тесты.
        System.out.println("5! = " + factorial(5L));
        System.out.println("0! = " + factorial(0L));
        System.out.println("1! = " + factorial(1L));
        System.out.println("20! = " + factorial(20L));
        System.out.println("21! = " + factorial(21L)); // Странный результат - отрицательный. Переполнение для long?
        //System.out.println("0! = " + factorial(-3)); // Тест исключения

        // 2. Поиск непарного числа в отсортированном массиве - тесты
        int [] nums = {-100, -100, -1, -1, 0, 0, 5, 7, 7, 8, 8};
        System.out.println(
                Arrays.toString(nums) + ": " + findSingleNumber(nums)
        );

        nums = new int []{0, 0, 1, 1, 2, 2, 3, 3, 11};
        System.out.println(
                Arrays.toString(nums) + ": " + findSingleNumber(nums)
        );

        nums = new int []{0, 1, 1};
        System.out.println(
                Arrays.toString(nums) + ": " + findSingleNumber(nums)
        );

        nums = new int []{3, 3, 9000};
        System.out.println(
                Arrays.toString(nums) + ": " + findSingleNumber(nums)
        );

        nums = new int[]{100500};
        System.out.println(
                Arrays.toString(nums) + ": " + findSingleNumber(nums)
        );

        nums = new int []{0, 0, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6};
        System.out.println(
                Arrays.toString(nums) + ": " + findSingleNumber(nums)
        );

        nums = new int []{0, 0, 1, 1, 2, 2, 3, 3, 4, 5, 5, 6, 6};
        System.out.println(
                Arrays.toString(nums) + ": " + findSingleNumber(nums)
        );

    }

    /*
    1. Написать рекурсивную функцию вычисления факториала factorial(n) -
    произведения всех чисел до n включительно
     */
    public static long factorial(long n) {
        if (n < 0)
            throw new RuntimeException("Wrong argument for 'factorial': method requires a positive number");

        if (n == 0)
            return 1L;
        return n * factorial(n - 1);
    }

    /*
    2. Дан отсортированный массив, в котором все элементы встречаются дважды (один за другим),
    а один элемент появляется только один раз.
    Найдите этот элемент. Определите асимптотическую сложность алгоритма.
     */
    public static int findSingleNumber(int [] pairs) {
        if (pairs.length < 3)
            return pairs[0]; // - заведомо непарный

        int start = 0;
        int end = pairs.length - 1;
        int current = end / 2;
        current = current + (1 - current % 2); // всегда отсекаем слева четное количество элементов

        while ((end - start) > 2) {  // СЛОЖНОСТЬ: O(log(n))

            if (pairs[current] != pairs[current - 1]) end = current - 1;   // Одиночное число - в первой половине
            if (pairs[current] == pairs[current - 1]) start = current + 1; // Одиночное число - во второй половине
            current = start + (end - start) / 2;
            current = current + (1 - current % 2); // всегда отсекаем слева четное количество элементов

        }

        // Получили позиции 3 значений, из которых одно непарное
        if ((pairs[start]) == pairs[current]) return pairs[end]; // кейс [x, x, y]
        return pairs[start];                                     // кейс [x, y, y]
    }
}
