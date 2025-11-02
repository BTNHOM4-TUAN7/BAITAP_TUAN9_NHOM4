import java.time.LocalDate;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        IQuanLySach qlSach = new QuanLySachImpl();
        QuanLyNhapKho qlNhapKho = new QuanLyNhapKho(qlSach);
        Scanner sc = new Scanner (System.in);
        int choice;
        Sach s1 =null;
        Sach s2 =null;
        


        do {
            System.out.println("========= MENU QUAN LY SACH =========");
            System.out.println("1. Them sach moi");
            System.out.println("2. Hien thi danh sach sach");
            System.out.println("3. Tim sach theo ma");
            System.out.println("4. Xoa sach theo ma");
             System.out.println("5. Cap nhat thong tin sach");
            System.out.println("6. Nhập kho sách (nhập ngày bằng 3 số: năm, tháng, ngày)");
            System.out.println("7. Kiểm tra tổng số lượng nhập theo khoảng ngày");  
            System.out.println("8. Thoat chuong trinh");
            System.out.print("Chon chuc nang: ");
            choice = Integer.parseInt(sc.nextLine());

            switch(choice) {
                case 1:
             // === Tạo đối tượng sách với đầy đủ thông tin ===
             s1 = new SachTieuThuyet(
                "S01",
                "De Men Phieu Luu Ky",
                "To Hoai",
                1941,
                50000,
                80000,
                "Ke A1",
                "Thieu Nhi",
                false, 
                0
             );

         s2 = new SachGiaoTrinh(
                "S02",
                "Giai Tich 1",
                "Nguyen Dinh Tri",
                2020,
                75000,
                65000,
                "Ke B4",
                "Toan",
                1
            );
            // === Thêm sách vào danh sách quản lý ===
            qlSach.themSach(s1);
            qlSach.themSach(s2);
            break;

            case 2:
            // === Hiển thị toàn bộ danh sách ===
            System.out.println("\n===== DANH SACH SACH =====");
            qlSach.hienThiDanhSach();
            break;

            case 3:
            // === Tìm kiếm theo mã sách ===
            System.out.println("\n Nhap ma sach can tim:");
            String maTim=sc.nextLine();
            System.out.println(qlSach.timKiemSach(maTim));
            break;

            case 4:
            // === Kiểm tra tồn kho ===
            if (s2 != null) {
                        System.out.println("\n Kiem tra ton kho S02 (yeu cau toi thieu 50000):");
                        System.out.println("Ket qua: " + s2.kiemTraTonKho(50000));
                    } else {
                        System.out.println("Sach S02 chưa được tạo, hay chon chuc nang 1 truoc!");
                    }
            break;

            case 5:
            if (s1 != null && s2 != null) {
                        System.out.println("\n Cap nhat vi tri S01...");
                        s1.capNhatViTri("Ke A3");

                        System.out.println("\n Sau cap nhat:");
                        System.out.println(s1);

                        System.out.println("\n Xoa sach S02:");
                        qlSach.xoaSach("S02");

                        System.out.println("\n===== DANH SACH SAU KHI XOA =====");
                        qlSach.hienThiDanhSach();
                    } else {
                        System.out.println("Chua co du lieu, hay chon chuc nang 1 truoc!");
                    }
            break;
            case 6:
        System.out.print("Nhập mã sách: ");
        String maNhap = sc.nextLine().trim();
        System.out.print("Nhập số lượng (số nguyên dương): ");
        int soLuongNhap;
        try {
            soLuongNhap = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Số lượng không hợp lệ.");
            break;
        }

        System.out.println("Nhập ngày (năm): ");
        int nam = Integer.parseInt(sc.nextLine());
        System.out.println("Nhập tháng: ");
        int thang = Integer.parseInt(sc.nextLine());
        System.out.println("Nhập ngày: ");
        int ngay = Integer.parseInt(sc.nextLine());

        try {
            LocalDate dateNhap = LocalDate.of(nam, thang, ngay);
            boolean ok = qlNhapKho.nhapKho(maNhap, soLuongNhap, dateNhap);
            if (ok) System.out.println("Nhập kho thành công!");
            else System.out.println("Nhập kho thất bại: mã sách không tồn tại hoặc dữ liệu sai.");
        } catch (Exception ex) {
            System.out.println("Ngày nhập không hợp lệ.");
        }
        break;

            case 7:
        System.out.print("Nhập mã sách cần kiểm tra: ");
        String maCheck = sc.nextLine().trim();

        System.out.println("Nhập ngày bắt đầu (năm): ");
        int y1 = Integer.parseInt(sc.nextLine());
        System.out.println("Nhập tháng bắt đầu: ");
        int m1 = Integer.parseInt(sc.nextLine());
        System.out.println("Nhập ngày bắt đầu: ");
        int d1 = Integer.parseInt(sc.nextLine());

        System.out.println("Nhập ngày kết thúc (năm): ");
        int y2 = Integer.parseInt(sc.nextLine());
        System.out.println("Nhập tháng kết thúc: ");
        int m2 = Integer.parseInt(sc.nextLine());
        System.out.println("Nhập ngày kết thúc: ");
        int d2 = Integer.parseInt(sc.nextLine());

        try {
            LocalDate tu = LocalDate.of(y1, m1, d1);
            LocalDate den = LocalDate.of(y2, m2, d2);
            int tong = qlNhapKho.kiemTraTonKhoTheoKhoangNgay(maCheck, tu, den);
            System.out.println("Tổng số lượng nhập của " + maCheck + " từ " + tu + " đến " + den + " là: " + tong);
        } catch (Exception ex) {
            System.out.println("Ngày không hợp lệ.");
        }
        break;

                case 8:
             System.out.println("Thoat chuong trinh!");
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
            }

        } while(choice != 6);
    sc.close();
    }
}
