package gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class 연구소_14502 {
	
	static int n,m,max;
	static int[][] map;
	static LinkedList<node> list = new LinkedList<>();
	static ArrayList<node> list_virus = new ArrayList<>();
	
	
	public static class node{
		int r;
		int c;
		public node(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		
		for(int i = 0 ; i < n ; i++) {
			st= new StringTokenizer(br.readLine());
			for(int j = 0 ; j < m ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2) {
					//바이러스 인덱스 리스트에 추가
					node nd = new node(i,j);
					list_virus.add(nd);
				}
				else if(map[i][j]==0){
					// 0 (현재 safeZone 리스트에 추가)
					node o = new node(i, j);
					list.add(o);
				}
			}
		}
		
		// cnt = 0 부터
		// last_idx = 0 부터  0부터뽑을꺼니까
		// chosen배열 새로 3길이짜리 생성해서 넣어줌.
		max = 0;
		buildWall(0, 0, new int[3]);
		
		System.out.println(max);
	}
	

	
	// 3개를 뽑고,
	// 그 위치에서 arr= 1
	// bfs
	// arr 0
	// max 갱신
	// 또 3개 뽑고, ...
	
	// int[] chosen 이라는 배열을 만들거에요
	// 여기에는 뽑은 좌표를 세곳 저장할 배열이에요.
	// ex) chosen[] = {0,5,7};
	// list.get(0)
	// list.get(5)
	// list.get(7)
	// 모두 arr = 1 벽으로 만들어주고
	// 2 위치에서 bfs를 실시합니다.
	// bfs 가 끝나면 남은 0의 개수를 셉니다
	// arr = 0 이게중요. 원상복구 ( = 백트래킹)
	// 여기서 마지막으로 max 값을 갱신하면됩니다. (max 값은 글로벌변수로, 누적갱신)
	
	private static void buildWall(int cnt, int last_idx, int[] chosen) {// 재귀
		if(cnt >= 3) {
//			System.out.println(Arrays.toString(chosen));
			// chosen[] =  {0,5,7};
			for(int i=0; i<chosen.length; i++) {
				node nn = list.get(chosen[i]);
				int row = nn.r;
				int col = nn.c;
				
				map[row][col] = 1;
			}
			
			// 모두 1 로 벽 칠해줬음
			// bfs 실행
			virus(map);
			
			for(int i=0; i<chosen.length; i++) {
				node nn = list.get(chosen[i]);
				int row = nn.r;
				int col = nn.c;
				
				map[row][col] = 0;
			}
			
		}
		
		else {
			for(int i=last_idx; i<list.size(); i++) {
				//cnt2일때 cnt 3실행(bfs및 재귀종료) -> c[2]값을 다음 값으로for문으로 바꿔줌
				// 결과적으로 chosen배열의 2번 idx가 계속 바뀌면서 for문을 끝까지 실행..
				// cnt 1로 돌아와서 cnt 1을 for문을 통해 다음값으로 변경
				// cnt 2값 할당 후 cnt 3 실행 ..하며 모든 경우의수를 탐색한다
				chosen[cnt] = i;
				buildWall(cnt + 1, i+1, chosen);
//				chosen[cnt] = 0; // 백트래킹 해주면 좋다.
				
			}
		}
	}
	private static void virus(int[][] map) {
		
		int[][] map_copy = new int[n][m];
		for(int r=0; r<n; r++) {
			map_copy[r] = Arrays.copyOf(map[r], m);
		}
		
		
		
		int[] dr = {-1 , 1 , 0 , 0};
		int[] dc = {0 , 0 , -1 , 1};
		
		Queue<node> q2 = new LinkedList<>();
		for(int i=0; i<list_virus.size(); i++) {
			q2.add(list_virus.get(i));
		}
		
		while(!q2.isEmpty()) {
			node nd = q2.poll();
			
			for(int i = 0 ; i < 4 ; i++) {
				int nr = nd.r + dr[i];
				int nc = nd.c + dc[i];
				
				if(nr >= 0 && nr < n && nc >=0 && nc < m) {
					if(map_copy[nr][nc] == 0) {
						map_copy[nr][nc] = 2;
						node o = new node(nr,nc);
						q2.offer(o);
					}
				}
			}
		}
		
		// max 값 갱신해주는 코드만 넣어주면..
		
		int safe_zone = 0;
		for(int r=0; r<n; r++) {
			for(int c=0; c<m; c++) {
				if(map_copy[r][c] == 0) {
					safe_zone++;
				}
			}
		}
//		System.out.println(safe_zone);
		
		max = Math.max(max,  safe_zone);
		
	}
}
