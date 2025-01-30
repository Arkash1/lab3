package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[12];

        
        System.out.println("Введите 12 элементов массива:");
        for (int i = 0; i < 12; i++) {
            arr[i] = scanner.nextInt();
        }
        scanner.close();

        
        int count = 0;
        for (int num : arr) {
            if (num > 0) count++;
        }

        int[] positives = new int[count];
        int index = 0;
        for (int num : arr) {
            if (num > 0) {
                positives[index++] = num;
            }
        }

        // Сортируем только положительные элементы
        quickSort(positives, 0, positives.length - 1);

        // Вставляем отсортированные положительные числа обратно в массив
        index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                arr[i] = positives[index++];
            }
        }

        
        System.out.println("Массив после сортировки положительных элементов:");
        System.out.println(Arrays.toString(arr));
    }

    
    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
