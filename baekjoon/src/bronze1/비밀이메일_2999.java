package bronze1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class 비밀이메일_2999 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int n = str.length();
		int r = 0;
		int c = 0;
		
		for(int i = 1 ; i <= n ; i++) {
			for(int j = i ;j <= n ; j++ ) {
				if(i <= j && i * j == n) {
					r = i;
					c = j;
				}	
			}
		}

		char[][] arr = new char[c][r];
		int cnt = 0 ;
		
		for(int i = 0 ; i < c ; i++) {
			for(int j = 0 ; j < r ; j++) {
				arr[i][j]=str.charAt(cnt);
				cnt++;
			}
		}
	
		for(int i = 0 ; i < r ; i++) {
			for(int j = 0 ; j < c ;j++) {
				System.out.print(arr[j][i]);
			}
		}
	}
}