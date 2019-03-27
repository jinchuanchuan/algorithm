package com.jcc.sort;

import java.util.Arrays;

/**
 * 选择排序
 * ①. 从待排序序列中，找到关键字最小的元素；
 * ②. 如果最小元素不是待排序序列的第一个元素，将其和第一个元素互换；
 * ③. 从余下的 N - 1 个元素中，找出关键字最小的元素，重复①、②步，直到排序结束。
 *
 *    仅增量因子为1 时，整个序列作为一个表来处理，表长度即为整个序列的长度。
 */
public class SelectionSort {

    public static void selectionSort(int[] arr) {
        for(int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for(int j = i + 1; j < arr.length; j++) {   //选出之后待排序中值最小的位置
                if(arr[j] < arr[min]) {
                    min = j;
                }
            }
            if(min != i){
                int temp = arr[min];      //交换操作
                arr[min] = arr[i];
                arr[i] = temp;
            }
            System.out.println("Sorting:  " + Arrays.toString(arr));
        }
    }
}
