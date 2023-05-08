package lesson01_20230424;

public class GCDAlgorythmExample {

    public static void main(String[] args) {

        int a = 12_000_003;
        int b = 129_003;
        int gcd;
        //long start = System.nanoTime();
        long start = System.nanoTime();
        gcd = greatestCommonDeliver(a, b);
        //long end = System.nanoTime();
        long end = System.nanoTime();
        System.out.println("gcd = " + gcd);
        System.out.println("Euclidean algorithm = " + (end - start));

        start = System.nanoTime();
        gcd = bruteForceAlgorithm(a, b);
        end = System.nanoTime();
        System.out.println("gcd = " + gcd);
        System.out.println("Brute force algorithm = " + (end - start));
        // Здесь брутфорс оказался быстрее. Вероятнее всего, в алгоритме Евклида много времени тратится на присвоение

    }

    public static int greatestCommonDeliver(int a, int b) {
        while (b != 0) {
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
        //System.out.println("gcd = " + a);
    }

    public static int bruteForceAlgorithm(int a, int b) {
        for (int i = Math.min(a, b); i > 0; i--) {
            if (a % i == 0 && b % i == 0) {
                //System.out.println("gcd = " + i);
                return i;
            }
        }
        return 0;
    }

}
