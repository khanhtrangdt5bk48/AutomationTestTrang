import java.text.DecimalFormat;
import java.util.Scanner;

public class ThongTinNhanVien 
{
	String hoTenNV;
	String phongBan;
	double soCCCD;
	double soDT;
	String ngaySinh;
	int sonamKN;
	
	
	public String getHoTenNV() {
		return hoTenNV;
	}
	public void setHoTenNV(String hoTenNV) {
		this.hoTenNV = hoTenNV;
	}
	public String getPhongBan() {
		return phongBan;
	}
	public void setPhongBan(String phongBan) {
		this.phongBan = phongBan;
	}
	public double getSoCCCD() {
		return soCCCD;
	}
	public void setSoCCCD(double soCCCD) {
		this.soCCCD = soCCCD;
	}
	public double getSoDT() {
		return soDT;
	}
	public void setSoDT(double soDT) {
		this.soDT = soDT;
	}
	public String getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public int getSonamKN() {
		return sonamKN;
	}
	public void setSonamKN(int sonamKN) {
		this.sonamKN = sonamKN;
	}
	
	public void NhapDS()
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập họ tên: ");
		setHoTenNV(sc.nextLine());
		
		System.out.print("Phòng ban: ");
		setPhongBan(sc.nextLine());
		
		System.out.print("Số Căn Cước Công Dân: ");
		double so = sc.nextDouble();
		sc.nextLine();
		setSoCCCD(so);
		
		System.out.print("Số điện thoại: ");
		double sodt = sc.nextDouble();
		sc.nextLine();
		setSoDT(sodt);
		
		System.out.print("Ngày Tháng Năm Sinh: ");
		setNgaySinh(sc.nextLine());
		
		System.out.print("Số Năm Kinh Nghiệm: ");
		int sonam = sc.nextInt();
		setSonamKN(sonam);
		
		System.out.println("======================================");
		
	}
	public void InDS() 
	{
        System.out.println("Họ tên: " + getHoTenNV());
        System.out.println("Phòng ban: " + getPhongBan());
        System.out.println("CCCD: " + getSoCCCD());
        System.out.println("Số Điện thoại: " + getSoDT());
        System.out.println("Ngày tháng năm sinh: " + getNgaySinh());
        System.out.println("Số Năm Kinh Nghiệm: " + getSonamKN());
        DecimalFormat df = new DecimalFormat("#,###");
        System.out.println("Mức Lương: " + df.format(tinhLuong()));
        System.out.println("**************");
		
	}
	public double tinhLuong() 
	{
		double luongCB = 10000000;
		int hesoLuong;
		
		if (sonamKN < 2)
			hesoLuong = 1;
		else if (sonamKN >= 2 && sonamKN < 5)
			hesoLuong = 2;
		else if (sonamKN >= 5 && sonamKN < 10)
			hesoLuong = 3;
		else
			hesoLuong = 4;
		return luongCB * hesoLuong;	
		
	}
}
