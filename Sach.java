package Pack;
public abstract class Sach implements IGiaBan, IKiemKe {
		protected String maSach;
		protected String tieuDe;
		protected String tacGia;
		protected int namXuatBan;
		protected int soLuong;
		protected double giaCoBan;
		
		void setMaSach(String maSach) {
			this.maSach=maSach;
		}
		String getMaSach() {
			return this.maSach;
		}
		void setTieuDe(String tieuDe) {
			this.tieuDe=tieuDe;
		}
		String getTieuDe() {
			return this.tieuDe;
		}
		void setTacGia(String tacGia) {
			this.tacGia=tacGia;
		}
		String getTacGia() {
			return this.tacGia;
		}
		void setnamXuatBan(int namXuatBan) {
			this.namXuatBan=namXuatBan;
		}
		int getNamXuatBan() {
			return this.namXuatBan;
		}
		void setSoLuong(int soLuong) {
			this.soLuong=soLuong;
		}
		int getSoLuong() {
			return this.soLuong;
		}
		void setGiaCoBan(double giaCoBan) {
			this.giaCoBan=giaCoBan;
		}
		double getGiaCoBan() {
			return this.giaCoBan;
		}
		public Sach(String maSach, String tieuDe, String tacGia,int namXuatBan, int soLuong, double giaCoBan) {
			this.maSach=maSach;
			this.tieuDe=tieuDe;
			this.tacGia=tacGia;
			this.namXuatBan=namXuatBan;
			this.soLuong=soLuong;
			this.giaCoBan=giaCoBan;
		}
		public Sach() {
		}
		public String toString() {
        return  "maSach='" + this.maSach + '\'' +
                ", tenSach='" + this.tieuDe + '\'' +
                ", tacGia='" + this.tacGia + '\'' +
				", Nam xuat ban=" + this.namXuatBan +
                ", So luong=" + this.soLuong ;      
    	}	
		public abstract double tinhGiaBan();
		public boolean kiemTraTonKho(int soLuongToiThieu) {
            return this.soLuong >= soLuongToiThieu;
        }
		public void capNhatViTri(String viTriMoi) {
            System.out.println("Da chuyen sach "+this.tieuDe+ " den khu vuc: " + viTriMoi);
        }
	}
