import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;

public class BaiTapMang {

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

        int[] arrTang = arr.clone();
        Arrays.sort(arrTang);
        System.out.print("\n\nMảng sau khi sắp xếp tăng dần: ");
        xuatMang(arrTang);

        System.out.print("Mảng sau khi sắp xếp giảm dần: ");
        sapXepGiam(arr);
        xuatMang(arr);
    }

    public static void xuatMang(int[] a) {
        for (int x : a) System.out.print(x + " ");
        System.out.println();
    }

    public static int tinhTong(int[] a) {
        int s = 0;
        for (int x : a) s += x;
        return s;
    }

    public static int countK(int[] a, int k) {
        int count = 0;
        for (int x : a) if (x == k) count++;
        return count;
    }

    public static int findMax(int[] a) {
        int max = a[0];
        for (int x : a) if (x > max) max = x;
        return max;
    }

    public static int findMin(int[] a) {
        int min = a[0];
        for (int x : a) if (x < min) min = x;
        return min;
    }

    public static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static void xuatSoNguyenTo(int[] a) {
        for (int x : a) {
            if (isPrime(x)) System.out.print(x + " ");
        }
    }

    public static void sapXepGiam(int[] a) {
        
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] < a[j]) {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
    }
}