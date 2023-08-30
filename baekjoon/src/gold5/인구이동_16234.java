package gold5;

import java.io.*;
import java.util.*;
//		두 나라의 인구 차이가 L이상 R이하 인경우 인구 이동 시작
//		두 국가의 인구이동중 = 연합( 각 연합의 인구수 = 연합의 인구수 / 칸의 개수 )
//		인구 이동이 없을때까지 지속

public class 인구이동_16234 {
	static int N,L,R,cnt,sum,ans;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {-1,1,0,0} ,dc= {0,0,-1,1};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		for(int i = 0 ; i < N ;i++) {
			st= new StringTokenizer(br.readLine());
			for(int j = 0 ; j < N ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		ans=0;
		visited = new boolean[N][N];
		while(true) {
			cnt=sum=0;
			for(int i = 0 ; i < N ; i++) {
				for(int j = 0 ; j < N ; j++) {
					if(!visited[i][j]) {
						BFS(new idx(i, j));
						
					}
				}
			}
			if(cnt == 0) break;
			else {
				for(int i = 0 ; i< N ; i++) {
					for(int j = 0 ; j < N ; j++) {
						map[i][j] = sum/cnt;
					}
				}
				ans++;
			}
		}
		System.out.println(ans);
	}
	private static void BFS(idx start) {
		Queue<idx> q = new LinkedList<>();
		visited[start.r][start.c] = true;
		q.add(start);
		
		while(!q.isEmpty()) {
			idx cur = q.poll();
			System.out.println(cur.toString());
			sum+=map[cur.r][cur.c];
			System.out.println("ans:"+ans);
			System.out.println("cnt:"+cnt);
			for(int i = 0 ; i < 4 ; i++) {
				int nr = cur.r+dr[i];
				int nc = cur.c+dc[i];
				
				if(nr>=0 && nr <N && nc >=0 && nc <N && !visited[nr][nc]) {
					if(Math.abs(map[cur.r][cur.c] - map[nr][nc]) >= L && Math.abs(map[cur.r][cur.c] - map[nr][nc]) <=R) {
						cnt++;
						System.out.println("l:"+Math.abs(map[cur.r][cur.c] - map[nr][nc]));
						System.out.println("idx:"+map[nr][nc]);
						visited[nr][nc] = true;
						q.add(new idx(nr, nc));
					}
				}
			}
		}
	}
	static class idx{
		int r,c;
		
		public idx(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "idx [r=" + r + ", c=" + c + "]";
		}
	}
}

