package com.jcc.sort;

public class Test {
    public static void main(String[] args) {
        int[] arr = {3, 6, 8, 45, 1, 25, 89, 6};
//选择排序
//        SelectionSort.selectionSort(arr);
//        冒泡排序
//        BubbleSort.BubbleSort(arr);
        QuickSort.quickSort(arr, 0, 7);
    }
}