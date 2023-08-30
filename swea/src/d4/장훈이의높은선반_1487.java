package d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 장훈이의높은선반_1487 {
	static int n , b , ans;
	static int [] H;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		for(int tc = 1 ; tc <= t ;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			n = Integer.parseInt(st.nextToken()); // 사람 수
			b = Integer.parseInt(st.nextToken()); // 탑의 높이
			H = new int[n]; // 사람 키
			int s =0; // 모든 키의 합
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0 ; i < n ; i++) {
				H[i] = Integer.parseInt(st.nextToken());
			}
			ans = Integer.MAX_VALUE;
			//비트마스킹 방식 (for문 2개)
			//1. for문 (모든 부분집합을 돌아보겠다.
			
			for(int i = 0 ; i< 1 << n ; i++) {
				//2. i는 부분집합 , 그런데 어떤 점원을 데리고 ?
				int sum = 0 ;
				for(int j = 0 ; i < n ; j++) {
					if((i & (1 << j)) != 0) {
						sum +=H[j];
					}
				}
				if( sum >= b && sum < ans) {
					ans = sum;
				}
			}
				
			System.out.println("#"+tc+" "+(ans-b));
		} // tc
	}
}
