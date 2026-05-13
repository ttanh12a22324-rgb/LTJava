package Laptrinhjavapackage;
import java.util.ArrayList;
public class Staff {
 private ArrayList<StaffMember> staffList;

 public Staff() {
     staffList = new ArrayList<StaffMember>();

     Executive giamdoc = new Executive("Nguyen Van A", "123 Le Loi, Q1", "0901234567",
                                       "BHXH-001", 10000000);
     giamdoc.awardBonus(3000000); 

     Hourly nvGio1 = new Hourly("Tran Thi B", "456 Nguyen Hue, Q1", "0912345678",
                                "BHXH-002", 50000); 
     nvGio1.addHours(160); 

     Hourly nvGio2 = new Hourly("Le Van C", "789 Hai Ba Trung, Q3", "0923456789",
                                "BHXH-003", 45000); 
     nvGio2.addHours(120); 

     Volunteer tinhNguyen = new Volunteer("Pham Thi D", "321 CMT8, Q10", "0934567890");
     staffList.add(giamdoc);
     staffList.add(nvGio1);
     staffList.add(nvGio2);
     staffList.add(tinhNguyen);
 }
 public void payday() {
     System.out.println("============ KY TRA LUONG ============");
     for (int i = 0; i < staffList.size(); i++) {
         StaffMember nv = staffList.get(i);
         System.out.println(nv.toString());

         double soTien = nv.pay();
         if (soTien == 0) {
             System.out.println("=> Tinh nguyen vien: khong nhan luong");
         } else {
             System.out.println("=> Tien nhan duoc: " + soTien + " dong");
         }
         System.out.println("--------------------------------------");
     }
 }
 public static void main(String[] args) {
     Staff congTy = new Staff();
     congTy.payday();
 }
}