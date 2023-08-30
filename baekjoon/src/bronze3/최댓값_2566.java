package bronze3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 최댓값_2566 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int[][] num = new int[9][9];
		int max = 0;
		int r = 0;
		int c = 0;
		
		for(int i = 0 ; i < 9 ; i++) {
			st= new StringTokenizer(br.readLine());
			for(int j = 0 ; j < 9 ; j++) {
				num[i][j] = Integer.parseInt(st.nextToken());
				if(num[i][j]>max) {
					max = num[i][j];
					r=i;
					c=j;
				}
			}
		}
		System.out.println(max);
		System.out.print((r+1)+" "+(c+1));
		
	}
}
