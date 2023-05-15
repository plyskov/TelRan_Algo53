package lesson02_20230508.homework;

/*
На вершине лесенки, содержащей N ступенек, находится мячик, который начинает прыгать по ним вниз, к основанию.
Мячик может прыгнуть на следующую ступеньку, на ступеньку через одну или через 2.
(То есть, если мячик лежит на 8-ой ступеньке, то он может переместиться на 5-ую, 6-ую или 7-ую.)
Определить число всевозможных «маршрутов» мячика с вершины на землю.
 */
public class Ladder {
    public static void main(String[] args) {

        System.out.println(ladderRecurcive(10));

    }

    public static int ladderRecurcive(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (n == 3) return 4;

        return ladderRecurcive(n - 1) + ladderRecurcive(n - 2) + ladderRecurcive(n - 3);
    }

    // todo Оптимизировать с помощью DP - поменять решение на цикл и 3 переменные

}
