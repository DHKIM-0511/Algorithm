package silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Stack;

public class 단지번호붙이기_2667 {
	static int cnt,N;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {-1,1,0,0} , dc= {0,0,-1,1};
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
		
		map = new int[N][N];
		visited = new boolean[N][N];
		
		for(int i = 0 ; i < N ; i++) {
			String str = br.readLine();
			for(int j = 0 ; j < N ; j++) {
				map[i][j] = str.charAt(j)-'0';
			}
		}
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				if(map[i][j] == 1 && visited[i][j] == false) {
					DFS(new idx(i, j));
					pq.add(cnt);
				}
			}
		}
		System.out.println(pq.size());
		while(!pq.isEmpty()) System.out.println(pq.poll());
	}
	private static void DFS(idx start) {
		Stack<idx> stack = new Stack<>();
		visited[start.r][start.c] = true;
		stack.push(start);
		cnt = 1;
		
		while(!stack.isEmpty()) {
			idx cur = stack.pop();
			
			for(int i = 0 ; i < 4 ; i++) {
				int nr = cur.r + dr[i];
				int nc = cur.c + dc[i];
				
				if(nr >= 0 && nr < N && nc >=0 && nc <N && visited[nr][nc] == false) {
					if(map[nr][nc] == 1) {
						cnt++;
						visited[nr][nc] = true;
						stack.push(new idx(nr, nc));
					}
				}
			}
		}
	}
}














