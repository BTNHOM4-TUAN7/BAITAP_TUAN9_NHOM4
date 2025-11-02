import java.util.ArrayList;
import java.util.List;

public class QuanLySachImpl implements IQuanLySach{
    private List<Sach> danhSachSach;

    public QuanLySachImpl() {
        danhSachSach = new ArrayList<>();
    }

    @Override
    public void themSach(Sach sach) {
        danhSachSach.add(sach);
        System.out.println("Da them sach: " + sach.getTieuDe());
    }

    @Override
    public Sach timKiemSach(String maSach) {
        for (Sach s : danhSachSach) {
            if (s.getMaSach().equalsIgnoreCase(maSach)) {
                return s;
            }
        }
        return null;
    }

    @Override
    public boolean xoaSach(String maSach) {
        Sach sach = timKiemSach(maSach);
        if (sach != null) {
            danhSachSach.remove(sach);
            System.out.println(" Da xoa sach co ma " + maSach);
            return true;
        }
        return false;
    }

    @Override
    public void hienThiDanhSach() {
        if (danhSachSach.isEmpty()) {
            System.out.println("Danh sach trong.");
        } else {
            System.out.println("DANH SACH SACH:");
            for (Sach s : danhSachSach) {
                System.out.println(s);
            }
        }
    }

    @Override
    public List<Sach> getDanhSachSach() {
        return danhSachSach;
    }
}
