package silver3;

import java.util.Scanner;

public class _1_2_3더하기_9095 {
	static int arr[] = new int [11];
	
	public static void main(String[] args)   {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		arr[1] = 1;
		arr[2] = 2;
		arr[3] = 4;
		
		for(int j=4;j<=10;j++) {
			arr[j] = arr[j-3] + arr[j-2] + arr[j-1]; // 이전 항 3개 더하기
		}
		
		for(int i=0;i<t;i++) {
			int n = sc.nextInt();
			
			System.out.println(arr[n]);
		}
	}
}
