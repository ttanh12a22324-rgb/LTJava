package Laptrinhjavapackage;
public class Hourly extends Employee {

 private int hoursWorked; 

 public Hourly(String name, String address, String phone,
               String socialSecurityNumber, double payRate) {
     super(name, address, phone, socialSecurityNumber, payRate);
     this.hoursWorked = 0;
 }

 public void addHours(int moreHours) {
     hoursWorked += moreHours;
 }

 public double pay() {
     double totalPay = payRate * hoursWorked;
     hoursWorked = 0; 
     return totalPay;
 }

 public String toString() {
     return super.toString()
          + "\nSo gio lam: " + hoursWorked;
 }
}