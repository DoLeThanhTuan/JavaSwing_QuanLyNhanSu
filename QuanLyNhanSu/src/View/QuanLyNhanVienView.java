package View;

import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Controller.QuanLyNhanVienController;
import DAO.NhanVienDAO;
import model.DanhSachNhanVienModel;
import model.NhanVien;
import model.NhanVienBienChe;
import model.NhanVienHopDong;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;

public class QuanLyNhanVienView extends JFrame {

	private DanhSachNhanVienModel model;
	private JTextField tf_MNV;
	private JTextField tf_hoTen;
	private JLabel lb_ngaySinh;
	private JTextField tf_ngaySinh;
	private JLabel lb_gioiTinh;
	private JTextField tf_soCM;
	private JLabel lb_soCM;
	private JTextField tf_ngayVaoCoQuan;
	private JLabel lb_ngayVaoCoQuan;
	private JRadioButton rdobt_Nam;
	private JRadioButton rdobt_Nu;
	private ButtonGroup btgroupGioiTinh;
	private JRadioButton rdobt_NVBC;
	private JRadioButton rdobt_NVHD;
	private ButtonGroup btgroupNV;
	private JTable table;
	private JLabel lb_heSoLuong;
	private JTextField tf_hsLuong;
	private JLabel lb_mucLuong;
	private JTextField tf_mucLuong;
	private String nutTrc = "";
	private JButton bt_Chon;
	private JButton bt_Sua;
	private JTable table_Find;
	private JButton bt_Tim;
	private JButton bt_huy;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_Find;

	public QuanLyNhanVienView() {
		this.model = new DanhSachNhanVienModel();
		setFont(new Font("Arial", Font.PLAIN, 20));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Quản Lý Nhân Viên");
		setBounds(100, 100, 736, 667);
		QuanLyNhanVienController ac = new QuanLyNhanVienController(this);

		this.setLayout(null);

		JLabel lb_MNV = new JLabel("Mã nhân viên");
		lb_MNV.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lb_MNV.setBounds(100, 20, 105, 30);
		this.add(lb_MNV);

		tf_MNV = new JTextField();
		tf_MNV.setFont(new Font("Tahoma", Font.PLAIN, 17));
		tf_MNV.setBounds(250, 20, 295, 30);
		this.add(tf_MNV);
		tf_MNV.setColumns(10);

		JLabel lb_hoTen = new JLabel("Họ tên");
		lb_hoTen.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lb_hoTen.setBounds(100, 60, 105, 30);
		this.add(lb_hoTen);

		tf_hoTen = new JTextField();
		tf_hoTen.setFont(new Font("Tahoma", Font.PLAIN, 17));
		tf_hoTen.setColumns(10);
		tf_hoTen.setBounds(250, 60, 295, 30);
		this.add(tf_hoTen);

		lb_ngaySinh = new JLabel("Ngày sinh");
		lb_ngaySinh.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lb_ngaySinh.setBounds(100, 140, 105, 30);
		this.add(lb_ngaySinh);

		tf_ngaySinh = new JTextField();
		tf_ngaySinh.setFont(new Font("Tahoma", Font.PLAIN, 17));
		tf_ngaySinh.setColumns(10);
		tf_ngaySinh.setBounds(250, 141, 295, 30);
		this.add(tf_ngaySinh);

		lb_gioiTinh = new JLabel("Giới tính");
		lb_gioiTinh.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lb_gioiTinh.setBounds(100, 100, 105, 30);
		this.add(lb_gioiTinh);

		rdobt_Nam = new JRadioButton("Nam");
		rdobt_Nam.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rdobt_Nam.setBounds(250, 105, 79, 21);
		this.add(rdobt_Nam);

		rdobt_Nu = new JRadioButton("Nữ");
		rdobt_Nu.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rdobt_Nu.setBounds(400, 105, 73, 21);
		this.add(rdobt_Nu);

		btgroupGioiTinh = new ButtonGroup();
		btgroupGioiTinh.add(rdobt_Nu);
		btgroupGioiTinh.add(rdobt_Nam);

		tf_soCM = new JTextField();
		tf_soCM.setFont(new Font("Tahoma", Font.PLAIN, 17));
		tf_soCM.setColumns(10);
		tf_soCM.setBounds(250, 181, 295, 30);
		this.add(tf_soCM);

		lb_soCM = new JLabel("Số CM");
		lb_soCM.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lb_soCM.setBounds(100, 180, 105, 30);
		this.add(lb_soCM);

		tf_ngayVaoCoQuan = new JTextField();
		tf_ngayVaoCoQuan.setFont(new Font("Tahoma", Font.PLAIN, 17));
		tf_ngayVaoCoQuan.setColumns(10);
		tf_ngayVaoCoQuan.setBounds(250, 222, 295, 30);
		this.add(tf_ngayVaoCoQuan);

		lb_ngayVaoCoQuan = new JLabel("Ngày vào cơ quan");
		lb_ngayVaoCoQuan.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lb_ngayVaoCoQuan.setBounds(100, 221, 142, 30);
		this.add(lb_ngayVaoCoQuan);

		rdobt_NVBC = new JRadioButton("Nhân viên biên chế");
		rdobt_NVBC.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				NVBC();
			}
		});
		rdobt_NVBC.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rdobt_NVBC.setBounds(127, 269, 181, 21);
		this.add(rdobt_NVBC);

		rdobt_NVHD = new JRadioButton("Nhân viên hợp đồng");
		rdobt_NVHD.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				NVHD();
			}
		});
		rdobt_NVHD.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rdobt_NVHD.setBounds(375, 269, 205, 21);
		this.add(rdobt_NVHD);

		btgroupNV = new ButtonGroup();
		btgroupNV.add(rdobt_NVBC);
		btgroupNV.add(rdobt_NVHD);

		JButton bt_Them = new JButton("Thêm");
		bt_Them.addActionListener(ac);
		bt_Them.setFont(new Font("Tahoma", Font.BOLD, 17));
		bt_Them.setBounds(10, 360, 105, 30);
		this.add(bt_Them);

		JButton bt_Xoa = new JButton("Xóa");
		bt_Xoa.addActionListener(ac);
		bt_Xoa.setFont(new Font("Tahoma", Font.BOLD, 17));
		bt_Xoa.setBounds(130, 360, 105, 30);
		this.add(bt_Xoa);

		bt_Sua = new JButton("Sửa");
		bt_Sua.addActionListener(ac);
		bt_Sua.setFont(new Font("Tahoma", Font.BOLD, 17));
		bt_Sua.setBounds(250, 362, 105, 27);
		this.add(bt_Sua);

		bt_Tim = new JButton("Tìm");
		bt_Tim.addActionListener(ac);
		bt_Tim.setFont(new Font("Tahoma", Font.BOLD, 17));
		bt_Tim.setBounds(370, 360, 105, 27);
		this.add(bt_Tim);

		bt_huy = new JButton("Hủy tìm");
		bt_huy.addActionListener(ac);
		bt_huy.setFont(new Font("Tahoma", Font.BOLD, 17));
		bt_huy.setBounds(370, 360, 105, 27);
		this.add(bt_huy);
		bt_huy.setVisible(false);

		JButton bt_DocFile = new JButton("Đọc File");
		bt_DocFile.addActionListener(ac);
		bt_DocFile.setFont(new Font("Tahoma", Font.BOLD, 17));
		bt_DocFile.setBounds(490, 360, 105, 27);
		this.add(bt_DocFile);
		JButton bt_GhiFile = new JButton("Ghi File");
		bt_GhiFile.addActionListener(ac);
		bt_GhiFile.setBounds(610, 360, 105, 27);
		bt_GhiFile.setFont(new Font("Tahoma", Font.BOLD, 17));
		this.add(bt_GhiFile);

		table = new JTable();
		table.addMouseListener(ac);
		table.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Mã nhân viên", "Họ tên", "Giới tính",
				"Ngày sinh", "Số CM", "Ngày vào cơ quan", "Hệ số lương", "Mức lương" }));
		table.setBounds(0, 0, 1, 1);

		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(22, 400, 678, 220);
		this.add(scrollPane);

		table_Find = new JTable();
		table_Find.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		table_Find.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Mã nhân viên", "Họ tên",
				"Giới tính", "Ngày sinh", "Số CM", "Ngày vào cơ quan", "Hệ số lương", "Mức lương" }));
		table_Find.setBounds(0, 0, 1, 1);

		scrollPane_Find = new JScrollPane(table_Find);
		scrollPane_Find.setBounds(22, 400, 678, 220);
		this.add(scrollPane_Find);

		lb_heSoLuong = new JLabel("Hệ số lương");
		lb_heSoLuong.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lb_heSoLuong.setBounds(77, 308, 96, 30);
		this.add(lb_heSoLuong);

		tf_hsLuong = new JTextField();
		tf_hsLuong.setFont(new Font("Tahoma", Font.PLAIN, 17));
		tf_hsLuong.setColumns(10);
		tf_hsLuong.setBounds(179, 308, 160, 30);
		tf_hsLuong.setEnabled(false);
		this.add(tf_hsLuong);

		lb_mucLuong = new JLabel("Mức lương");
		lb_mucLuong.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lb_mucLuong.setBounds(382, 307, 87, 30);
		this.add(lb_mucLuong);

		tf_mucLuong = new JTextField();
		tf_mucLuong.setFont(new Font("Tahoma", Font.PLAIN, 17));
		tf_mucLuong.setColumns(10);
		tf_mucLuong.setBounds(484, 307, 160, 30);
		tf_mucLuong.setEnabled(false);
		this.add(tf_mucLuong);
		this.hienThiDuLieuSQL();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");

	public NhanVien getNhanVien() {
		if (this.rdobt_NVBC.isSelected()) {
			NhanVien nv = new NhanVienBienChe();
			nv.setMaNV(this.tf_MNV.getText());
			nv.setHoTen(this.tf_hoTen.getText());
			if (this.rdobt_Nam.isSelected())
				nv.setGioiTinh("Nam");
			else
				nv.setGioiTinh("Nữ");
			try {
				nv.setNgaySinh(df.parse(this.tf_ngaySinh.getText()));
				nv.setNgayVaoCoQuan(df.parse(this.tf_ngayVaoCoQuan.getText()));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			nv.setSoCM(this.tf_soCM.getText());
			((NhanVienBienChe) nv).setHeSoLuong(Double.parseDouble(this.tf_hsLuong.getText()));
			return nv;
		} else if (this.rdobt_NVHD.isSelected()) {
			NhanVien nv = new NhanVienHopDong();
			nv.setMaNV(this.tf_MNV.getText());
			nv.setHoTen(this.tf_hoTen.getText());
			if (this.rdobt_Nam.isSelected())
				nv.setGioiTinh("Nam");
			else
				nv.setGioiTinh("Nữ");
			try {
				nv.setNgaySinh(df.parse(this.tf_ngaySinh.getText()));
				nv.setNgayVaoCoQuan(df.parse(this.tf_ngayVaoCoQuan.getText()));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			nv.setSoCM(this.tf_soCM.getText());
			((NhanVienHopDong) nv).setMucLuong(Double.parseDouble(this.tf_mucLuong.getText()));
			return nv;
		}
		return null;
	}

	public void ThemNV() {
		this.nutTrc = "Thêm";
		NhanVien nv = getNhanVien();
		if (nv != null) {
			this.model.themNV(nv);
			DefaultTableModel tableModel = (DefaultTableModel) this.table.getModel();
			tableModel.addRow(new Object[] { nv.getMaNV(), nv.getHoTen(), nv.getGioiTinh(), df.format(nv.getNgaySinh()),
					nv.getSoCM(), df.format(nv.getNgayVaoCoQuan()),
					nv instanceof NhanVienBienChe ? ((NhanVienBienChe) nv).getHeSoLuong() : null,
					nv instanceof NhanVienHopDong ? ((NhanVienHopDong) nv).getMucLuong() : null });
			int kq = NhanVienDAO.getInstance().inserṭ̣(nv);
			JOptionPane.showMessageDialog(this, "Có "+ kq+" dòng đã được thêm");
		} else {
			JOptionPane.showMessageDialog(this, "Nhập dữ liệu sai");
		}
		this.xoaForm();
	}

	public void XoaNV() {
		DefaultTableModel tableModel = (DefaultTableModel) this.table.getModel();
		int row_select = this.table.getSelectedRow();
		String MNVXoa = (String) tableModel.getValueAt(row_select, 0);
		this.model.xoaNV(MNVXoa);
		int kq = NhanVienDAO.getInstance().delete(MNVXoa);
		JOptionPane.showMessageDialog(this, "Có "+kq+" đã xóa");
		tableModel.removeRow(row_select);
	}

	public void DocFile() {
		DefaultTableModel tableModel = (DefaultTableModel) this.table.getModel();
		this.model.ReadFile("C:\\Users\\Dell\\Downloads\\fileIn.txt");
		ArrayList<NhanVien> list = this.model.getDsnv();
		for (NhanVien nhanVien : list) {
			tableModel.addRow(new Object[] { nhanVien.getMaNV(), nhanVien.getHoTen(), nhanVien.getGioiTinh(),
					df.format(nhanVien.getNgaySinh()), nhanVien.getSoCM(), df.format(nhanVien.getNgayVaoCoQuan()),
					nhanVien instanceof NhanVienBienChe ? ((NhanVienBienChe) nhanVien).getHeSoLuong() : null,
					nhanVien instanceof NhanVienHopDong ? ((NhanVienHopDong) nhanVien).getMucLuong() : null });
		}
		JOptionPane.showMessageDialog(this, "Đã đọc File(C:\\Users\\Dell\\Downloads\\fileIn.txt)");
	}

	public void ghiFile() {
		this.model.WriteFile("C:\\Users\\Dell\\Downloads\\fileOut.txt");
		JOptionPane.showMessageDialog(this, "Đã ghi vào File(C:\\Users\\Dell\\Downloads\\fileOut.txt)");
	}

	public void xoaForm() {
		this.tf_MNV.setText("");
		this.tf_hoTen.setText("");
		this.btgroupGioiTinh.clearSelection();
		this.tf_ngaySinh.setText("");
		this.tf_soCM.setText("");
		this.tf_ngayVaoCoQuan.setText("");
		this.btgroupNV.clearSelection();
		this.tf_hsLuong.setText("");
		this.tf_mucLuong.setText("");
	}

	public void hienThiLenForm() {
		int row_selected = this.table.getSelectedRow();
		this.tf_MNV.setText((String) this.table.getValueAt(row_selected, 0));
		this.tf_hoTen.setText((String) this.table.getValueAt(row_selected, 1));
		String gt = (String) this.table.getValueAt(row_selected, 2);
		if (gt.equals("Nam"))
			this.rdobt_Nam.setSelected(true);
		if (gt.equals("Nữ"))
			this.rdobt_Nu.setSelected(true);
		this.tf_ngaySinh.setText((String) this.table.getValueAt(row_selected, 3));
		this.tf_soCM.setText((String) this.table.getValueAt(row_selected, 4));
		this.tf_ngayVaoCoQuan.setText((String) this.table.getValueAt(row_selected, 5));
		if (this.table.getValueAt(row_selected, 7) == null) {
			this.rdobt_NVBC.setSelected(true);
			this.tf_hsLuong.setText(String.valueOf(this.table.getValueAt(row_selected, 6)));
			this.tf_mucLuong.setText("");
		} else if (this.table.getValueAt(row_selected, 6) == null) {
			this.rdobt_NVHD.setSelected(true);
			this.tf_mucLuong.setText(String.valueOf(this.table.getValueAt(row_selected, 7)));
			this.tf_hsLuong.setText("");
		}
	}

	public void Sua() {
		NhanVien nv = this.getNhanVien();
		this.model.suaNV(nv);
		int row_selected = this.table.getSelectedRow();
		this.table.setValueAt(nv.getHoTen(), row_selected, 1);
		this.table.setValueAt(nv.getGioiTinh(), row_selected, 2);
		this.table.setValueAt(df.format(nv.getNgaySinh()), row_selected, 3);
		this.table.setValueAt(nv.getSoCM(), row_selected, 4);
		this.table.setValueAt(df.format(nv.getNgayVaoCoQuan()), row_selected, 5);
		if (nv instanceof NhanVienBienChe)
			this.table.setValueAt(((NhanVienBienChe) nv).getHeSoLuong(), row_selected, 6);
		else
			this.table.setValueAt(null, row_selected, 6);
		if (nv instanceof NhanVienHopDong)
			this.table.setValueAt(((NhanVienHopDong) nv).getMucLuong(), row_selected, 7);
		else
			this.table.setValueAt(null, row_selected, 7);
		int kq = NhanVienDAO.getInstance().update(nv);
		JOptionPane.showMessageDialog(this, "Có "+kq +" đã thay đổi");
		this.xoaForm();
	}

	public void Tim() {
		int rowCount = this.table_Find.getRowCount();
		DefaultTableModel modelTable = (DefaultTableModel) this.table_Find.getModel();
		for(int i = rowCount-1;i>=0;i--) {
			modelTable.removeRow(i);
		}
		NhanVien nv = NhanVienDAO.getInstance().selectMaNV(this.tf_MNV.getText());
		if (nv != null) {
			modelTable.addRow(new Object[] { nv.getMaNV(), nv.getHoTen(), nv.getGioiTinh(), df.format(nv.getNgaySinh()),
					nv.getSoCM(), df.format(nv.getNgayVaoCoQuan()),
					nv instanceof NhanVienBienChe ? ((NhanVienBienChe) nv).getHeSoLuong() : null,
					nv instanceof NhanVienHopDong ? ((NhanVienHopDong) nv).getMucLuong() : null });
		}
		this.scrollPane.setVisible(false);
		this.scrollPane_Find.setVisible(true);
		this.bt_huy.setVisible(true);
		this.bt_Tim.setVisible(false);
	}

	public void HuyTim() {
		this.scrollPane.setVisible(true);
		this.scrollPane_Find.setVisible(false);
		this.bt_Tim.setVisible(true);
		this.bt_huy.setVisible(false);
	}

	public void NVBC() {
		this.tf_mucLuong.setText("");
		this.tf_hsLuong.setEnabled(true);
		this.tf_mucLuong.setEnabled(false);
	}

	public void NVHD() {
		this.tf_hsLuong.setText("");
		this.tf_mucLuong.setEnabled(true);
		this.tf_hsLuong.setEnabled(false);
	}
	public void hienThiDuLieuSQL() {
		DefaultTableModel model_table = (DefaultTableModel) this.table.getModel();
		this.model.LayDuLieuTuSQL();
		ArrayList<NhanVien> list = this.model.getDsnv();
		for (NhanVien nv: list) {
			model_table.addRow(new Object[] {
				nv.getMaNV(),
				nv.getHoTen(),
				nv.getGioiTinh(),
				df.format(nv.getNgaySinh()),
				nv.getSoCM(),
				df.format(nv.getNgayVaoCoQuan()),
				nv instanceof NhanVienBienChe? ((NhanVienBienChe)nv).getHeSoLuong() : null,
				nv instanceof NhanVienHopDong? ((NhanVienHopDong)nv).getMucLuong() : null,
			});
		}
	}
}
