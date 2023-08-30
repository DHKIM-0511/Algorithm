package silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 이동하기_11048 {
	static int N,M;
	static int[][] map;
	static int[][] dp;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N+1][M+1];
		dp = new int[N+1][M+1];
		for(int i = 1 ; i < N+1 ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j < M+1 ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		getMoreCandy();
		System.out.println(dp[N][M]);
	}
	private static void getMoreCandy() {
		//처음 행과 처음 열 dp에 누적합 저장
		for(int i =1 ; i < N +1 ; i++) dp[i][1] = map[i][1]+ dp[i-1][1];
		for(int i =1 ; i < M +1 ; i++) dp[1][i] = map[1][i]+ dp[1][i-1];
		
		for(int i = 2 ; i < N + 1 ; i++) {
			for(int j = 2; j < M+1 ; j++) {
				dp[i][j] = map[i][j] + Math.max(dp[i-1][j], dp[i][j-1]);
			}
		}
	}
}
