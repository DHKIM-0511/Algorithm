package d3;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 현주의상자바꾸기_5789 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		
		int t = Integer.parseInt(br.readLine());
		
		for(int tc = 1 ; tc <= t; tc++) {
			
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()); // n 개 상자
			int q = Integer.parseInt(st.nextToken()); // 작업 횟수
			
			int[] l = new int[q];
			int[] r = new int[q];
			
			for(int i = 0 ; i < q ; i++) {
				st = new StringTokenizer(br.readLine());
				l[i] = Integer.parseInt(st.nextToken()); // 왼쪽 범위
				r[i] = Integer.parseInt(st.nextToken()); // 오른쪽 범위
			}
			
			int[] cnt = new int[n];
			
			for(int i = 0 ; i < q ; i++) {				
				for(int j = 0 ; j < n ; j++) {					
					if(j >=l[i]-1 && j <=r[i]-1) { // 범위에 들면 해당 상자에 작업횟수를 저장.
						cnt[j] = i+1;
					}
				}
			}
			
			
			System.out.print("#"+tc+" ");
			for(int a: cnt) {
				System.out.print(a+" ");
			}
			System.out.println();
		}
	
	
	}
}
