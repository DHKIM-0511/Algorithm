package bronze1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 부녀회장이될테야_2775 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(br.readLine());
		
		int[][] num = new int[15][15];
		
		for(int i =0 ; i < 15 ; i++) {
			num[i][1] = 1;
			num[0][i] = i;
		}
		
		for(int i = 1; i < 15; i ++) {	
			 
			for(int j = 2; j < 15; j++) {	
				num[i][j] = num[i][j - 1] + num[i - 1][j];
			}
		}
		
		for(int i = 0 ; i < tc ; i++) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			System.out.println(num[k][n]);
		}
	}
}


