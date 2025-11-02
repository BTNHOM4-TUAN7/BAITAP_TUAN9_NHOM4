import java.util.InputMismatchException;
import java.util.Scanner;
public class Test {
    private static Scanner scanner = new Scanner(System.in);
    private static IQuanLySach quanLy = new QuanLySachImpl();
    public static void main(String[] args) {
        themDuLieuMau();
        int choice = 0;
        do {
            hienThiMenu();
            try {
                System.out.print("-> Vui long chon chuc nang (0-7): ");
                choice = scanner.nextInt();
                scanner.nextLine(); // Tiêu thụ ký tự newline
                switch (choice) {
                    case 1:
                        themMoiSachGiaoTrinh();
                        break;
                    case 2:
                        themMoiSachTieuThuyet();
                        break;
                    case 3:
                        quanLy.hienThiDanhSach();
                        break;
                    case 4:
                        timKiemSachTheoMa();
                        break;
                    case 5:
                        xoaSachTheoMa();
                        break;
                    case 6:
                        capNhatSoLuongSach();
                        break;
                    case 7:
                        kiemTraChucNangKiemKe();
                        break;
                    //thêm mới
                    case 8:
                        quanLy.thongKeThuVien();
                        break;
                    case 0:
                        System.out.println("Cam on da su dung chuong trinh. Tam Biet!");
                        break;
                    default:
                        System.out.println("Lua chon khong hop le. Vui long chon tu 0 den 7.");
                }
            } catch (InputMismatchException e) {
                System.out.println("LOI: Vui long nhap so nguyen.");
                scanner.nextLine(); // Xóa bộ đệm đầu vào
                choice = -1; // Đặt lại lựa chọn để vòng lặp tiếp tục
            }
            System.out.println(); // Thêm một dòng trống để dễ nhìn
        } while (choice != 0);
        scanner.close();
    }
    public static void hienThiMenu() {
        System.out.println("========= MENU CHUONG TRINH QUAN LY SACH =========");
        System.out.println("1. Them Sach Giao Trinh moi");
        System.out.println("2. Them Sach Tieu Thuyet moi");
        System.out.println("3. Hien thi toan bo danh sach sach");
        System.out.println("4. Tim kiem theo Ma Sach");
        System.out.println("5. Xoa sach theo Ma Sach");
        System.out.println("6. Cap nhat so luong sach");
        System.out.println("7. Kiem tra chuc nang kiem ke (Ton kho, Vi tri)");
        //---them moi---
        System.out.println("8. Thong ke thu vien");
        System.out.println("0. Thoat chuong trinh");
        System.out.println("====================================================");
    }
    
    private static void themDuLieuMau() {
        System.out.println("...Dang them du lieu mau...");
        // Yêu cầu 4.2: Tạo đối tượng
        Sach sg1 = new SachGiaoTrinh("GT01", "Giai Tich 1", "Nguyen Van A", 2022, 10, 50000, "Toan hoc", "Dai hoc");
        Sach st1 = new SachTieuThuyet("TT01", "Harry Potter P1", "J.K. Rowling", 2010, 5, 120000, "Ky ao", true);
        Sach st2 = new SachTieuThuyet("TT02", "De Men Phieu Luu Ky", "To Hoai", 2015, 20, 45000, "Thieu nhi", false);
        
        quanLy.themSach(sg1);
        quanLy.themSach(st1);
        quanLy.themSach(st2);
        System.out.println();
    }
    private static Sach nhapThongTinSachCoBan(String maSach) {
        System.out.print("Nhap tieu de: ");
        String tieuDe = scanner.nextLine();
        System.out.print("Nhap tac gia: ");
        String tacGia = scanner.nextLine();
        int namXB = nhapSoNguyen("Nhap nam XB: ");
        int soLuong = nhapSoNguyen("Nhap so luong: ");
        double giaCoBan = nhapSoDouble("Nhap gia co ban: ");
        return null; // Sẽ không dùng hàm này
    }
    private static void themMoiSachGiaoTrinh() {
        System.out.println("--- Them Sach Giao Trinh ---");
        System.out.print("Nhap ma sach (vi du: GT02): ");
        String maSach = scanner.nextLine();
        if (quanLy.timKiemSach(maSach) != null) {
            System.out.println("LOI: Ma sach nay da ton tai!");
            return;
        }
        System.out.print("Nhap tieu de: ");
        String tieuDe = scanner.nextLine();
        System.out.print("Nhap tac gia: ");
        String tacGia = scanner.nextLine();
        int namXB = nhapSoNguyen("Nhap nam XB: ");
        int soLuong = nhapSoNguyen("Nhap so luong: ");
        double giaCoBan = nhapSoDouble("Nhap gia co ban: ");
        System.out.print("Nhap mon hoc: ");
        String monHoc = scanner.nextLine();
        System.out.print("Nhap cap do (Dai hoc, cap 3...): ");
        String capDo = scanner.nextLine();
        Sach sg = new SachGiaoTrinh(maSach, tieuDe, tacGia, namXB, soLuong, giaCoBan, monHoc, capDo);
        quanLy.themSach(sg);
    }
    private static void themMoiSachTieuThuyet() {
        System.out.println("--- Them Sach Tieu Thuyet ---");
        System.out.print("Nhap ma sach (vi du: TT03): ");
        String maSach = scanner.nextLine();
        if (quanLy.timKiemSach(maSach) != null) {
            System.out.println("LOI: Ma sach nay da ton tai!");
            return;
        }
        System.out.print("Nhap tieu de: ");
        String tieuDe = scanner.nextLine();
        System.out.print("Nhap tac gia: ");
        String tacGia = scanner.nextLine();
        int namXB = nhapSoNguyen("Nhap nam XB: ");
        int soLuong = nhapSoNguyen("Nhap so luong: ");
        double giaCoBan = nhapSoDouble("Nhap gia co ban: ");
        System.out.print("Nhap the loai (Ky ao, Trinh tham...): ");
        String theLoai = scanner.nextLine();
        boolean laSeries = nhapBoolean("uon sach nay co thuoc series khong (y/n): ");
        Sach st = new SachTieuThuyet(maSach, tieuDe, tacGia, namXB, soLuong, giaCoBan, theLoai, laSeries);
        quanLy.themSach(st);
    }
    private static void timKiemSachTheoMa() {
        System.out.print("Nhap ma sach can tim: ");
        String maSach = scanner.nextLine();
        Sach s = quanLy.timKiemSach(maSach);
        if (s != null) {
            System.out.println("--- Tim thay sach ---");
            System.out.println(s.toString());
        } else {
            System.out.println("-> Khong tim thay sach co ma: " + maSach);
        }
    }
    private static void xoaSachTheoMa() {
        System.out.print("Nhap ma sach can xoa: ");
        String maSach = scanner.nextLine();
        quanLy.xoaSach(maSach); 
    }
    private static void capNhatSoLuongSach() {
        System.out.print("Nhap ma sach can cap nhat so luong: ");
        String maSach = scanner.nextLine();
        int soLuongMoi = nhapSoNguyen("Nhap so luong moi: ");
        quanLy.capNhatSoLuong(maSach, soLuongMoi);
    }
    private static void kiemTraChucNangKiemKe() {
        System.out.print("Nhap ma sach muon kiem ke: ");
        String maSach = scanner.nextLine();
        Sach s = quanLy.timKiemSach(maSach);
        if (s == null) {
            System.out.println("-> Khong tim thay sach co ma: " + maSach);
            return;
        }
        System.out.println("--- Kiem tra ton kho ---");
        int soLuongToiThieu = nhapSoNguyen("Nhap so luong toi thieu can kiem tra: ");
        boolean duHang = s.kiemTraTonKho(soLuongToiThieu); 
        System.out.println("-> Sach '" + s.getTieuDe() + "' (hien co " + s.getSoLuong() + ") " +
                           (duHang ? "Du" : "KHONG DU") + " so luong toi thieu (" + soLuongToiThieu + ").");
        System.out.println("\n--- Cap nhat vị tri ---");
        System.out.print("Nhap vi tri moi (vi du: Ke A1-05): ");
        String viTriMoi = scanner.nextLine();
        s.capNhatViTri(viTriMoi);
    }
    private static int nhapSoNguyen(String message) {
        int number = 0;
        boolean validInput = false;
        while (!validInput) {
            try {
                System.out.print(message);
                number = scanner.nextInt();
                if (number < 0) {
                    System.out.println("LOI: So khong duoc am.");
                } else {
                    validInput = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("LOI: Vui long nhap so nguyen hop le.");
            } finally {
                scanner.nextLine(); 
            }
        }
        return number;
    }
    private static double nhapSoDouble(String message) {
        double number = 0;
        boolean validInput = false;
        while (!validInput) {
            try {
                System.out.print(message);
                number = scanner.nextDouble();
                 if (number < 0) {
                    System.out.println("LOI: So khong duoc am.");
                } else {
                    validInput = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("LOI: Vui long nhap so thuc hop le.");
            } finally {
                scanner.nextLine();
            }
        }
        return number;
    }
    private static boolean nhapBoolean(String message) {
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.equals("y") || input.equals("yes")) {
                return true;
            } else if (input.equals("n") || input.equals("no")) {
                return false;
            } else {
                System.out.println("LOI: Vui long chi nhap 'y' (co) hoac 'n' (khong).");
            }
        }
    }
}
