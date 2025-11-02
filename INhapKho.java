import java.time.LocalDate;

public interface INhapKho {
    /**
     * Nhập kho cho một mã sách đã tồn tại.
     *
     * @param maSach Mã sách (phải tồn tại trong hệ thống)
     * @param soLuong số lượng nhập (dương)
     * @param ngayNhap LocalDate ngày nhập kho
     * @return true nếu nhập thành công, false nếu mã sách không tồn tại hoặc soLuong <= 0
     */
    boolean nhapKho(String maSach, int soLuong, LocalDate ngayNhap);

    /**
     * Tính tổng số lượng nhập của một mã sách trong khoảng từ "tuNgay" đến "denNgay" (bao gồm cả 2 đầu).
     *
     * @param maSach mã sách
     * @param tuNgay ngày bắt đầu (inclusive)
     * @param denNgay ngày kết thúc (inclusive)
     * @return tổng số lượng nhập trong khoảng; nếu không tìm thấy mã sách trả về 0
     */
    int kiemTraTonKhoTheoKhoangNgay(String maSach, LocalDate tuNgay, LocalDate denNgay);
}
