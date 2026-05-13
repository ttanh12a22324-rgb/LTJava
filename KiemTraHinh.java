package Laptrinhjavapackage;

public class KiemTraHinh {
    public static void main(String[] args) {
        Hinhchunhat hinhChuNhat = new Hinhchunhat("Do", 5.0, 3.0);
        hinhtron hinhTron = new hinhtron("Xanh", 4.0);
        HinhVuong hinhVuong = new HinhVuong("Vang", 6.0);
        
        System.out.println("=== HINH CHU NHAT ===");
        System.out.println(hinhChuNhat.LayThongTin());
        
        System.out.println("=== HINH TRON ===");
        System.out.println(hinhTron.LayThongTin());
        
        System.out.println("=== HINH VUONG ===");
        System.out.println(hinhVuong.LayThongTin());
    }
}