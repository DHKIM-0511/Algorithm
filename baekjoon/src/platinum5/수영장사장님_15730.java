package platinum5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class 수영장사장님_15730 {
	static int N,M,ans;
	static int[][] map;
	static boolean[][] visited;
	static idx lowH;
	static PriorityQueue<idx> pq;
	static Stack<idx> stack;
	static int[] dr = {-1, 1, 0, 0} , dc= {0,0,-1,1};
	static class idx implements Comparable<idx>{
		int r, c,h;

		public idx(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		public idx(int r, int c, int h) {
			super();
			this.r = r;
			this.c = c;
			this.h = h;
		}

		@Override
		public int compareTo(idx o) {
			return this.h - o.h;
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M];
		pq = new PriorityQueue<>();
		stack = new Stack<>();
		
		int tmp = Integer.MAX_VALUE;
		for(int i = 0 ; i< N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < M ; j++) {
				int H = Integer.parseInt(st.nextToken());
				map[i][j] = H;
				if(H < tmp) {
					tmp=H;
					lowH = new idx(i, j);
				}
			}
		}
		ans = 0;
		findHole();
		System.out.println();
	}

	private static void findHole() {
		
		for(int i = 1 ; i < N-1 ; i++) { // 모서리 제외
			for(int j = 1 ; j< M-1 ; j++) {
				if(check(i,j)) {
					stack.push(new idx(i, j)); //시작 구덩이 스택에 추가
					
				}
			}
		}
		getWaterSum();
	}

	private static void getWaterSum() {
		int[] nearH = new int[4];
		
		while(!stack.isEmpty()) {
			idx cur = stack.pop();
			
			visited[cur.r][cur.c] = true;
			
			idx tmp = null;
			for(int i = 0 ; i < 4; i++) {
				int nr = cur.r +dr[i];
				int nc = cur.c +dc[i];
				
				if(range(nr,nc)&& !visited[nr][nc]) {
					nearH[i] = map[nr][nc]; 
				}
			}
			// 주변 높이가 같을 경우
			if(isEqual(nearH)) {
				ans+= nearH[0]-cur.h;
				
			}else {//주변 높이가 다를경우
//				idx next =
//				stack.push(next);s
			}
		}
	}

	private static boolean isEqual(int[] nearH) {
		for(int i = 1 ; i< 4; i++) {
			if(nearH[0] != nearH[i]) return false;
		}
		return true;
	}

	private static boolean check(int r, int c) {
		boolean flag = true;
		
		for(int i = 0 ; i< 4 ; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if(range(nr,nc)) {
				if(map[nr][nc] < map[r][c]) flag = false;
			}
		}
		return flag;
	}
	static boolean range(int x,int y) {
		if(x>=0 && x < N && y >=0 && y <M) return true;
		else return false;
	}
}
