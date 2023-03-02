package model;

import java.util.Date;

public class NhanVienHopDong extends NhanVien{
	private double mucLuong;

	public NhanVienHopDong(String maNV, String hoTen, Date ngayVaoCoQuan, String gioiTinh, String soCM, Date ngaySinh,
			double mucLuong) {
		super(maNV, hoTen, ngayVaoCoQuan, gioiTinh, soCM, ngaySinh);
		this.mucLuong = mucLuong;
	}

	public NhanVienHopDong() {
		super();
	}

	public double getMucLuong() {
		return mucLuong;
	}

	public void setMucLuong(double mucLuong) {
		this.mucLuong = mucLuong;
	}


	@Override
	public String toString() {
		return "2, "+this.maNV+", "+this.hoTen+", "+df.format(this.ngayVaoCoQuan)+", "+this.gioiTinh+", "+this.soCM+", "+df.format(ngaySinh)+", "+this.mucLuong;
	}

	@Override
	public double tinhPhuCap() {
		return 0.1*(this.mucLuong) + this.thamNien()>=2?200000:100000;
	}

	@Override
	public double tinhThucLinh() {
		return this.Luongcoban + this.mucLuong + this.tinhPhuCap();
	}
	
	
	
}
