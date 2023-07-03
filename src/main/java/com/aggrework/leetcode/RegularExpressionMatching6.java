package com.aggrework.leetcode;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author james l
 */
@Component
public class RegularExpressionMatching6 {
    public boolean isMatch(String s, String p) {
        int i = 0,j = 0;
        int sLen = s.length(), pLen = p.length();
        int iUpperCharPos = -1, jUpperCharPos = -1;
        int iUpperCharPosEnd = -1;
        boolean inUpperCharMode = false, inSuperMode = false;
        int iSupperCharPos = -1, jSupperCharPos = -1;
        List<LiftPoint> liftPoints = new ArrayList<>();
        while (true) {
            char sC = i == sLen ? 0 : s.charAt(i);
            char pC = j == pLen ? 0 : p.charAt(j);
            char nextJC = j >= pLen - 1 ? 0 : p.charAt(j + 1);

            boolean dotChar = isDotChar(pC, nextJC);
            boolean lowerChar = isLowerChar(pC, nextJC);
            if (lowerChar || dotChar) {
                if (inSuperMode) {
                    inSuperMode = false;
                    //i = iSupperCharPos;
                    jSupperCharPos = j;
                } else if (inUpperCharMode) {
                    iUpperCharPosEnd = i;
                    i = iUpperCharPos;
                    inUpperCharMode = false;
                    jUpperCharPos = j;
                } else {
                    if (sC != pC) {
                        if (sC == 0) {
                            break;
                        }
                        if (dotChar) {
                            i++;
                            j++;
                        } else if (iUpperCharPos < iUpperCharPosEnd) {
                            iUpperCharPos++;
                            i = iUpperCharPos;
                            j = jUpperCharPos;
                        } else if (iSupperCharPos != -1) {
                            iSupperCharPos++;
                            i = iSupperCharPos;
                            j = jSupperCharPos;
                        } else {
                            if (liftPoints.isEmpty()) {
                                break;
                            }
                            // Back then
                            LiftPoint prevLiftPoint = liftPoints.get(liftPoints.size() - 1);
                            iUpperCharPos = prevLiftPoint.getIUpperCharPos();
                            jUpperCharPos = prevLiftPoint.getJUpperCharPos();
                            iUpperCharPosEnd = prevLiftPoint.getIUpperCharPosEnd();
                            iSupperCharPos = prevLiftPoint.getISupperCharPos();
                            jSupperCharPos = prevLiftPoint.getJSupperCharPos();
                            liftPoints.remove(liftPoints.size() - 1);
                            if (iUpperCharPos < iUpperCharPosEnd) {
                                iUpperCharPos++;
                                i = iUpperCharPos;
                                j = jUpperCharPos;
                            } else if (iSupperCharPos != -1) {
                                iSupperCharPos++;
                                i = iSupperCharPos;
                                j = jSupperCharPos;
                            }
                        }
                    } else {
                        i++;
                        j++;
                    }
                }
            }
            if (isUpperChar(pC, nextJC)) {
                if (inSuperMode) {
                    j = j + 2;
                } else {
                    if (!inUpperCharMode) {

                        if (iUpperCharPos < iUpperCharPosEnd) {
                            // Save lift point 1
                            LiftPoint liftPoint = new LiftPoint();
                            liftPoint.setIUpperCharPos(iUpperCharPos);
                            liftPoint.setJUpperCharPos(jUpperCharPos);
                            liftPoint.setIUpperCharPosEnd(iUpperCharPosEnd);
                            liftPoints.add(liftPoint);
                        } else if (iSupperCharPos != -1) {
                            // Save lift point 2
                            liftPoints.clear();
                            LiftPoint liftPoint = new LiftPoint();
                            liftPoint.setISupperCharPos(iSupperCharPos);
                            liftPoint.setJSupperCharPos(jSupperCharPos);
                            liftPoints.add(liftPoint);
                            iSupperCharPos = jSupperCharPos = -1;

                        }

                        iUpperCharPos = i;
                        inUpperCharMode = true;
                    } else if (sC == pC) {
                        i++;
                    } else {
                        j = j + 2;
                    }
                }
            }
            if (isSuperChar(pC, nextJC)) {
                inUpperCharMode = false;
                iUpperCharPos = -1;
                jUpperCharPos = -1;
                iUpperCharPosEnd = -1;
                j = j + 2;
                inSuperMode = true;
                iSupperCharPos = i;
                //jSupperCharPos = j;
            }

            if (i == sLen && j == pLen) {
                return true;
            }
        }
        
        return false;
    }

    private int charType(char c, char nextChar) {
        if (isDotChar(c, nextChar)) {
            return 1;
        }
        if (isLowerChar(c, nextChar)) {
            return 2;
        }
        if (isUpperChar(c, nextChar)) {
            return 4;
        }
        if (isSuperChar(c, nextChar)) {
            return 8;
        }
        return -1;
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

    private class LiftPoint {
        private int iUpperCharPos = -1;
        private int iUpperCharPosEnd = -1;
        private int jUpperCharPos = -1;
        private int iSupperCharPos = -1;
        private int jSupperCharPos = -1;

        public int getIUpperCharPos() {
            return iUpperCharPos;
        }

        public void setIUpperCharPos(int iUpperCharPos) {
            this.iUpperCharPos = iUpperCharPos;
        }

        public int getIUpperCharPosEnd() {
            return iUpperCharPosEnd;
        }

        public void setIUpperCharPosEnd(int iUpperCharPosEnd) {
            this.iUpperCharPosEnd = iUpperCharPosEnd;
        }

        public int getJUpperCharPos() {
            return jUpperCharPos;
        }

        public void setJUpperCharPos(int jUpperCharPos) {
            this.jUpperCharPos = jUpperCharPos;
        }

        public int getISupperCharPos() {
            return iSupperCharPos;
        }

        public void setISupperCharPos(int iSupperCharPos) {
            this.iSupperCharPos = iSupperCharPos;
        }

        public int getJSupperCharPos() {
            return jSupperCharPos;
        }

        public void setJSupperCharPos(int jSupperCharPos) {
            this.jSupperCharPos = jSupperCharPos;
        }
    }
}
