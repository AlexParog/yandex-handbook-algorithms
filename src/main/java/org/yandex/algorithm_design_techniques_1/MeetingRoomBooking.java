package org.yandex.algorithm_design_techniques_1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Описание: задано n интервалов. Требуется найти максимальное количество взаимно непересекающихся интервалов.
 * Два интервала пересекаются, если они имеют хотя бы одну общую точку.
 * Формат ввода: в первой строке задано одно число n (1 <= n <= 100) - количество интервалов.
 * В следующих n строках заданы интервалы li, ri (1 <= li <= ri <= 50)
 * Формат вывода: выведите ответ на задачу
 */
public class MeetingRoomBooking {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numSegments = Integer.parseInt(input.nextLine());
        int nonOverlappingCount = 0;

        Segment[] segments = new Segment[numSegments];
        for (int i = 0; i < numSegments; i++) {
            String[] segmentInfo = input.nextLine().split(" ");
            int left = Integer.parseInt(segmentInfo[0]);
            int right = Integer.parseInt(segmentInfo[1]);

            segments[i] = new Segment(left, right);
        }

        Arrays.sort(segments, Comparator.comparingInt(Segment::getRight));

        int currentRight = Integer.MIN_VALUE;
        for (Segment segment : segments) {
            if (segment.getLeft() > currentRight) {
                currentRight = segment.getRight();
                nonOverlappingCount++;
            }
        }
        System.out.println(nonOverlappingCount);
    }
}

class Segment {
    private int left;
    private int right;

    public Segment(int left, int right) {
        this.left = left;
        this.right = right;
    }

    public int getRight() {
        return right;
    }

    public int getLeft() {
        return left;
    }
}
