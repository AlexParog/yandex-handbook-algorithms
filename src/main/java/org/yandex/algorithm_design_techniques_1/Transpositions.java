package org.yandex.algorithm_design_techniques_1;

import java.util.Scanner;

/**
 * Описание: Выведите число перестановок P(n).
 * Формат ввода: В первой строке находится одно число n (1 <= n <= 7).
 * Формат вывода: Выведите ответ на задачу.
 */
public class Transpositions {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        if (n >= 1 && n <= 7) {
            System.out.println(getFactorial(n));
        }
    }

    public static long getFactorial(int n) {
        if (n <= 2) {
            return n;
        }
        return n * getFactorial(n - 1);
    }
}
