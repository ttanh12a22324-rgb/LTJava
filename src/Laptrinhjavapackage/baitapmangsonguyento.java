package Laptrinhjavapackage;
import java.util.Scanner;

public class baitapmangsonguyento {

    
    static boolean laNguyenTo(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so phan tu: ");
        int n = sc.nextInt();
        int[] M = new int[n];
        System.out.println("Nhap cac phan tu:");
        for (int i = 0; i < n; i++) {
            System.out.print("M[" + i + "] = ");
            M[i] = sc.nextInt();
        }
        System.out.print("Dong 1 - So le: ");
        int demLe = 0;
        for (int x : M) {
            if (x % 2 != 0) {
                System.out.print(x + " ");
                demLe++;
            }
        }
        System.out.println("-> Tong: " + demLe + " so le");
        System.out.print("Dong 2 - So chan: ");
        int demChan = 0;
        for (int x : M) {
            if (x % 2 == 0) {
                System.out.print(x + " ");
                demChan++;
            }
        }
        System.out.println("-> Tong: " + demChan + " so chan");

        
        System.out.print("Dong 3 - So nguyen to: ");
        for (int x : M) {
            if (laNguyenTo(x)) {
                System.out.print(x + " ");
            }
        }
        System.out.println();
        System.out.print("Dong 4 - Khong phai nguyen to: ");
        for (int x : M) {
            if (!laNguyenTo(x)) {
                System.out.print(x + " ");
            }
        }
        System.out.println();

        sc.close();
    }
}