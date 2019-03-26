package com.jcc;

import java.util.Arrays;

/**
 * @description:
 * @author: jcc
 * @date: 2019-03-26 18:46
 * @Modified By:
 * 插入排序——直接插入排序
 * 一般来说，插入排序都采用in-place在数组上实现。具体算法描述如下：
 * 1.从第一个元素开始，该元素可以认为已经被排序
 * 2.取出下一个元素，在已经排序的元素序列中从后向前扫描
 * 3.如果该元素（已排序）大于新元素，将该元素移到下一位置
 * 4.重复步骤3，直到找到已排序的元素小于或者等于新元素的位置
 * 5.将新元素插入到该位置后
 * 6.重复步骤2~5
 * arr 待排序数组
 */
public class Insertion {

    public static void  InsertionSort1(int[] arr) {
//        for (int i = 1; i < arr.length; i++) {
//            int temp = arr[i];   // 取出下一个元素，在已经排序的元素序列中从后向前扫描
//            for (int j = i; j >= 0; j--) {
//                if (j > 0 && arr[j-1] > temp) {
//                    arr[j] = arr[j-1];   // 如果该元素（已排序）大于取出的元素temp，将该元素移到下一位置
//                    System.out.println("Temping:  " + Arrays.toString(arr));
//                } else {
//                    // 将新元素插入到该位置后
//                    arr[j] = temp;
//                    System.out.println("Sorting:  " + Arrays.toString(arr));
//                    break;
//                }
//            }
//        }
//        System.out.println("结果集：" + Arrays.toString(arr));

        for(int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            for (int j = i; j >= 0; j--) {
                if(j > 0 && arr[j-1] > temp) {
                    arr[j] = arr[j-1];
                } else {
                    arr[j] = temp;
                    break;
                }
            }
        }
    }

    // 交换次数较多的实现
    public static void InsertionSort2(int[] arr) {
        for(int i = 0; i <= arr.length - 1; i++) {
            for(int j = i; j > 0; j--) {
                if(arr[j-1] < arr[j]) {
                    break;
                }
                //交换操作
                int temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;
                System.out.println("Sorting：" + Arrays.toString(arr));
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 6, 8, 45, 1, 25, 89, 6};
        System.out.println("1111");
//        InsertionSort1(arr);
        InsertionSort2(arr);
    }
}
