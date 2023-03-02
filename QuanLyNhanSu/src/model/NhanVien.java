package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class NhanVien implements INhanVien{

	protected String maNV;
	protected String hoTen;
	protected Date ngayVaoCoQuan;
	protected String gioiTinh;
	protected String soCM;
	protected Date ngaySinh;
	
	public NhanVien(String maNV, String hoTen, Date ngayVaoCoQuan, String gioiTinh, String soCM, Date ngaySinh) {
		this.maNV = maNV;
		this.hoTen = hoTen;
		this.ngayVaoCoQuan = ngayVaoCoQuan;
		this.gioiTinh = gioiTinh;
		this.soCM = soCM;
		this.ngaySinh = ngaySinh;
	}
	
	public NhanVien() {
	}

	public SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	
	public String getMaNV() {
		return maNV;
	}

	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public Date getNgayVaoCoQuan() {
		return ngayVaoCoQuan;
	}

	public void setNgayVaoCoQuan(Date ngayVaoCoQuan) {
		this.ngayVaoCoQuan = ngayVaoCoQuan;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getSoCM() {
		return soCM;
	}

	public void setSoCM(String soCM) {
		this.soCM = soCM;
	}

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	@Override
	public abstract String toString();
	
	public int thamNien() {
		Date ngayHienTai = new Date();
		return ngayHienTai.getYear() - this.ngayVaoCoQuan.getYear();
	}
	
	@Override
	public abstract double tinhPhuCap();

	@Override
	public abstract double tinhThucLinh();
	
}
