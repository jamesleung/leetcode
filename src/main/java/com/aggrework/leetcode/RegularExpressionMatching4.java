package com.aggrework.leetcode;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * @author james l
 */
@Component
public class RegularExpressionMatching4 {
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

            // 最后的匹配
            // 1，s已经匹配完, p还没
            if (i == sLen - 1 && j > -1) {
                sC = s.charAt(i);
                int exatualMatchCount = 0;
                boolean commonMatched = false;
                while (true) {

                    pC = pA.get(j);
                    if (pC == '*') {
                        commonMatched = true;
                    } else if ((pC&32) == 0) {
                        if (sC == (char) (pC ^ 32)) {
                            commonMatched = true;
                        }
                    } else if (pC == '.') {
                        exatualMatchCount++;
                    } else {
                        if (sC == pC) {
                            exatualMatchCount++;
                        } else {
                            break;
                        }
                    }
                    j--;
                    if (j == -1) {
                        break;
                    }
                }
                return exatualMatchCount == 1 || exatualMatchCount == 0 && commonMatched;
            }
            // 2，p已经匹配到最后一个, s还没
            if (j == 0 && i < sLen - 1) {
                j = 0;
                pC = pA.get(j);
                //lastChance = true;
                if (pC == '*') {
                    return true;
                }
                if (pC == '.') {
                    return false;
                }
                if ((pC&32) == 0) {
                    // 大写字母
                    pC = (char) (pC ^ 32);
                    while (true) {
                        sC = s.charAt(i);
                        if (sC != pC) {
                            return false;
                        }
                        i++;
                        if (i == sLen) {
                            return true;
                        }
                    }
                } else {
                    // 小写字母
                    if (inKingMode && pC != sC) {
                        i++;
                    }
                    return false;
                }
            }



            //取出s
            if (i <= sLen - 1) {
                sC = s.charAt(i);
            }
            //取出p
            if (j >= 0) {
                pC = pA.get(j);
            }

            // 开始匹配过程
            if ((pC&32) == 0) {
                // 大写字母表示小写字母+*
                pC = (char) (pC ^ 32);
                if (pC == sC) {
                    i++;
                    //j--;
                } else {
                    j--;
                }
            } else if (pC == '*') {
                // 表示万能符
                inKingMode = true;
                j--;
            } else if (pC == '.') {
                // 表示1位通配符
                i++;
                j--;
                inKingMode = false;
            } else {
                // 小写字母
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

            // 结束
            if (i == sLen && j == -1) {
                return true;
            }
        }

        return false;
    }
}
