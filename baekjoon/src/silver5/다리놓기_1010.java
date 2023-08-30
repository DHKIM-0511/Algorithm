package silver5;

import java.util.Scanner;

public class 다리놓기_1010 {
	
	static int[][] arr = new int[30][30];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		
		for(int tc = 1 ; tc <= t ; tc++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			
			sb.append(combination(m, n)).append('\n');
		}
		System.out.println(sb);
	}

	private static int combination(int m, int n) {
		//메모이제이션
		if(arr[m][n] > 0) {
			return arr[m][n]; 
		}
		
		if(m == n || n == 0) {
			return arr[m][n] = 1;
		}
		
		return arr[m][n] = combination(m - 1, n - 1) + combination(m - 1, n);
	}
}
