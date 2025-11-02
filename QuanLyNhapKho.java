import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class QuanLyNhapKho implements INhapKho {
    private IQuanLySach qlSach; // dùng interface quản lý sách hiện có
    private List<LichSuNhapKho> lichSu;

    public QuanLyNhapKho(IQuanLySach qlSach) {
        this.qlSach = qlSach;
        this.lichSu = new ArrayList<>();
    }

    @Override
    public boolean nhapKho(String maSach, int soLuong, LocalDate ngayNhap) {
        if (soLuong <= 0) return false;

        // kiểm tra sách tồn tại trong hệ thống
        Object ketqua = qlSach.timKiemSach(maSach); // giả sử trả về Sach hoặc null
        if (ketqua == null) {
            return false;
        }

        // nếu timKiemSach trả về String (thông tin) thay vì Sach, bạn cần sửa lại ở đây
        // dưới đây mình giả sử ketqua là Sach
        try {
            Sach sach = (Sach) ketqua;
            // cập nhật số lượng trên đối tượng Sach
            int old = sach.getSoLuong();
            sach.setSoLuong(old + soLuong);

            // lưu lịch sử nhập kho
            LichSuNhapKho ls = new LichSuNhapKho(maSach, soLuong, ngayNhap);
            lichSu.add(ls);
            return true;
        } catch (ClassCastException ex) {
            // Nếu timKiemSach không trả về Sach, trả về false (bạn chỉnh lại nếu cần)
            return false;
        }
    }

    @Override
    public int kiemTraTonKhoTheoKhoangNgay(String maSach, LocalDate tuNgay, LocalDate denNgay) {
        int tong = 0;
        for (LichSuNhapKho ls : lichSu) {
            if (!ls.getMaSach().equals(maSach)) continue;
            LocalDate ngay = ls.getNgayNhap();
            if ((ngay.isEqual(tuNgay) || ngay.isAfter(tuNgay)) &&
                (ngay.isEqual(denNgay) || ngay.isBefore(denNgay))) {
                tong += ls.getSoLuong();
            }
        }
        return tong;
    }

    // tiện ích: in lịch sử
    public List<LichSuNhapKho> getLichSu() {
        return new ArrayList<>(lichSu);
    }
}
