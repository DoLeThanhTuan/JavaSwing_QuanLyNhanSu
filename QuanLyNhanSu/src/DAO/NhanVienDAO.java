package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import connectDB.connectSql;
import model.NhanVien;
import model.NhanVienBienChe;
import model.NhanVienHopDong;

public class NhanVienDAO {
	private Connection cnt;
	private PreparedStatement pst;
	private ResultSet rs;
	public static NhanVienDAO getInstance() {
		return new NhanVienDAO();
	}
	public ArrayList<NhanVien> selectAll(){
		ArrayList<NhanVien> list = new ArrayList<>();
		cnt = connectSql.getConnectionSqlServer();
		String cauLenh= "Select * from tbNHANVIEN";
		try {
			pst = cnt.prepareStatement(cauLenh);
			rs = pst.executeQuery();
			while(rs.next()) {
				NhanVien nv;
				if(rs.getString(7).equals("1")) {
					nv = new NhanVienBienChe(
							rs.getString(1),
							rs.getString(2),
							rs.getDate(6),
							rs.getString(3),
							rs.getString(5),
							rs.getDate(4),
							rs.getDouble(8)
							); 
				}
				else {
					nv = new NhanVienHopDong(
							rs.getString(1),
							rs.getString(2),
							rs.getDate(6),
							rs.getString(3),
							rs.getString(5),
							rs.getDate(4),
							rs.getDouble(9)
							); 
					
				}
				list.add(nv);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	public NhanVien selectMaNV(String MaNV){
		NhanVien nv = null;
		cnt = connectSql.getConnectionSqlServer();
		String cauLenh= "Select * from tbNHANVIEN where IDMANHANVIEN = ?";
		try {
			pst = cnt.prepareStatement(cauLenh);
			pst.setString(1, MaNV);
			rs = pst.executeQuery();
			while(rs.next()) {
				if(rs.getString(7).equals("1")) {
					nv = new NhanVienBienChe(
							rs.getString(1),
							rs.getString(2),
							rs.getDate(6),
							rs.getString(3),
							rs.getString(5),
							rs.getDate(4),
							rs.getDouble(8)
							); 
				}
				else {
					nv = new NhanVienHopDong(
							rs.getString(1),
							rs.getString(2),
							rs.getDate(6),
							rs.getString(3),
							rs.getString(5),
							rs.getDate(4),
							rs.getDouble(9)
							); 
					
				}
				connectSql.closeConnectionSqlSever(cnt);
				return nv;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	public int inserṭ̣(NhanVien nv) {
		int kq;
		cnt = connectSql.getConnectionSqlServer();
		String cauLenh = "set dateformat 'dmy' insert tbNHANVIEN values(?,?,?,?,?,?,?,?,?)";
		try {
			pst = cnt.prepareStatement(cauLenh);
			pst.setString(1, nv.getMaNV());
			pst.setString(2, nv.getHoTen());
			pst.setString(3, nv.getGioiTinh());
			pst.setString(4, df.format(nv.getNgaySinh()));
			pst.setString(5, nv.getSoCM());
			pst.setString(6, df.format(nv.getNgayVaoCoQuan()));
			if(nv instanceof NhanVienBienChe) {
				pst.setInt(7, 1);
				pst.setDouble(8, ((NhanVienBienChe)nv).getHeSoLuong());
				pst.setString(9, null);
			}
			if(nv instanceof NhanVienHopDong) {
				pst.setInt(7, 2);
				pst.setDouble(9, ((NhanVienHopDong)nv).getMucLuong());
				pst.setString(8, null);
			}
			kq = pst.executeUpdate();
			connectSql.closeConnectionSqlSever(cnt);
			return kq;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int delete(String MaNV) {
		int kq;
		cnt = connectSql.getConnectionSqlServer();
		String cauLenh = "delete tbNHANVIEN where IDMANHANVIEN = ?";
		try {
			pst = cnt.prepareStatement(cauLenh);
			pst.setString(1, MaNV);
			kq = pst.executeUpdate();
			connectSql.closeConnectionSqlSever(cnt);
			return kq;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	public int update(NhanVien nv) {
		int kq;
		cnt = connectSql.getConnectionSqlServer();
		String cauLenh = "set dateformat 'dmy' update tbNHANVIEN set HOTEN = ?, GIOITINH = ?, NGAYSINH= ?, SOCHUNGMINH = ?, NGAYVAOCOQUAN= ?,IDLOAINHANVIEN= ?, HESOLUONG = ?, MUCLUONG = ? where IDMANHANVIEN = ?";
		try {
			pst = cnt.prepareStatement(cauLenh);
			pst.setString(1, nv.getHoTen());
			pst.setString(2, nv.getGioiTinh());
			pst.setString(3, df.format(nv.getNgaySinh()));
			pst.setString(4, nv.getSoCM());
			pst.setString(5, df.format(nv.getNgayVaoCoQuan()));
			if(nv instanceof NhanVienBienChe) {
				pst.setInt(6, 1);
				pst.setDouble(7, ((NhanVienBienChe)nv).getHeSoLuong());
				pst.setString(8, null);
			}
			if(nv instanceof NhanVienHopDong) {
				pst.setInt(6, 2);
				pst.setString(7, null);
				pst.setDouble(8, ((NhanVienHopDong)nv).getMucLuong());
			}
			pst.setString(9, nv.getMaNV());
			kq = pst.executeUpdate();
			connectSql.closeConnectionSqlSever(cnt);
			return kq;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
}
