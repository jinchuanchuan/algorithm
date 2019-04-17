package com.jcc.leetcode.NO27;

public class Solution {
    public static int removeElement(int[] nums, int val) {
        int k = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,2,3,3};
        int result = removeElement(nums,2);
        System.out.println(result);
    }
}
