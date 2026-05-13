package Laptrinhjavapackage;
public class Hinhchunhat extends Hinh {
    double chieudai;
    double chieurong;

    public Hinhchunhat(String mau, double chieudai, double chieurong) {
        super(mau);
        this.chieudai = chieudai;
        this.chieurong = chieurong;
    }

    @Override
    public double TinhDienTich() {
        return chieudai * chieurong;
    }

    @Override
    public double TinhChuVi() {
        return 2 * (chieudai + chieurong);
    }

    @Override
    public String LayThongTin() {
        return "Hình chữ nhật - " + super.LayThongTin()
             + " | Chiều dài: " + chieudai
             + " | Chiều rộng: " + chieurong
             + " | Diện tích: " + TinhDienTich()
             + " | Chu vi: " + TinhChuVi();
    }
}
