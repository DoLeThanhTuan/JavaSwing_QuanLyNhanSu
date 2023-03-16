package model;

import java.util.Date;

public class NhanVienBienChe extends NhanVien{
	private double heSoLuong;

	public NhanVienBienChe(String maNV, String hoTen, Date ngayVaoCoQuan, String gioiTinh, String soCM, Date ngaySinh,
			double heSoLuong) {
		super(maNV, hoTen, ngayVaoCoQuan, gioiTinh, soCM, ngaySinh);
		this.heSoLuong = heSoLuong;
	}

	public NhanVienBienChe() {
		super();
	}

	public double getHeSoLuong() {
		return heSoLuong;
	}

	public void setHeSoLuong(double heSoLuong) {
		this.heSoLuong = heSoLuong;
	}

	
	@Override
	public String toString() {
		return "1, "+this.maNV+", "+this.hoTen+", "+df.format(this.ngayVaoCoQuan)+", "+this.gioiTinh+", "+this.soCM+", "+df.format(ngaySinh)+", "+this.heSoLuong;
	}
	
	@Override
	public double tinhPhuCap() {
		return 0.1*(this.Luongcoban) + this.thamNien()>=10?500000:200000;
	}

	@Override
	public double tinhThucLinh() {
		return this.heSoLuong * this.Luongcoban + this.tinhPhuCap();
	}
	
}
