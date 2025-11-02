import java.util.List;
public interface IQuanLySach 
{
    void themSach(Sach s);
    Sach timKiemTheoMa(String maSach);
    boolean xoaSach(String maSach);
    void hienThiDanhSach();
    List<Sach> getDanhSach();
}