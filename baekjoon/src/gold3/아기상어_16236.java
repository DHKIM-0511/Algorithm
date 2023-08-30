package gold3;

import java.io.*;
import java.util.*;

public class 아기상어_16236 {
	static int N,eat,ans;
	static int[][] map;
	static int[] dr = {-1,0,1,0}, dc = {0,-1,0,1};
	static boolean[][] visited;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		idx start=null;
		for(int i =0 ; i < N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < N ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 9) { // 시작 위치 지정
					start = new idx(i, j, 2, 0);
					map[i][j]=0;
				}
			}
		}
		ans = 0;
		while(true) {
			// 먹을때마다 방문배열 초기화
			visited = new boolean[N][N];
			// BFS함수 결과 임시 저장
			idx tmp =BFS(start);
			
			if(tmp.r == -1)break;// 먹을 물고기가 없으면 끝냄
			else start = tmp; // 있으면 시작위치를 먹은 위치로 설정
		}
		System.out.println(ans);
	}
	private static idx BFS(idx start) {
		Queue<idx> q = new LinkedList<>();
		
		PriorityQueue<idx> pq = new PriorityQueue<>();// 같은 깊이의 먹을 수 있는 물고기들을 저장 
		visited[start.r][start.c]= true; // 시작위치 방문
		q.add(start);
		
		while(!q.isEmpty()) {
			idx cur = q.poll();
			
			for(int i = 0 ; i < 4 ; i++) { // 델타 배열
				int nr = cur.r+dr[i];
				int nc = cur.c+dc[i];
				//경계 조건 내부 && !방문 && 현재 크기보다 작거나 같은경우
				if(nr>=0 && nr < N && nc >=0 && nc <N && !visited[nr][nc] && map[nr][nc] <= cur.size) {
					// 먹을수 있는 물고기를 찾음 && 해당 깊이보다 크면 건너뜀
					if(!pq.isEmpty() && cur.len+1 > pq.peek().len) continue;
					//같은크기 || 0 이면 이동
					if(map[nr][nc] == cur.size || map[nr][nc] == 0) {
						visited[nr][nc] = true;
						q.add(new idx(nr, nc, cur.size, cur.len+1));
					}
					//먹을 수 있는 물고기이면 pq 저장
					else if(map[nr][nc] < cur.size) {
						pq.add(new idx(nr, nc, cur.size, cur.len+1));
					}
				}
			}
		}
		//같은 깊이를 모두 고려후
		if(!pq.isEmpty()) {
			idx next = pq.poll(); // r이 작고 같다면 c가 작은 idx
			eat++;
			if(eat == next.size) {
				eat = 0;
				next.size++;
			}
			visited[next.r][next.c] = true;
			map[next.r][next.c] = 0;
			
			ans+=next.len;
			next.len = 0;
			return  next; 
		}
		//물고기 없음
		return new idx(-1, -1, -1, -1);
	}
	static class idx implements Comparable<idx>{
		int r,c,size,len;
		
		public idx(int r, int c, int size, int len) {
			super();
			this.r = r;
			this.c = c;
			this.size = size;
			this.len = len;
		}

		@Override
		public int compareTo(idx o) {
			if(this.r == o.r) return this.c-o.c;
			else return this.r-o.r;
		}
	}
}
