

public class SachTieuThuyet extends Sach {
    private String theLoai;
    private boolean laSachSeries;
    private int soLuong;

    
    public SachTieuThuyet(String theLoai, boolean laSachSeries, int soLuong) {
        this.theLoai = theLoai;
        this.laSachSeries = laSachSeries;
        this.soLuong = soLuong;
    }

    public SachTieuThuyet(String maSach, String tieuDe, String tacGia, int namXuatBan, int soLuong, double giaCoBan,
            String viTri, String theLoai, boolean laSachSeries, int soLuong2) {
        super(maSach, tieuDe, tacGia, namXuatBan, soLuong, giaCoBan, viTri);
        this.theLoai = theLoai;
        this.laSachSeries = laSachSeries;
        soLuong = soLuong2;
    }
    
    public String getTheLoai() {
        return theLoai;
    }

    public boolean isLaSachSeries() {
        return laSachSeries;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setTheLoai(String theLoai) {
        this.theLoai = theLoai;
    }

    public void setLaSachSeries(boolean laSachSeries) {
        this.laSachSeries = laSachSeries;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    @Override
    public double tinhGiaBan() {
        if (laSachSeries)
            return this.giaCoBan + 15000;
        else
            return this.giaCoBan;
    }
    @Override
    public boolean kiemTraTonKho(int soLuongToiThieu){
        return this.soLuong>=soLuongToiThieu;
    }
    @Override
    public String toString() {
        return "Sach Tieu thuyet-"+getTieuDe()+
                ", The loai: " + theLoai +
                ", La series: " + (laSachSeries ? "Co" : "Khong") +
                ", Gia ban: " + tinhGiaBan()+
                ", Ton kho: " + soLuong;
    }
    @Override
    public void capNhatViTri(String viTriMoi) {
        System.out.println("Da chuyen sach '"+ getTieuDe()+"' den khu vuc:"+ viTriMoi);
    }
}
