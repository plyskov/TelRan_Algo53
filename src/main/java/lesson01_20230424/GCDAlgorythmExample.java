package lesson01_20230424;

public class GCDAlgorythmExample {

    public static void main(String[] args) {

        int a = 12_000_003;
        int b = 129;
        //long start = System.nanoTime();
        long start = System.currentTimeMillis();
        greatestCommonDeliver(a, b);
        //long end = System.nanoTime();
        long end = System.currentTimeMillis();
        System.out.println("Euclidean algorithm = " + (end - start));

        start = System.currentTimeMillis();
        bruteForceAlgorithm(a, b);
        end = System.currentTimeMillis();
        System.out.println("Brute force algorithm = " + (end - start));
        // Здесь брутфорс оказался быстрее. Вероятнее всего, в алгоритме Евклида много времени тратится на присвоение

    }

    public static void greatestCommonDeliver(int a, int b) {
        while (b != 0) {
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        System.out.println("gcd = " + a);
    }

    public static void bruteForceAlgorithm(int a, int b) {
        for (int i = Math.min(a, b); i > 0; i--) {
            if (a % i == 0 && b % i == 0) {
                System.out.println("gcd = " + i);
                break;
            }
        }
    }

}
