package gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n,m,max;
	static int[][] map;
	static ArrayList<index> list0 = new ArrayList<>();
	static ArrayList<index> virusIndex = new ArrayList<>();
	
	public static class index{
		int r;
		int c;
		public index(int r, int c) {
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
		
		for(int i = 0 ; i < n ; i ++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < m ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if(map[i][j] == 2) {
					 // 바이러스 인덱스 리스트에 추가
					index idx = new index(i, j);
					virusIndex.add(idx);
				}else if(map[i][j] == 0) {
					// 0 (현재 safeZone 리스트에 추가)
					index idx = new index(i, j);
					list0.add(idx);
				}
			}
		}
		max = 0;
		buildWall(0,0,new int[3]);
		System.out.println(max);
	}
	private static void buildWall(int cnt, int lastIndex, int[] chosen) { //재귀
		
		if(cnt >= 3) {
			for(int i = 0 ; i < chosen.length ; i++) {
				int row = list0.get(chosen[i]).r;
				int col = list0.get(chosen[i]).c;
				map[row][col] = 1;
			}
			virus(map);
			
			for(int i = 0 ; i < chosen.length ; i++) { // 백트래킹
				int row = list0.get(chosen[i]).r;
				int col = list0.get(chosen[i]).c;
				map[row][col] = 0;
			}
			
		}else {
			//0번의 IDX가 들어있는 리스트만큼 lastIDX부터 반복문 실행
			for(int i = lastIndex ; i < list0.size() ; i++) {
				//cnt2일때 cnt 3실행(bfs및 재귀종료) -> c[2]값을 다음 값으로for문으로 바꿔줌
				// 결과적으로 chosen배열의 2번 idx가 계속 바뀌면서 for문을 끝까지 실행..
				// cnt 1로 돌아와서 cnt 1을 for문을 통해 다음값으로 변경
				// cnt 2값 할당 후 cnt 3 실행 ..하며 모든 경우의수를 탐색한다
				chosen[cnt] = i;
				buildWall(cnt+1 , i+1 , chosen);

			}
		}
	}
	private static void virus(int[][] map) {
		//전역변수 map을 복사
		int[][] copyMap = new int[n][m];
		
		for(int i = 0 ; i< n ; i++) {
			copyMap[i] = Arrays.copyOf(map[i], m);
		}
		//바이러스 인덱스를 q에 추가
		Queue<index> q = new LinkedList<>();
		for(int i = 0 ; i < virusIndex.size() ; i++) {
			q.offer(virusIndex.get(i));
		}

		int[] dr = {-1,1,0,0};
		int[] dc = {0,0,-1,1};
		
		while(!q.isEmpty()) {
			index idx = q.poll();
			
			for(int i = 0 ; i < 4 ; i++) {
				int nr = idx.r + dr[i];
				int nc = idx.c + dc[i];
				
				if(nr < n && nr >=0 && nc < m && nc >=0) {
					if(copyMap[nr][nc] == 0) {
						copyMap[nr][nc] = 2;
						index nextIdx = new index(nr, nc);
						q.offer(nextIdx);
					}
				}
			}
		}
		int safeZone = 0 ;
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j < m ; j++) {
				if(copyMap[i][j] == 0 )
					safeZone++;
			}
		}
		max = Math.max(safeZone, max);
		
	}
}
