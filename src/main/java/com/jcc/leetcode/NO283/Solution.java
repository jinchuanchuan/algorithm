package com.jcc.leetcode.NO283;

import java.util.Arrays;

public class Solution {
    public static void moveZeroes(int[] nums) {
        int k = 0;//nums中，[0...k)的元素均为非0元素
        int temp = 0 ;
        //遍历到第i个元素后，保证[0...i]中所有非0元素都按照顺序排列在[0...k)中
        //同时，[k...i]为0
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                if(k != i) {//防止自己和自己交换位置
                    temp = nums[k];
                    nums[k] = nums[i];
                    nums[i] = temp;
                    k++;
                } else {
                    k++;
                }
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        moveZeroes(nums);
    }
}
