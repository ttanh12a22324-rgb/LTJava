package Laptrinhjavapackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BaitapsudungArrayList {

    static ArrayList<String> danhSach = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    static void themSinhVien() {
        System.out.print("Nhap ten sinh vien: ");
        String ten = sc.nextLine();
        danhSach.add(ten);
        System.out.println("Da them: " + ten);
    }

    static void xuatDanhSach() {
        if (danhSach.isEmpty()) {
            System.out.println("Danh sach trong!");
            return;
        }
        System.out.println("--- Danh sach sinh vien ---");
        for (int i = 0; i < danhSach.size(); i++) {
            System.out.println((i + 1) + ". " + danhSach.get(i));
        }
    }


    static void suaSinhVien() {
        xuatDanhSach();
        System.out.print("Nhap so thu tu can sua: ");
        int vitri = sc.nextInt();
        sc.nextLine();
        if (vitri < 1 || vitri > danhSach.size()) {
            System.out.println("Vi tri khong hop le!");
            return;
        }
        System.out.print("Nhap ten moi: ");
        String tenMoi = sc.nextLine();
        danhSach.set(vitri - 1, tenMoi);
        System.out.println("Da sua thanh cong!");
    }
    static void xoaSinhVien() {
        System.out.print("Nhap ten can xoa: ");
        String ten = sc.nextLine();
        boolean daXoa = false;
        ArrayList<String> canXoa = new ArrayList<>();
        for (String sv : danhSach) {
            if (sv.toLowerCase().contains(ten.toLowerCase())) {
                canXoa.add(sv);
                daXoa = true;
            }
        }
        danhSach.removeAll(canXoa);
        if (daXoa) System.out.println("Da xoa cac sinh vien chua ten: " + ten);
        else System.out.println("Khong tim thay sinh vien nao!");
    }
    static void timSinhVien() {
        System.out.print("Nhap chu can tim (mac dinh 'An'): ");
        String chu = sc.nextLine();
        if (chu.isEmpty()) chu = "An";
        System.out.println("--- Ket qua tim kiem '" + chu + "' ---");
        boolean timThay = false;
        for (String sv : danhSach) {
            if (sv.toLowerCase().contains(chu.toLowerCase())) {
                System.out.println(sv);
                timThay = true;
            }
        }
        if (!timThay) System.out.println("Khong tim thay!");
    }
    static void sapXep() {
        Collections.sort(danhSach);
        System.out.println("Da sap xep theo thu tu alphabet!");
        xuatDanhSach();
    }
    static void soLuong() {
        System.out.println("Tong so sinh vien: " + danhSach.size());
    }
    static void hienThiMenu() {
        System.out.println("\n====== QUAN LY SINH VIEN ======");
        System.out.println("1. Them sinh vien");
        System.out.println("2. Xuat danh sach sinh vien");
        System.out.println("3. Sua sinh vien");
        System.out.println("4. Xoa sinh vien");
        System.out.println("5. Tim sinh vien co chu 'An'");
        System.out.println("6. Sap xep sinh vien");
        System.out.println("7. So luong sinh vien");
        System.out.println("0. Thoat");
        System.out.print("Chon chuc nang: ");
    }

    public static void main(String[] args) {
        int luaChon;
        do {
            hienThiMenu();
            luaChon = sc.nextInt();
            sc.nextLine(); 
            switch (luaChon) {
                case 1: themSinhVien(); break;
                case 2: xuatDanhSach(); break;
                case 3: suaSinhVien(); break;
                case 4: xoaSinhVien(); break;
                case 5: timSinhVien(); break;
                case 6: sapXep(); break;
                case 7: soLuong(); break;
                case 0: System.out.println("Tam biet!"); break;
                default: System.out.println("Lua chon khong hop le!");
            }
        } while (luaChon != 0);

        sc.close();
    }
}
