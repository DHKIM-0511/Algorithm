package silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 계단오르기_2579 {
	static int N;
	static int[] score;
	static int[] dp;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		score = new int[301];
		
		for(int i = 1 ; i< N+1 ; i++) score[i] = Integer.parseInt(br.readLine());
		dp = new int[301];
		
		getMaxScore();
		System.out.println(dp[N]);
	}
	private static void getMaxScore() {
		dp[1] = score[1];
		dp[2] = score[2]+score[1];
		for(int i = 3; i < N+1 ; i++) {
			dp[i] = Math.max(score[i]+dp[i-2], score[i]+score[i-1]+dp[i-3]);
		}
	}
}
