package com.aggrework.leetcode;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author james l
 */
@Component
public class Palindromic2 {
    int[] asciiCached;
    public String longestPalindrome(String s) {
        int len = s.length(), start = 0, maxLen = 1;
        int[] asciis = new int[128];
        // find the same char max len
        int[] originChecked = new int[len];
        asciiCached = new int[len];
        // <KeyCharAscii, AdjacentPositionList>
        Map<Integer, ArrayList<Integer>> keyPos = new HashMap<>(len);
        for (int i = len - 1; i >= 0; i--) {
            int c = charAt(s, i);
            // the same char show again.
            int prevPos = asciis[c];
            if (prevPos != 0) {
                // the second char show at this time.
                if (originChecked[prevPos] == 0) {
                    originChecked[prevPos] = 1;
                }
                originChecked[i] = 1;
                if (charAt(s, i) == charAt(s, i + 1)) {
                    originChecked[prevPos]++;
                    if (originChecked[prevPos] >= maxLen) {
                        maxLen = originChecked[prevPos];
                        start = prevPos;
                    }
                } else {
                    asciis[c] = i;
                }
            } else {
                asciis[c] = i;
            }
            if (i > 1) {
                int sumAscii = charAt(s, i) + charAt(s, i - 1) + charAt(s, i - 2);
                ArrayList<Integer> arr = keyPos.computeIfAbsent(sumAscii, k -> new ArrayList<>(len));
                arr.add(i);
            }
        }
        if (maxLen > 1) {
            start = start - maxLen + 1;
        }
        for (int i = 0; i < len - 2; i++) {
            if (len - i <= maxLen) {
                break;
            }
            int sumAscii = charAt(s, i) + charAt(s, i + 1) + charAt(s, i + 2);
            ArrayList<Integer> arr = keyPos.get(sumAscii);
            if ((originChecked[i] == 0 && 1 == arr.size()) || arr == null) {
                continue;
            }
            for (ArrayList<Integer> arr1 : keyPos.values()) {

            }
            int checkedStart = -1, checkedEnd = -1;
            int checkedLength = originChecked[i];
            if (checkedLength > 1) {
                checkedStart = i;
                checkedEnd = checkedStart + checkedLength - 1;
            }
            for (int j = arr.size() - 1; j >= 0; j--) {
                int end1 = arr.get(j);
                if (i + 2 > end1) {
                    continue;
                }
                if (i >= checkedStart && end1 <= checkedEnd) {
                    // already compared in the first step
                    i = checkedEnd;
                    break;
                }
                int subLen = end1 - i + 1;
                if (subLen <= maxLen) {
                    continue;
                }
                /*
                if (charAt(s, i) != charAt(s, end1)) {
                    continue;
                }
                if (charAt(s, i + 1) != charAt(s, end1 - 1)) {
                    continue;
                }
                if (charAt(s, i + 2) != charAt(s, end1 - 2)) {
                    continue;
                }

                 */
                int falseFlag = 0, times = 0, loopCount = subLen >> 2;
                for (int m = 0; m < loopCount; m++) {
                    if (charAt(s, i + times + m) != charAt(s, end1 - times - m)) {
                        falseFlag = -1;
                        break;
                    }
                }
                /*
                for (int m = i + 3; m <= end1; m++) {
                    if (loopCount <= 0) {
                        break;
                    }
                    if (charAt(s, m) != charAt(s, end1 - times)) {
                        falseFlag = -1;
                        break;
                    }
                    loopCount--;
                    times++;
                }

                 */
                if (falseFlag == 0) {
                    maxLen = subLen;
                    start = i;
                }
            }
        }
        return s.substring(start, start + maxLen);
    }

    private int charAt(String s, int i) {
        if (asciiCached[i] == 0) {
            asciiCached[i] = s.charAt(i);
        }
        return asciiCached[i];
    }
}
