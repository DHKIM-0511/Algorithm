package gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 알파벳_1987 {
	static int R,C,ans;
	static char[][] map;
	static boolean[] visited;
	static int[]dr= {-1,1,0,0} , dc= {0,0,-1,1};
	static class idx{
		int r,c,cnt;

		public idx(int r, int c,int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=  new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken()); 
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		visited = new boolean[26]; //A~Z 65 ~ 90
		for(int i = 0 ; i< R ; i++) {
			String tmp = br.readLine();
			for(int j = 0 ; j < C ; j++) {
				map[i][j] = tmp.charAt(j);
			}
		}
		
		ans = Integer.MIN_VALUE;
		DFS(new idx(0, 0,0));
		
		System.out.println(ans);
	}
	private static void DFS(idx cur) {
		if(visited[(int)map[cur.r][cur.c]-65]) {
			ans = Math.max(ans, cur.cnt);
			return;
		}
		visited[(int)map[cur.r][cur.c]-65] = true;
		for(int i = 0 ; i< 4 ; i++) {
			int nr = cur.r + dr[i];
			int nc = cur.c + dc[i];
			
			if(nr >=0 && nr <R && nc >=0 &&nc < C) {
				DFS(new idx(nr, nc,cur.cnt+1));
			}
		}
		visited[(int)map[cur.r][cur.c]-65] = false;
	}
}
