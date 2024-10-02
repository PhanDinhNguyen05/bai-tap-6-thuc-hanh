package PhanDinhNguyen_23683721;

import java.text.DecimalFormat;
import java.util.Objects;

public abstract class HangHoa {
	protected String maHang;
	protected String tenHang;
	protected double donGia;
	protected int soLuongTon;

	public HangHoa() {
	}

	public HangHoa(String maHang, String tenHang, double donGia, int soLuongTon) throws Exception {
		setMaHang(maHang);
		setTenHang(tenHang);
		setDonGia(donGia);
		setSoLuongTon(soLuongTon);
	}

	public String getMaHang() {
		return maHang;
	}

	public void setMaHang(String maHang) throws Exception {
		if (maHang != null || maHang.trim().equalsIgnoreCase("") != true)
			this.maHang = maHang;
		else
			throw new Exception("Mã Không được rỗng");
	}

	public String getTenHang() {
		return tenHang;
	}

	public void setTenHang(String tenHang) {
		if (tenHang != null || tenHang.trim().equalsIgnoreCase("") != true)
			this.tenHang = tenHang;
		else
			this.tenHang = "xxx";
	}

	public double getDonGia() {
		return donGia;
	}

	public void setDonGia(double donGia) throws Exception {
		if (donGia >= 0)
			this.donGia = donGia;
		else
			throw new Exception("Lỗi đơn giá");
	}

	public int getSoLuongTon() {
		return soLuongTon;
	}

	public void setSoLuongTon(int soLuongTon) throws Exception {
		if (soLuongTon >= 0)
			this.soLuongTon = soLuongTon;
		else
			throw new Exception("Lỗi số lượng tồn");
	}

	public String toString() {
		DecimalFormat df = new DecimalFormat("#,##0.00VND");
		String s = "";
		return s += String.format("|%-10s|%-20s|%-25s|%-8s|%-30s|", maHang, tenHang, df.format(donGia), soLuongTon,
				danhGia());
	}

	protected abstract String danhGia();

	public int hashCode() {
		return Objects.hash(maHang);
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HangHoa other = (HangHoa) obj;
		return Objects.equals(maHang, other.maHang);

	}
}
