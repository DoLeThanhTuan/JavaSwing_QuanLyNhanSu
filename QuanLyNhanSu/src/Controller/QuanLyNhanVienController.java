package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import org.w3c.dom.events.MouseEvent;

import View.QuanLyNhanVienView;

public class QuanLyNhanVienController implements ActionListener, MouseListener{
	private QuanLyNhanVienView view;
	
	public QuanLyNhanVienController(QuanLyNhanVienView quanLyNhanVienView) {
		this.view = quanLyNhanVienView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String ac = e.getActionCommand();
		if(ac.equals("Thêm"))
			this.view.ThemNV();
		if(ac.equals("Xóa"))
			this.view.XoaNV();
		if(ac.equals("Đọc File"))
			this.view.DocFile();
		if(ac.equals("Ghi File"))
			this.view.ghiFile();
		if(ac.equals("Chọn"))
			this.view.hienThiLenForm();
		if(ac.equals("Sửa"))
			this.view.Sua();
		if(ac.equals("Tìm"))
			this.view.Tim();
		if(ac.equals("Hủy tìm"))
			this.view.HuyTim();
	}

	@Override
	public void mouseClicked(java.awt.event.MouseEvent e) {
		this.view.hienThiLenForm();
	}

	@Override
	public void mousePressed(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
