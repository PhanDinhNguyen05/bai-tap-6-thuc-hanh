package PhanDinhNguyen_23683721;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class QuanLyHangHoa {
	private List<HangHoa> hangHoa;
	public QuanLyHangHoa() {
		hangHoa=new ArrayList<>();
	}
	public boolean themHangHoa(HangHoa hh) {
		if(hangHoa.contains(hh))
			return false;
		hangHoa.add(hh);
		return true;
	}
	public boolean xoaHangHoa(String tenHangHoa) {
		for(HangHoa hh:hangHoa) {
			if(hh.getTenHang().equalsIgnoreCase(tenHangHoa))
				return hangHoa.remove(hh);
		}
		return false;
	}
	public List<HangHoa> getHangHoa(){
		return hangHoa;
	}
	public void sapXepTheoMaHangHoa() {
		Collections.sort(hangHoa,new Comparator<HangHoa>() {
			public int compare(HangHoa o1,HangHoa o2) {
				return o1.getMaHang().compareToIgnoreCase(o2.getMaHang());
			}
		});
	}
	public void sapXepTheoDonGia() {
		Collections.sort(hangHoa, new Comparator<HangHoa>() {
			public int compare(HangHoa o1,HangHoa o2) {
				if(o1.getDonGia()<o2.getDonGia())
					return 1;
				else {
					if(o2.getDonGia()==o1.getDonGia())
						return 0;
					else
						return -1;
				}
			}
		});
	}
	public boolean capNhapHangTonKho(String maHang,int soHangTon) throws Exception {
		if(soHangTon<=0)
			return false;
		for(HangHoa hh: hangHoa) {
			if(hh.getMaHang().equalsIgnoreCase(maHang)) {
				if(hh instanceof HangHoa) {
					HangHoa hang=(HangHoa) hh;
					hang.setSoLuongTon(soHangTon);
					return true;
				}
			}
		}
		return false;
	}
	public List<HangThucPham> getHangThucPham(){
		List<HangThucPham> hangThucPham=new ArrayList<>();
		for(HangHoa hh:hangHoa) {
			if(hh instanceof HangThucPham) {
				HangThucPham htp=(HangThucPham) hh;
				hangThucPham.add(htp);
			}
		}
		return hangThucPham;
	}
}
