package silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 연속합_1912 {
	static int[] arr;		
	static Integer[] dp;	
	static int max;			
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		arr = new int[N];
		dp = new Integer[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		dp[0] = arr[0];
		max = arr[0];
		
		rc(N - 1);
		
		System.out.println(max);	
	}
	static int rc(int N) {
		if(dp[N] == null) {
			dp[N] = Math.max(rc(N - 1) + arr[N], arr[N]);
			
			// 해당 dp[N]과 max 중 큰 값으로 max 갱신 
			max = Math.max(dp[N], max);
		}
		
		return dp[N];
	}
}
