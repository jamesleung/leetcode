package com.aggrework.leetcode;

import org.springframework.stereotype.Component;

@Component
public class Palindromic3 {
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len == 1) {
            return s;
        }
        int maxLen = 1;
        int start = 0, end = 0;
        int[] diffs = new int[len];
        for (int i = 1; i < len; i++) {
            diffs[i] = s.charAt(i) - s.charAt(i - 1);
        }
        for (int i = 1; i < diffs.length; i++) {
            int sumDiff = 0;
            for (int j = diffs.length - 1; j>=i; j--) {
            //for (int j = i; j < diffs.length; j++) {
                if (diffs[j] != 0) {
                    sumDiff = sumDiff + diffs[j];
                }
                if (sumDiff != 0) {
                    continue;
                }
                int subLen = j - i + 1;
                int falseFlag = 0, loopCount = subLen >> 1;
                for (int m = 0; m < loopCount; m++) {
                    if (diffs[i + m] != -diffs[j - m]) {
                        falseFlag = -1;
                        break;
                    }
                }
                if (falseFlag == 0) {
                    subLen++;
                    if (subLen > maxLen) {
                        maxLen = subLen;
                        start = i - 1;
                        end = j;
                        return s.substring(start, end + 1);
                    }
                }
            }
        }
        return s.substring(start, end + 1);
    }
}