package com.aggrework.leetcode;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author james l
 */
@Component
public class ZigzagConversion1 {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        char[] ca = s.toCharArray();
        int len = ca.length;
        int duration = 2*numRows-2;
        int stuckDeep = (int) Math.ceil((float)len/duration);
        char[][] r = new char[numRows][stuckDeep * (numRows - 1)];
        Map<Integer, int[][]> map = new HashMap<>(len);

        int row = -1, col = -1, count = 0;
        for (int i = 0; i < duration; i++) {
            // the first numRows chars
            int a  = i % duration;
            if (a == 0) {
                row = -1;
                col++;
            }
            if (a < numRows) {
                r[a][col] = ca[i];
                row++;
            } else {
                row--;
                col++;
                r[row][col] = ca[i];
            }
        }

        StringBuilder sb = new StringBuilder(len);
        for (char[] cs : r) {
            for (char c : cs) {
                if (c != 0) {
                    sb.append(c);
                }
            }
        }

        return sb.toString();
    }
}
