package com.jcc.leetcode.NO75;

import java.util.Arrays;

public class Solution {
    //时间复杂度：O(n)
    //空间复杂度：O(1)
    public static void sortColors(int[] nums) {
        //三路快排实现
        int zero = -1;         //nums[0...zero] == 0
        int two = nums.length; //nums[two...n-1] == 2
        for(int i = 0; i < two;) {
            if(nums[i] == 1) {
                i++;
            } else if(nums[i] == 2) {
                two--;
                int temp = nums[i];
                nums[i] = nums[two];
                nums[two] = temp;
            } else {
                zero++;
                int temp = nums[i];
                nums[i] = nums[zero];
                nums[zero] = temp;
                i++;
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        Solution.sortColors(new int[]{2,0,2,1,1,0});
    }
}
