package PhanDinhNguyen_23683721;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class HangThucPham extends HangHoa {
	private String nhaCungCap;
	private LocalDate ngaySanXuat;
	private LocalDate ngayHetHan;

	public HangThucPham() {

	}

	public HangThucPham(String maHang, String tenHang, double donGia, int soLuongTon, String nhaCungCap,
			LocalDate ngaySanXuat, LocalDate ngayHetHan) throws Exception {
		super(maHang, tenHang, donGia, soLuongTon);
		setNhaCungCap(nhaCungCap);
		setNgaySanXuat(ngaySanXuat);
		setNgayHetHan(ngayHetHan);
	}

	public String getNhaCungCap() {
		return nhaCungCap;
	}

	public void setNhaCungCap(String nhaCungCap) {
		this.nhaCungCap = nhaCungCap;
	}

	public LocalDate getNgaySanXuat() {
		return ngaySanXuat;
	}

	public void setNgaySanXuat(LocalDate ngaySanXuat) {
		if (ngaySanXuat.isBefore(LocalDate.now()))
			this.ngaySanXuat = ngaySanXuat;
		else
			this.ngaySanXuat = LocalDate.now();
	}

	public LocalDate getNgayHetHan() {
		return ngayHetHan;
	}

	public void setNgayHetHan(LocalDate ngayHetHan) {
		if (ngayHetHan.isAfter(ngaySanXuat))
			this.ngayHetHan = ngayHetHan;
		else
			this.ngayHetHan = ngaySanXuat;
	}

	@Override
	protected String danhGia() {
		if (soLuongTon > 0 && ngayHetHan.isAfter(LocalDate.now()))
			return "Khó Bán";
		else
			return "";
	}
	public double getVAT() {
		return getDonGia()*getSoLuongTon()*0.05;
	}
	public String toString() {
		DateTimeFormatter df=DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return super.toString() + String.format("%-30s|%-20s|%-20s|%-10s|", nhaCungCap, df.format(ngaySanXuat), df.format(ngayHetHan),getVAT());
	}

}

