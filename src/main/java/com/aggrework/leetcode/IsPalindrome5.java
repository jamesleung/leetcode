package com.aggrework.leetcode;

import org.springframework.stereotype.Component;

@Component
public class IsPalindrome5 {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x < 10) {
            return true;
        }



        return true;
    }
}
