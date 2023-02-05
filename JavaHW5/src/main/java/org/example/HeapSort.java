package org.example;

/**
 * Реализовать алгоритм пирамидальной сортировки (HeapSort)
 */
public class HeapSort {
    static int heapSize;

    public static void sort(int[] arr) {
        buildHeap(arr);
        while (heapSize > 1) {
            swap(arr, 0, heapSize - 1);
            heapSize--;
            heapify(arr, 0);
        }
    }

    private static void buildHeap(int[] arr) {
        heapSize = arr.length;
        for (int i = arr.length / 2; i >= 0; i--) {
            heapify(arr, i);
        }
    }

    private static void heapify(int[] arr, int i) {
        int l = left(i);
        int r = right(i);
        int max = i;

        if (l < heapSize && arr[i] < arr[l]) {
            max = l;
        }
        if (r < heapSize && arr[max] < arr[r]) {
            max = r;
        }
        if (i != max) {
            swap(arr, i, max);
            heapify(arr, max);
        }
    }

    private static int right(int i) {
        return 2 * i + 2;
    }

    private static int left(int i) {
        return 2 * i + 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
