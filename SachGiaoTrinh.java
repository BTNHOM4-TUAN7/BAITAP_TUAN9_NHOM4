
public class SachGiaoTrinh extends Sach {
    private String monHoc;
    private int soLuong;

   
    public SachGiaoTrinh(String monHoc, int soLuong) {
        this.monHoc = monHoc;
        this.soLuong = soLuong;
    }
    public SachGiaoTrinh(String maSach, String tieuDe, String tacGia, int namXuatBan, int soLuong, double giaCoBan,
            String viTri, String monHoc, int soLuong2) {
        super(maSach, tieuDe, tacGia, namXuatBan, soLuong, giaCoBan, viTri);
        this.monHoc = monHoc;
        soLuong = soLuong2;
    }
    public String getMonHoc() 
    { 
        return monHoc; 
    }
    public void setMonHoc(String monHoc) 
    { 
        this.monHoc = monHoc; 
    }
    public int getSoLuong()
    {
        return soLuong;
    }
    public void setSoLuong(int soLuong)
    {
        this.soLuong=soLuong;
    }
    @Override
    public double tinhGiaBan() {
        //vi du giao trinh co thue 5%
        return getGiaCoBan() *1.05;
        }
    @Override
    public boolean kiemTraTonKho(int soLuongToiThieu)
    {
        return this.soLuong>=soLuongToiThieu;
    }
    @Override
    public void capNhatViTri(String viTriMoi)
    {
        System.out.println("Da chuyen sach'"+getTieuDe() +"' den khu vuc: "+viTriMoi);
    }
    @Override
    public String toString() {
        return "Sach Giao Trinh -"+ getTieuDe() +
                ", Mon hoc: " + monHoc +
                ", Ton kho:" +soLuong +
                ", Gia ban: " + tinhGiaBan();
    }
}
