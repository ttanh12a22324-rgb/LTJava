package Laptrinhjavapackage;

import java.util.Scanner;
import java.util.regex.*;

public class timsonguyenamtrongchuoi {
    
    static void timsonguyenam(String str) {
        Pattern pattern = Pattern.compile("-\\d+");
        Matcher matcher = pattern.matcher(str);
        
        System.out.println("Các số nguyên âm trong chuỗi:");
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập chuỗi: ");
        String str = sc.nextLine();
        timsonguyenam(str);
        sc.close(); 
    }
}