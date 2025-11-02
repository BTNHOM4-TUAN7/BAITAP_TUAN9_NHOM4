package Pack;

//import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        IQuanLySach quanLySach= new QuanLySach();

        SachGiaoTrinh gt1 = new SachGiaoTrinh("gt01", "Lap trinh huong doi tuong", "Kinh", 2023, 56, "Lap trinh Java", "Dai hoc", 20000, 2);

        SachGiaoTrinh gt2 = new SachGiaoTrinh("gt02", "Cau truc du lieu va giai thuat", "An", 2022, 48, "CTDL & GT", "Dai hoc", 18000, 3);

        SachGiaoTrinh gt3 = new SachGiaoTrinh("gt03", "Co so du lieu", "Binh", 2021, 0, "SQL va He quan tri CSDL", "Cao dang", 22000, 1);

        SachTieuThuyet tt1 = new SachTieuThuyet("tt01", "Ke huy diet", "Nguyen Van Muoi", 2016, 62, "Trinh tham", true, 35000);

        SachTieuThuyet tt2 = new SachTieuThuyet("tt02", "Mat troi dem", "Le Thi Lan", 2019, 70, "Tinh cam", false, 42000);

        SachTieuThuyet tt3 = new SachTieuThuyet("tt03", "Bong toi cuoi duong", "Tran Quang", 2021, 80, "Tam ly xa hoi", true, 50000);
        quanLySach.themSach(gt1);
        quanLySach.themSach(gt2);
        quanLySach.themSach(gt3);
        quanLySach.themSach(tt1);
        quanLySach.themSach(tt2);
        quanLySach.themSach(tt3);
        Menu menu=new Menu(quanLySach);
        int luaChon;
        do{
            menu.hienThiMenu();
            luaChon=menu.chonMenu();
            menu.xuLyLuaChonMenu(luaChon);
        }while(luaChon != 0);
    }
}