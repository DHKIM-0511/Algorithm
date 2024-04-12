package codetree;

import java.util.*;
import java.io.*;

public class 포탑부수기 {
	static int n,m,k;
	static int[][] map;
	static int[][] history;
	static boolean[][] isFight;
	static int[] dr = {0,1,0,-1, -1,-1, 1, 1}, dc= {1,0,-1,0, -1,1,1,-1};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		map = new int[n+1][m+1];
		history = new int[n+1][m+1];

		for(int i = 1 ; i <= n ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j =1 ; j <= m ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int turn = 1 ; turn <= k ;turn++) {
			
			//공격자 선정
			//공격력 n+m만큼 증가
			isFight = new boolean[n+1][m+1];
			
			Node attacker = getAttacker();
			map[attacker.r][attacker.c] += n+m;
			System.out.println();
			System.out.println("히스토리 맵출력=========");
			for(int i =1 ; i<= n ; i++) {
				for(int j = 1 ; j <= m ; j++) {
					System.out.print(history[i][j]+" ");
				}
				System.out.println();
			}
			
			System.out.println();
			System.out.println("공격 전맵출력=========");
			for(int i =1 ; i<= n ; i++) {
				for(int j = 1 ; j <= m ; j++) {
					System.out.print(map[i][j]+" ");
				}
				System.out.println();
			}
			System.out.println();
			
			//공격자 공격: 공격자 제외 가장 강한 포탑 공격
			Node target = new Node(-1, -1);
			int flag = 0;
			for(int i = 1 ; i <= n ; i++) {
				for(int j =1 ; j <= m ; j++) {
					if(map[i][j] <= 0 || (attacker.r == i && attacker.c == j)) continue; //부서지거나 공격자거나
					
					if(flag < map[i][j] ) { //공격력이 강한
						flag = map[i][j];
						target = new Node(i, j);
					}else if ( flag == map[i][j] ) { 
						if(history[target.r][target.c] > history[i][j]) target = new Node(i,j); // 공격한지 오래된
						else if ((history[target.r][target.c] == history[i][j])&&target.r + target.c > i + j) target = new Node(i, j); // R+C값이 작은
						else if(((history[target.r][target.c] == history[i][j])&&target.r + target.c == i + j)&&target.c > j)target = new Node(i, j); // 열값이 작은
					}
				}
			}
			
			isFight[attacker.r][attacker.c] = true;
			isFight[target.r][target.c] = true;
			
			//레이저 공격 or 포탄 공격
			//공격력 == 0 이면 부서짐
			if(!bfs(attacker, target)) {
				//포탄 공격 실행
				map[target.r][target.c] -= map[attacker.r][attacker.c];
				int dmg = map[attacker.r][attacker.c]/2;
				
				for(int i = 0; i < 8 ; i++) {
					int nr = target.r + dr[i];
					int nc = target.c + dc[i];
					
					if(OOB(nr,nc)) {
						if(nr == 0) nr = n;
						else if (nr > n)nr = 1;
						if (nc == 0) nc = m;
						else if (nc > m) nc = 1;
					}
					if(map[nr][nc] <= 0||(attacker.r == nr && attacker.c == nc)) continue;
//					System.out.println("포탄공격 대상: "+ nr+" "+nc);
					map[nr][nc] -= dmg;
					isFight[nr][nc] = true;
				}
			}
			System.out.println("att: "+ attacker.r+" "+attacker.c);
			System.out.println("target: "+ target.r+" "+target.c);
			System.out.println();
			System.out.println("공격 후맵출력=========");
			for(int i =1 ; i<= n ; i++) {
				for(int j = 1 ; j <= m ; j++) {
					System.out.print(map[i][j]+" ");
				}
				System.out.println();
			}
			System.out.println();
			
			//공격자 턴 저장
			history[attacker.r][attacker.c] = turn;
			
			if(isFinish()) break;
			//공격이 끝나면 공격하지않았고, 피해도 안받은 포탑 공격력 ++
			for(int i =1 ; i<= n ; i++) {
				for(int j = 1; j <= m ; j++) {
					if(isFight[i][j] || map[i][j] <= 0) continue;
					map[i][j] ++;
				}
			}
		}
		//최종 남은 포탑 혹은 가장 강한 포탑 출력
		int ans = 0;
		for(int i =1 ; i<= n ; i++) {
			for(int j = 1; j <= m ; j++) {
				ans = Math.max(ans, map[i][j]);
			}
		}
		System.out.println(ans);
	}
	static boolean bfs(Node start, Node target) {
		Queue<Node> q = new LinkedList<>();
		boolean[][] visited = new boolean[n+1][m+1];
		Node[][] parent = new Node[n+1][m+1];
		
		q.offer(start);
		visited[start.r][start.c] = true;
		
		//경로 유무 확인
		boolean flag = false;
		while (!q.isEmpty()) {
			Node cur = q.poll();
			
			if(cur.r == target.r && cur.c == target.c) {
				flag = true;
				break;
			}
			for(int i = 0 ; i < 4 ; i++) {
				int nr = cur.r + dr[i];
				int nc = cur.c + dc[i];
				
				if(OOB(nr,nc)) {
					if(nr == 0) nr = n;
					else if (nr > n)nr = 1;
					if (nc == 0) nc = m;
					else if (nc > m) nc = 1;
				}
				
				if(visited[nr][nc] || map[nr][nc] <= 0) continue;
				
				q.offer(new Node(nr,nc));
				visited[nr][nc] = true;
				parent[nr][nc] = cur;
			}
		}
		// 경로 없음
		if(!flag) return false;
		
		map[target.r][target.c] -= map[start.r][start.c];
		int dmg = map[start.r][start.c]/2;
		
		int r = target.r;
		int c = target.c;
		while(true) {
			Node cur = parent[r][c];
			if(cur.r == start.r && cur.c == start.c) break;
			map[cur.r][cur.c] -= dmg;
			isFight[cur.r][cur.c] = true;
			r = cur.r;
			c = cur.c;
		}
		
		return true;
	}
	static Node getAttacker() {
		//부서지지 않고 가장 약한 포탑이 공격자
		//공격력이 같다면 최근 공격한 포탑 선정, 같으면 R+C가 큰, C가 큰
		Node attacker = new Node(-1, -1);
				
		int flag = 7777;
		for(int i = 1 ; i <= n ; i++) {
			for(int j =1 ; j <= m ; j++) {
				if(map[i][j] <= 0) continue; //부서지면 넘김
				
				if(flag > map[i][j] ) { //공격력이 약한
					flag = map[i][j];
					attacker = new Node(i, j);
				}else if ( flag == map[i][j] ) {
					if (history[attacker.r][attacker.c] < history[i][j]) attacker = new Node(i, j); // 최근 공격한
					else if ((history[attacker.r][attacker.c] == history[i][j]) && attacker.r + attacker.c < i + j) attacker = new Node(i, j); // R+C값이 큰
					else if(((history[attacker.r][attacker.c] == history[i][j]) && attacker.r + attacker.c == i + j) &&attacker.c < j)attacker = new Node(i, j); // 열값이 큰
				}
			}
		}
		
		return attacker;
	}
	static boolean isFinish() {
		//부서지지 않은 포탑 == 1 이면 즉시 break
		int cnt = 0;
		
		for(int i = 1; i <= n ; i++) {
			for(int j = 1; j <= m ; j++) {
				if(map[i][j] > 0) cnt++;
			}
		}
		return cnt == 1;
	}
	static boolean OOB(int r,int c) {
		return r < 1 || r > n || c < 1 || c > m;
	}
	static class Node{
		int r,c;
		Node(int r,int c){
			this.r =r;
			this.c =c;
		}
	}
}