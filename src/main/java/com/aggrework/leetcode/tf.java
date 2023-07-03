package com.aggrework.leetcode;

import java.util.Scanner;
public class tf {
    public static boolean judge24(double a, double b, double c, double d) {
        if (calculate(a + b, c, d) || calculate(a - b, c, d) || calculate(b - a, c, d) || calculate(a * b, c, d) || calculate(a / b, c, d) || calculate(b / a, c, d)) {
            return true;
        } else if (calculate(a, b + c, d) || calculate(a, b - c, d) || calculate(a, b * c, d) || calculate(a, b / c, d) || calculate(a, b, c + d) || calculate(a, b, c - d) || calculate(a, b, c * d) || calculate(a, b, c / d)) {
            return true;
        } else {
            return false;
        }
    }
    public static boolean calculate(double a, double b, double c) {
        if (calculate(a + b, c) || calculate(a - b, c) || calculate(a * b, c) || calculate(a / b, c)) {
            return true;
        } else if (calculate(a, b + c) || calculate(a, b - c) || calculate(a, b * c) || calculate(a, b / c)) {
            return true;
        } else {
            return false;
        }
    }
    public static boolean calculate(double a, double b) {
        if (Math.abs(a + b - 24) < 0.000001 || Math.abs(a - b - 24) < 0.000001 || Math.abs(b - a - 24) < 0.000001 || Math.abs(a * b - 24) < 0.000001 || (b != 0 && Math.abs(a / b - 24) < 0.000001) || (a != 0 && Math.abs(b / a - 24) < 0.000001)) {
            return true;
        } else {
            return false;
        }
    }
    public static void main(String[]args) {
        Scanner in = new Scanner(System.in);
        System.out.print("请输入4个1到13之间的数字：");
        double a = in.nextDouble();
        double b = in.nextDouble();
        double c = in.nextDouble();
        double d = in.nextDouble();
        in.close();
        String result = judge24(a, b, c, d) ? "能" : "不能";
        System.out.println(a + "、" + b + "、" + c + "、" + d + " " + result + "通过加减乘除得到24。");
    }
}

