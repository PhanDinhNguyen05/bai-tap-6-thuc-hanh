package PhanDinhNguyen_23683721;

public class HangDienMay extends HangHoa {
	private int thoiGianBaoHanh;
	private double congSuat;

	public HangDienMay() {

	}

	public HangDienMay(String maHang, String tenHang, double donGia, int soLuongTon, int thoiGianBaoHanh,
			double congSuat) throws Exception {
		super(maHang, tenHang, donGia, soLuongTon);
		this.thoiGianBaoHanh = thoiGianBaoHanh;
		this.congSuat = congSuat;
	}

	public int getThoiGianBaoHanh() {
		return thoiGianBaoHanh;
	}

	public void setThoiGianBaoHanh(int thoiGianBaoHanh) throws Exception {
		if (thoiGianBaoHanh >= 0)
			this.thoiGianBaoHanh = thoiGianBaoHanh;
		else
			throw new Exception("lỗi thời gian bảo hành");
	}

	public double getCongSuat() {
		return congSuat;
	}

	public void setCongSuat(double congSuat) throws Exception {
		if (congSuat >= 0)
			this.congSuat = congSuat;
		else
			throw new Exception("Lỗi công suất");
	}

	public double getVAT() {
		return getDonGia() * getSoLuongTon() * 0.05;
	}

	public String toString() {
		return super.toString() + String.format("%-20s|%-20s|%-10s|", thoiGianBaoHanh, congSuat, getVAT());
	}

	@Override
	protected String danhGia() {
		return (soLuongTon < 3) ? "Bán Được" : "";
	}
}
