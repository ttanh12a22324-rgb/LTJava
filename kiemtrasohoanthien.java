package Laptrinhjavapackage;
import java.util.Scanner;

public class kiemtrasohoanthien {
    static boolean isPerfect(int n) {
        if (n < 2) return false;
        int tong = 0;
        for (int i = 1; i < n; i++) {
            if (n % i == 0) tong += i;
        }
        return tong == n;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập n: ");
        int n = sc.nextInt();
        if (isPerfect(n))
            System.out.println(n + " là số hoàn thiện");
        else
            System.out.println(n + " không phải số hoàn thiện");
        sc.close();
    }
}