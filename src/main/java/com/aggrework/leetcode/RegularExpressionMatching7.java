package com.aggrework.leetcode;

import org.springframework.stereotype.Component;

/**
 * @author james l
 */
@Component
public class RegularExpressionMatching7 {
    public boolean isMatch(String s, String p) {
        return match(s, 0, p, 0);
    }

    private boolean match(String s, int sBegin, String p, int pBegin) {
        int sLen = s.length(), pLen = p.length();
        if (sBegin == sLen && pBegin == pLen) {
            return true;
        }

        int iNewLifePos = -1, iNewLifePosEnd = -1, jNewLifePos = -1;

        char sC = sBegin == sLen ? 0 : s.charAt(sBegin);
        char pC = pBegin == pLen ? 0 : p.charAt(pBegin);
        char nextJC = pBegin >= pLen - 1 ? 0 : p.charAt(pBegin + 1);

        if (isDotChar(pC, nextJC)) {
            if (sC == 0) {
                return false;
            }
            return match(s, sBegin + 1, p, pBegin + 1);
        } else if (isLowerChar(pC, nextJC)) {
            if (sC == pC) {
                return match(s, sBegin + 1, p, pBegin + 1);
            }
        } else if (isUpperChar(pC, nextJC)) {
            iNewLifePos = sBegin;
            int i = sBegin;
            int j = pBegin;
            boolean isSupperMode = false;
            while (true) {
                // to get the new life point
                if (sC == pC) {
                    i++;
                    sC = i == sLen ? 0 : s.charAt(i);
                } else {
                    j = j + 2;
                    pC = j == pLen ? 0 : p.charAt(j);
                    nextJC = j >= pLen - 1 ? 0 : p.charAt(j + 1);
                    if (isUpperChar(pC, nextJC)) {
                        continue;
                    }
                    if (isSuperChar(pC, nextJC)) {
                        isSupperMode = true;
                        continue;
                    }
                    if (isLowerChar(pC, nextJC) || isDotChar(pC, nextJC)) {
                        iNewLifePosEnd = i;
                        if (isSupperMode) {
                            iNewLifePosEnd = s.length();
                        }
                        jNewLifePos = j;
                        break;
                    }
                }
            }
            while (iNewLifePos <= iNewLifePosEnd) {
                if (match(s, iNewLifePos, p, jNewLifePos)) {
                    return true;
                }
                iNewLifePos++;
            }
            return false;
        } else if (isSuperChar(pC, nextJC)) {
            iNewLifePos = sBegin;
            int j = pBegin;
            while (true) {
                // to get the new life point
                j = j + 2;
                pC = j == pLen ? 0 : p.charAt(j);
                nextJC = j >= pLen - 1 ? 0 : p.charAt(j + 1);
                if (isUpperChar(pC, nextJC)) {
                    continue;
                }
                if (isSuperChar(pC, nextJC)) {
                    continue;
                }
                if (isLowerChar(pC, nextJC) || isDotChar(pC, nextJC)) {
                    jNewLifePos = j;
                    iNewLifePosEnd = s.length();
                    break;
                }
            }
            while (iNewLifePos <= iNewLifePosEnd) {
                if (match(s, iNewLifePos, p, jNewLifePos)) {
                    return true;
                }
                iNewLifePos++;
            }
            return false;
        }

        return false;
    }

    private boolean isDotChar(char c, char nextChar) {
        return c == '.' && nextChar != '*';
    }

    private boolean isLowerChar(char c, char nextChar) {
        if (nextChar == '*') {
            return false;
        }
        if (c != '.' && c != '*') {
            return true;
        }
        return false;
    }

    private boolean isUpperChar(char c, char nextChar) {
        if (nextChar != '*') {
            return false;
        }
        if (c != '.') {
            return true;
        }
        return false;
    }

    private boolean isSuperChar(char c, char nextChar) {
        return c == '.' && nextChar == '*';
    }
}
