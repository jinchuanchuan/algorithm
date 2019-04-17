package com.jcc.leetcode.NO26;

public class Solution {
    public static int removeDuplicates(int[] nums) {
        int count = 0;
        for(int i = 1; i < nums.length; i++) {
            if(nums[count] != nums[i]) {
                nums[count + 1] = nums[i];
                count++;
            }
        }
        return count + 1;
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        int[] nums  = {1,1,2};
        int result = removeDuplicates(nums);
        System.out.println(result);
    }
}
