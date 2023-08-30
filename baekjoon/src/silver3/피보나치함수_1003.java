package silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 피보나치함수_1003 {
	static int[] ans;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(br.readLine());
		for(int t = 1; t <= tc ; t++) {
			int N = Integer.parseInt(br.readLine());
			ans = new int[2];
			fibo(N);
			System.out.println(ans[0]+" "+ans[1]);
		}
	}
	private static void fibo(int n) {
		
		if(n == 0) {
			ans[0]++;
			return;
		}
		if(n == 1) {
			ans[1]++;
			return;
		}
		int tmp = 0;
		int tmp1 = 0;
		int tmp2 = 1;
		
		for(int i = 1; i < n ; i++) {
			tmp  = tmp1 + tmp2 ;
			tmp1 = tmp2;
			tmp2 = tmp;
		}
		ans[0] = tmp1;
		ans[1] = tmp2;
	}
}
