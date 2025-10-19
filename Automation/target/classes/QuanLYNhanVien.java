import java.text.DecimalFormat;
import java.util.Scanner;

public class QuanLyNhanVien 
{

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Hãy nhập vào tổng số nhân viên: ");
		int n = sc.nextInt();
		sc.nextLine();
		ThongTinNhanVien[] nv = new ThongTinNhanVien[n];
		for (int i = 0; i < n; i++)
		{
			System.out.println("Thông tin nhân viên thứ "+ (i+1));
			nv[i] = new ThongTinNhanVien();
			nv[i].NhapDS();		
		}
		System.out.println("Danh Sách Nhân Viên trong công ty: ");
		for (int i = 0; i < n; i++)
		{
			System.out.println("Nhân viên thứ "+ (i+1));
			nv[i].InDS();		
		}
		mucLuongTB(nv);
		tongChiPhi(nv);
	}
	
	public static void mucLuongTB(ThongTinNhanVien[] nv)
	{
		double sum = 0;
		for (int i = 0; i < nv.length; i++)
		{
			sum += nv[i].tinhLuong();
		}
		double luongTB = (double) sum / nv.length;
		DecimalFormat df = new DecimalFormat("#,###");
		System.out.println("Lương trung bình của cả công ty = " + df.format(luongTB));
		System.out.println("Danh sách nhân viên có lương cao hơn trung bình:");
		boolean coNhanVien = false;
		for (int i = 0; i < nv.length; i++)
		{
			double luongNV = nv[i].tinhLuong();
			if (luongNV > luongTB)
			{
				coNhanVien = true;
				System.out.println("--------------------------------------");
				System.out.println("Nhân viên thứ " + (i + 1));
				System.out.println("Họ tên: " + nv[i].getHoTenNV());
		        System.out.println("Mức Lương: " + df.format(nv[i].tinhLuong()));
			}			
		}
		if (!coNhanVien)
			System.out.println("Không có nhân viên nào có lương cao hơn mức trung bình.");
	}
	
	public static void tongChiPhi(ThongTinNhanVien[] nv)
	{
		double hsThuong = 0.1;
		double tongChiPhi = 0;
		DecimalFormat df = new DecimalFormat("#,###");
		for (int i = 0; i < nv.length; i++)
		{
			double luongNV = nv[i].tinhLuong();
			double luongThang = (double) hsThuong * luongNV + luongNV;
	        tongChiPhi += luongThang;
		}
		System.out.println("--------------------------------------");
		System.out.println("Tổng Chi Phí một tháng của toàn công ty: "+df.format(tongChiPhi));
	}
}
