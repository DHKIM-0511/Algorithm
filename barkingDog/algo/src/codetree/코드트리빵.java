package codetree;

import java.util.*;
import java.io.*;

public class 코드트리빵 {
	
	static int n,m;
	static int[][] map;
	static boolean[][] impossible;
	static int[] dr = {-1, 0, 0, 1} , dc= {0, -1,1,0};
	static Node[] store;
	static Person[] people;
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken()); 
		m= Integer.parseInt(st.nextToken());
		map = new int[n+1][n+1];
		impossible = new boolean[n+1][n+1];
		for(int i = 1 ; i <= n ;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= n ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		store = new Node[m+1];
		people = new Person[m+1];
		for(int i = 1; i <= m ; i++) {
			st = new StringTokenizer(br.readLine());
			int sr = Integer.parseInt(st.nextToken());
			int sc = Integer.parseInt(st.nextToken());
			
			store[i] = new Node(sr, sc);
			people[i] = new Person(-1, -1, false,0);
		}
		

		int time = 1;
		while(true) {
			//이동
			for(int i = 1; i <= m ; i++) {
				//이동 가능한 사람
				if(!people[i].move) continue;
				Person p = people[i];
				Node s = store[i];
				
				//최단 거리로 1칸 이동
				int[] nextLoc = bfs(p , s);
				p.r = nextLoc[0];
				p.c = nextLoc[1];
			}
			
			//도착 확인
			for(int i = 1; i <= m ; i++) {
				if(!people[i].move) continue;
				Person p = people[i];
				Node s = store[i];
				//도착시 정지 및 이동 불가 처리
				if(p.r == s.r && p.c == s.c) {
					p.move = false;
					impossible[s.r][s.c] = true;
				}
			}
			
			
			//모두 도착하면 종료
			if(isFinish()) break;
			
			//베이스캠프 입장
			if(time <= m) {
				Node bc = getBaseCamp(time);
				people[time] = new Person(bc.r, bc.c, true, 0); // 베이스 캠프 입장
				impossible[bc.r][bc.c] = true; // 해당칸 이동 불가
			}
			time++;
		}
		
		System.out.println(time);
		
	}
	static int[] bfs(Person start, Node end) {
		Queue<Person> q = new LinkedList<>();
		boolean[][] vis = new boolean[n+1][n+1];
		Person[][] path = new Person[n+1][n+1];
		
		q.offer(start);
		vis[start.r][start.c] = true;
		
		while (!q.isEmpty()) {
			Person cur = q.poll();
			
			if(cur.r == end.r && cur.c == end.c) {
				break;
			}
			
			for(int i = 0; i < 4 ; i++) {
				int nr = cur.r + dr[i];
				int nc = cur.c + dc[i];
				
				if(OOB(nr,nc) || impossible[nr][nc] || vis[nr][nc]) continue;
				q.offer(new Person(nr, nc, true, cur.cnt+1));
				vis[nr][nc] = true;
				path[nr][nc] = cur;
			}
		}
		//도착
		int r = end.r;
		int c = end.c;
		while(true) {
			Person p = path[r][c];
			if( p.r == start.r && p.c == start.c) break;
			r = p.r;
			c = p.c;
		}
		return new int[] {r, c};
	}
	static Node getBaseCamp(int t) {
		//t번 사람이 입장, 목표 편의점최단거리인 베이스캠프로 입장
		//최단거리 , 행이작은, 열이 작은
		Queue<Node>q = new LinkedList<>();
		int[][] dist = new int[n+1][n+1];
		
		q.offer(store[t]);
		dist[store[t].r][store[t].c] = 1;
		
		PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2) -> { // 칸수, 행, 열
			if(o1.r == o2.r) return o1.c - o2.c;
			return o1.r-o2.r;
		});
		
		int mnCnt = 10000;
		while (!q.isEmpty()) {
			Node cur = q.poll();
			
			if(mnCnt < dist[cur.r][cur.c]) break;
			
			if(map[cur.r][cur.c] == 1) {
				pq.offer(cur);
				mnCnt = dist[cur.r][cur.c];
			}
			
			for(int i =0 ; i < 4 ; i++) {
				int nr = cur.r + dr[i];
				int nc = cur.c + dc[i];
				
				if(OOB(nr, nc) || impossible[nr][nc] || dist[nr][nc] > 0) continue;
				q.offer(new Node (nr,nc));
				dist[nr][nc] = dist[cur.r][cur.c] + 1;
			}
		}
		
		return pq.poll();
	}
	
	static boolean isFinish() {
		
		for(int i =1 ; i <= m ; i++) {
			if(!impossible[store[i].r][store[i].c]) return false; 
		}
		return true;
	}
	
	static boolean OOB(int r, int c) {
		return r < 1 || r > n || c < 1 || c > n;
	}
	static class Node{
		int r,c;
		Node(int r, int c){
			this.r=r;
			this.c=c;
		}
	}
	static class Person{
		int r,c,cnt;
		boolean move;
		Person(int r, int c, boolean move, int cnt){
			this.r=r;
			this.c=c;
			this.move = move;
			this.cnt = cnt;
		}
	}
}
