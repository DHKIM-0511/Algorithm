package gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 리모컨_1107 {
	static int N,M,ans;
	static int[] cant;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		cant= new int[M];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i< M ; i++) cant[i] =Integer.parseInt(st.nextToken());
		ans = Integer.MAX_VALUE;
		DFS(100);
		System.out.println(ans);
	}
	private static void DFS(int channel) {
		if(channel == N) {
			ans = Math.min(ans, channel);
			return;
		}
		
	}
}
