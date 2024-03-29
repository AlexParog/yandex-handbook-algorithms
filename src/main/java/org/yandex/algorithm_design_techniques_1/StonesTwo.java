package org.yandex.algorithm_design_techniques_1;

import java.util.Scanner;

/**
 * Описание: Вы играете в игру "Камни": игру для двух игроков с двумя наборами камней по n и m штук.
 * С каждым ходом один игрок может забрать следующие комбинации камней:
 * 1. Взять один камень из любого набора;
 * 2. Взять два камня из какого-то одного набора;
 * 3. Взять два камня из одного и один из другого.
 * Когда камень забрали, он выходит из игры. Побеждает игрок, который заберет последний камень. Первый ход за вами.
 * Вы и ваш оппонент играете оптимально.
 * Формат ввода: в первой строке содержится два числа n (1 <= n <= 1000), m (1 <= m <= 1000) - количество ваших камней и
 * количество камней у вашего оппонента.
 * Формат вывода: в единственной строке выведите Loose, если вы заведомо проиграете, и Win, иначе.
 */

// TODO: в данном коде есть ошибка
public class StonesTwo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.close();

        if (canWin(n, m)) {
            System.out.println("Win");
        } else {
            System.out.println("Loose");
        }
    }

    // Метод определяет, сможет ли игрок, делающий ход, выиграть при заданном распределении камней
    private static boolean canWin(int n, int m) {
        // Базовые случаи
        if (n == 0 && m == 0) {
            return false; // Нет ходов осталось - проигрыш
        }
        if (n == 1 && m == 0 || n == 0 && m == 1) {
            return true; // Последний камень можно взять - выигрыш
        }
        if (n == m) {
            return false; // Зеркальные ходы оппонента приведут к проигрышу
        }

        // Попробовать различные ходы и проверить, есть ли выигрышный среди них
        return !canWin(n - 1, m) || // Взять один камень из первого набора
                !canWin(n, m - 1) || // Взять один камень из второго набора
                n > 1 && !canWin(n - 2, m) || // Взять два камня из первого набора
                m > 1 && !canWin(n, m - 2) || // Взять два камня из второго набора
                n > 0 && m > 0 && !canWin(n - 1, m - 2) || // Взять один камень из первого и два из второго набора
                n > 0 && m > 0 && !canWin(n - 2, m - 1);   // Взять два камня из первого и один из второго набора
    }
}
