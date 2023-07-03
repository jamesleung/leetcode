package com.aggrework.leetcode;

import org.springframework.stereotype.Component;

/**
 * @author james l
 */
@Component
public class Palindromic4 {
    private int[] asciiCached;
    private int[][] checkedPair;
    public String longestPalindrome(String s) {
        int start = 0, end = 0, maxLen = 1;
        int len = s.length();
        asciiCached = new int[len];
        checkedPair = new int[len][len];
        // <KeyCharAscii, AdjacentPositionList>
        int[][] keyPos1 = new int[128][len];
        // record the last position of current char
        int[] asciis = new int[128];
        //checkedPair = new HashMap<>(len);

        int endTemp = 0, maxLenTemp = 1;
        for (int i = 0; i < len; i++) {
            int c = charAt(s, i);
            keyPos1[c][asciis[c]] = i + 1;
            asciis[c] = asciis[c] + 1;

            if (i < len - 1 && asciiCached[i] == charAt(s, i + 1)) {
                endTemp = i + 1;
                maxLenTemp++;
            } else {
                if (maxLenTemp > maxLen) {
                    maxLen = maxLenTemp;
                    end = endTemp;
                    start = endTemp - maxLenTemp + 1;
                    checkedPair[start][end] = 1;
                }
                maxLenTemp = 1;
                endTemp = 0;
            }
        }
        for (int k = 0; k < keyPos1.length; k++) {
            //for (ArrayList<Integer> list : keyPos.values()) {
            int[] list = keyPos1[k];
            if (list.length == 1) {
                continue;
            }
            for (int i = 0; i < list.length; i++) {
                if (list[i] == 0) {
                    // to next list
                    break;
                }
                int start1 = list[i] - 1;
                if (len - start1 <= maxLen) {
                    break;
                }
                for (int j = i + 1; j < list.length; j++) {
                    if (list[j] == 0) {
                        break;
                    }
                    int end1 = list[j] - 1;
                    int len1 = end1 - start1 + 1;
                    if (len1 <= maxLen) {
                        continue;
                    }
                    if (ifPalindromic(start1, end1)) {
                        // already checked
                        maxLen = len1;
                        start = start1;
                        end = end1;
                    }
                    // 判断下一步是j++还是j++++：单数看中点左右，双数看中间两点左右
                    // 不是就不是，是可能还不是


                }
            }
        }
        return s.substring(start, end + 1);
    }
    private boolean ifPalindromic(int start, int end) {
        if (start == end) {
            return true;
        }
        // 记录已经检查过的pair，后续再碰到就直接用前面的结果
        if (checkedPair[start][end] == 1) {
            return true;
        }
        boolean checked;
        if (end - start == 1) {
            checked = asciiCached[start] == asciiCached[end];
            if (checked) {
                checkedPair[start][end] = 1;
            }
            return checked;
        }
        checked = asciiCached[start] == asciiCached[end] && ifPalindromic(start + 1, end - 1);
        if (checked) {
            checkedPair[start][end] = 1;
        }
        return checked;
    }
    private int charAt(String s, int i) {
        int r = asciiCached[i];
        if (r == 0) {
            r = s.charAt(i);
            asciiCached[i] = r;
        }
        return r;
    }
}
