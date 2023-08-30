package gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 케이크자르기_17179 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 자르는 횟수의 case
		int M = Integer.parseInt(st.nextToken()); // 자를 수 있는 지점의 개수
		int L = Integer.parseInt(st.nextToken()); // 롤 케이크 길이
		
		int[] cutPoint = new int[M+1];
		for(int i = 0 ; i < M ; i++) {
			cutPoint[i] = Integer.parseInt(br.readLine());
		}
		cutPoint[M] = L;
		
		int[] cut = new int[N];
		for(int i = 0 ; i < N ; i++) {
			cut[i] = Integer.parseInt(br.readLine());
		}
		
		for(int next : cut) {
			int left = 0;
			int right = L;
			int ans = 0;
			
			while(left <= right) {
				
				int mid = (left + right) / 2; // 최소길이 
				int cnt = 0;
				int temp = 0;
				
				for(int i = 0 ; i <= M ; i++) {
					if(cutPoint[i] - temp >= mid) { // 구간길이 >= 최소 구간의 최대값
						cnt++;
						temp = cutPoint[i];
					}
				}
				if(cnt > next) {
					left = mid+1;
					ans = Math.max(ans, mid);
				}
				else {
					right = mid-1;
				}
			}
			System.out.println(ans);
		}
	}
}
