package lesson01_20230424;

import java.util.Arrays;
import java.util.Random;

public class SortExamples {

    public static void main(String[] args) {
        //int [] ints = new int[]{1, 4, 5, 1, 2, 4, 7, 0, 2, 3};
        int [] ints = new int[100_000];

        Random random = new Random();
        for (int i = 0; i < ints.length; i++) {
            ints[i] = random.nextInt(100);
        }

        long start = System.nanoTime();
        sortBruteForce(ints);  // O(n^2)
        long end = System.nanoTime();
        System.out.println("Tme brute force time elapsed: " + (end - start));

        // На малом числе элементов брутфорс быстрее, если число элементов массива расчет -
        // стандартный алгоритм начинает выигрывать.
        // Здесь 100 элементов брутфорс быстрее, а на 1000 элеменов уже быстрее стандартный алгоритм

        for (int i = 0; i < ints.length; i++) {
            ints[i] = random.nextInt(100);
        }

        //System.out.println(Arrays.toString(ints));

        start = System.nanoTime();
        Arrays.sort(ints);
        end = System.nanoTime();
        System.out.println("The standard elapsed: " + (end - start));

    }

    private static void sortBruteForce(int[] ints) {
        for (int i = 0; i < ints.length; i++) {

            for (int j = i + 1; j < ints.length; j++) {
                if (ints[i] > ints[j]) {
                    int tmp = ints[i];
                    ints[i] = ints[j];
                    ints[j] = tmp;
                }
            }
        }
    }

}
