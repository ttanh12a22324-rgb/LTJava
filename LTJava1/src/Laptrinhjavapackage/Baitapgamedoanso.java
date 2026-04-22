import java.util.Scanner;
import java.util.Random;

public class GameDoanSo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String tiepTuc;

        do {
            chayGame(sc);
            System.out.print("\nThím có muốn chơi nữa không? (C/K): ");
            tiepTuc = sc.next();
        } while (tiepTuc.equalsIgnoreCase("c"));

        System.out.println("Tạm biệt thím nhé!");
        sc.close();
    }

    public static void chayGame(Scanner sc) {
        Random rd = new Random();
        int soCuaMay = rd.nextInt(101); 
        int soLanDoan = 0;
        int toiDa = 7;
        boolean thang = false;

        System.out.println("\n--- GAME ĐOÁN SỐ (0-100) ---");
        System.out.println("Thím có tối đa 7 lần để đoán.");

        while (soLanDoan < toiDa) {
            soLanDoan++;
            System.out.print("Lần " + soLanDoan + " - Mời thím đoán: ");
            
            // Kiểm tra đầu vào có phải là số hay không
            if (!sc.hasNextInt()) {
                System.out.println("Nhập số thôi thím ơi!");
                sc.next(); // Đọc bỏ giá trị không phải số
                soLanDoan--; // Không tính lượt này
                continue;
            }

            int soNguoiDoan = sc.nextInt();

            if (soNguoiDoan == soCuaMay) {
                System.out.println("Chuẩn luôn! Thím đoán đúng rồi!");
                thang = true;
                break;
            } else if (soNguoiDoan < soCuaMay) {
                System.out.println("Số thím đoán NHỎ HƠN số của máy.");
            } else {
                System.out.println("Số thím đoán LỚN HƠN số của máy.");
            }

            if (soLanDoan < toiDa) {
                System.out.println("Thím còn " + (toiDa - soLanDoan) + " lượt.");
            }
        }

        if (!thang) {
            System.out.println("\nGame Over nha thím!");
            System.out.println("Số của máy là: " + soCuaMay);
        }
    }
}