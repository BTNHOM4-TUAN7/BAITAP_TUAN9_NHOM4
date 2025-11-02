import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        IQuanLySach ql = new QuanLySachImpl();

        int chon;
        do {
            System.out.println("\n===== MENU QUAN LY SACH =====");
            System.out.println("1. Them sach giao trinh");
            System.out.println("2. Them sach tieu thuyet");
            System.out.println("3. Hien thi danh sach");
            System.out.println("4. Xoa sach theo ma");
            System.out.println("5. Cap nhat so luong");
            System.out.println("6. Kiem tra ton kho (IKiemKe)");
            System.out.println("7. Tinh tong gia tri kho");
            System.out.println("8. Sap xep sach theo gia ban giam dan");
            System.out.println("0. Thoat");
            System.out.print("Chon: ");
            chon = sc.nextInt();
            sc.nextLine();

            switch (chon) {
                case 1 -> {
                    System.out.print("Ma sach: "); String ma = sc.nextLine();
                    System.out.print("Tieu de: "); String td = sc.nextLine();
                    System.out.print("Tac gia: "); String tg = sc.nextLine();
                    System.out.print("Nam XB: "); int nam = sc.nextInt(); sc.nextLine();
                    System.out.print("So luong: "); int sl = sc.nextInt(); sc.nextLine();
                    System.out.print("Gia co ban: "); double gia = sc.nextDouble(); sc.nextLine();
                    System.out.print("Mon hoc: "); String mh = sc.nextLine();
                    System.out.print("Cap do: "); String cd = sc.nextLine();
                    ql.themSach(new SachGiaoTrinh(ma, td, tg, nam, sl, gia, mh, cd));
                }
                case 2 -> {
                    System.out.print("Ma sach: "); String ma = sc.nextLine();
                    System.out.print("Tieu de: "); String td = sc.nextLine();
                    System.out.print("Tac gia: "); String tg = sc.nextLine();
                    System.out.print("Nam XB: "); int nam = sc.nextInt(); sc.nextLine();
                    System.out.print("So luong: "); int sl = sc.nextInt(); sc.nextLine();
                    System.out.print("Gia co ban: "); double gia = sc.nextDouble(); sc.nextLine();
                    System.out.print("The loai: "); String tl = sc.nextLine();
                    System.out.print("Co phai series khong (true/false): ");
                    boolean series = sc.nextBoolean(); sc.nextLine();
                    ql.themSach(new SachTieuThuyet(ma, td, tg, nam, sl, gia, tl, series));
                }
                case 3 -> ql.hienThiDanhSach();
                case 4 -> {
                    System.out.print("Nhap ma can xoa: ");
                    String ma = sc.nextLine();
                    System.out.println(ql.xoaSach(ma) ? "Da xoa." : "Khong tim thay ma sach.");
                }
                case 5 -> {
                    System.out.print("Nhap ma sach can cap nhat: ");
                    String ma = sc.nextLine();
                    System.out.print("So luong moi: ");
                    int sl = sc.nextInt(); sc.nextLine();
                    System.out.println(ql.capNhatSoLuong(ma, sl) ? "Cap nhat thanh cong." : "Khong tim thay sach.");
                }
                case 6 -> {
                    System.out.print("Nhap ma sach can kiem tra: ");
                    String ma = sc.nextLine();
                    Sach s = ql.timKiemTheoMa(ma);
                    if (s != null) {
                        System.out.print("Nhap so luong toi thieu: ");
                        int sl = sc.nextInt(); sc.nextLine();
                        boolean du = s.kiemTraTonKho(sl);
                        System.out.println("Ket qua: " + (du ? "Du hang" : "Thieu hang"));
                        s.capNhatViTri("Kho A1");
                    } else {
                        System.out.println("Khong tim thay sach.");
                    }
                }
                case 7 -> {
                    double tong = ql.tinhTongGiaTriKho();
                    System.out.printf("Tong gia tri kho: %,.0f VND%n", tong);
                }
                case 8 -> ql.sapXepTheoGiaBanGiamDan();
                case 0 -> System.out.println("Thoat chuong trinh!");
                default -> System.out.println("Lua chon khong hop le!");
            }

        } while (chon != 0);
    }
}
