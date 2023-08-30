package silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 겹치는건싫어_20922 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		int[] cnt = new int[100001];
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i< N ; i++) arr[i] = Integer.parseInt(st.nextToken());
		
		int ans = Integer.MIN_VALUE;
		int start = 0;
		int end = 0;
		
		while(start < N) {
			if(cnt[arr[end]]+1 > K) {
				ans = Math.max(ans, end - start);
				cnt[arr[start]]--;
				start++;
			}else {
				cnt[arr[end]]++;
				end++;
				if(end == N) {
					ans = Math.max(ans, end-start);
					break;
				}
			}
		}
		
		System.out.println(ans);
	}
}
