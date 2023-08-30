package d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 숫자배열회전_1961 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		int t = Integer.parseInt(br.readLine());
		
		for(int tc = 1 ; tc <= t ; tc++) {
			StringBuilder sb = new StringBuilder();
			int n = Integer.parseInt(br.readLine());
			
			int[][] nums = new int[n][n];
			
			for(int i = 0 ; i < n ; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0 ; j < n ; j++) {
					nums[i][j] = Integer.parseInt(st.nextToken());					
				}
			}
			
			for(int i = 0 ; i < n ; i++) {
				
				for(int j = 0 ; j < n ; j++) {//90도
					if(nums[n-1-j][i] >= 0 ) {
						sb.append(nums[n-1-j][i]);
					}
				}
				sb.append(" ");
				for(int j = 0 ; j < n ; j++) {//180도
					if(nums[n-1-i][n-1-j] >= 0) {
						sb.append(nums[n-1-i][n-1-j]);
					}
				}
				sb.append(" ");
				for(int j = 0 ; j < n ; j++) {//270도
					if(nums[j][n-1-i] >= 0) {
						sb.append(nums[j][n-1-i]);
					}
				}					
				
				sb.append("\n");
			}

			System.out.print("#"+tc+"\n"+sb);
		}
		
	}
}
