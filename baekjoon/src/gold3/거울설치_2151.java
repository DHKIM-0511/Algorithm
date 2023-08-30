package gold3;

import java.io.*;
import java.util.*;

public class 거울설치_2151 {
	static int N,ans;
	static idx start,end;
	static char[][] map;
	static boolean[][][] visited;
	static int[] dr = {-1,0,1,0},dc= {0,1,0,-1};
	
	static class idx implements Comparable<idx>{
		int r,c,n,d;

		public idx(int r, int c, int n, int d) {
			super();
			this.r = r;
			this.c = c;
			this.n = n;
			this.d = d;
		}

		@Override
		public int compareTo(idx o) {
			return this.n - o.n;
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		
		int cnt = 0;
		for(int i = 0; i < N; i++){
			String tmp = br.readLine();
			for(int j = 0 ; j < N ; j++) {
				map[i][j] = tmp.charAt(j);
				if(map[i][j] == '#') {
					if(cnt == 0) start = new idx(i, j, 0, 0);
					else end = new idx(i, j, 0, 0);
					cnt++;
				}
			}
        }

        BFS();
        System.out.println(ans);
    }

	private static void BFS() {
		PriorityQueue<idx> q = new PriorityQueue<>();
        visited = new boolean[N][N][4];
       
        for(int i=0; i<4; i++){
            q.offer(new idx(start.r, start.c, 0, i));
            visited[start.r][start.c][i] = true;
        }

        while(!q.isEmpty()){
            idx cur = q.poll();

            if(cur.r == end.r && cur.c == end.c){
                ans = cur.n;
                return;
            }
			
			int nr = cur.r+dr[cur.d];
			int nc = cur.c+dc[cur.d];
			
			if(nr>=0 && nr<N && nc>=0 && nc<N && !visited[nr][nc][cur.d]) { 

		        if(map[nr][nc] != '*') {
		        	//설치 하지 않고 진행.
			        q.add(new idx(nr, nc, cur.n, cur.d));
			        visited[nr][nc][cur.d] = true;
			        
			        if(map[nr][nc] == '!'){
			            q.add(new idx(nr, nc, cur.n+1, (cur.d+4-1)%4));
			            visited[nr][nc][(cur.d+4-1)%4] = true;
			            
			            q.add(new idx(nr, nc, cur.n+1, (cur.d+1)%4));
			            visited[nr][nc][(cur.d+1)%4] = true;
			        }
		        }
			}
        }
    }
}