package gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 부분합_1806 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int[] arrSum = new int[N+1];
		
		//누적합 저장
		st= new StringTokenizer(br.readLine());
		for(int i = 1 ; i <= N ; i++) arrSum[i] = arrSum[i-1]+Integer.parseInt(st.nextToken()); 
		
		int minLength = Integer.MAX_VALUE;
		int start = 0;
		int end = 1;
		
		while(end <= N) {
			int sum = 0;
			//구간합 = 누적합 - 누적합
			sum = arrSum[end]-arrSum[start];
			
			if(S<=sum) { 
				minLength = Math.min(end - start, minLength);
				start++;
			}else {
				end++;
			}
		}
		
		if(minLength == Integer.MAX_VALUE) System.out.println(0);
		else System.out.println(minLength);
	}
}
