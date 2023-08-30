package bronze1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 색종이_10163 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[][] map = new int[1001][1001];
		
		int n = Integer.parseInt(br.readLine());
		
		for(int i = 0 ; i < n ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			
			for(int j = x ; j < x+w ; j++) {
				for(int k = y ; k < y+h ; k++ ) {
					map[j][k] = i+1;
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0 ; i < n ; i++) {
			int sum = 0;
			for(int j = 0 ; j < 1001 ; j++) {
				for(int k = 0 ; k < 1001 ; k++) {
					if(map[j][k] == i+1) {
						sum++;
						
					}
				}
			}
			sb.append(sum).append("\n");
		}
		
		System.out.println(sb);
	}
}
