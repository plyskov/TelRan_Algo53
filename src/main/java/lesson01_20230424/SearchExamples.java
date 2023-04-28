package lesson01_20230424;

import java.util.Arrays;

public class SearchExamples {
    public static void main(String[] args) {

        int [] ints = new int[]{1, 2, 4, 7, 1, 8, 4, 8};

        int key = 9; // значение, которое ищем

        long start = System.nanoTime();
        int index = searchSequentually(ints, key);
        System.out.println(index);
        long end = System.nanoTime();
        System.out.println("Brute force search time: " + (end - start));

        start = System.nanoTime();
        Arrays.sort(ints);
        System.out.println(Arrays.toString(ints));
        index = binarySearch(ints, key);
        end = System.nanoTime();
        System.out.println(index);
        System.out.println("Binary search time: " + (end - start));

    }

    // Бинарный поиск
    private static int binarySearch(int[] ints, int key) {
        int start = 0;
        int end = ints.length - 1;
        int current = end / 2;

        while (start < end) {
            if (ints[current] == key) return current;
            if (ints[current] > key) end = current - 1;
            if (ints[current] < key) start = current + 1;
            current = start + (end - start) / 2;
        }

        return -1;
    }

    // Поиск перебором
    private static int searchSequentually(int[] ints, int key) {
        for (int i = 0; i < ints.length; i++) {
            if (ints[i] == key) return i;
        }
        return - 1;
    }

}
