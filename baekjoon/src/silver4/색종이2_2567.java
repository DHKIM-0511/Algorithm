package silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 색종이2_2567 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int[][] paper = new int[100][100];

		
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken()); 
			int y = Integer.parseInt(st.nextToken());
			for(int j = x ; j < x+10 ; j++) {
				for(int k = y ; k < y+10 ; k++) {
					paper[j][k]=1;
				}
			}
		}
		System.out.println(roundLength(paper));

	}

	private static int roundLength(int[][] paper) {
		int length = 0;
		int[] dr = { -1 , 0 , 1 , 0};
		int[] dc = {  0 ,-1 , 0 , 1};
		
		for(int i = 0 ; i < 100 ; i++) {
			for(int j = 0 ; j < 100 ; j++) {
				if(paper[i][j] == 1)
					for(int k = 0 ; k < 4 ; k++) {
						int nr = i + dr[k];
						int nc = j + dc[k];
						if(nr<100 && nr >=0 && nc <100 && nc >=0 && paper[nr][nc] == 0)
							length++;
						else if(nr<0 || nr >=100 || nc < 0 || nc >= 100)
							length++;
						
					}
			}
		}
		return length;
	}
}
