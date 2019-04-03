package com.jcc.mukeliubobobo.array;

/**
 * @description: 二分查找，实在有序数组中进行的；首先要确定边界值，再选出中间值mid；
 * 之后再折中寻找。
 * @author: jcc
 * @date: 2019-04-02 17:38
 * @Modified By:
 */
public class BinarySearch {
    public static int binarySearch(int[] arr, int n, int target) {
        int l = 0 , r = n - 1;//在[l...r]的范围里寻找target
        while(l <= r) {       //当 l == r时,区间[l...r]依然是有效的
            int mid = l + (r - l)/2;//int mid = (l+r)/2;这样会出现整型溢出。
            if(arr[mid] == target) {
                return mid;
            }
            if(target > arr[mid]) {
                l = mid + 1;   //target在[mid+1...r]中
            } else {           //target < arr[mid]
                r = mid - 1;   //target在[l...mid-1]中
            }
        }
        return -1;
    }
}
