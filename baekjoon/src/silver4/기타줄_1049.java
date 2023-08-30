package silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 기타줄_1049 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] pak = new int[M];
		int[] one = new int[M];
		for(int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine());
			
			 pak[i] = Integer.parseInt(st.nextToken()); 
			 one[i] = Integer.parseInt(st.nextToken()); 
		}
		Arrays.sort(pak);
		Arrays.sort(one);
		int ans = 0;
		
		ans = Math.min((N/6+1) * pak[0], N*one[0]);
		ans = Math.min(ans, N%6*one[0] + (N/6)*pak[0]);
		
		System.out.println(ans);
	}
}
