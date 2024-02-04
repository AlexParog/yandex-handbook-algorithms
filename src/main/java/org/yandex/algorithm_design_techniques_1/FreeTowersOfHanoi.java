package org.yandex.algorithm_design_techniques_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Описание: Головоломка <<Ханойские башни>> состоит из трёх стержней, пронумеруем их слева направо: 1, 2 и 3.
 * Также в головоломке используется стопка дисков с отверстием посередине. Радиус дисков уменьшается снизу вверх.
 * Изначально диски расположены на левом стержне (стержень 1), самый большой диск находится внизу. Диски в игре
 * перемещаются по одному со стержня на стержень. Диск можно надеть на стержень, только если он пустой или верхний диск
 * на нём большего размера, чем перемещаемый. Цель головоломки — перенести все диски со стержня 1 на стержень 3.
 * Требуется найти последовательность ходов, которая решает головоломку <<Ханойские башни>>.
 * <p>
 * Формат ввода: В первой строке находится одно число n (3 <= n <= 10) - количество дисков на первой башне.
 * <p>
 * Формат вывода: в первой строке количество операций k, в следующих по два числа: перемещение с x стержня на y стержень.
 */

public class FreeTowersOfHanoi {

    /**
     * Операции перемещения
     */
    public static List<String> operations = new ArrayList<>();

    /**
     * Старт
     */
    private static final int STARTING_ROD = 1;

    /**
     * Конец
     */
    private static final int ENDING_ROD = 3;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int discs = scanner.nextInt();
        scanner.close();

        if (discs >= 3 && discs <= 10) {
            recursionOfTheHanoiTowers(discs, STARTING_ROD, ENDING_ROD);
        }

        // количество операций
        System.out.println(operations.size());
        // операции
        for (String operation : operations) {
            System.out.println(operation);
        }
    }

    /**
     * Рекурсивный метод для решения задачи "Ханойские башни".
     *
     * @param discs   количество дисков
     * @param fromPeg начальный стержень
     * @param toPeg   конечный стержень
     */
    public static void recursionOfTheHanoiTowers(int discs, int fromPeg, int toPeg) {
        int unusedPeg = findUnusedPeg(fromPeg, toPeg);

        if (discs == 1) {
            operations.add(fromPeg + " " + toPeg);
            return;
        }

        // Передвигаем все диски, кроме нижнего, на неиспользуемый стержень
        recursionOfTheHanoiTowers(discs - 1, fromPeg, unusedPeg);
        operations.add(fromPeg + " " + toPeg);
        // Передвигаем диски, которые мы поместили на временный (неиспользуемый) стержень,
        // на целевой стержень
        recursionOfTheHanoiTowers(discs - 1, unusedPeg, toPeg);
    }

    /**
     * Метод для поиска неиспользуемого стержня.
     *
     * @param fromPeg начальный стержень
     * @param toPeg   конечный стержень
     * @return неиспользуемый стержень
     */
    private static int findUnusedPeg(int fromPeg, int toPeg) {
        for (int peg = 1; peg <= 3; peg++) {
            if (peg != fromPeg && peg != toPeg) {
                return peg;
            }
        }
        return -1; // В случае ошибки
    }
}

