package com.jcc.leetcode.NO167;

public class Solution {
    public static int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length - 1;
        while(l < r) {
            if(numbers[l] + numbers[r] == target) {
                System.out.println("第一个值：" + (l+1) + "-----第二值：" + (r+1));
                return new int[]{l+1,r+1};
            } else if(numbers[1] + numbers[r] < target) {
                l++;
            } else {
                r--;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Solution.twoSum(new int[]{2, 7, 11, 15}, 9);
    }
}
