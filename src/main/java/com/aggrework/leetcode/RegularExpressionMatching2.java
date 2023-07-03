package com.aggrework.leetcode;

import org.springframework.stereotype.Component;

/**
 * @author james l
 */
@Component
public class RegularExpressionMatching2 {
    public boolean isMatch(String s, String p) {
        if (s.equals(p)) {
            return true;
        }
        int lastStarPos = -1;
        int lenS = s.length();
        int lenp = p.length();
        int ii = lenS - 1;
        int jj = p.length() - 1;
        int leftCCount = 0;
        while (ii >= 0 && jj >= 0) {
            if (p.charAt(jj) == '.') {
                ii--;
                jj--;
                leftCCount++;
                continue;
            }
            if (p.charAt(jj) == '*') {
                lastStarPos = jj;
                break;
            }
            if (s.charAt(ii) != p.charAt(jj)) {
                return false;
            }
            ii--;
            jj--;
            leftCCount++;
        }
        lenS = lastStarPos > 0 ? lenS - leftCCount : lenS;

        int i = 0, j = 0;
        int curPChar = p.charAt(0), prePChar = 0;
        int curSChar = s.charAt(0);
        int lenP = lastStarPos > 0 ? lastStarPos + 1 : lenp;
        boolean moveSNext = false, movePNext = false, inKingMode = false;
        int odd = 0;
        int charFlag = 0;
        while (true) {
            if (i == lenS && inKingMode) {
                j = lenP;
                break;
            }
            if (j == lenP && inKingMode) {
                i = lenS;
                break;
            }
            if (i == lenS) {
                if (j < lenP && lastStarPos > 0) {
                    if (odd == 0) {
                        if (p.charAt(j) != '*') {
                            charFlag = 1;
                        } else {
                            charFlag = 2;
                        }
                    }
                    if (charFlag == 1) {
                        if ((odd&1)==1 && p.charAt(j) != '*') {
                            return false;
                        }
                    }
                    if (charFlag == 2) {
                        if ((odd&1)==0 && p.charAt(j) != '*') {
                            return false;
                        }
                    }
                    odd++;
                    j++;
                    continue;
                }
                break;
            }
            if (j == lenP) {
                break;
            }

            if (moveSNext) {
                curSChar = s.charAt(i);
                moveSNext = false;
            }
            if (movePNext) {
                curPChar = p.charAt(j);
                movePNext = false;
            }
            if (curPChar == '.') {
                i++;
                moveSNext = true;
                j++;
                movePNext = true;
                prePChar = curPChar;
                continue;
            }
            if (curPChar == '*') {
                if (prePChar == '.') {
                    j++;
                    movePNext = true;
                    inKingMode = true;
                    continue;
                }
                if (curSChar == prePChar) {
                    i++;
                    moveSNext = true;
                    inKingMode = true;
                    continue;
                }
                j++;
                movePNext = true;
                inKingMode = false;
                prePChar = 0;
                continue;
            }

            if (inKingMode) {
                if (curSChar == curPChar) {
                    inKingMode = false;
                    j++;
                    movePNext = true;
                }
                i++;
                moveSNext = true;
                continue;
            }
            if (curSChar != curPChar) {
                if (p.charAt(j + 1) == '*') {
                    j = j + 2;
                    movePNext = true;
                    continue;
                }
                return false;
            }
            i++;
            moveSNext = true;
            j++;
            movePNext = true;
            prePChar = curPChar;
        }
        if (i == lenS && j == lenP) {
            return true;
        }
        if (i == lenS) {
            if (lastStarPos == -1) {
                return false;
            }
            return lenP - j == 2;
        }
        return false;
    }
}
