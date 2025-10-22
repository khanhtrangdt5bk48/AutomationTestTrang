package automation.testsuite;

import java.lang.reflect.Array;
import java.util.Scanner;

import org.testng.annotations.Test; //sử dụng ctrl + cách để xh gợi ý
public class Practice 
{
	@Test
	public void tinhTongMang()
	{
		/* Nhập vào một mảng gồm n phần tử (n nhập vào từ bàn phím). Tính tổng của các phần tử trong mảng vừa nhập*/
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập độ dài của mảng: ");
		int n = sc.nextInt();
		int[]a = new int[n];
		int sum = 0;
		for (int i = 0; i < n; i++)
		{
			System.out.println("Nhập phần tử mảng thứ "+i+1);
			a[i] = sc.nextInt();
			sum += a[i];
		}
		System.out.println("Tổng của mảng là: "+sum);
	}
	@Test
	public void timSoLonNhatMang()
	{
		/* Nhập vào một mảng gồm n phần tử (n nhập vào từ bàn phím). Tính tổng của các phần tử trong mảng vừa nhập*/
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập độ dài của mảng: ");
		int n = sc.nextInt();
		int[]a = new int[n];
		for (int i = 0; i < n; i++)
		{
			System.out.println("Nhập phần tử mảng thứ "+i+1);
			a[i] = sc.nextInt();
		}
		int max = a[n-1];
		for (int i = 0; i < n; i++)
		{
			if (a[i] > max)
				max = a[i];
			
		}
		System.out.println("Số lớn nhất của mảng là: "+max);
	}
	@Test
	public void timSoNhoNhatMang()
	{
		/* Nhập vào một mảng gồm n phần tử (n nhập vào từ bàn phím). Tính tổng của các phần tử trong mảng vừa nhập*/
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập độ dài của mảng: ");
		int n = sc.nextInt();
		int[]a = new int[n];
		for (int i = 0; i < n; i++)
		{
			System.out.println("Nhập phần tử mảng thứ "+i+1);
			a[i] = sc.nextInt();
		}
		int min = a[n-1];
		for (int i = 0; i < n; i++)
		{
			if (a[i] < min)
				min = a[i];
			
		}
		System.out.println("Số lớn nhất của mảng là: "+min);
	}
	@Test
	public void nhapTenNhanVien()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Tổng số nhân viên hiện tại: ");
		int n = sc.nextInt();
		sc.nextLine();
		String[] nhanVien = new String[n];
		for (int i = 0; i < n; i++)
		{
			System.out.println("Hãy nhập tên nhân viên thứ "+i+": ");
			nhanVien[i] = sc.nextLine();
		}
		System.out.println("Danh sách nhân viên: ");
		for (String ten : nhanVien)
		{
			System.out.println("- " + ten);	
		}
	}

}
