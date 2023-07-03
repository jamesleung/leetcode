package com.aggrework.leetcode;

import org.springframework.stereotype.Component;
import java.util.ArrayList;

/**
 * @author james l
 */
@Component
public class IsPalindrome2 {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x < 10) {
            return true;
        }
        int y = x, pre = -1, sum = 0;
        pre = y % 10;
        y = (y - pre) / 10;
        ArrayList<Integer> a = new ArrayList<>(10);

        while (true) {
            int diff;
            if (y < 10) {
                diff = y - pre;
                a.add(diff);
                sum += diff;
                break;
            }
            int cur = y % 10;
            diff = cur - pre;
            a.add(diff);
            sum += diff;
            y = (y - cur) / 10;
            pre = cur;
        }
        if (sum != 0) {
            return false;
        }
        int len = a.size();
        if (len == 1) {
            return a.get(0) == 0;
        }
        if ((len & 1) == 1 && a.get(len >> 1) != 0) {
            return false;
        }
        for (int start = 0, end = len - 1; start < end; start++, end--) {
            if (a.get(start) + a.get(end) != 0) {
                return false;
            }
        }
        return true;
    }
}
