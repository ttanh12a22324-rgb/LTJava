package Laptrinhjavapackage;
import java.util.Scanner;
import java.util.Random;

public class baitapmang {

    static void xuatMang(int[] arr) {
        for (int x : arr) System.out.print(x + " ");
        System.out.println();
    }

    static int tinhTong(int[] arr) {
        int tong = 0;
        for (int x : arr) tong += x;
        return tong;
    }

    static int countK(int[] arr, int k) {
        int dem = 0;
        for (int x : arr) if (x == k) dem++;
        return dem;
    }

    static int findMax(int[] arr) {
        int max = arr[0];
        for (int x : arr) if (x > max) max = x;
        return max;
    }

    static int findMin(int[] arr) {
        int min = arr[0];
        for (int x : arr) if (x < min) min = x;
        return min;
    }

    static boolean laNguyenTo(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++)
            if (n % i == 0) return false;
        return true;
    }

    static void xuatSoNguyenTo(int[] arr) {
        for (int x : arr) if (laNguyenTo(x)) System.out.print(x + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập số lượng phần tử N: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        Random rd = new Random();
        for (int i = 0; i < n; i++) {
            arr[i] = rd.nextInt(100);
        }

        System.out.println("\n--- Toàn bộ mảng ---");
        xuatMang(arr);

        System.out.println("\nTổng mảng: " + tinhTong(arr));

        System.out.print("\nNhập số K cần tìm: ");
        int k = sc.nextInt();
        System.out.println("Số " + k + " xuất hiện " + countK(arr, k) + " lần.");

        System.out.println("Phần tử lớn nhất: " + findMax(arr));
        System.out.println("Phần tử nhỏ nhất: " + findMin(arr));

        System.out.print("Các số nguyên tố trong mảng: ");
        xuatSoNguyenTo(arr);

        sc.close();
    }
}