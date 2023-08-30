package bronze2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 분해합_2231 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());  // 생성자
		
		//분해합이 n이되는 가장 작은 수를 구하시오
		int ans = 0;
		
		for(int i = 1 ; i < n ; i++) { // 1~n-1까지 탐색
			int num = i;
			int sum = 0;
			
			while(num != 0) { // 각 자릿수 sum에 더하기
				sum += num % 10;
				num /= 10;
			}
			
			if(sum + i == n) {
				ans = i;
				break;
			}
		}
		
		System.out.println(ans);
	}
}
