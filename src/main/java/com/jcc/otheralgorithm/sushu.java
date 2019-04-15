package com.jcc.otheralgorithm;

public class sushu {
    /**
     * 求出1-100之间的素数(质数)
     * 素数:只能被1和自己整除的数
     */
    public static void main(String[] args) {
        for(int i = 2; i <= 100; i++) {
            boolean flag = true;
            for(int j = 2; j <= i-1; j++) {
                if(i%j == 0) {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                System.out.print(i + ",");
            }
        }
    }
}
