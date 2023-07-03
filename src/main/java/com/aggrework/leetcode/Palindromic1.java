package com.aggrework.leetcode;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * @author james l
 */
@Component
public class Palindromic1 {
    public String longestPalindrome(String s) {
        int len = s.length(), start = 0, maxLen = 1;
        int[] asciis = new int[128];

        // find the same char max len
        int[] originChecked = new int[len];
        for (int i = len - 1; i >= 0; i--) {
            int c = s.charAt(i);
            // the same char show again.
            int prevPos = asciis[c];
            if (prevPos != 0) {
                // the second char show at this time.
                if (originChecked[prevPos] == 0) {
                    originChecked[prevPos] = 1;
                }
                originChecked[i] = 1;
                if (s.charAt(i) == s.charAt(i + 1)) {
                    originChecked[prevPos] = originChecked[prevPos] + 1;
                    if (originChecked[prevPos] > maxLen) {
                        maxLen = originChecked[prevPos];
                        start = prevPos;
                    }
                } else {
                    asciis[c] = i;
                }
            } else {
                asciis[c] = i;
            }
        }

        if (maxLen > 1) {
            start = start - maxLen + 1;
        }

        // check the chars which are single in the origin string
        for (int i = 0; i < len - 1; i++) {
            if (originChecked[i] == 0) {
                if (i == 0 || i == len - 1) {
                    continue;
                }
                int nxtPos = i + 1;
                if (originChecked[nxtPos] == 0) {
                    i++;
                    continue;
                }
                int prePos = i - 1;
                int maxLenTemp = 1;
                while (prePos >= 0 && nxtPos < len) {
                    if (s.charAt(prePos) != s.charAt(nxtPos)) {
                        break;
                    }
                    maxLenTemp = maxLenTemp + 2;
                    prePos--;
                    nxtPos++;
                }
                if (maxLenTemp > 1 && maxLenTemp > maxLen) {
                    maxLen = maxLenTemp;
                    start = prePos + 1;
                }
            } else {
                // originChecked[i] > 0
                int checkedStart = -1, checkedEnd = -1, checkedLength;
                if ((len - i) <= maxLen) {
                    break;
                }
                if (originChecked[i] > 1) {
                    checkedStart = i;
                    checkedLength = originChecked[i];
                    checkedEnd = checkedStart + checkedLength - 1;
                }
                for (int j = i + 1; j < len; j++) {
                    if (originChecked[j] == 0) {
                        break;
                    }
                    int subLen = j - i + 1;
                    if (subLen <= maxLen) {
                        // total length of comparing chars is smaller than maxLen, so break at here
                        continue;
                    }
                    if (s.charAt(i) != s.charAt(j) || s.charAt(i + 1) != s.charAt(j - 1)) {
                        continue;
                    }
                    if (i >= checkedStart && j <= checkedEnd) {
                        // already compared in the first step
                        i = checkedEnd;
                        break;
                    }
                    int falseFlag = 0, times = 0, loopCount = subLen / 2;
                    for (int m = i; m <= j; m++) {
                        if (s.charAt(m) != s.charAt(j - times)) {
                            falseFlag = -1;
                            break;
                        }
                        loopCount--;
                        if (loopCount <= 0) {
                            break;
                        }
                        times++;
                    }
                    if (falseFlag == 0) {
                        maxLen = subLen;
                        start = i;
                    }
                }
            }
        }
        return s.substring(start, start + maxLen);
    }
}
