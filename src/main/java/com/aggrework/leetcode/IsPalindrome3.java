package com.aggrework.leetcode;

import org.springframework.stereotype.Component;

@Component
public class IsPalindrome3 {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int ten = 10;
        if (x < ten) {
            return true;
        }
        int i = 0;
        int[] a = new int[ten];
        a[0] = x % ten;
        do {
            x = (x - a[i]) / ten;
            i++;
            a[i] = x % ten;
        } while (x >= ten);
        int mid = i >> 1;
        int offset = 0;
        int mid1 = mid + (i & 1);
        while (offset <= mid) {
            if (a[mid - offset] != a[mid1 + offset]) {
                return false;
            }
            offset++;
        }
        return true;
    }
}
