package bronze5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 팩토리얼_10872 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int ans = 1;
		
		if(n == 0 || n == 1) {
			ans = 1;
		}else {
			int[] num = new int[n];
			num[0]++;
			for(int i = 1 ; i < n ; i++) {
				num[i] = num[i-1] + 1;
				ans *= num[i];
			}
		}
		System.out.println(ans);
		
	}
}
