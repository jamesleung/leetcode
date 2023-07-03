package com.aggrework.leetcode;

import org.springframework.stereotype.Component;

/**
 * @author lenovo
 */
@Component
public class ReverseInteger1 {
    public int reverse(int x) {
        int r = 0;
        while (true) {
            int a = x % 10;
            if ((Integer.MAX_VALUE / 10) < r || (Integer.MIN_VALUE / 10) > r) {
                return 0;
            }
            r *= 10;
            if (Integer.MAX_VALUE < a + r || Integer.MIN_VALUE > a + r) {
                return 0;
            }
            r += a;
            if (x == a) {
                return r;
            }
            x = (x - a) / 10;
        }
    }
}
