package lesson02_20230508;

public class FibonacciSequence {

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

        // Оптимизируем Фибоначчи - будем хранить результаты промежуьлчных вычислений,
        // чтобы не вычислять дважды
        // (принцип мемоизации)
        System.out.println(fibonacciMemo(9));

        // Сравним время
        int n = 70;

//        long start = System.nanoTime();
//        long result = fibonacci(n);
//        long end = System.nanoTime();
//        System.out.println("Time: " + (end - start) + "; result = " + result);

        long start = System.nanoTime();
        long result = fibonacciMemo(n);
        long end = System.nanoTime();
        System.out.println("Time: " + (end - start) + "; result Memo = " + result);

        start = System.nanoTime();
        result = fibonacciTabulation(n);
        end = System.nanoTime();
        System.out.println("Time: " + (end - start) + "; result Tab = " + result);

        System.out.println(sequence(0));
        System.out.println(sequence(1));
        System.out.println(sequence(2));
        System.out.println(sequence(3));
        System.out.println(sequence(4));
        System.out.println(sequence(5));
        System.out.println(sequence(6));
        System.out.println(sequence(7));
        System.out.println(sequence(8));
        System.out.println(sequence(9));

        System.out.println(sequence(100));
        System.out.println(sequence(124));
    }

    public static long fibonacci(long i) {
        if (i == 0) return 0;
        if (i == 1) return 1;
        return fibonacci(i - 1) + fibonacci(i - 2); // O(2^n) - очень высокая сложность
    }

    public static long fibonacciMemo(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        long [] values = new long[n + 1];
        values[0] = 0;
        values[1] = 1;

        return fibonacciMemoRecurcion(values, n);
    }

    private static long fibonacciMemoRecurcion(long[] values, int current) {

        if (current == 0) return 0;
        if (current == 1) return 1;

        long result;

        if (values[current] == 0) {
            values[current] = fibonacciMemoRecurcion(values, current - 2)
                    + fibonacciMemoRecurcion(values, current - 1);
        }
        result = values[current];
        return result;

    }

    // Табуляция - дин программирование снизу вверх
    private static long fibonacciTabulation(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        long a = 0; // 0-е значение
        long b = 1; // 1-е значение
        long c = a + b;

        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

    /* 1. Вычислить n-й член последовательности, заданной формулами:
        a(2n) = a(n) + a(n-1),
        a(2n+1) = a(n) — a(n-1),
        a(0) = a(1) = 1.
     */
    public static int sequence(int n) {

        // base cases
        if (n == 0) return 1;
        if (n == 1) return 1;

        int prevN = n / 2;

        if (n % 2 == 0) {
            return sequence(prevN) + sequence(prevN - 1);
        } else {
            return sequence(prevN) - sequence(prevN - 1);
        }
    }

}
