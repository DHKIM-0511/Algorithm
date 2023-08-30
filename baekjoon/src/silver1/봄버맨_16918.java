package silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 봄버맨_16918 {
	static int R,C,N;
	static char[][] map;
	static int[][] time;
	static int[] dr = {-1,1,0,0} , dc= {0,0,-1,1};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		for(int i= 0 ; i < R; i++) {
			String tmp = br.readLine();
			for(int j = 0 ; j < C ; j++) {
				map[i][j] = tmp.charAt(j);
				if(map[i][j] == 'O') time[i][j] =3;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		int t = 1;
		while(true) {
			if(N < 0) {
				break;
			}
			
			if(t % 2 == 0) {
				setBombs();
			}
			
			if(t >= 3 ) {
				bomb();
			}
		}
	}
	private static void bomb() {
		
	}
	private static void setBombs() {
		for(int i = 0 ; i < )
		
	}
}
