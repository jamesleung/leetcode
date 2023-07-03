package com.aggrework.leetcode;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * @author james l
 */
@Component
public class RegularExpressionMatching3 {
    public boolean isMatch(String s, String p) {
        if (s.equals(p)) {
            return true;
        }

        ArrayList<Character> pA = new ArrayList<>(p.length());
        for (int i = p.length() - 1; i >= 0; i--) {
            char c = p.charAt(i);
            if (c == '*') {
                if (i > 0) {
                    c = p.charAt(i - 1);
                    if (c == '.') {
                        pA.add('*');
                    } else {
                        // 变成大写
                        pA.add((char) (c ^ 32));
                    }
                    i--;
                }
            } else {
                pA.add(c);
            }
        }

        int i = 0, j = pA.size() - 1, sLen = s.length();
        boolean inKingMode = false, lastChance = false;
        char sC = 0, pC = 0;
        while (true) {

            if (i <= sLen - 1) {
                sC = s.charAt(i);
            }
            if (j >= 0) {
                pC = pA.get(j);
            }

            if (i >= sLen && j > -1) {
                i = sLen - 1;
                sC = 0;
                lastChance = true;
                inKingMode = false;
            }
            if (j <= -1 && i < sLen) {
                j = 0;
                pC = pA.get(j);
                lastChance = true;
                if (pA.get(j + 1) == '*') {
                    i = sLen - 1;
                    sC = s.charAt(i);
                }
            }

            if ((pC&32) == 0) {
                // 大写字母表示小写字母+*
                if (lastChance) {
                    j--;
                    continue;
                }
                pC = (char) (pC ^ 32);
                if (pC == sC) {
                    i++;
                    //j--;
                } else {
                    j--;
                }
            } else if (pC == '*') {
                if (lastChance) {
                    j--;
                    continue;
                }
                inKingMode = true;
                j--;
            } else if (pC == '.') {
                if (lastChance) {
                    break;
                    /*
                    if (j == 0 && i < sLen - 1) {
                        break;
                    }

                     */
                }
                i++;
                j--;
                if (!lastChance) {
                    inKingMode = false;
                }
            } else {

                if (lastChance) {
                    break;
                }
                if (inKingMode) {
                    if (pC != sC) {
                        i++;
                    }
                    if (pC == sC) {
                        i++;
                        j--;
                        inKingMode = false;
                    }
                } else {
                    if (pC == sC) {
                        i++;
                        j--;
                    } else {
                        break;
                    }
                }
            }

            if (i == sLen && j == -1) {
                return true;
            }
        }

        return false;
    }
}
