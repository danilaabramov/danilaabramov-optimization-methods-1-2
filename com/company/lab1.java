package com.company;

    public class lab1 {
        static double y(int a, double x) {
            if(a == 1) return -1 / (1 + Math.pow(x, 6));
            if(a == 2) return 10 - 1 / Math.cosh(Math.pow((x - 3), 2));
            if(a == 3) return Math.tanh(Math.pow(x, 4) - 2 * x);
            if(a == 4) return 1 / (1 + Math.exp(-5 * Math.pow(x, 2) + 10 * x));
            return 0;
        }

        static void dihMin(int f, double a, double b){
            double x1, x2;
            double delta = 0.1;
            double eps = 0.01;

            int i = 0;
            while(delta < Math.abs(b - a)){
                x1 = (a + b) / 2 - eps / 2;
                x2 = (a + b) / 2 + eps / 2;
                if(y(f, x1) > y(f, x2)) a = x1;
                else b = x2;
                ++i;
            }
            System.out.println("Минимум(дихотомия): " + (a + b) / 2);
            System.out.println("Итерации: " + i);
        }

        static void goldMin(int f, double a, double b){
            double Phi = (1 + Math.sqrt(5)) / 2;
            double delta = 0.1;
            double x1 = b - (b - a) / Phi;
            double x2 = a + (b - a) / Phi;
            double y1 = y(f, x1);
            double y2 = y(f, x2);

            int i = 0;
            while(delta < Math.abs(b - a)){
                if(y1 > y2){
                    a = x1;
                    x1 = x2;
                    y1 = y2;
                    x2 = b - (x1 - a);
                    y2 = y(f, x2);
                }
                else{
                    b = x2;
                    x2 = x1;
                    y2 = y1;
                    x1 = a + (b - x2);
                    y1 = y(f, x1);
                }
                ++i;
            }
            System.out.println("Минимум(золотое сечение): " + (a + b) / 2);
            System.out.println("Итерации: " + i);
        }

        static double Fibonacci(int n) {
            if (n == 0 || n == 1) return 1;
            else return (Fibonacci(n - 1) + Fibonacci(n - 2));
        }

        static void fibMin(int f, double a, double b, int n) {
            double lambda, mu;
            lambda = a + (Fibonacci(n - 2) / Fibonacci(n)) * (b - a);
            mu = a + (Fibonacci(n - 1) / Fibonacci(n)) * (b - a);
            double flambda = y(1, lambda);
            double fmu = y(f, mu);
            for (int i = n - 1; i > 1; --i) {
                System.out.println(a + " " + b);
                if (flambda > fmu) {
                    a = lambda;
                    lambda = mu;
                    mu = b - (lambda - a);
                    flambda = fmu;
                    fmu = y(f, mu);

                }
                else {
                    b = mu;
                    mu = lambda;
                    lambda = a + (b - mu);
                    fmu = flambda;
                    flambda = y(f, lambda);
                }

            }
            System.out.println("Минимум(Фибоначчи): " + (a + b) / 2);
            System.out.println("Итерации: " + n);
        }

        public static void main() {
            int f = 1;
            double a = -10;
            double b = 20;

            dihMin(f, a, b);
            goldMin(f, a, b);
            fibMin(f, a, b, 20);
        }
    }

