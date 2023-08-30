package silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RGB거리_1149 {
	static int N;
	static int[][] RGB;
	static int[][] dp;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		RGB= new int[1001][3];
		dp = new int[1001][3];
		
		for(int i = 1 ; i < N+1 ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j <3 ; j++) {
				RGB[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp[0][0] = RGB[0][0]; // R
		dp[0][1] = RGB[0][1]; // G 
		dp[0][2] = RGB[0][2]; // B
		
		for(int i = 1 ; i < N+1 ; i++) {
			dp[i][0] = RGB[i][0] + Math.min(dp[i-1][1], dp[i-1][2]); 
			dp[i][1] = RGB[i][1] + Math.min(dp[i-1][0], dp[i-1][2]);
			dp[i][2] = RGB[i][2] + Math.min(dp[i-1][0], dp[i-1][1]);
		}
		System.out.println(Math.min(dp[N][0], Math.min(dp[N][1], dp[N][2])));
	}
}
