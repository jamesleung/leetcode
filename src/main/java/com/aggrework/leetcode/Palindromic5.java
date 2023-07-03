package com.aggrework.leetcode;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author james l
 */
@Component
public class Palindromic5 {
    public String longestPalindrome(String s) {
        int len = s.length(), start = 0, maxLen = 1;
        //int[] asciis = new int[128];
        // find the same char max len
        //int[] originChecked = new int[len];
        int[] asciiCached = new int[len];
        // <KeyCharAscii, AdjacentPositionList>
        Map<Integer, ArrayList<Integer>> keyPos = new HashMap<>(len);
        for (int i = len - 1; i >= 0; i--) {
            int c = s.charAt(i);
            asciiCached[i] = c;
            /*
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
                    int a = originChecked[prevPos];
                    if (a >= maxLen) {
                        maxLen = a;
                        start = prevPos;
                    }
                } else {
                    asciis[c] = i;
                }
            } else {
                asciis[c] = i;
            }

             */
            ArrayList<Integer> arr = keyPos.computeIfAbsent(c, k -> new ArrayList<>(len));
            arr.add(i);
        }
        for (ArrayList<Integer> arr : keyPos.values()) {
            int arrSize = arr.size();
            if (arrSize == 1) {
                continue;
            }
            for (int i = arrSize - 1; i >= 0; i--) {
                int start1 = arr.get(i);
                if (len - start1 <= maxLen) {
                    break;
                }
                for (int j = 0; j < arrSize; j++) {
                    int end1 = arr.get(j);
                    int subLen = end1 - start1 + 1;
                    if (subLen < maxLen) {
                        break;
                    }
                    if (start1 >= end1) {
                        break;
                    }


                    /*
                    int fastCheck = 0;
                    int start2 = arr.get(i);
                    int end2 = arr.get(j);
                    int count = (i - j + 1) >> 1;
                    for (int k = 0; k < count; k++) {
                        if ((arr.get(i - k) - start2) != (end2 - arr.get(j + k))) {
                            fastCheck = 1;
                            break;
                        }
                    }
                    if (fastCheck == 1) {
                        continue;
                    }

                     */



                    int falseFlag = 0, loopCount = subLen >> 1;
                    for (int m = 0; m < loopCount; m++) {
                        if (asciiCached[start1 + m] != asciiCached[end1 - m]) {
                            falseFlag = -1;
                            break;
                        }
                    }
                    if (falseFlag == 0) {
                        maxLen = subLen;
                        start = start1;
                        break;
                    }
                }
            }
        }
        return s.substring(start, start + maxLen);
    }
}
