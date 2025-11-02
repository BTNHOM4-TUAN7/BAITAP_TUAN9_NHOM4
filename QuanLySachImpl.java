import java.util.ArrayList;
import java.util.List;
public class QuanLySachImpl implements IQuanLySach 
{
    private List<Sach> dsSach = new ArrayList<>();
    @Override
    public void themSach(Sach s) 
    {
        dsSach.add(s);
    }
    @Override
    public Sach timKiemTheoMa(String maSach)
    {
        for (Sach s : dsSach) {
            if (s.getMaSach().equalsIgnoreCase(maSach)) 
            {
                return s;
            }
        }
        return null;
    }
    @Override
    public boolean xoaSach(String maSach) 
    {
        Sach s = timKiemTheoMa(maSach);
        if (s != null) {
            dsSach.remove(s);
            return true;
        }
        return false;
    }
    @Override
    public void hienThiDanhSach() 
    {
        for (Sach s : dsSach) {
            System.out.println(s.toString());
        }
    }
    @Override
    public List<Sach> getDanhSach() 
    {
        return dsSach;
    }
}