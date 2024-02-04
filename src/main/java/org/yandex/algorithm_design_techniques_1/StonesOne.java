package org.yandex.algorithm_design_techniques_1;

import java.util.Scanner;

/**
 * Описание: Вы играете в игру "Камни": игру для двух игроков с двумя наборами камней по n и m штук.
 * С каждым ходом один игрок может взять один камень (из любого набора) или два камня (по одному из обоих).
 * Когда камень забрали, он выходит из игры. Побеждает игрок, который заберет последний камень. Первый ход за вами.
 * Вы и ваш оппонент играете оптимально.
 * Формат ввода: в первой строке содержится два числа n (1 <= n <= 10), m (1 <= m <= 10) - количество ваших камней и
 * количество камней у вашего оппонента.
 * Формат вывода: в единственной строке выведите Loose, если вы заведомо проиграете, и Win, иначе.
 */
public class StonesOne {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        System.out.println(getLooseOrWin(n, m));
    }

    public static String getLooseOrWin(int n, int m) {
        final String win = "Win";
        final String loose = "Loose";

        if (n % 2 == 0 && m % 2 == 0) {
            return loose;
        }
        return win;
    }
}
