package gold3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 세용액_2473 {
	static int N,max;
	static long[] arr,ans;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new long[N];
		ans = new long[3];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i =0; i < N ; i++) arr[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(arr);
		

		long minSum = Long.MAX_VALUE;
		
		//초기값이 답일 수 도있음
		for(int i = 0; i < N; i++) {
			int start =i+1;
			int end = N-1;
			while(start < end) {
				
				long sum = arr[start] + arr[end] + arr[i];
				
				if(Math.abs(sum) < minSum) {
					minSum = Math.abs(sum);
					ans[0] = arr[i];
					ans[1] = arr[start];
					ans[2] = arr[end];
					}
				
				if(sum == 0) break;
				
				if(sum < 0) {
					start++;
				}else {
					end--;
				}
			}
		}
		System.out.println(ans[0]+" "+ans[1]+" "+ans[2]);
	}
}
