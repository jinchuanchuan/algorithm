package com.jcc.leetcode.NO215;

import java.util.Arrays;

public class Solution {
    public static int findKthLargest(int[] nums, int k) {
        int[] a = Solution.sort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(a));
        System.out.println(a[a.length -k]);
        return a[a.length -k];
    }
     public static int[] sort(int[] nums, int low, int high) {
        int l = low;
        int r = high;
        int pivot = nums[l];
        while (l < r) {
            while (l < r && nums[r] >= pivot){
                r--;
            }
            nums[l] = nums[r];
            while(l < r && nums[l] <= pivot){
                l++;
            }
           nums[r] = nums[l];
        }
        nums[l] = pivot;
        sort(nums, low, l-1);
        sort(nums, l+1, high);
        return nums;
     }

    public static void main(String[] args) {
        Solution.findKthLargest(new int[]{3,2,1,5,6,4},2);
    }
}
