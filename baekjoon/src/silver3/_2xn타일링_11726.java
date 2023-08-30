package silver3;

import java.util.Scanner;

public class _2xn타일링_11726 {
	static int[] dp = new int[1001];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		
		System.out.println(tile(n));
	}
	private static int tile(int n) {
		dp[1] = 1;
		dp[2] = 2;
		//2xn 크기의 타일을 채우는 방법수는
		// n-1일때의 방법 + n-2일때의 방법을 더하는것 
		for(int i = 3 ; i < n+1 ; i++) {
			dp[i] = (dp[i-1] + dp[i-2] )%10007;
		}
		return dp[n];
	}
}
