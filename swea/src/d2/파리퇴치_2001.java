package d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 파리퇴치_2001 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		for(int tc = 1 ; tc <= t ; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int ans = 0;
			
			int[][] fly = new int[n][n];
			
			
			for(int i = 0 ; i < n ; i ++) { // 배열받기
				st = new StringTokenizer(br.readLine());
				for(int j = 0 ; j < n ; j++) {
					fly[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i = 0 ;  i <= n-m ; i++) {  // n-m만큼의 범위 설정
				for(int j = 0 ; j <= n-m ; j++) {
					int sum = 0;
					for(int k = 0 ; k < m ; k++) { // 그안에서 m 크기의 배열을
						for(int l = 0 ; l < m ; l++) {
							sum += fly[i+k][j+l]; // sum에 더해줌
						}
					}
					if(ans < sum)
						ans = sum; // 최댓값
				}
			}
			
			
			
			
			System.out.println("#"+tc+" "+ans);
		}
		
	}
}
