import java.util.List;
public interface IQuanLySach {
    void themSach(Sach sach);                     // Them 1 cuon vao ds
    Sach timKiemSach(String maSach);              // Tim sach theo ma
    boolean xoaSach(String maSach);               // Xoa sach theo ma, tra ve true/fale neu xoa duoc
    void hienThiDanhSach();                       // Hien thi toan bo sach
    List<Sach> getDanhSachSach();                 // Tra ve ds de dung cho khac
}
