import java.util.ArrayList;
public class QuanLySachImpl implements IQuanLySach {
    private ArrayList<Sach> danhSachSach;
    public QuanLySachImpl() {
        danhSachSach = new ArrayList<>();
    }
    @Override
    public void themSach(Sach s) {
        if (timKiemSach(s.getMaSach()) != null) {
            System.out.println("-> LOI: Ma sach '" + s.getMaSach() + "' da ton tai. Khong the them.");
        } else {
            danhSachSach.add(s);
            System.out.println("-> Da them sach thanh cong: " + s.getTieuDe());
        }
    }
    @Override
    public boolean xoaSach(String maSach) {
        Sach s = timKiemSach(maSach);
        if (s != null) {
            danhSachSach.remove(s);
            System.out.println("-> Da xoa sach: " + s.getTieuDe());
            return true;
        } else {
            System.out.println("-> LOI: Khong tim thay sach co ma '" + maSach + "'.");
            return false;
        }
    }
    @Override
    public boolean capNhatSoLuong(String maSach, int soLuongMoi) {
        Sach s = timKiemSach(maSach);
        if (s != null) {
            s.setSoLuong(soLuongMoi);
            System.out.println("-> Da cap nhat so luong cho sach '" + s.getTieuDe() + "' thanh " + soLuongMoi);
            return true;
        } else {
            System.out.println("-> LOI: Khong tim thay sach co ma '" + maSach + "'.");
            return false;
        }
    }
    @Override
    public Sach timKiemSach(String maSach) {
        for (Sach s : danhSachSach) {
            if (s.getMaSach().equalsIgnoreCase(maSach)) {
                return s;
            }
        }
        return null; // Không tìm thấy
    }
    @Override
    public void hienThiDanhSach() {
        if (danhSachSach.isEmpty()) {
            System.out.println("-> Danh sach hien dang trong!");
        } else {
            System.out.println("\n============== DANH SACH TRONG THU VIEN ==============");
            for (Sach s : danhSachSach) {
                System.out.println(s.toString()); 
            }
            System.out.println("==========================================================");
        }
    }
    @Override
    public void thongKeThuVien() {
        System.out.println("\n============== THONG KE THU VIEN ==============");
        if (danhSachSach.isEmpty()) {
            System.out.println("-> Thu vien hien dang trong!");
            System.out.println("==================================================");
            return; // Kết thúc hàm nếu không có sách
        }
        int tongSoLoaiSach = danhSachSach.size();
        int tongSoQuyen = 0;
        double tongGiaTri = 0;
        // Duyệt qua từng loại sách trong kho//
        for (Sach s : danhSachSach) {
            // 1. Cộng dồn tổng số quyển
            tongSoQuyen += s.getSoLuong();
            // 2. Cộng dồn tổng giá trị
            // (Lấy số lượng của sách đó * Giá bán của 1 quyển sách đó)
            tongGiaTri += (s.getSoLuong() * s.tinhGiaBan());
        }
        System.out.println("- Tong so loai sach (dau sach): " + tongSoLoaiSach);
        System.out.println("- Tong so quyen sach trong kho: " + tongSoQuyen);
        System.out.println("- Tong gia tri ton kho (theo gia ban): " + String.format("%,.0f", tongGiaTri) + " VND");
        System.out.println("==================================================");
    }
}

