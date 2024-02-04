package org.yandex.algorithm_design_techniques_1;

import java.util.Scanner;

/**
 * Описание: Выведите число перестановок C(n, k).
 * Формат ввода: В первой строке находится два числа n (1 <= n <= 7), k (1 <= n <= 7).
 * Формат вывода: Выведите ответ на задачу.
 */
public class Combination {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] nums = input.nextLine().split(" ");
        int n = Integer.parseInt(nums[0]);
        int k = Integer.parseInt(nums[1]);

        System.out.println(combinations(n, k));
    }

    public static int combinations(int n, int k) {
        return factorial(n) / (factorial(n - k) * factorial(k));
    }

    public static int factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        int result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
