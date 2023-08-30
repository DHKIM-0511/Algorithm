package silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 히오스프로게이머_16564 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] input = new int[N];
		
		for (int i = 0; i < N; i++) input[i] = Integer.parseInt(br.readLine());
		Arrays.sort(input);
		
		long  ans = 0;
		long  left = input[0];
		long  right = input[N-1];
		while(left<=right) {
			
			long  mid = (left+right)/2;
			long sum = 0;
			
			for (int i = 0; i < N; i++) {
				if(input[i]<mid) sum += (mid-input[i]);
			}
			
			if(sum<=K) {
				ans = mid;
				left = mid+1;
			}else {
				right = mid-1;
			}
		}
		System.out.println(ans);
	}
}
