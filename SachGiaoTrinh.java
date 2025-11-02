package Pack;

import java.time.LocalDate;

public class SachGiaoTrinh extends Sach {
    private String monHoc;
    private String capDo;
    private int soNamPhatHanh; 
    String getMonHoc() {
        return monHoc;
    }
    void setMonHoc(String monHoc){
        this.monHoc = monHoc;
    }
    String getCapDo() {
        return this.capDo;
    }
    void setCapDo(String capDo){
        this.capDo = capDo;
    }
    int getSoNamPhatHanh() {
        return soNamPhatHanh;
    }
    void setSoNamPhatHanh(int soNamPhatHanh){
        this.soNamPhatHanh = soNamPhatHanh;
    }
    public SachGiaoTrinh(String maSach, String tieuDe, String tacGia, int namXuatBan, int soLuong, String monHoc, String capDo, double giaCoBan, int soNamPhatHanh) {
        super(maSach, tieuDe, tacGia, namXuatBan, soLuong, giaCoBan);
        this.monHoc = monHoc;
        this.capDo = capDo;
        this.soNamPhatHanh = soNamPhatHanh;
    }
    @Override
    public String toString() {
        return super.toString() +
                ", Mon hoc='" + this.monHoc + '\'' +
                ", Cap do='" + this.capDo + '\'' + ",gia ban:"+ tinhGiaBan() +
                '}';
    }
    public SachGiaoTrinh(){
        super();
    }
    LocalDate localDate = LocalDate.now();
    int year = localDate.getYear();
    {
    this.soNamPhatHanh = year - super.getNamXuatBan();
    }
    @Override
    public double tinhGiaBan() {
        return super.getGiaCoBan() + ( this.soNamPhatHanh* 5000);
    }
}
