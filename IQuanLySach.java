import java.util.List;

public interface IQuanLySach {
    void themSach(Sach s);
    boolean xoaSach(String maSach);
    Sach timKiemTheoMa(String maSach);
    boolean capNhatSoLuong(String maSach, int soLuongMoi);
    void hienThiDanhSach();
    List<Sach> getDanhSach();
    double tinhTongGiaTriKho();
    void sapXepTheoGiaBanGiamDan();

}
