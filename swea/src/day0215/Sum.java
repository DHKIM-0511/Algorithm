package day0215;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sum {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int tc = 0 ; tc < 10 ; tc++) {
			int t = Integer.parseInt(br.readLine());
			
			int[][] arr = new int[100][100];
			for(int i = 0 ; i < 100 ; i++) { // 배열 입력
				st = new StringTokenizer(br.readLine());
				for(int j = 0 ; j < 100 ; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			//가로합 , 세로합 , 대각선 합중 최대값을 출력.
			int hSum = 0;
			int vSum = 0;
			int cSum = 0;
			int ctemp =0;
			int ans = 0;
			
			for(int i = 0 ; i < 100 ; i++) {
				
				int htemp = 0;
				int vtemp = 0;
				
				for(int j = 0 ; j < 100 ; j++) {	
					htemp += arr[i][j];
					vtemp += arr[j][i];
				}
				
				if(htemp > hSum) {
					hSum = htemp;
				}
				if(vtemp > vSum) {
					vSum = vtemp;
				}
				
				ctemp += arr[i][i]; 
				cSum += arr[99-i][i];
			}
			cSum = Math.max(cSum, ctemp);
			ans = Math.max(hSum, vSum);
			ans = Math.max(ans, cSum);
			
			System.out.println("#"+t+" "+ans);
		}
	}
}
