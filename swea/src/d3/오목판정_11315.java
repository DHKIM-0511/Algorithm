package d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 오목판정_11315 {
	static int n;
	
	static boolean omok(char[][] a) {
		
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j < n ; j++) {
				if(a[i][j] == 'o') {
					int om = 0;
					
					for(int k = 1 ; k < 5 ; k++) {
						if (i + k < n) {
							if(a[i+k][j] == 'o') // 수직 오목이면
								om++;
							else {
								om = 0;
								break;
							}
						}
					}
					if(om == 4)
						return true;
					else om = 0;
					
					for(int k = 1 ; k < 5 ; k++) {
						if(j+k < n) {
							if(a[i][j+k] == 'o') // 수평 오목이면
								om++;
							else {
								om = 0;
								break;
							}
						}
					}
					if(om == 4)
						return true;
					else om = 0;
					
					for(int k = 1 ; k < 5 ; k++) {
						if(i+k < n && j + k < n) {
							if(a[i+k][j+k] == 'o') // 오른쪽 대각선 오목이면
								om++;
							else {
								om = 0;
								break;
							}
						}
					}
					if(om == 4)
						return true;
					else om = 0;
					
					for(int k = 1 ; k < 5 ; k++) {
						if(i+k<n && j-k>=0) {
							if(a[i+k][j-k] == 'o') // 왼쪽 대각선 오목이면
								om++;
							else {
								om = 0;
								break;
						}
					}
				}
				if(om == 4)
					return true;
				else om = 0;
			}
		}
	}
		return false;
}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		for(int tc = 1 ; tc <= t ; tc++) {
			
			n = Integer.parseInt(br.readLine());
			
			char[][] arr = new char[n][n];
			
			for (int r = 0; r < n; r++) {
				
				String line = br.readLine();
				
				for (int c = 0; c < n; c++) {
					arr[r][c] = line.charAt(c);
				}
			}
			
			if(omok(arr)) {
				System.out.println("#"+tc+" YES");
			}else
				System.out.println("#"+tc+" NO");
			
		}
	}
}
