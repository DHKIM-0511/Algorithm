package silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 덩치_7568 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] h = new int[n];
		int[] w = new int[n];
		for(int i = 0 ; i < n ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			h[i] = Integer.parseInt(st.nextToken());
			w[i] = Integer.parseInt(st.nextToken());
		}
		int[] rank = new int[n];
		
		for(int i = 0 ; i < n ; i++) {
			
			for(int j = 0 ; j < i ; j++) {
				if(h[i] < h[j] && w[i] < w[j])
					rank[i]++;
			}
		
			for(int j = i ; j<n ; j++) {
				if(h[i] < h[j] && w[i] < w[j])
					rank[i]++;
			}
		
		}
		
		for(int a : rank) {
			System.out.printf("%d ",a+1);
		}
	}
}
