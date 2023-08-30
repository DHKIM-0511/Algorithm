package silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 빙고_2578 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[][] cs = new int[5][5];
		int[][] mc = new int[5][5];
		
		for(int i = 0 ; i < 2 ; i++) {
			for(int j = 0; j < 5; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int k = 0 ; k < 5 ; k++) {
					if(i==0) {
						cs[j][k] = Integer.parseInt(st.nextToken());
					} else {
						mc[j][k] = Integer.parseInt(st.nextToken());
					}
				}
			}
		}
		
		int cnt = 0;
		int x = 0;
		int y = 0;
		
		while(true) {
			
			for(int i = 0 ; i < 5 ; i++) {
				for(int j = 0 ; j< 5 ; j++) {
					if(mc[x][y] == cs[i][j]) {
						cs[i][j] = 0;
						cnt++;
					}
				}
			}
			
			//종료 조건.. 
			
				int bingo  = 0;
				
				//가로 빙고
				for(int i = 0 ; i < 5 ; i++) {
					boolean a = true;
					for(int j = 0 ; j< 5 ; j++) {
						
						if(cs[i][j] != 0) {
							a = false;
							break;
						}							
					}
					if(a)
						bingo++;
				}
					
				//세로 빙고
				for(int i = 0 ; i < 5 ; i++) {
					boolean a = true;
					for(int j = 0 ; j< 5 ; j++) {
						if(cs[j][i] != 0) {
							a = false;
							break;
						}	
					}
					if(a)
						bingo++;
				}
				
				//대각선 빙고
				boolean check = true;
				
				for(int i = 0 ; i < 5 ; i++) {
					if(cs[i][i] != 0) 
						check = false;
				}
				if(check) bingo++;
				
				check = true;
				for(int i = 0 ; i < 5 ; i++) {
					if(cs[4-i][i] != 0) 
						check = false;
				}
				if(check) bingo++;

				if(bingo>=3)
					break;
			
			
			
			y++;
			if(y == 5) {
				y = 0;
				x++;
			}
			if(x==5)
				break;
		}
		System.out.println(cnt);
	}
}
