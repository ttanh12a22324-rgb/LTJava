package Laptrinhjavapackage;

public class hinhtron extends Hinh {
    double bankinh;
    
    hinhtron(String mau, double bankinh) {
        super(mau);
        this.bankinh = bankinh;
    }
    
    @Override
    public double TinhDienTich() {
        return Math.PI * bankinh * bankinh;
    }
    
    @Override
    public double TinhChuVi() {
        return 2 * Math.PI * bankinh;
    }
    
    @Override
    public String LayThongTin() {
        return super.LayThongTin() +
               ", Ban kinh: " + bankinh +
               ", Dien tich: " + TinhDienTich() +
               ", Chu vi: " + TinhChuVi();
    }
}