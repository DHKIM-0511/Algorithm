package codetree;

import java.util.*;
import java.io.*;

public class 포탑부수기2 {
	static int[][] map;
	static int[][] history;
	static boolean[][] isFight;
	
	static int n,m,k;
	static int[] dr = {0,1,0,-1, -1,-1, 1, 1}, dc= {1,0,-1,0, -1,1,1,-1};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		 
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		map = new int[n+1][m+1];
		history = new int[n+1][m+1]; 
		
		for(int i = 1 ; i <= n ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j<= m ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//게임 시작
		for(int turn = 1 ; turn <= k ; turn++) {
			
			isFight = new boolean[n+1][m+1];
			
			Node att = getAttacker();//공격자 선정
			Node target = getTarget(att);//타겟 선정
			
			map[att.r][att.c] += n+m;
			
			isFight[att.r][att.c] = true;
			isFight[target.r][target.c] = true;
			
			//공격자 공격 (레이저 안되면 포탄)
			if(!bfs(att,target)) {
				//레이저 경로 없음 및 포탄 공격
				map[target.r][target.c] -= map[att.r][att.c];
				int dmg = map[att.r][att.c]/2;
				
				for(int i = 0 ; i < 8 ; i++) {
					int nr = target.r + dr[i];
					int nc = target.c + dc[i];
					
					if(OOB(nr,nc)) {
						if(nr == 0) nr = n;
						else if(nr > n) nr = 1;
						if(nc == 0) nc = m;
						else if(nc > m) nc = 1;
					}
					if((nr == att.r && nc == att.c) || map[nr][nc] <= 0) continue;
					map[nr][nc] -= dmg;
					isFight[nr][nc] = true;
				}
			}
			
			//공격자 턴 저장
			history[att.r][att.c] = turn;
			
			//살아있는 포탑 == 1 이면 즉시 종료
			if(isFinish()) break;
			
			
			//공격에 참여x -> 공격력++
			for(int i =1 ; i <= n ; i++) {
				for(int j = 1; j<= m ; j++) {
					if(isFight[i][j] || map[i][j] <= 0) continue;
					map[i][j] ++;
				}
			}
		}
		
		//가장 강한 포탑 공격력 출력
		int ans = 0;
		for(int i = 1 ; i<= n ; i++) {
			for(int j = 1; j <= m ; j++) {
				ans = Math.max(ans , map[i][j]);
			}
		}
		System.out.println(ans);
	}
	static boolean bfs(Node start, Node end) {
		Queue<Node> q = new LinkedList<>();
		boolean[][] visited =new boolean[n+1][m+1];
		Node[][] parent = new Node[n+1][m+1];
		
		q.offer(start);
		visited[start.r][start.c]= true;
		
		boolean flag = false;
		while (!q.isEmpty()) {
			Node cur = q.poll();
			
			if(cur.r == end.r && cur.c == end.c) {
				flag = true;
				break;
			}
			
			for(int i = 0; i < 4 ; i++) {
				int nr = cur.r + dr[i];
				int nc = cur.c + dc[i];
				
				if(OOB(nr,nc)) {
					if(nr == 0) nr = n;
					else if(nr > n) nr = 1;
					if(nc == 0) nc = m;
					else if(nc > m) nc = 1;
				}
				if(visited[nr][nc] || map[nr][nc] <= 0) continue;
				
				q.offer(new Node(nr,nc));
				visited[nr][nc] = true;
				parent[nr][nc] = cur;
			}
		}
		
		if(!flag) return false;
		
		//레이저 경로 발견 및 공격
		map[end.r][end.c] -= map[start.r][start.c];
		int dmg = map[start.r][start.c]/2;
		
		int r = end.r;
		int c = end.c;
		while (true) {
			Node n = parent[r][c];
			if(n.r == start.r && n.c == start.c) break;
			map[n.r][n.c] -= dmg;
			isFight[n.r][n.c] = true;
			r = n.r;
			c = n.c;
		}
		
		return true;
	}
	
	static Node getTarget(Node att) {
		//공격자 제외 가장 강한 포탑 선정
		//공격력이 같다면 가장 오래된 공격 포탑, r+c가 작은거, C가 작은거
		
		int mxDmg = 0;
		Node t = new Node(-1, -1);
		for(int i = 1; i <= n ; i++) {
			for(int j = 1; j <= m ; j++) {
				if(map[i][j] <= 0 || (i == att.r && j == att.c)) continue;
				
				if(mxDmg < map[i][j]) {
					mxDmg = map[i][j];
					t = new Node(i, j);
				}if(mxDmg == map[i][j]) {
					if(history[i][j] < history[t.r][t.c]) t = new Node(i, j);
					else if((history[i][j] == history[t.r][t.c]) && t.r + t.c > i + j) t = new Node(i, j);
					else if(((history[i][j] == history[t.r][t.c]) && t.r + t.c == i + j)&& t.c > j) t = new Node(i, j);
				}
			}
		}
		return t;
	}
	
	static Node getAttacker() {
		//부서지지 않고 가장 약한 포탑이 공격자
		//공격력이 같다면 가장 최근 공격 포탑, r+c가 큰거, C가 큰거
		
		int minDmg = 7777;
		Node att = new Node(-1, -1);
		for(int i = 1; i <= n ; i++) {
			for(int j = 1; j <= m ; j++) {
				if(map[i][j] <= 0) continue;
				
				if(minDmg > map[i][j]) {
					minDmg = map[i][j];
					att = new Node(i, j);
				}if(minDmg == map[i][j]) {
					if(history[i][j] > history[att.r][att.c]) att = new Node(i, j);
					else if((history[i][j] == history[att.r][att.c]) && att.r + att.c < i + j) att = new Node(i, j);
					else if(((history[i][j] == history[att.r][att.c]) && att.r + att.c == i + j)&& att.c < j) att = new Node(i, j);
				}
			}
		}
		return att;
	}
	static boolean isFinish() {
		int cnt = 0;
		for(int i = 1; i<= n ;i++) {
			for(int j =1 ; j <= m ;j++) {
				if(map[i][j] > 0) cnt++;
			}
		}
		return cnt == 1;
	}
	static boolean OOB(int r,int c) {
		return r < 1|| r > n || c < 1|| c> m;
	}
	static class Node{
		int r,c;
		Node(int r,int c){
			this.r =r;
			this.c =c;
		}
	}
		
}