package Pack;

public class SachTieuThuyet extends Sach {
        private String theLoai;
        private Boolean laSachSerie;
        String getTheLoai() {
            return theLoai;
        }
        void setTheLoai(String theLoai){
            this.theLoai = theLoai;
        }
        Boolean getlaSachSerie() {
            return this.laSachSerie;
        }
        void setLaSachSerie(Boolean laSachSerie){
            this.laSachSerie = laSachSerie;
        }
        public SachTieuThuyet(String maSach, String tieuDe, String tacGia, int namXuatBan, int soLuong, String theLoai, Boolean laSachSerie, double giaCoBan) {
            super(maSach, tieuDe, tacGia, namXuatBan, soLuong,giaCoBan);
            this.theLoai = theLoai;
            this.laSachSerie = laSachSerie;
        }
        @Override
        public String toString() {
            return super.toString() +
                    ", The loai='" + this.theLoai + '\'' +
                    ", La sach serie=" + (this.laSachSerie ? "Co" : "Khong") +
                    ", gia ban=" + tinhGiaBan() +'}';
        }
        public SachTieuThuyet(){
            super();
        }
        @Override
        public double tinhGiaBan() {
            if (this.laSachSerie) {
                return super.getGiaCoBan() + 15000;
            } else {
                return super.getGiaCoBan();
            }
        }
}
