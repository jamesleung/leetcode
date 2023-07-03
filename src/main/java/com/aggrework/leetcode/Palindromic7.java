package com.aggrework.leetcode;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class Palindromic7 {
    private char[] a;
    public String longestPalindrome(String s) {
        a = s.toCharArray();
        int end = 0, maxLenTemp = 1, maxLen = 1, len = a.length, theLastOne = len - 1;
        // end position & len
        Map<Integer, Integer> candidates = new HashMap<>(len);
        for (int i = 1; i < len; i++) {
            if (a[i] == a[i - 1]) {
                maxLenTemp++;
                if (i == theLastOne || a[i] != a[i + 1]) {
                    candidates.put(i, maxLenTemp);
                    maxLenTemp = 1;
                }
            } else if (i < theLastOne && a[i + 1] == a[i - 1]) {
                candidates.put(i + 1, 3);
            }
        }
        for (Integer right : candidates.keySet()) {
            int lenTemp = candidates.get(right);
            int left = right - lenTemp + 1;
            int times = getPalindromic(left - 1, right + 1);
            lenTemp = lenTemp + 2*times;
            if (lenTemp > maxLen) {
                maxLen = lenTemp;
                end = right + times;
            }
        }
        return maxLen == len ? s : s.substring(end - maxLen + 1, end + 1);
    }

    private int getPalindromic(int left, int right) {
        int times = 0;
        while(left >= 0 && right < a.length) {
            if (a[left] != a[right]) {
                break;
            }
            left--;
            right++;
            times++;
        }
        return times;
    }
}
