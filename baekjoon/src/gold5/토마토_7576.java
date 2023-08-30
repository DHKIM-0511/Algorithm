package gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//큐는 방문 순서 - 들어갔다가 나오는 거
		// 1번 위치 - 큐에 넣음
		// 방문 처리하고 기존 꺼는 큐에서 제거 -> 주변 걸 찾아서 큐에 넣어줌
		// -> 해당 위치에 깊이를 표시
		
		// 2차원 배열은 방문 순서를 직접 기록
public class 토마토_7576 {
	static int n;
	static int m;
	
	//익은 토마토의 위치.
	public static class dot {
		int x;
		int y;
		
		public dot(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[n][m];
		
		Queue<dot> dq = new LinkedList<>();
		
		boolean check = false;
		
		for(int i = 0 ; i < n ; i ++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < m ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				//익은 토마토 위치 리스트에 추가
				if(map[i][j] == 1) {
					dot d = new dot(i, j);
					dq.add(d); // 시작위치를 q 에 넣는다
				}
				if(map[i][j] == 0) { 
					check =  true;
				}
			}
		}
		
		// 0 이 없으면 0출력후 종료
		if(!check) {
			System.out.println(0);
			return;
		}
		// 0 이 있으면 bfs함수 실행
		bfs(dq , map);
		int max = 0;
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j< m ; j++) {
				if(map[i][j] > max ) max = map[i][j]; // 최대값 저장
				if(map[i][j] == 0) {
					System.out.println(-1);
					return;		
				}
			}
		}

		System.out.println(max - 1); // 아니면 max - 1
	}

	public static void bfs(Queue<dot> dq, int[][] map) {
		int[] dr = {-1 , 1 , 0 , 0};
		int[] dc = { 0 , 0, -1 , 1};
		
		while(!dq.isEmpty()) {
			dot tmp = dq.poll();
		
			for(int i = 0 ; i < 4 ; i++) {
				int nr = tmp.x + dr[i];
				int nc = tmp.y + dc[i];
				
				if(nr >= 0 && nr < n && nc >= 0 && nc < m) {
					if(map[nr][nc]==0) {
						map[nr][nc] = map[tmp.x][tmp.y] + 1;
						dot d = new dot(nr , nc);
						dq.offer(d);
					}
				}
			}
		}
	}
}
