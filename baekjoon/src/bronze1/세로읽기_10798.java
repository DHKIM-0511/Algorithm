package bronze1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 세로읽기_10798 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		char[][] arr = new char[5][15];
		
		for(int i = 0 ; i < 5 ; i++) {
			String tmp = br.readLine();
			for(int j = 0 ; j < tmp.length() ; j++) {
				arr[i][j] = tmp.charAt(j);
			}
			for(int j = tmp.length() ; j < 15 ; j++) {
				arr[i][j] = '*';
			}
		}
		
		for(int i = 0 ; i < 15 ; i++) {
			for(int j = 0 ; j < 5 ; j ++) {
				if(arr[j][i] != '*')
					sb.append(arr[j][i]);
			}
		}
		
		
		System.out.println(sb);
	
	}
}
