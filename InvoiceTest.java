package Laptrinhjavapackage;
import java.util.ArrayList;
import java.util.Scanner;

public class InvoiceTest {
    static ArrayList<Invoice> danhSach = new ArrayList<Invoice>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
     
            System.out.println("\n========== MENU ==========");
            System.out.println("1. Nhap Invoice vao danh sach");
            System.out.println("2. Xuat thong tin mot Invoice");
            System.out.println("3. Sap xep danh sach");
            System.out.println("4. Tim kiem Invoice theo ma mat hang");
            System.out.println("5. Xoa Invoice theo ma mat hang");
            System.out.println("6. In toan bo danh sach");
            System.out.println("0. Thoat");
            System.out.print("Chon chuc nang: ");
            choice = Integer.parseInt(sc.nextLine().trim());

            switch (choice) {
                case 1:
                    nhapInvoice();
                    break;
                case 2:
                    xuatMot();
                    break;
                case 3:
                    menuSapXep();
                    break;
                case 4:
                    timKiem();
                    break;
                case 5:
                    xoaInvoice();
                    break;
                case 6:
                    inDanhSach();
                    break;
                case 0:
                    System.out.println("Thoat chuong trinh.");
                    break;
                default:
                    System.out.println("Lua chon khong hop le, vui long chon lai!");
            }

        } while (choice != 0);
    }
    static void nhapInvoice() {
        System.out.print("Nhap so luong Invoice muon them (it nhat 10): ");
        int n = Integer.parseInt(sc.nextLine().trim());

        if (n < 10) {
            System.out.println("Phai nhap it nhat 10 Invoice!");
            return;
        }

        for (int i = 0; i < n; i++) {
            System.out.println("\n--- Nhap Invoice thu " + (i + 1) + " ---");

         
            String ma;
            while (true) {
                System.out.print("Ma mat hang: ");
                ma = sc.nextLine().trim();
                if (timTheoMa(ma) == -1) {
                    break; 
                } else {
                    System.out.println("Ma nay da ton tai! Vui long nhap ma khac.");
                }
            }

            System.out.print("Mo ta mat hang: ");
            String moTa = sc.nextLine().trim();

            System.out.print("So luong: ");
            int soLuong = Integer.parseInt(sc.nextLine().trim());

            System.out.print("Gia moi mat hang: ");
            double gia = Double.parseDouble(sc.nextLine().trim());
            Invoice invoice = new Invoice(ma, moTa, soLuong, gia);
            danhSach.add(invoice);
        }

        System.out.println("Nhap thanh cong " + n + " Invoice!");
    }

    static void xuatMot() {
        System.out.print("Nhap ma mat hang can xem: ");
        String ma = sc.nextLine().trim();

        int viTri = timTheoMa(ma);
        if (viTri == -1) {
            System.out.println("Khong tim thay Invoice co ma: " + ma);
        } else {
            inHeader();
            System.out.println(danhSach.get(viTri));
        }
    }
    static void menuSapXep() {
        System.out.println("\n-- Sap xep theo tieu chi nao? --");
        System.out.println("1. Ma mat hang");
        System.out.println("2. So luong mua");
        System.out.print("Chon: ");
        int tieuChi = Integer.parseInt(sc.nextLine().trim());

        System.out.println("\n-- Chon thuat toan sap xep --");
        System.out.println("1. Bubble Sort (sap xep noi bot)");
        System.out.println("2. Interchange Sort (sap xep doi cho truc tiep)");
        System.out.println("3. Insertion Sort (sap xep chen)");
        System.out.println("4. Quick Sort (sap xep phan hoach)");
        System.out.println("5. Selection Sort (sap xep chon lua)");
        System.out.print("Chon: ");
        int thuatToan = Integer.parseInt(sc.nextLine().trim());

        switch (thuatToan) {
            case 1:
                bubbleSort(tieuChi);
                break;
            case 2:
                interchangeSort(tieuChi);
                break;
            case 3:
                insertionSort(tieuChi);
                break;
            case 4:
                quickSort(0, danhSach.size() - 1, tieuChi);
                break;
            case 5:
                selectionSort(tieuChi);
                break;
            default:
                System.out.println("Lua chon khong hop le!");
                return;
        }

        System.out.println("Sap xep hoan tat!");
        inDanhSach();
    }
    static int soSanh(Invoice a, Invoice b, int tieuChi) {
        if (tieuChi == 1) {
            return a.getPartNumber().compareTo(b.getPartNumber());
        } else {
            return a.getQuantity() - b.getQuantity();
        }
    }

    static void hoanVi(int i, int j) {
        Invoice tam = danhSach.get(i);
        danhSach.set(i, danhSach.get(j));
        danhSach.set(j, tam);
    }
    static void bubbleSort(int tieuChi) {
        int n = danhSach.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (soSanh(danhSach.get(j), danhSach.get(j + 1), tieuChi) > 0) {
                    hoanVi(j, j + 1);
                }
            }
        }
    }
    static void interchangeSort(int tieuChi) {
        int n = danhSach.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (soSanh(danhSach.get(i), danhSach.get(j), tieuChi) > 0) {
                    hoanVi(i, j);
                }
            }
        }
    }
    static void insertionSort(int tieuChi) {
        int n = danhSach.size();
        for (int i = 1; i < n; i++) {
            Invoice key = danhSach.get(i);
            int j = i - 1;
            while (j >= 0 && soSanh(danhSach.get(j), key, tieuChi) > 0) {
                danhSach.set(j + 1, danhSach.get(j));
                j--;
            }
            danhSach.set(j + 1, key);
        }
    }
    static void quickSort(int thap, int cao, int tieuChi) {
        if (thap < cao) {
            Invoice pivot = danhSach.get(cao);
            int i = thap - 1;
            for (int j = thap; j < cao; j++) {
                if (soSanh(danhSach.get(j), pivot, tieuChi) <= 0) {
                    i++;
                    hoanVi(i, j);
                }
            }
            hoanVi(i + 1, cao);
            int viTriPivot = i + 1;
            quickSort(thap, viTriPivot - 1, tieuChi);
            quickSort(viTriPivot + 1, cao, tieuChi);
        }
    }
    static void selectionSort(int tieuChi) {
        int n = danhSach.size();
        for (int i = 0; i < n - 1; i++) {
            int viTriNhoNhat = i;
            for (int j = i + 1; j < n; j++) {
                if (soSanh(danhSach.get(j), danhSach.get(viTriNhoNhat), tieuChi) < 0) {
                    viTriNhoNhat = j;
                }
            }
            hoanVi(i, viTriNhoNhat);
        }
    }
    static void timKiem() {
        System.out.println("1. Tim kiem tuyen tinh (Linear Search)");
        System.out.println("2. Tim kiem nhi phan (Binary Search) - can sap xep theo ma truoc");
        System.out.print("Chon: ");
        int cachTim = Integer.parseInt(sc.nextLine().trim());

        System.out.print("Nhap ma mat hang can tim: ");
        String ma = sc.nextLine().trim();

        int viTri = -1;

        if (cachTim == 1) {
        
            for (int i = 0; i < danhSach.size(); i++) {
                if (danhSach.get(i).getPartNumber().equalsIgnoreCase(ma)) {
                    viTri = i;
                    break;
                }
            }
        } else {
          
            int thap = 0, cao = danhSach.size() - 1;
            while (thap <= cao) {
                int giua = (thap + cao) / 2;
                int ketQua = danhSach.get(giua).getPartNumber().compareTo(ma);
                if (ketQua == 0) {
                    viTri = giua;
                    break;
                } else if (ketQua < 0) {
                    thap = giua + 1; 
                } else {
                    cao = giua - 1; 
                }
            }
        }

        if (viTri == -1) {
            System.out.println("Khong tim thay Invoice co ma: " + ma);
        } else {
            System.out.println("Tim thay tai vi tri: " + viTri);
            inHeader();
            System.out.println(danhSach.get(viTri));
        }
    }

    static void xoaInvoice() {
        System.out.print("Nhap ma mat hang can xoa: ");
        String ma = sc.nextLine().trim();

        int viTri = timTheoMa(ma);
        if (viTri == -1) {
            System.out.println("Khong tim thay Invoice co ma: " + ma);
        } else {
            danhSach.remove(viTri);
            System.out.println("Xoa Invoice co ma '" + ma + "' thanh cong!");
        }
    }
    static int timTheoMa(String ma) {
        for (int i = 0; i < danhSach.size(); i++) {
            if (danhSach.get(i).getPartNumber().equalsIgnoreCase(ma)) {
                return i;
            }
        }
        return -1; 
    }
    static void inHeader() {
        System.out.println("+------------+----------------------+----------+--------------+-----------------+");
        System.out.printf("| %-10s | %-20s | %8s | %12s | %15s |%n",
                "Ma HH", "Mo ta", "So luong", "Don gia", "Thanh tien");
        System.out.println("+------------+----------------------+----------+--------------+-----------------+");
    }
    static void inDanhSach() {
        if (danhSach.isEmpty()) {
            System.out.println("Danh sach hien dang trong!");
            return;
        }
        inHeader();
        for (int i = 0; i < danhSach.size(); i++) {
            System.out.println(danhSach.get(i));
        }
        System.out.println("+------------+----------------------+----------+--------------+-----------------+");
        System.out.println("Tong so Invoice: " + danhSach.size());
    }
}