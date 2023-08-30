package d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 농작물수확하기_2805 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int t = Integer.parseInt(br.readLine());
		
		for(int tc = 1 ; tc <= t ; tc++) {
			
			int n = Integer.parseInt(br.readLine());
			int[][] value = new int[n][n];
			
			for(int i = 0 ; i < n ; i++) { // 연속된 숫자 입력받기
				String temp = br.readLine();
				for(int j = 0 ; j < n ; j++) {
					value[i][j] = temp.charAt(j)-'0';
				}
			}
			
			int left = n / 2;
			int right = n / 2; // 왼쪽, 오른쪽 범위 설정
			int ans = 0; // 출력값
			
			for(int i = 0 ; i < n ; i++) {
				for(int j = 0 ; j < n ; j++) {
					
					if(j >=left && j <=right) { // 범위 내 값 더하기
						ans += value[i][j] ;
					}
				}
				
				if(i>=n/2) { // 범위 재설정
					left++;
					right--;
				}else {
					left--;
					right++;
				}
			}
			
			System.out.println("#"+tc+" "+ans);
		}
	
	
	}
}
