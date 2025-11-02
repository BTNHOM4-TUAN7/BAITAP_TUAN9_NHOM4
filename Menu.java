package Pack;

public class Menu {
    java.util.Scanner scanner = new java.util.Scanner(System.in);
    private IQuanLySach quanLySach;
    public Menu(IQuanLySach quanLySach){
        this.quanLySach=quanLySach;
    }
    public void hienThiMenu() {
        System.out.println("===== QUAN LY SACH =====");
        System.out.println("1. Hien thi tat ca sach");
        System.out.println("2. Them sach");
        System.out.println("3. Xoa sach");
        System.out.println("4. Cap nhat sach");
        System.out.println("5. Tim kiem sach theo ma");
        System.out.println("6. Kiem ke sach");
        System.out.println("7. Chuyen vi tri sach");
        System.out.println("0. Thoat");
        System.out.print("Chon chuc nang (1-6): ");
    }
    public int chonMenu() {
        int luaChon = Integer.parseInt(scanner.nextLine());
        return luaChon;
    }
    public void xuLyLuaChonKhongHopLe() {
        System.out.println("Lua chon khong hop le. Vui long thu lai.");
    }
    public void hienThiThoat() {
        System.out.println("Thoat chuong trinh. Tam biet!");
    }
    public void xuLyLuaChonMenu(int luaChon) {
        switch (luaChon) {
            case 1:
                quanLySach.hienThiTatCa();
                break;
            case 2:
                themSach(quanLySach);
                break;
            case 3:{
                System.out.print("Nhap ma sach can xoa");
                String s = scanner.nextLine();
                quanLySach.xoaSach(s);
            }
                break;
            case 4:
            {
                int luaChonLoaiSach;
                System.out.print("Nhap ma sach can cap nhat:");
                String s = scanner.nextLine();
                System.out.println("Chon sach can cap nhat:");
                System.out.println("1. Sach giao trinh");
                System.out.println("2. Sach tieu thuyet");
                System.out.println("0. Thoat");
                System.out.print("Nhap lua chon (0-2): ");
                luaChonLoaiSach = Integer.parseInt(scanner.nextLine());
                switch (luaChonLoaiSach) {
                    case 1:
                        {
                            System.out.println("Nhap thong tin sach giao trinh:");
                            System.out.print("Ma sach: ");
                            SachGiaoTrinh sachGiaoTrinh = new SachGiaoTrinh();
                            sachGiaoTrinh.setMaSach(scanner.nextLine());
                            System.out.print("Tieu de: ");
                            sachGiaoTrinh.setTieuDe(scanner.nextLine());
                            System.out.print("Tac gia: ");
                            sachGiaoTrinh.setTacGia(scanner.nextLine());
                            System.out.print("Nam xuat ban: ");
                            sachGiaoTrinh.setnamXuatBan(Integer.parseInt(scanner.nextLine()));
                            System.out.print("So luong: ");
                            sachGiaoTrinh.setSoLuong(Integer.parseInt(scanner.nextLine()));
                            System.out.print("Mon hoc: ");
                            sachGiaoTrinh.setMonHoc(scanner.nextLine());
                            System.out.print("Cap do: ");
                            sachGiaoTrinh.setCapDo(scanner.nextLine());
                            System.out.print("Gia co ban: ");
                            sachGiaoTrinh.setGiaCoBan(Double.parseDouble (scanner.nextLine()));
                            quanLySach.capNhatSach(s, sachGiaoTrinh);
                            System.out.println("Cap nhat thanh cong!");
                        }
                        break;
                    case 2:
                        {
                            System.out.println("Nhap thong tin sach tieu thuyet:");
                            SachTieuThuyet sachTieuThuyet = new SachTieuThuyet();
                            System.out.print("Ma sach: ");
                            sachTieuThuyet.setMaSach(scanner.nextLine());
                            System.out.print("Tieu de: ");
                            sachTieuThuyet.setTieuDe(scanner.nextLine());
                            System.out.print("Tac gia: ");
                            sachTieuThuyet.setTacGia(scanner.nextLine());
                            System.out.print("Nam xuat ban: ");
                            sachTieuThuyet.setnamXuatBan(Integer.parseInt(scanner.nextLine()));
                            System.out.print("So luong: ");
                            sachTieuThuyet.setSoLuong(Integer.parseInt(scanner.nextLine()));
                            System.out.print("The loai: ");
                            sachTieuThuyet.setTheLoai(scanner.nextLine());
                            System.out.print("La sach serie (true/false): ");
                            sachTieuThuyet.setLaSachSerie(Boolean.parseBoolean(scanner.nextLine()));
                            System.out.print("Gia co ban: ");
                            sachTieuThuyet.setGiaCoBan(Double.parseDouble(scanner.nextLine()));
                            quanLySach.capNhatSach(s, sachTieuThuyet);
                            System.out.println("Cap nhat thanh cong!");
                        }
                        break;
                    default:
                        xuLyLuaChonKhongHopLe();
                    break;
            }
            }
                break;
            case 5:
                {
                    System.out.println("Nhap ma can tim:");
                    String s = scanner.nextLine();
                    if(quanLySach.timKiemTheoMa(s) != null){
                        System.out.println("Da tim thay sch \nThong tin sach la:"+quanLySach.timKiemTheoMa(s).toString());
                    }
                    else {
                        System.out.println("Khong ton tai.");
                    }

                }
                break;
            case 6:{
                System.out.print("Nhap ma sach can kiem ke:");
                String s = scanner.nextLine();
                System.out.println(quanLySach.timKiemTheoMa(s).kiemTraTonKho(1));
            }
                break;
                case 7:{
                    System.out.print("Nhap ma sach can chuyen di:");
                    String s = scanner.nextLine();
                    System.out.print("Nhap vi tri se chuyen di:");
                    String viTri = scanner.nextLine();
                    quanLySach.timKiemTheoMa(s).capNhatViTri(viTri);
                } 
                break;
            case 0: hienThiThoat();
            default:
                    xuLyLuaChonKhongHopLe();
                break;
        }
    }
    //private void xoaSach(){
        
    //}
    private void themSach(IQuanLySach quanLySach) {
        int luaChonLoaiSach;
        do{
            
            System.out.println("Lua chon sach can nhap thong tin:");
            System.out.println("1. Sach giao trinh");
            System.out.println("2. Sach tieu thuyet");
            System.out.println("0. Thoat");
            System.out.print("Nhap lua chon (0-2): ");
            luaChonLoaiSach = Integer.parseInt(scanner.nextLine());
            switch (luaChonLoaiSach) {
                case 1:
                    {
                        System.out.println("Nhap thong tin sach giao trinh:");
                        System.out.print("Ma sach: ");
                        SachGiaoTrinh sachGiaoTrinh = new SachGiaoTrinh();
                        sachGiaoTrinh.setMaSach(scanner.nextLine());
                        System.out.print("Tieu de: ");
                        sachGiaoTrinh.setTieuDe(scanner.nextLine());
                        System.out.print("Tac gia: ");
                        sachGiaoTrinh.setTacGia(scanner.nextLine());
                        System.out.print("Nam xuat ban: ");
                        sachGiaoTrinh.setnamXuatBan(Integer.parseInt(scanner.nextLine()));
                        System.out.print("So luong: ");
                        sachGiaoTrinh.setSoLuong(Integer.parseInt(scanner.nextLine()));
                        System.out.print("Mon hoc: ");
                        sachGiaoTrinh.setMonHoc(scanner.nextLine());
                        System.out.print("Cap do: ");
                        sachGiaoTrinh.setCapDo(scanner.nextLine());
                        System.out.print("Gia co ban: ");
                        sachGiaoTrinh.setGiaCoBan(Double.parseDouble (scanner.nextLine()));
                        quanLySach.themSach(sachGiaoTrinh);
                    }
                    break;
                case 2:
                    {
                        System.out.println("Nhap thong tin sach tieu thuyet:");
                        SachTieuThuyet sachTieuThuyet = new SachTieuThuyet();
                        System.out.print("Ma sach: ");
                        sachTieuThuyet.setMaSach(scanner.nextLine());
                        System.out.print("Tieu de: ");
                        sachTieuThuyet.setTieuDe(scanner.nextLine());
                        System.out.print("Tac gia: ");
                        sachTieuThuyet.setTacGia(scanner.nextLine());
                        System.out.print("Nam xuat ban: ");
                        sachTieuThuyet.setnamXuatBan(Integer.parseInt(scanner.nextLine()));
                        System.out.print("So luong: ");
                        sachTieuThuyet.setSoLuong(Integer.parseInt(scanner.nextLine()));
                        System.out.print("The loai: ");
                        sachTieuThuyet.setTheLoai(scanner.nextLine());
                        System.out.print("La sach serie (true/false): ");
                        sachTieuThuyet.setLaSachSerie(Boolean.parseBoolean(scanner.nextLine()));
                        System.out.print("Gia co ban: ");
                        sachTieuThuyet.setGiaCoBan(Double.parseDouble(scanner.nextLine()));
                        quanLySach.themSach(sachTieuThuyet);
                    }
                    break;
                default:
                    xuLyLuaChonKhongHopLe();
                    break;
            }
        }while( luaChonLoaiSach != 0 );
        int luaChon = 0;
        xuLyLuaChonMenu(luaChon);
    }
}
