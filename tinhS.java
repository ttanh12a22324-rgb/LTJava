package Laptrinhjavapackage;

import java.util.Scanner;

public class tinhS {
    static long factorial(int k) {
        long result = 1;
        for (int i = 2; i <= k; i++) result *= i;
        return result;
    }

    static double S(double x, int n) {
        double tong = 0;
        for (int k = 0; k <= n; k++) {
            int soMu = 2 * k + 1;
            tong += Math.pow(x, soMu) / factorial(soMu);
        }
        return tong;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập x: ");
        double x = sc.nextDouble();
        System.out.print("Nhập n: ");
        int n = sc.nextInt();
        System.out.printf("S(%.2f, %d) = %.6f%n", x, n, S(x, n));
        System.out.printf("sin(%.2f)  = %.6f%n", x, Math.sin(x));
        sc.close();
    }
}