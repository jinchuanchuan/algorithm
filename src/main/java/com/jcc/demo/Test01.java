package com.jcc.demo;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Test01 {
    public static void main(String[] args) {
        Map map = new HashMap();
    }


}
class Solution {
    public boolean isValid(String s) {
        Stack stack = new Stack();
        for(int i = 0; i < s.length(); i++) {
            String charStr = String.valueOf(s.charAt(i));
            if( charStr.equals("(") || charStr.equals("{") || charStr.equals("[")) {
                stack.push(charStr);
            } else {
                if(stack.empty()) {
                    return false;
                }
                Object pop = stack.pop();
                String match = new String();
                if(charStr.equals(")")) {
                    match = "(";
                } else if(charStr.equals("]")) {
                    match = "[";
                } else {
                    match = "{";
                }
                if(!pop.equals(match)) {
                    return false;
                }
            }
        }
        if(!stack.empty()) {
            return false;
        }
        return true;
    }
}