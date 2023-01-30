package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add(rand.nextInt(100));
        }
        System.out.println(list);
        System.out.println();
        task1(list);
        task2(list);
        System.out.println();
        System.out.println("Сортировка слиянием");
        int[] arr = new int[] {40, 20, 98, 29, 47, 18, 95, 57, 76, 71, 75, 52, 21, 7, 91, 7, 60, 84, 41, 13};
        arr = mergeSort(arr);
        System.out.println(Arrays.toString(arr));

    }

    static void task1(List<Integer> list) {
        /*Пусть дан произвольный список целых чисел, удалить из него четные числа*/

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % 2 == 0) {
                list.remove(i);
                i--;
            }
        }
        System.out.println(list + " -> Только нечетные элементы");
    }
    static void task2(List<Integer> list) {
        /*Задан целочисленный список ArrayList. Найти минимальное,
         максимальное и среднее арифметическое из этого списка.*/

        System.out.println("Максимальное -> "+ Collections.max(list));
        System.out.println("Минимальное -> "+ Collections.min(list));
        double sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum = sum + list.get(i);
        }
        sum = sum / list.size();
        System.out.println("Среднее арифметическое -> "+ sum);
    }

    static int[] mergeSort(int[] arr) {
        /*Реализовать алгоритм сортировки слиянием*/
        int[] tmp;
        int[] currentSrc = arr;
        int[] currentRes = new int[arr.length];

        int size = 1;
        while (size < arr.length) {
            for (int i = 0; i < arr.length; i += 2 * size) {
                merge(currentSrc, i, currentSrc, i + size, currentRes, i, size);
            }

            tmp = currentSrc;
            currentSrc = currentRes;
            currentRes = tmp;

            size = size * 2;

            System.out.println(Arrays.toString(currentSrc));
        }
        return currentSrc;

    }
    static void merge(int[] src1, int src1start, int[] src2, int src2start, int[] res, int resStart, int size) {
        int index1 = src1start;
        int index2 = src2start;

        int src1end = Math.min(src1start + size, src1.length);
        int src2end = Math.min(src2start + size, src2.length);

        if (src1start + size > src1.length) {
            for (int i = src1start; i < src1end; i++) {
                res[i] = src1[i];
            }
            return;
        }

        int iterCount = src1end - src1start + src2end - src2start;

        for (int i = resStart; i < resStart + iterCount; i++) {
            if (index1 < src1end && (index2 >= src2end || src1[index1] < src2[index2])) {
                res[i] = src1[index1];
                index1++;
            } else {
                res[i] = src2[index2];
                index2++;
            }
        }
    }
}