public class SachTieuThuyet extends Sach 
{
    private String theLoai;
    private boolean laSachSeries;
    public SachTieuThuyet(String maSach, String tieuDe, String tacGia, int namXuatBan, int soLuong,
                          double giaCoBan, String theLoai, boolean laSachSeries) 
    {
        super(maSach, tieuDe, tacGia, namXuatBan, soLuong, giaCoBan);
        this.theLoai = theLoai;
        this.laSachSeries = laSachSeries;
    }
    @Override
    public double tinhGiaBan() 
    {
        return getGiaCoBan() + (laSachSeries ? 15000 : 0);
    }
    @Override
    public boolean kiemTraTonKho(int soLuongToiThieu) 
    {
        return getSoLuong() >= soLuongToiThieu;
    }
    @Override
    public void capNhatViTri(String viTriMoi) 
    {
        System.out.println("Da chuyen sach [" + getTieuDe() + "] den khu vuc: " + viTriMoi);
    }
    @Override
    public String toString() 
    {
        return super.toString() +
               ", The loai: " + theLoai +
               ", La sach series: " + (laSachSeries ? "Co" : "Khong") +
               ", Gia ban: " + String.format("%,.0f", tinhGiaBan()) + " VND";
    }
}