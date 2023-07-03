package com.aggrework.leetcode;

import org.springframework.stereotype.Component;

/**
 * @author james l
 */
@Component
public class ZigzagConversion3 {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        char[] ca = s.toCharArray();
        int len = s.length();
        int duration = 2*numRows - 2;
        int durationCount = (int) Math.ceil((float)len/duration);
        char[] cas = new char[len];
        int index = 0;
        for (int i = 0; i < numRows; i++) {
            int j = 0;
            int next;
            while (j < durationCount) {
                next = i + j*duration;
                if (next >= len) {
                    break;
                }
                int maxLoop = 2;
                while(next < (j + 1)*duration) {
                    cas[index++] = ca[next];
                    int cur = next;
                    next = cur + 2*(numRows - i) - 2;
                    maxLoop--;
                    if (next >= len) {
                        break;
                    }
                    if (next == cur) {
                        break;
                    }
                    if (maxLoop == 0) {
                        break;
                    }
                }
            }
        }
        return String.valueOf(cas);
    }
}
