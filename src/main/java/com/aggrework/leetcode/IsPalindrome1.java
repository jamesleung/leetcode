package com.aggrework.leetcode;

import org.springframework.stereotype.Component;

@Component
public class IsPalindrome1 {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x < 10) {
            return true;
        }
        int r = 0, y = x;
        int tens = 1;
        while (true) {
            int i = (y / tens);
            r = r * 10 + i % 10;
            if (i < 10) {
                break;
            }
            tens *= 10;
        }
        return x == r;
    }
}
