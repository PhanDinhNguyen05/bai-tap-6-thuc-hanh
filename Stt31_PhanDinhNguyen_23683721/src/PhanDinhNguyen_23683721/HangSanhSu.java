package PhanDinhNguyen_23683721;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class HangSanhSu extends HangHoa{
	private LocalDate ngaySanXuat;
	private LocalDate ngayNhapKho;
	public HangSanhSu() {
		
	}
	
	public HangSanhSu(String maHang, String tenHang, double donGia, int soLuongTon, LocalDate ngaySanXuat,
			LocalDate ngayNhapKho) throws Exception {
		super(maHang, tenHang, donGia, soLuongTon);
		this.ngaySanXuat = ngaySanXuat;
		this.ngayNhapKho = ngayNhapKho;
	}

	public LocalDate getNgaySanXuat() {
		return ngaySanXuat;
	}
	public void setNgaySanXuat(LocalDate ngaySanXuat) {
		if(ngaySanXuat.isBefore(LocalDate.now()))
			this.ngaySanXuat=ngaySanXuat;
		else
			this.ngaySanXuat=LocalDate.now();
	}
	public LocalDate getNgayNhapKho() {
		return ngayNhapKho;
	}
	public void setNgayNhapKho(LocalDate ngayNhapKho) {
		if(ngayNhapKho.isBefore(LocalDate.now()))
			this.ngayNhapKho=ngayNhapKho;
		else
			this.ngayNhapKho=LocalDate.now();
	}
	@Override
	protected String danhGia() {
		int ngayTon=(int)LocalDate.now().getDayOfYear()-ngayNhapKho.getDayOfYear();
		if(soLuongTon>50&&ngayTon>10)
			return "Bán chậm";
		else
			return "";
	}
	public double getVAT() {
		return getDonGia()*getSoLuongTon()*0.1;
	}
	public String toString() {
		DateTimeFormatter df=DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return super.toString()+String.format("%-20s|%-20s|%-10s|",df.format(ngaySanXuat),df.format(ngayNhapKho),getVAT());
	}
}
