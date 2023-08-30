package gold3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 말이되고픈원숭이_1600 {
	static int K,W,H , ans;
	static int[][] map;
	static class idx{
		int r,c , cnt,Hcnt;

		public idx(int r, int c, int cnt, int hcnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			Hcnt = hcnt;
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine()); // 말처럼 움직이는 횟수
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		map = new int[H][W]; // 1은 장애물 , 0 만 갈 수 있음. 왼쪽위 -> 우하
		
		for(int i = 0 ; i < H ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < W ; j++) {
				map[i][j] =Integer.parseInt(st.nextToken());
			}
		}
		ans = Integer.MAX_VALUE;
		
		move(new idx(0,0,0,0));
		
		if(ans ==Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(ans);
	}
	private static void move(idx start) {
		
		//경로마다 방문처리를 새롭게 고려해주어야한다
		int[][][] visited = new int[K+1][H][W];
		
		Queue<idx> q = new LinkedList<>();
		q.add(start);
		
		while(!q.isEmpty()) {
			idx cur = q.poll();
			
			if(cur.r == H-1 && cur.c == W-1) {
				ans = Math.min(ans, cur.cnt);
				break;
			}
//			for(int i = 0 ; i< K+1 ; i++) {
//				for(int j = 0 ; j < H ; j++) {
//					for(int k = 0 ; k < W ;k++ ) {
//						System.out.print(visited[i][j][k]);
//					}
//					System.out.println();
//				}
//				System.out.println("--------------------------------");
//			}
			if(cur.Hcnt <K) {
				int[] dr = {-2 , -1 , 1 , 2 , 2 , 1 , -1 , -2};
				int[] dc = { -1 , -2 ,-2 ,-1 , 1 , 2 ,  2 ,  1};
				for(int i = 0 ; i < 8 ; i++) {
					int nr = cur.r + dr[i];
					int nc = cur.c + dc[i];
					
					if(nr >= 0 && nr < H && nc >= 0 &&nc < W) {
						if(visited[cur.Hcnt+1][nr][nc]==0 & map[nr][nc] ==0) {
							visited[cur.Hcnt+1][nr][nc] = 1;
							q.add(new idx(nr, nc , cur.cnt+1, cur.Hcnt+1));
						}
					}
				}
			} 
			int[] dr = {-1 , 1 , 0 , 0};
			int[] dc = { 0 , 0 ,-1 , 1};
			for(int i = 0 ; i < 4 ; i++) {
				int nr = cur.r + dr[i];
				int nc = cur.c + dc[i];
				
				if(nr >= 0 && nr < H && nc >= 0 &&nc < W) {
					if(visited[cur.Hcnt][nr][nc]==0 & map[nr][nc] ==0) {
						visited[cur.Hcnt][nr][nc] = 1;
						q.add(new idx (nr, nc,cur.cnt+1,cur.Hcnt));
					}
				}
			}
		}
	}
}