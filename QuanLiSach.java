

import java.util.ArrayList;

public class QuanLiSach {
    private ArrayList<Sach> dsSach;

    public QuanLiSach() {
        dsSach = new ArrayList<>();
    }

    public void themSach(Sach b) {
        dsSach.add(b);
    }

    public void hienThiTatCa() {
        System.out.println("===== DANH SÁCH SÁCH =====");
        for (Sach b : dsSach) {
            System.out.println(b);
        }
    }
}
