package gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 적록색약_10026 {
	static int N , nCnt , cCnt ;
	static char[][] map;
	static boolean[][][] visited;
	static int[] dr = {-1,1,0,0} , dc = {0,0,-1,1};
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
		
		N = Integer.parseInt(br.readLine());
		map =new char[N][N];
		visited =new boolean[2][N][N]; // 0 : 정상 , 1 : 색약
		
		for(int i = 0 ; i < N ; i++) {
			String str = br.readLine();
			for(int j = 0 ; j < N ; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				for(int k = 0 ; k < 2 ; k++) {
					if(!visited[k][i][j]) {
						bfs(new idx(i, j),k);
						if(k == 0 ) nCnt++;
						else cCnt++;
					}
				}
			}
		}
		System.out.println(nCnt+" "+cCnt);
	}
	private static void bfs(idx start,int k) {
		Queue<idx> q = new LinkedList<>();
		q.add(start);
		visited[k][start.r][start.c] = true;
		
		while(!q.isEmpty()) {
			idx cur = q.poll();
//			System.out.println("k:"+k);
//			System.out.println("cur.r:"+cur.r+"  cur.c:"+cur.c);
			
			for(int i = 0 ; i < 4 ; i++) {
				int nr = cur.r + dr[i];
				int nc = cur.c + dc[i];
				
				if(nr >=0 && nr < N && nc >= 0 && nc < N && !visited[k][nr][nc]) {
					if(k==0) { // 정상개수 세기
						if(map[nr][nc] == map[cur.r][cur.c]) {
							q.add(new idx(nr, nc));
							visited[k][nr][nc] = true;
						}
					}else {
						if(map[cur.r][cur.c] == 'R' || map[cur.r][cur.c] == 'G') {
							if(map[nr][nc] != 'B') {
								q.add(new idx(nr, nc));
								visited[k][nr][nc] = true;
							}
						}else {
							if(map[nr][nc] == map[cur.r][cur.c]) {
								q.add(new idx(nr, nc));
								visited[k][nr][nc] = true;
							}
						}
					}
				}
			}
		}
	}
}















