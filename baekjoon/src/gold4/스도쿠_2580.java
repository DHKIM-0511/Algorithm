package gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 스도쿠_2580 {
	static int[][] map = new int[9][9];
	static StringBuilder sb = new StringBuilder();
	static class idx{
		int r,c;
		public idx(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i = 0 ; i < 9 ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < 9 ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		back(new idx(0, 0));
		
	}
	private static void back(idx cur) {
		if(cur.c == 9) {
			back(new idx(cur.r+1, 0));
			return;
		}
		if(cur.r == 9) {
			for(int i = 0 ; i < 9 ; i++) {
				for(int j = 0 ; j < 9 ; j++) {
					sb.append(map[i][j]).append(" ");
				}
				sb.append('\n');
			}
			System.out.println(sb);
			System.exit(0);
		}
		if(map[cur.r][cur.c] == 0) {
			
			for(int i = 1 ; i < 10 ; i++) {
				if(check(cur,i)) {
					map[cur.r][cur.c] = i;
					back(new idx(cur.r, cur.c+1));
				}
			}
			map[cur.r][cur.c] = 0;
			return;
		}
		back(new idx(cur.r, cur.c+1));
	}
	private static boolean check(idx cur , int tmp) {
		//행 및 열에 같은 값이있으면 불가
		for(int i = 0 ; i < 9 ; i++) {
			if(map[cur.r][i] == tmp) return false;
			if(map[i][cur.c] == tmp) return false;
		}
		
		int row = (cur.r / 3) * 3;
		int col = (cur.c / 3) * 3;
 
		for (int i = row; i < row + 3; i++) {
			for (int j = col; j < col + 3; j++) {
				if (map[i][j] == tmp) return false;
			}
		}
		return true;
	}
}
