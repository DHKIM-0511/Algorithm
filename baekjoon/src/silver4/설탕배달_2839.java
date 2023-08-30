package silver4;

import java.util.Scanner;

public class 설탕배달_2839 {
	static int cnt;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		cnt = Integer.MAX_VALUE;
		
		find(n);
		
		System.out.println(cnt);
	}
	private static void find(int n) {
		
		int a = n/5; 
		int b = n/3;
		
		for(int i = 0 ; i <= a ; i++) {
			for(int j = 0 ; j <= b ; j++) {
				
				if( n - 5*i - 3*j == 0) {
					if(cnt > i+j)
						cnt = i+j;
				}
			}
		}
		if(cnt == Integer.MAX_VALUE)
			cnt=-1;
	}
}
