package bronze1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 직사각형네개의합집합의면적구하기_2669 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[][] map = new int[100][100];
		int sum = 0;
		for(int i = 0 ; i < 4 ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			
			for(int j = x ; j < p ; j++) {
				for(int k = y ; k < q ; k++) {
					if(map[j][k] != 1) {
						map[j][k] = 1;
						sum++;
					}
				}
			}
		}
		
		System.out.println(sum);
	}
}
