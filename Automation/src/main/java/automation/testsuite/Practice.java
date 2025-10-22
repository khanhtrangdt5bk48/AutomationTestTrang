package automation.testsuite;

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

}
