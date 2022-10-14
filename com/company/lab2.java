package com.company;

public class lab2 {
    public static double fxy(double x, double y){
        return 0.75 * Math.pow(x, 2) + 0.75 * Math.pow(y, 2);
    }

    public static double fx(double x){
        return Math.pow(x, 2) - 2 * x;
    }

    static double goldMin(double a, double b) {
        double Phi = (1 + Math.sqrt(5)) / 2;
        double delta = 0.1;
        double x1 = b - (b - a) / Phi;
        double x2 = a + (b - a) / Phi;
        double y1 = fx(x1);
        double y2 = fx(x2);

        int i = 0;
        while (delta < Math.abs(b - a)) {
            if (y1 > y2) {
                a = x1;
                x1 = x2;
                y1 = y2;
                x2 = b - (x1 - a);
                y2 = fx(x2);
            } else {
                b = x2;
                x2 = x1;
                y2 = y1;
                x1 = a + (b - x2);
                y1 = fx(x1);
            }
            ++i;
        }
        return (a + b) / 2;
    }

    public static void main() {
        System.out.println(goldMin(1, 2));
    }
}