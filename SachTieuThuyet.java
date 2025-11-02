public class SachTieuThuyet extends Sach {
    private String theLoai;
    private boolean laSachSeries;
    public SachTieuThuyet() {
        super();
    }
    public SachTieuThuyet(String maSach, String tieuDe, String tacGia, int namXuatBan, int soLuong, double giaCoBan,
                          String theLoai, boolean laSachSeries) {
        super(maSach, tieuDe, tacGia, namXuatBan, soLuong, giaCoBan);
        this.theLoai = theLoai;
        this.laSachSeries = laSachSeries;
    }
    public String getTheLoai() {
        return theLoai;
    }
    public void setTheLoai(String theLoai) {
        this.theLoai = theLoai;
    }
    public boolean isLaSachSeries() {
        return laSachSeries;
    }
    public void setLaSachSeries(boolean laSachSeries) {
        this.laSachSeries = laSachSeries;
    }
    @Override
    public double tinhGiaBan() {
        return getGiaCoBan() + (laSachSeries ? 15000 : 0);
    }
    @Override
    public String toString() {
        return "[STT] " + super.toString() +
               ", The loai: " + theLoai +
               ", La sach series: " + (laSachSeries ? "Co" : "Khong") +
               ", Gia ban: " + String.format("%,.0f", tinhGiaBan()) + " VND";
    }
}