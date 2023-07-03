package com.aggrework.leetcode;

import org.springframework.stereotype.Component;

@Component
public class MyAtoi1 {
    public int myAtoi(String s) {
        int r = 0, flag = 0, iCount = 0, tenTimes = 1, second5 = 0, len = s.length();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (flag == 0) {
                if (c == ' ') {
                    continue;
                }
                if (c == '-') {
                    flag = -1;
                    continue;
                }
                if (c == '+') {
                    flag = 1;
                    continue;
                }
            }
            if (!(c>='0' && c<= '9')) {
                break;
            }
            // number
            if (flag == 0) {
                flag = 1;
            }
            if (iCount == 0 && c == '0') {
                continue;
            }
            iCount++;
            int ci = (c-'0');
            if (iCount <= 5) {
                r = ((r << 1) + (r << 3)) + ci;
            } else if (iCount <= 10) {
                tenTimes = (tenTimes << 1) + (tenTimes << 3);
                second5 = ((second5 << 1) + (second5 << 3)) + ci;
            } else {
                return flag == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
        }
        //merge & compare
        if (iCount > 5) {
            int mValue = flag == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            if (flag * (mValue / tenTimes) < r) {
                return mValue;
            }
            r *= tenTimes;
            if (-flag * mValue + second5 > -r) {
                return mValue;
            }
            r += second5;
        }
        return flag == 1 ? r : (~r + 1);
    }
}
