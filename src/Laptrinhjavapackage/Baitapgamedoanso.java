package Laptrinhjavapackage;
import java.util.Scanner;
import java.util.Random;

public class Baitapgamedoanso {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String tiepTuc;

        do {
            chayGame(sc);
            System.out.print("\nBạn có muốn chơi nữa không? (C/K): ");
            tiepTuc = sc.next();
        } while (tiepTuc.equalsIgnoreCase("c"));

        System.out.println("Tạm biệt bạn nhé!");
        sc.close();
    }

    public static void chayGame(Scanner sc) {
        Random rd = new Random();
        int soCuaMay = rd.nextInt(101); 
        int soLanDoan = 0;
        int toiDa = 7;
        boolean thang = false;

        System.out.println("\n--- GAME ĐOÁN SỐ (0-100) ---");
        System.out.println("Bạn có tối đa 7 lần để đoán.");

        while (soLanDoan < toiDa) {
            soLanDoan++;
            System.out.print("Lần " + soLanDoan + " - Mời bạn đoán: ");
            
            
            if (!sc.hasNextInt()) {
                System.out.println("Nhập số thôi bạn ơi!");
                sc.next(); 
                soLanDoan--; 
                continue;
            }

            int soNguoiDoan = sc.nextInt();

            if (soNguoiDoan == soCuaMay) {
                System.out.println("Chuẩn luôn! Thím đoán đúng rồi!");
                thang = true;
                break;
            } else if (soNguoiDoan < soCuaMay) {
                System.out.println("Số bạn đoán NHỎ HƠN số của máy.");
            } else {
                System.out.println("Số bạn đoán LỚN HƠN số của máy.");
            }

            if (soLanDoan < toiDa) {
                System.out.println("Bạn còn " + (toiDa - soLanDoan) + " lượt.");
            }
        }

        if (!thang) {
            System.out.println("\nGame Over nha Bạn!");
            System.out.println("Số của máy là: " + soCuaMay);
        }
    }
}