package PhanDinhNguyen_23683721;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) throws Exception {
		QuanLyHangHoa hh=new QuanLyHangHoa();
		Scanner sc=new Scanner(System.in);
		HangHoa hh1,hh2,hh3,hh4,hhx;
		List<HangHoa> dshh=hh.getHangHoa();
		DateTimeFormatter df= DateTimeFormatter.ofPattern("dd/MM/yyyy");
		hh1=new HangThucPham("TP01", "Gạo 2 Lúa", 10000, 20,"Công ty TNHH Lê Huy" ,
				LocalDate.parse("12/02/2019", df),  LocalDate.parse("29/11/2022", df));
		hh3=new HangThucPham("TP03", "Rau Sạch", 5000, 2,"Công ty TNHH Lê Huy" ,
				LocalDate.parse("05/02/2021", df),  LocalDate.parse("12/02/2021", df));
		hh2=new HangDienMay("DM02", "Tủ Lạnh", 1500000, 2, 24, 24);
		hh4=new HangSanhSu("SS04", "Bát", 12000, 60, LocalDate.parse("21/03/2022", df), LocalDate.parse("23/03/2022", df));
		int chon;
		do {
			System.out.println("1.Thêm Hàng Hóa");
			System.out.println("2.Thông tin hàng hóa");
			System.out.println("3.Sắp xếp theo mã Hàng hóa");
			System.out.println("4.Sắp xếp theo đơn giá");
			System.out.println("5.cập nhật Hàng tồn kho");
			System.out.println("6.xóa hàng hóa");
			System.out.println("7.thông tin hàng thực phẩm");
			System.out.println("0.thóat");
			System.out.println("nhập lựa chọn: ");
			chon=sc.nextInt();
			switch(chon) {
			case 1:
				hh.themHangHoa(hh1);
				hh.themHangHoa(hh2);
				hh.themHangHoa(hh3);
				hh.themHangHoa(hh4);
				break;
			case 2:
				for(HangHoa hangHoa:dshh) {
					System.out.println(hangHoa);
				}
				break;
			case 3:
				hh.sapXepTheoMaHangHoa();
				break;
			case 4:
				hh.sapXepTheoDonGia();
				break;
			case 5:
				boolean kqcn=hh.capNhapHangTonKho("TP03", 26);
				if(kqcn) {
					System.out.println("Đã cập nhật");
				}else
					System.out.println("cập nhật thất bại");
				break;
			case 6:
				boolean kqxoa=hh.xoaHangHoa("Tủ Lạnh");
				if(kqxoa)
					System.out.println("Đã xóa");
				else 
					System.out.println("xóa thất bại");
				break;
			case 7:
				hh.getHangThucPham().forEach(htp->System.out.println(htp));
				break;
			default:
				System.out.println("kết thúc");
				break;
			}
		}while(chon!=0);
	}
}
