package gold5;

import java.util.Scanner;

public class 울타리치기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		sc.close();
		
		//1 ~ 5 = N +0
		// 6 ~ 11= N+1 
		// 7 = N+1
		// 8 = N+2
		// 9 = N+3
		//10 = N+4
		//11 = N+5
		//12 = N+7
		//13 = N+8
		//14 = N+10
		
		long ans = 1;
		long tmp  = 1;
		for(int i = 2 ; i <= N ; i++) {
			if(i % 6 == 0) tmp++;
			if(i % 6 == 1) ans--;
			ans += tmp;
		}
		System.out.println(ans);
	}
}
