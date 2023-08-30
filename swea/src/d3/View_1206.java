package d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class View_1206 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		for(int tc = 1 ; tc <= 10 ; tc++) {
			
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int ans = 0;
			 // 각 건물의 높이를 배열에저장
			int[] H = new int[n]; 
			for(int i = 0 ; i < n ; i++) {
				H[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int i = 2 ; i < n-2 ; i++) {
				int max1 = Math.max(H[i-2], H[i-1]);
				int max2 = Math.max(H[i+2], H[i+1]);
				int max = Math.max(max1, max2);
				
				if(H[i] > max) {
					ans += H[i] - max;
				}
				
			}
			System.out.println("#"+tc+" "+ans);
			
		}
		
		
	}
}
