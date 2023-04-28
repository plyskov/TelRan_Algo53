package lesson01_20230424;

public class RecursiveAlgsExample {
    public static void main(String[] args) {

        //f(5);
        //System.out.println(sumNumbers(4));

        //f1(10);

        // Последовательность Фибоначчи: каждое следующее - сумма 2 предыдущих
        // 0 1 1 2 3 5 8 13 21
        // fibonacci(n) - написать ф-цию, выдающую n-ый член последовательности
        // fibonacci(1) = 0
        // fibonacci(2) = 1
        // fibonacci(3) = 1
        // fibonacci(4) = 2
        System.out.println(fibonacci(9));

    }

    private static int fibonacci(int i) {
        if (i == 1) return 0;
        if (i == 2) return 1;
        return fibonacci(i - 1) + fibonacci(i - 2); // O(2^n) - очень высокая сложность
    }


    private static void f1(int n) {
        System.out.println(n);
        f2(n);
    }

    private static void f2(int n) {
        n++;
        if (n > 20) return; // base condition
        f1(n);
    }

    public static void f(int i) {
        System.out.println(i++);
        if (i > 100) return; // base condition - условие выхода из рекурсии
        f(i);
    }

    private static int sumNumbers(int i) {
        if (i == 1) return 1;
        int result = i + sumNumbers(i - 1);
        return result;
    }

}
