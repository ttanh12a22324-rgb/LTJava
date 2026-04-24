import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class QuanLySoNguyen {
    public static void main(String[] args) {
        ArrayList<Integer> danhSach = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int luaChon;

        do {
            System.out.println("\n--- MENU QUẢN LÝ ---");
            System.out.println("1. Thêm số vào danh sách");
            System.out.println("2. Hiển thị danh sách");
            System.out.println("3. Sửa số (theo vị trí)");
            System.out.println("4. Xóa số (theo vị trí)");
            System.out.println("5. Tìm kiếm một số");
            System.out.println("6. Sắp xếp tăng dần");
            System.out.println("0. Thoát");
            System.out.print("Chọn chức năng: ");
            luaChon = scanner.nextInt();

            switch (luaChon) {
                case 1: 
                    System.out.print("Nhập số nguyên cần thêm: ");
                    int soMoi = scanner.nextInt();
                    danhSach.add(soMoi);
                    break;

                case 2: 
                    System.out.println("Danh sách hiện tại: " + danhSach);
                    break;

                case 3: 
                    System.out.print("Nhập vị trí cần sửa (0 đến " + (danhSach.size() - 1) + "): ");
                    int indexSua = scanner.nextInt();
                    if (indexSua >= 0 && indexSua < danhSach.size()) {
                        System.out.print("Nhập giá trị mới: ");
                        int giaTriMoi = scanner.nextInt();
                        danhSach.set(indexSua, giaTriMoi);
                        System.out.println("Đã cập nhật.");
                    } else {
                        System.out.println("Vị trí không hợp lệ!");
                    }
                    break;

                case 4: 
                    System.out.print("Nhập vị trí cần xóa: ");
                    int indexXoa = scanner.nextInt();
                    if (indexXoa >= 0 && indexXoa < danhSach.size()) {
                        danhSach.remove(indexXoa);
                        System.out.println("Đã xóa.");
                    } else {
                        System.out.println("Vị trí không hợp lệ!");
                    }
                    break;

                case 5: 
                    System.out.print("Nhập số cần tìm: ");
                    int soTim = scanner.nextInt();
                    if (danhSach.contains(soTim)) {
                        System.out.println("Tìm thấy số " + soTim + " tại vị trí: " + danhSach.indexOf(soTim));
                    } else {
                        System.out.println("Không tìm thấy số trong danh sách.");
                    }
                    break;

                case 6: 
                    Collections.sort(danhSach);
                    System.out.println("Danh sách sau khi sắp xếp tăng dần: " + danhSach);
                    break;

                case 0:
                    System.out.println("Đang thoát chương trình...");
                    break;

                default:
                    System.out.println("Lựa chọn sai, vui lòng nhập lại!");
            }
        } while (luaChon != 0);
        
        scanner.close();
    }
}