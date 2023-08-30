package day0215;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ladder1 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int t = 1 ; t <= 10 ; t++) {
			int tc = Integer.parseInt(br.readLine());
			
			int[][] ladder = new int[100][100];
			
			for(int i = 0 ; i < 100 ; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0 ; j < 100 ; j++) {
					ladder[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			
			
		}
		
		
		
		
	}
}
