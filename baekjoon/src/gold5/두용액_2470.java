package gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 두용액_2470 {
	static int N;
	static int[] arr;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i =0; i < N ; i++) arr[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(arr);
		
		int start =0;
		int end = N-1;
		int minSum = Math.abs(arr[start]+arr[end]);
		
		int a=start,b=end;
		while(start < end) {
			
			int sum = arr[start] + arr[end];
			
			if(Math.abs(sum) < minSum) {
				minSum = Math.abs(sum);
				a = start;
				b = end;
				}
			
			if(sum == 0) break;
			
			if(sum < 0) {
				start++;
			}else {
				end--;
			}
		}
		System.out.println(arr[a]+" "+arr[b]);
	}
}