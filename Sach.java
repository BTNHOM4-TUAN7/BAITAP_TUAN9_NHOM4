
public abstract class Sach implements IGiaBan,IKiemKe
{
    private String maSach;
    private String tieuDe;
    private String tacGia;
    private int namXuatBan;
    private int soLuong;
    protected double giaCoBan;
    protected String viTri; 
    // Constructor mặc định
    public Sach(){}
    // Constructor có tham số 
    public Sach(String maSach, String tieuDe, String tacGia, int namXuatBan, int soLuong,double giaCoBan,String viTri) {
        this.maSach = maSach;
        this.tieuDe = tieuDe;
        this.tacGia = tacGia;
        this.namXuatBan = namXuatBan;
        this.soLuong = soLuong;
        this.giaCoBan=giaCoBan;
        this.viTri=viTri;
}
//getter, setter
public String getMaSach() {
        return maSach;
    }
    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }
    public String getTieuDe() {
        return tieuDe;
    }
    public void setTieuDe(String tieuDe) 
    {
        this.tieuDe = tieuDe;
    }
    public String getTacGia() 
    {
        return tacGia;
    }
    public void setTacGia(String tacGia) 
    {
        this.tacGia = tacGia;
    }
    public int getNamXuatBan() 
    {
        return namXuatBan;
    }
    public void setNamXuatBan(int namXuatBan) 
    {
        this.namXuatBan = namXuatBan;
    }
    public int getSoLuong()
     {
        return soLuong;
    }
    public void setSoLuong(int soLuong) 
    {
        this.soLuong = soLuong;
    }
    public double getGiaCoBan()
    {
        return giaCoBan;
    }
    public void setGiaCoBan( double giaCoBan)
    {
        this.giaCoBan=giaCoBan;
    }
    public String getViTri(){
        return viTri;
    }
    public void setViTri(String viTri){
        this.viTri=viTri;
    }
        public abstract double tinhGiaBan();

    public void hienThiThongTin()
    {
     System.out.println(this.toString());
    }
    // Phương thức toString()
    @Override
    public String toString() {
        return "Ma sach: " + maSach + 
               ", Tieu de: " + tieuDe +
               ", Tac gia: " + tacGia +
               ", Nam xuat ban: " + namXuatBan +
               ", So luong: " + soLuong +
               ", Gia co ban: " +giaCoBan;
    }
}