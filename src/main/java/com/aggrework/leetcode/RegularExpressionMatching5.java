package com.aggrework.leetcode;

import org.springframework.stereotype.Component;

/**
 * @author james l
 */
@Component
public class RegularExpressionMatching5 {
    public boolean isMatch(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        int i = 0, j = 0;
        char sC = 0, pC = 0, pCnxt = 0, pCprev = 0;
        boolean inKingMode = false;
        int iKingPos = -1, jKingPos = -1;
        int iCharStar = -1, jCharStar = -1, iTempCurPos = -1;
        while (true) {

            sC = i == sLen ? 0 : s.charAt(i);
            pC = j == pLen ? 0 : p.charAt(j);
            pCnxt = j >= pLen - 1 ? 0 : p.charAt(j + 1);

            if (pC == '.') {
                if (pCnxt == '*') {
                    // .*
                    j = j + 2;
                    inKingMode = true;
                    iKingPos = i;
                    jKingPos = j;
                } else {
                    i++;
                    j++;
                }
            } else {
                if (pCnxt == '*') {
                    // 字母*
                    jCharStar = pC;
                    int iCount = getStarCharCount(s, pC, i);
                    int jCount = getStarCharCount(p, pC, j+2);
                    if (iCount < jCount) {
                        if (inKingMode) {
                            iKingPos++;
                            i = iKingPos;
                            j = jKingPos;
                        } else {
                            break;
                        }
                    } else {
                        i = i + iCount;
                        j = j + jCount;
                    }
                    //j = j + 2;
                } else {
                    if (pC == sC) {
                        i++;
                        j++;
                    } else {
                        if (sC == '0' || pC == '0') {
                            break;
                        }
                        if (jCharStar != '0') {
                            if (pC != jCharStar) {

                            }
                        }
                        if (inKingMode) {
                            iKingPos++;
                            i = iKingPos;
                            j = jKingPos;
                        } else {
                            break;
                        }
                    }
                }
            }

            if (pC == '*') {
                pCprev = p.charAt(j - 1);
                if (pCprev == '.') {
                    j++;
                    inKingMode = true;
                    iKingPos = i;
                    jKingPos = j;
                } else {
                    // 字母*
                    jCharStar = pCprev;

                }
            }

            if (pC != '.' && pC != '*') {
                if (pC == sC) {
                    i++;
                    j++;
                } else {
                    if (sC == '0' || pC == '0') {
                        break;
                    }
                    if (inKingMode) {
                        iKingPos++;
                        i = iKingPos;
                        j = jKingPos;
                    } else {
                        break;
                    }
                }
            }
            if (i == sLen && j == pLen) {
                return true;
            }


            pCnxt = j >= pLen - 1 ? 0 : p.charAt(j + 1);

            if (!inKingMode) {
                // normal mode
                if (pC == '.') {
                    if (pCnxt == '*') {
                        // .*
                        inKingMode = true;
                        iKingPos = i;
                        j = j + 2;
                        jKingPos = j;
                    } else {
                        i++;
                        j++;
                    }
                } else {
                    if (pC != sC) {
                        if (pCnxt == '*') {
                            // 字母*
                            if (iCharStar != -1) {
                                iTempCurPos = i;
                                i = iCharStar;
                                iCharStar = -1;
                            }
                            j = j + 2;
                        } else {
                            if (iTempCurPos != -1) {
                                i = iTempCurPos;
                            } else {
                                break;
                            }
                        }
                    } else {
                        if (pCnxt == '*') {
                            iCharStar = i;
                            jCharStar = j;
                            i++;
                        } else {
                            i++;
                            j++;
                        }
                    }
                }
            } else {
                // king mode
                if (pC == '.') {
                    if (pCnxt == '*') {
                        // .*
                        inKingMode = true;
                        iKingPos = i;
                        j = j + 2;
                        jKingPos = j;
                    } else {
                        i++;
                        j++;
                    }
                } else {
                    if (sC == pC) {
                        if (pCnxt == '*') {
                            i++;
                        } else {
                            i++;
                            j++;
                        }
                    } else {
                        if (pCnxt == '*') {
                            j++;
                        } else {
                            i = iKingPos + 1;
                            iKingPos = i;
                            j = jKingPos;
                        }
                    }
                }
            }

            if (i == sLen && j == pLen) {
                return true;
            }

            if (i > sLen || j > pLen) {
                break;
            }
        }
        return false;
    }

    private int getStarCharCount(String which, char starChar, int start) {
        char c;
        int count = 0;
        int end = start, len = which.length();
        while (true) {
            if (end >= len) {
                break;
            }
            c = which.charAt(end);
            if (c == starChar || c == '.') {
                end++;
                count++;
                continue;
            }
            break;
        }
        return count;
    }
}
