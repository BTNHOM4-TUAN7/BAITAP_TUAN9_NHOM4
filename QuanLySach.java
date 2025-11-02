package Pack;
import java.util.ArrayList;
public class QuanLySach implements IQuanLySach {
    private ArrayList<Sach> danhSach = new ArrayList<>();
    public QuanLySach(){

    }
    public void themSach(Sach sach) {
        danhSach.add(sach);
    }
    public void xoaSach(String maSach) {
        danhSach.removeIf(s -> s.getMaSach().equalsIgnoreCase(maSach));
    }
    public void capNhatSach(String maSach, Sach sachMoi) {
        for (int i = 0; i < danhSach.size(); i++) {
            if (danhSach.get(i).getMaSach().equalsIgnoreCase(maSach)) {
                danhSach.set(i, sachMoi);
                return;
            }
        }
    }
    public Sach timKiemTheoMa(String maSach) {
        for (Sach s : danhSach) {
            if (s.getMaSach().equalsIgnoreCase(maSach)) {
                return s;
            }
        }
        return null;
    }
    public void hienThiTatCa() {
        if(danhSach.size() != 0)
            for (Sach s : danhSach) {
            System.out.println(s.toString());
            System.out.println("----------------------");
            }
        else
            System.out.println("Khong ton tai danh sach.");
    }
    
}
