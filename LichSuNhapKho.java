import java.time.LocalDate;

public class LichSuNhapKho {
    private String maSach;
    private int soLuong;
    private LocalDate ngayNhap;

    public LichSuNhapKho(String maSach, int soLuong, LocalDate ngayNhap) {
        this.maSach = maSach;
        this.soLuong = soLuong;
        this.ngayNhap = ngayNhap;
    }

    public String getMaSach() { return maSach; }
    public int getSoLuong() { return soLuong; }
    public LocalDate getNgayNhap() { return ngayNhap; }

    @Override
    public String toString() {
        return "LichSuNhapKho{" +
                "maSach='" + maSach + '\'' +
                ", soLuong=" + soLuong +
                ", ngayNhap=" + ngayNhap +
                '}';
    }
}

