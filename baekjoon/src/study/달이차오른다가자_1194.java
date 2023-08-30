package study;

import java.io.*;
import java.util.*;

public class 달이차오른다가자_1194 {
	static int N,M;
	static char[][] map;
	//            r,c,a,b,c,d,e,f
	static boolean[][][][][][][][] visited;
	
	static idx start;
	
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	static class idx{
		int x,y,cnt;
		int a,b,c,d,e,f;
		public idx(int x, int y, int cnt, int a, int b, int c, int d, int e, int f) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.a = a;
			this.b = b;
			this.c = c;
			this.d = d;
			this.e = e;
			this.f = f;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 행
		M = Integer.parseInt(st.nextToken()); // 열
		map = new char[N][M];
		visited = new boolean[N][M][2][2][2][2][2][2];
		
		for(int i = 0 ; i < N ; i++) {
			String tmp = br.readLine();
			for(int j = 0 ; j < M ; j++) {
				map[i][j] = tmp.charAt(j);
				if(map[i][j] == '0') start = new idx(i, j,1,0,0,0,0,0,0);
			}
		}
		System.out.println(BFS());
	}
	private static int BFS() {
		Queue<idx> q = new LinkedList<>();
		visited[start.x][start.y][0][0][0][0][0][0] = true;
		q.add(start);
		
		while(!q.isEmpty()) {
			idx cur = q.poll();
			
			for(int i = 0 ; i< 4 ; i++) {
				int nr = cur.x+dr[i];
				int nc = cur.y+dc[i];
				
				if(nr >=0 && nr < N && nc >=0 && nc <M) {
					if(map[nr][nc] == '1') {
						return cur.cnt;
					}
					
					if(map[nr][nc] == '.' &&!visited[nr][nc][cur.a][cur.b][cur.c][cur.d][cur.e][cur.f]) {
						visited[nr][nc][cur.a][cur.b][cur.c][cur.d][cur.e][cur.f] = true;
						q.offer(new idx(nr, nc, cur.cnt+1, cur.a, cur.b, cur.c, cur.d, cur.e, cur.f));
					}
					
					if(map[nr][nc] == '0' &&!visited[nr][nc][cur.a][cur.b][cur.c][cur.d][cur.e][cur.f]) {
						visited[nr][nc][cur.a][cur.b][cur.c][cur.d][cur.e][cur.f] = true;
						q.offer(new idx(nr, nc, cur.cnt+1, cur.a, cur.b, cur.c, cur.d, cur.e, cur.f));
					}
					//열쇠 줍기
					if(map[nr][nc] == 'a'&& cur.a ==0 &&!visited[nr][nc][cur.a+1][cur.b][cur.c][cur.d][cur.e][cur.f]) {
						visited[nr][nc][cur.a+1][cur.b][cur.c][cur.d][cur.e][cur.f] = true;
						q.offer(new idx(nr, nc, cur.cnt+1, cur.a+1, cur.b, cur.c, cur.d, cur.e, cur.f));
					}
					if(map[nr][nc] == 'b'&& cur.b ==0 &&!visited[nr][nc][cur.a][cur.b+1][cur.c][cur.d][cur.e][cur.f]) {
						visited[nr][nc][cur.a][cur.b+1][cur.c][cur.d][cur.e][cur.f] = true;
						q.offer(new idx(nr, nc, cur.cnt+1, cur.a, cur.b+1, cur.c, cur.d, cur.e, cur.f));
					}
					if(map[nr][nc] == 'c'&& cur.c ==0 &&!visited[nr][nc][cur.a][cur.b][cur.c+1][cur.d][cur.e][cur.f]) {
						visited[nr][nc][cur.a][cur.b][cur.c+1][cur.d][cur.e][cur.f] = true;
						q.offer(new idx(nr, nc, cur.cnt+1, cur.a, cur.b, cur.c+1, cur.d, cur.e, cur.f));
					}
					if(map[nr][nc] == 'd'&& cur.d ==0 &&!visited[nr][nc][cur.a][cur.b][cur.c][cur.d+1][cur.e][cur.f]) {
						visited[nr][nc][cur.a][cur.b][cur.c][cur.d+1][cur.e][cur.f] = true;
						q.offer(new idx(nr, nc, cur.cnt+1, cur.a, cur.b, cur.c, cur.d+1, cur.e, cur.f));
					}
					if(map[nr][nc] == 'e'&& cur.e ==0 &&!visited[nr][nc][cur.a][cur.b][cur.c][cur.d][cur.e+1][cur.f]) {
						visited[nr][nc][cur.a][cur.b][cur.c][cur.d][cur.e+1][cur.f] = true;
						q.offer(new idx(nr, nc, cur.cnt+1, cur.a, cur.b, cur.c, cur.d, cur.e+1, cur.f));
					}
					if(map[nr][nc] == 'f'&& cur.f ==0 &&!visited[nr][nc][cur.a][cur.b][cur.c][cur.d][cur.e][cur.f+1]) {
						visited[nr][nc][cur.a][cur.b][cur.c][cur.d][cur.e][cur.f+1] = true;
						q.offer(new idx(nr, nc, cur.cnt+1, cur.a, cur.b, cur.c, cur.d, cur.e, cur.f+1));
					}
					//열쇠 있을때 이동
					if(map[nr][nc] == 'a'&& cur.a ==1 &&!visited[nr][nc][cur.a][cur.b][cur.c][cur.d][cur.e][cur.f]) {
						visited[nr][nc][cur.a][cur.b][cur.c][cur.d][cur.e][cur.f] = true;
						q.offer(new idx(nr, nc, cur.cnt+1, cur.a, cur.b, cur.c, cur.d, cur.e, cur.f));
					}
					if(map[nr][nc] == 'b'&& cur.b ==1 &&!visited[nr][nc][cur.a][cur.b][cur.c][cur.d][cur.e][cur.f]) {
						visited[nr][nc][cur.a][cur.b][cur.c][cur.d][cur.e][cur.f] = true;
						q.offer(new idx(nr, nc, cur.cnt+1, cur.a, cur.b, cur.c, cur.d, cur.e, cur.f));
					}
					if(map[nr][nc] == 'c'&& cur.c ==1 &&!visited[nr][nc][cur.a][cur.b][cur.c][cur.d][cur.e][cur.f]) {
						visited[nr][nc][cur.a][cur.b][cur.c][cur.d][cur.e][cur.f] = true;
						q.offer(new idx(nr, nc, cur.cnt+1, cur.a, cur.b, cur.c, cur.d, cur.e, cur.f));
					}
					if(map[nr][nc] == 'd'&& cur.d ==1 &&!visited[nr][nc][cur.a][cur.b][cur.c][cur.d][cur.e][cur.f]) {
						visited[nr][nc][cur.a][cur.b][cur.c][cur.d][cur.e][cur.f] = true;
						q.offer(new idx(nr, nc, cur.cnt+1, cur.a, cur.b, cur.c, cur.d, cur.e, cur.f));
					}
					if(map[nr][nc] == 'e'&& cur.e ==1 &&!visited[nr][nc][cur.a][cur.b][cur.c][cur.d][cur.e][cur.f]) {
						visited[nr][nc][cur.a][cur.b][cur.c][cur.d][cur.e][cur.f] = true;
						q.offer(new idx(nr, nc, cur.cnt+1, cur.a, cur.b, cur.c, cur.d, cur.e, cur.f));
					}
					if(map[nr][nc] == 'f'&& cur.f ==1 &&!visited[nr][nc][cur.a][cur.b][cur.c][cur.d][cur.e][cur.f]) {
						visited[nr][nc][cur.a][cur.b][cur.c][cur.d][cur.e][cur.f] = true;
						q.offer(new idx(nr, nc, cur.cnt+1, cur.a, cur.b, cur.c, cur.d, cur.e, cur.f));
					}
					
					if(map[nr][nc] == 'A'&& cur.a ==1 &&!visited[nr][nc][cur.a][cur.b][cur.c][cur.d][cur.e][cur.f]) {
						visited[nr][nc][cur.a][cur.b][cur.c][cur.d][cur.e][cur.f] = true;
						q.offer(new idx(nr, nc, cur.cnt+1, cur.a, cur.b, cur.c, cur.d, cur.e, cur.f));
					}
					if(map[nr][nc] == 'B'&& cur.b ==1 &&!visited[nr][nc][cur.a][cur.b][cur.c][cur.d][cur.e][cur.f]) {
						visited[nr][nc][cur.a][cur.b][cur.c][cur.d][cur.e][cur.f] = true;
						q.offer(new idx(nr, nc, cur.cnt+1, cur.a, cur.b, cur.c, cur.d, cur.e, cur.f));
					}
					if(map[nr][nc] == 'C'&& cur.c ==1 &&!visited[nr][nc][cur.a][cur.b][cur.c][cur.d][cur.e][cur.f]) {
						visited[nr][nc][cur.a][cur.b][cur.c][cur.d][cur.e][cur.f] = true;
						q.offer(new idx(nr, nc, cur.cnt+1, cur.a, cur.b, cur.c, cur.d, cur.e, cur.f));
					}
					if(map[nr][nc] == 'D'&& cur.d ==1 &&!visited[nr][nc][cur.a][cur.b][cur.c][cur.d][cur.e][cur.f]) {
						visited[nr][nc][cur.a][cur.b][cur.c][cur.d][cur.e][cur.f] = true;
						q.offer(new idx(nr, nc, cur.cnt+1, cur.a, cur.b, cur.c, cur.d, cur.e, cur.f));
					}
					if(map[nr][nc] == 'E'&& cur.e ==1 &&!visited[nr][nc][cur.a][cur.b][cur.c][cur.d][cur.e][cur.f]) {
						visited[nr][nc][cur.a][cur.b][cur.c][cur.d][cur.e][cur.f] = true;
						q.offer(new idx(nr, nc, cur.cnt+1, cur.a, cur.b, cur.c, cur.d, cur.e, cur.f));
					}
					if(map[nr][nc] == 'F'&& cur.f ==1 &&!visited[nr][nc][cur.a][cur.b][cur.c][cur.d][cur.e][cur.f]) {
						visited[nr][nc][cur.a][cur.b][cur.c][cur.d][cur.e][cur.f] = true;
						q.offer(new idx(nr, nc, cur.cnt+1, cur.a, cur.b, cur.c, cur.d, cur.e, cur.f));
					}
				}
			}
		}
		return -1;
	}
}














