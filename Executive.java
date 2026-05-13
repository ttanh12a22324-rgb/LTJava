package Laptrinhjavapackage;
public class Executive extends Employee {

 private double bonus;

 public Executive(String name, String address, String phone,
                  String socialSecurityNumber, double payRate) {
     super(name, address, phone, socialSecurityNumber, payRate);
     this.bonus = 0; 
 }


 public void awardBonus(double execBonus) {
     this.bonus = execBonus;
 }
 
 public double pay() {
     double totalPay = super.pay() + bonus;
     bonus = 0; 
     return totalPay;
 }

 public String toString() {
     return super.toString()
          + "\nTien thuong: " + bonus;
 }
}