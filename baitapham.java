import java.util.Scanner;

class NhanVien {
    String ho, ten;
    int soSP;
    NhanVien(String ho, String ten, int soSP) {
        this.ho = ho;
        this.ten = ten;
        this.soSP = soSP;
    }
    double donGia() {
        if (soSP >= 600) return 0.65;
        else if (soSP >= 400) return 0.6;
        else if (soSP >= 200) return 0.55;
        else return 0.5;
    }
    double luong() {
        return soSP * donGia();
    }
    boolean LonHon(NhanVien nv2) {
        return this.soSP > nv2.soSP;
    }

    String hoTen() {
        return ho + " " + ten;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        NhanVien[] nv = new NhanVien[2];
        for (int i = 0; i < 2; i++) {
            System.out.println("=== Nhân viên " + (i + 1) + " ===");
            System.out.print("Nhập họ: ");
            String ho = sc.nextLine();
            System.out.print("Nhập tên: ");
            String ten = sc.nextLine();
            System.out.print("Nhập số sản phẩm: ");
            int soSP = Integer.parseInt(sc.nextLine());
            nv[i] = new NhanVien(ho, ten, soSP);
        }
        System.out.println("\n===== KẾT QUẢ =====");
        for (int i = 0; i < 2; i++) {
            System.out.printf("Lương %s: %.2f%n", nv[i].hoTen(), nv[i].luong());
        }
        System.out.println("\n-- Dùng hàm LonHon --");
        if (nv[0].LonHon(nv[1])) {
            System.out.println(nv[0].hoTen() + " có số SP nhiều hơn: " 
                + (nv[0].soSP - nv[1].soSP) + " SP");
        } else if (nv[1].LonHon(nv[0])) {
            System.out.println(nv[1].hoTen() + " có số SP nhiều hơn: " 
                + (nv[1].soSP - nv[0].soSP) + " SP");
        } else {
            System.out.println("Hai nhân viên có số SP bằng nhau!");
        }
        System.out.println("\n-- Không dùng hàm LonHon --");
        if (nv[0].soSP > nv[1].soSP) {
            System.out.println(nv[0].hoTen() + " có số SP nhiều hơn: " 
                + (nv[0].soSP - nv[1].soSP) + " SP");
        } else if (nv[1].soSP > nv[0].soSP) {
            System.out.println(nv[1].hoTen() + " có số SP nhiều hơn: " 
                + (nv[1].soSP - nv[0].soSP) + " SP");
        } else {
            System.out.println("Hai nhân viên có số SP bằng nhau!");
        }

        sc.close();
    }
}