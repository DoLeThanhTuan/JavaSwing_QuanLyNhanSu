package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import DAO.NhanVienDAO;

public class DanhSachNhanVienModel implements IIO{
	ArrayList<NhanVien> dsnv;

	public DanhSachNhanVienModel(ArrayList<NhanVien> dsnv) {
		this.dsnv = dsnv;
	}
	
	public DanhSachNhanVienModel() {
		this.dsnv = new ArrayList<>();
	}

	public ArrayList<NhanVien> getDsnv() {
		return dsnv;
	}

	public void setDsnv(ArrayList<NhanVien> dsnv) {
		this.dsnv = dsnv;
	}
	SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	public boolean themNV(NhanVien nv) {
		return this.dsnv.add(nv);
	}
	public NhanVien TimNV(String MNV) {
		for (NhanVien nhanVien : dsnv) {
			if(nhanVien.getMaNV().equals(MNV))
				return nhanVien;
		}
		return null;
	}
	public boolean xoaNV(String MNV) {
		for (NhanVien nhanVien : dsnv) {
			if(nhanVien.getMaNV().equals(MNV))
				return this.dsnv.remove(nhanVien);
		}
		return false;
	}
	public void inDS() {
		for (NhanVien nhanVien : dsnv) {
			System.out.println(nhanVien);
		}
	}
	public void suaNV(NhanVien nv) {
		for (NhanVien nhanVien : dsnv) {
			if(nhanVien.getMaNV().equals(nv.getMaNV())) {
				nhanVien.setHoTen(nv.getHoTen());
				nhanVien.setNgayVaoCoQuan(nv.getNgayVaoCoQuan());
				nhanVien.setGioiTinh(nv.getGioiTinh());
				nhanVien.setSoCM(nv.getSoCM());
				nhanVien.setNgaySinh(nv.getNgaySinh());
				if(nv instanceof NhanVienBienChe)
					((NhanVienBienChe)nhanVien).setHeSoLuong(((NhanVienBienChe) nv).getHeSoLuong());
				else
					((NhanVienHopDong)nhanVien).setMucLuong(((NhanVienHopDong)nv).getMucLuong());
			}
		}
	}
	public double tongLuong() {
		double tong = 0;
		for (NhanVien nhanVien : dsnv) {
			tong+=nhanVien.tinhThucLinh();
		}
		return tong;
	}

	@Override
	public void ReadFile(String pathFile) {
		File f = new File(pathFile);
		FileReader fr;
		try {
			fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			try {
				String line = br.readLine();
				while(line!=null) {
					String text[] = line.split(", ");
					if(text[0].equals("1")) {
						NhanVien nv = new NhanVienBienChe();
						nv.setMaNV(text[1]);
						nv.setHoTen(text[2]);
						try {
							nv.setNgayVaoCoQuan(df.parse(text[3]));
							nv.setNgaySinh(df.parse(text[6]));
						} catch (ParseException e) {
							e.printStackTrace();
						}
						nv.setGioiTinh(text[4]);
						nv.setSoCM(text[5]);
						((NhanVienBienChe)nv).setHeSoLuong(Double.parseDouble(text[7]));
						this.dsnv.add(nv);
					}
					else if(text[0].equals("2")) {
						NhanVien nv = new NhanVienHopDong();
						nv.setMaNV(text[1]);
						nv.setHoTen(text[2]);
						try {
							nv.setNgayVaoCoQuan(df.parse(text[3]));
							nv.setNgaySinh(df.parse(text[6]));
						} catch (ParseException e) {
							e.printStackTrace();
						}
						nv.setGioiTinh(text[4]);
						nv.setSoCM(text[5]);
						((NhanVienHopDong)nv).setMucLuong(Double.parseDouble(text[7]));
						this.dsnv.add(nv);
					}
					line = br.readLine();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void WriteFile(String pathFile) {
		File f = new File(pathFile);
		FileWriter fw;
		try {
			fw = new FileWriter(f);
			BufferedWriter bw = new BufferedWriter(fw);
			for (NhanVien nhanVien : dsnv) {
				bw.write(nhanVien.toString());
				bw.newLine();
			}
			bw.flush();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void LayDuLieuTuSQL() {
		this.dsnv = NhanVienDAO.getInstance().selectAll();
	}
}
