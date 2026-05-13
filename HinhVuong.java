package Laptrinhjavapackage;

public class HinhVuong extends Hinhchunhat {
    
    HinhVuong(String mau, double bankinh) {
        super(mau, bankinh, bankinh);
    }
    
    @Override
    public String LayThongTin() {
        return "Mau: " + mau +
               ", Canh: " + chieudai +
               ", Dien tich: " + TinhDienTich() +
               ", Chu vi: " + TinhChuVi();
    }
}