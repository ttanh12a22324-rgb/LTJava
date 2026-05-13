package Laptrinhjavapackage;
import java.util.Scanner;

public class kiemtrachusochan {
    static boolean allEven(int n) {
        while (n > 0) {
            if ((n % 10) % 2 != 0) return false;
            n /= 10;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập n: ");
        int n = sc.nextInt();
        if (allEven(n))
            System.out.println(n + " có toàn chữ số chẵn");
        else
            System.out.println(n + " không có toàn chữ số chẵn");
    }
}



