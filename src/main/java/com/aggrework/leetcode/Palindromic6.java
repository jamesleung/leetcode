package com.aggrework.leetcode;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author james l
 */
@Component
public class Palindromic6 {
    public String longestPalindrome(String s) {
        int len = s.length(), end = 0, maxLen = 1;
        int[] asciiCached = new int[len];
        int[] diffs = new int[len];
        asciiCached[0] = s.charAt(0);
        for (int i = 1; i < len; i++) {
            int c = s.charAt(i);
            asciiCached[i] = c;
            diffs[i] = c - asciiCached[i - 1];
        }
        ArrayList<Integer> arr = new ArrayList<>(len);
        Map<Integer, Integer> zeroArr = new HashMap<>(len);
        int prevChar = asciiCached[0];
        int maxLenTemp = 1;
        for (int i = 1; i < len; i++) {
            if (diffs[i] == 0 && prevChar == asciiCached[i]) {
                maxLenTemp++;
                if (maxLenTemp > maxLen) {
                    maxLen = maxLenTemp;
                    end = i;
                }
            } else {
                if (diffs[i - 1] == 0 && i > 1) {
                    // end position & len
                    zeroArr.put(i - 1, maxLenTemp);
                }

                prevChar = asciiCached[i];
                maxLenTemp = 1;
                if (i < len - 1 && diffs[i] + diffs[i + 1] == 0) {
                    arr.add(i);
                }
            }
        }

        // center
        for (int i = 0; i < arr.size(); i++) {
            int index = arr.get(i);
            maxLenTemp = 3;
            int left = index - 2;
            int right = index + 2;
            while(left >= 0 && right < len) {
                if (asciiCached[left] != asciiCached[right]) {
                    break;
                }
                maxLenTemp = maxLenTemp + 2;
                left--;
                right++;
            }
            if (maxLenTemp > maxLen) {
                maxLen = maxLenTemp;
                end = right - 1;
            }
        }

        // center
        for (Integer i : zeroArr.keySet()) {
            maxLenTemp = zeroArr.get(i);
            int right = i;
            int left = right - maxLenTemp + 1;
            left--;
            right++;
            while(left >= 0 && right < len) {
                if (asciiCached[left] != asciiCached[right]) {
                    break;
                }
                maxLenTemp = maxLenTemp + 2;
                left--;
                right++;
            }
            if (maxLenTemp > maxLen) {
                maxLen = maxLenTemp;
                end = right - 1;
            }
        }

        return maxLen == len ? s : s.substring(end - maxLen + 1, end + 1);
    }
}
