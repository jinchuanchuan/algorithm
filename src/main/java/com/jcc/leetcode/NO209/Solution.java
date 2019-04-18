package com.jcc.leetcode.NO209;

public class Solution {
    public static int minSubArrayLen(int s, int[] nums) {
        int l = 0; int r = -1; //nums[l...r] 为我们的滑动窗口
        int sum = 0; int res = nums.length + 1;
        while(l < nums.length) {
            if(r + 1 < nums.length && sum < s) {
                r++;
                sum += nums[r];
            } else {
                sum -= nums[l];
                l++;
            }
            if(sum >= s) {
                res = Math.min(res, r-l+1);
            }
        }
        if(res == nums.length + 1) {
            return 0;
        }
        System.out.println(res);
        return res;
    }

    public static void main(String[] args) {
        Solution.minSubArrayLen(7, new int[]{2,3,1,2,4,3});
    }
}
