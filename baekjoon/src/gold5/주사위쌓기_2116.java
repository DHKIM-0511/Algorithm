package gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 주사위쌓기_2116 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[][] dice = new int[n][6];
		
		for(int i = 0 ; i < n ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < 6 ;j++) {
				dice[n][j] = Integer.parseInt(st.nextToken());
			}
		}
//		System.out.println(diceMax(dice , n));
	}
	//윗면(A) : idx = 0
	//옆면(B ~ E) : idx = 1 ~ 4
	//아랫면(F) : idx = 5
	
//	private static int diceMax(int[][] dice, int n) {
//		int max = 0;
//		//map쓸것
//		for(int i = 0 ; i < n ; i++) {
//			for(int j = 0 ; j < 6 ; j++) {
//				
//				
//			}
//		}
//		
//		return null;
//	}
}
