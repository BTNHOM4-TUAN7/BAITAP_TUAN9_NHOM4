import java.util.Scanner;
public class Test {
    public static void main(String[] args) {
        IQuanLySach quanLy = new QuanLySachImpl();
        Scanner sc = new Scanner(System.in);
        // Tạo sẵn vài sách mẫu
        quanLy.themSach(new SachGiaoTrinh("GT01", "Giai tich 1", "Nguyen Van A", 2022, 10, 50000, "Toan hoc", "Dai hoc"));
        quanLy.themSach(new SachTieuThuyet("TT01", "Harry Potter", "J.K. Rowling", 2010, 3, 120000, "Ky ao", true));
        int chon;
        do {
            System.out.println("\n===== MENU QUAN LY SACH =====");
            System.out.println("1. Hien thi danh sach sach");
            System.out.println("2. Tim sach theo ma");
            System.out.println("3. Xoa sach theo ma");
            System.out.println("4. Kiem tra ton kho & cap nhat vi tri");
            System.out.println("0. Thoat");
            System.out.print("Chon chuc nang: ");
            chon = sc.nextInt();
            sc.nextLine();
            switch (chon) {
                case 1:
                    quanLy.hienThiDanhSach();
                    break;
                case 2:
                    System.out.print("Nhap ma sach can tim: ");
                    String maTim = sc.nextLine();
                    Sach s = quanLy.timKiemTheoMa(maTim);
                    System.out.println((s != null) ? s : "Khong tim thay sach!");
                    break;
                case 3:
                    System.out.print("Nhap ma sach can xoa: ");
                    String maXoa = sc.nextLine();
                    System.out.println(quanLy.xoaSach(maXoa) ? "Da xoa!" : "Khong tim thay!");
                    break;
                case 4:
                    System.out.print("Nhap ma sach can kiem tra: ");
                    String maSach = sc.nextLine();
                    Sach sach = quanLy.timKiemTheoMa(maSach);
                    if (sach != null) {
                        System.out.print("Nhap so luong toi thieu: ");
                        int sl = sc.nextInt(); sc.nextLine();
                        boolean du = sach.kiemTraTonKho(sl);
                        System.out.println("Ton kho: " + (du ? "DU" : "THIEU"));
                        sach.capNhatViTri("Kho A1-Ke 5");
                    } else {
                        System.out.println("Khong tim thay sach!");
                    }
                    break;
                case 0:
                    System.out.println("Thoat chuong trinh!");
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
            }
        } while (chon != 0);
    }
}