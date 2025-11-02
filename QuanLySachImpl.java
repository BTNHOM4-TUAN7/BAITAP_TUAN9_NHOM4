import java.util.ArrayList;
import java.util.List;

public class QuanLySachImpl implements IQuanLySach {
    private List<Sach> danhSachSach = new ArrayList<>();

    @Override
    public void themSach(Sach s) {
        danhSachSach.add(s);
    }

    @Override
    public boolean xoaSach(String maSach) {
        return danhSachSach.removeIf(s -> s.getMaSach().equalsIgnoreCase(maSach));
    }

    @Override
    public Sach timKiemTheoMa(String maSach) {
        for (Sach s : danhSachSach) {
            if (s.getMaSach().equalsIgnoreCase(maSach)) return s;
        }
        return null;
    }

    @Override
    public boolean capNhatSoLuong(String maSach, int soLuongMoi) {
        Sach s = timKiemTheoMa(maSach);
        if (s != null) {
            s.setSoLuong(soLuongMoi);
            return true;
        }
        return false;
    }

    @Override
    public void hienThiDanhSach() {
        if (danhSachSach.isEmpty()) {
            System.out.println("Danh sach rong!");
        } else {
            System.out.println("\n=== DANH SACH SACH ===");
            for (Sach s : danhSachSach) {
                System.out.println(s.toString());
            }
        }
    }

    @Override
    public List<Sach> getDanhSach() {
        return danhSachSach;
    }
    @Override
    public double tinhTongGiaTriKho() {
    double tong = 0;
    for (Sach s : danhSachSach) {
        tong += s.tinhGiaBan() * s.getSoLuong();
    }
    return tong;
}

   @Override
   public void sapXepTheoGiaBanGiamDan() {
    danhSachSach.sort((a, b) -> Double.compare(b.tinhGiaBan(), a.tinhGiaBan()));
    System.out.println("Danh sach da duoc sap xep theo gia ban giam dan!");
}
}
