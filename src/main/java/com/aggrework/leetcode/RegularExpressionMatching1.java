package com.aggrework.leetcode;

import org.springframework.stereotype.Component;

/**
 * @author james l
 */
@Component
public class RegularExpressionMatching1 {
    public boolean isMatch(String s, String p) {
        if (s.equals(p)) {
            return true;
        }
        int len = s.length();
        int i = -1, j = -1;
        int nextPChar = 0;
        for (i = 0, j = 0; i < len; i++) {
            if (nextPChar > 0) {
                if (s.charAt(i) != nextPChar) {
                    continue;
                }
                nextPChar = 0;
                j++;
                if (j >= p.length()) {
                    break;
                }
                continue;
            }
            if (p.charAt(j) == s.charAt(i)) {
                j++;
                if (j >= p.length()) {
                    break;
                }
                continue;
            }
            if (p.charAt(j) == '.') {
                j++;
                if (j >= p.length()) {
                    break;
                }
            } else if (p.charAt(j) == '*') {
                i--;
                if (p.charAt(j - 1) == '.') {
                    if (j == p.length() - 1) {
                        return true;
                    } else {

                    }
                } else {

                }
            } else {
                return false;
            }
        }
        if (nextPChar > 0) {
            return false;
        }
        return true;
    }
}
