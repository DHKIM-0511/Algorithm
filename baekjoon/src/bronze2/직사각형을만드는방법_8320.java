package bronze2;

import java.util.Scanner;

public class 직사각형을만드는방법_8320 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		
		int cnt = 0;
		for(int i=1; i<n+1; i++) {
			for(int j=1; j<=i; j++){
				if(i*j <= n)
					cnt++;
			}
		}
				
		System.out.println(cnt);
	}
}
//직사각형 : 2(a+b)
// 높이 : 1 -> 1 ~ n 까지 있고  
// 높이 : 2 -> 1 ~ n/2 까지 있고
// 높이 : 3 -> 1 ~ n/3