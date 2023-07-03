package com.aggrework.leetcode;

import org.springframework.stereotype.Component;

/**
 * @author james l
 */
@Component
public class IsPalindrome4 {
    final static int [] sizeTable = { 9, 99, 999, 9999, 99999, 999999, 9999999,
            99999999, 999999999, Integer.MAX_VALUE };
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x < 10) {
            return true;
        }
        int l = stringSize(x), loops = l >> 1;
        int tensL, tensR, loop = 1;
        do {
            tensL = (int) Math.pow(10, l - loop);
            tensR = (int) Math.pow(10, loop - 1);
            int left = (x / tensL) % 10;
            int right = (x / tensR) % 10;
            if (left != right) {
                return false;
            }
            loop++;
        } while (loop <= loops);
        return true;
    }

    int stringSize(int x) {
        for (int i=0; ; i++) {
            if (x <= sizeTable[i]) {
                return i + 1;
            }
        }
    }
}
