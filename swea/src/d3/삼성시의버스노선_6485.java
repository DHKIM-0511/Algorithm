package d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 삼성시의버스노선_6485 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		
		for(int tc = 1 ; tc <= t ; tc++) {
			
			int n = Integer.parseInt(br.readLine()); // 버스노선 개수
			int[] A = new int[n];
			int[] B = new int[n];
			
			for(int i = 0 ; i < n ; i++) {//A이상 B이하 모든 노선을 다니는 버스 노선
				st = new StringTokenizer(br.readLine());
				A[i] = Integer.parseInt(st.nextToken());
				B[i] = Integer.parseInt(st.nextToken());
			}
			
			int p = Integer.parseInt(br.readLine()); // 버스정류장 개수
			int[] c = new  int[p];
			for(int i = 0 ; i < p ; i++) {
				c[i]=Integer.parseInt(br.readLine()); // 버스 정류장 번호
			}
			
			StringBuilder sb = new StringBuilder();
			
			for(int i = 0 ; i < p ; i++) {
				int cnt = 0;
				for(int j = 0 ; j < n ; j++) {
					
					if(c[i]>=A[j] && c[i]<=B[j]) {
						cnt++;
					}
					
				}
				sb.append(cnt).append(" ");
			}
			
			System.out.println("#"+tc+" "+sb);
			
		}
		
		
	}
}
