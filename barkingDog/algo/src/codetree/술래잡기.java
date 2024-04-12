package codetree;

import java.io.*;
import java.util.*;


public class 술래잡기 {
	static int n,m,h,k;
	static Node node; // 술래
	static Runner[] runners;
	static boolean[][] trees;
	static int[][] map; //러너만 기록
	static int[] dr = {-1,0,1,0} , dc= {0,1,0,-1};
	static int[] nodeDir;
	static int[][] display;
	static int disp;
	static int max = 1;
	static int cnt  = 0;
	static int flag = 0;
	static int plus = 1;
	static int dir = 0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		map = new int[n+1][n+1];
		node = new Node(n/2+1, n/2+1, 0);
		
		runners = new Runner[m+1];
		for(int i = 1; i <= m ; i++) {
			st= new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			runners[i] = new Runner(r, c, d, false);
			map[r][c] = i;
		}
		
		trees = new boolean[n+1][n+1];
		for(int i = 1 ; i <= h ; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			trees[r][c] = true; 
		}
		
		display = new int[n+1][n+1];
		disp = 1;
		

		
		//게임 시작
		for(int turn = 1; turn <= k ; turn++) {
			printMap();
			//도망자 동시에 움직임
			int[][] runnerMoveInfo = moveRunner();
			for(int i =1 ; i<= n ; i++) {
				for(int j = 1; j<= n ; j++) {
					map[i][j] = runnerMoveInfo[i][j];
				}
			}
			printMap();
			
			//술래 움직임
			snailMove();
			
			//도망자 잡기
			for(int i = 0 ; i < 3 ; i++) {
				int nr = node.r + dr[dir]*i;
				int nc = node.c + dc[dir]*i;
				
				if(OOB(nr,nc) || trees[nr][nc] || map[nr][nc] <= 0) continue;
				Runner r = runners[map[nr][nc]];
				r.isOut = true;
				map[r.r][r.c] = 0;
				node.p += turn;
			}
		}
		
		displayMap();
		
		//술래가 총 얻게되는 점수 출력
		System.out.println(node.p);
	}
	static void snailMove(){
		System.out.println("idx: "+node.r + " "+ node.c+" val: "+ disp);
		display[node.r][node.c] = disp++;
		cnt++;
		
		node.r += dr[dir];
		node.c += dc[dir];
		
		if(node.r == 1 && node.c== 1) { //역방향 달팽이
			max = n;
			cnt = 1;
			flag = 1;
			plus = -1;
			dir = 2;
		}else if(node.r == (n+1)/2 && node.c == (n+1)/2) { //정방향 달팽이
			max = 1;
			cnt = 0;
			flag = 0;
			plus = 1;
			dir = 0;
		}else {
			
			if(cnt == max) {
				cnt = 0;
				dir = (dir + plus < 0 ? 3 : dir+plus) % 4;
				
				if(flag == 0) {
					flag = 1;
				}else {
					flag = 0;
					max += plus;
				}
			}
		}
	}
	
	static int[][] moveRunner(){
		int[][] newMap = new int[n+1][n+1];
		
		for(int i =1 ; i<= m ; i++) {
			if(runners[i].isOut || getDistWithNode(runners[i]) > 3) continue; // 잡혔거나, 거리가 3보다 크면 스킵
			
			Runner r = runners[i];
			int nr = r.r + dr[r.d];
			int nc = r.c + dc[r.d];
			
			if(OOB(nr,nc)) { // OOB이면 방향 바꿈
				r.d = (r.d+2) % 4;
				nr = r.r + dr[r.d];
				nc = r.c + dc[r.d];
			}
			
			if(nr == node.r && nc == node.c) {
				newMap[r.r][r.c] = i;
				continue; // 다음칸에 술래가있으면 가만히 
			}
			newMap[nr][nc] = i; // map 저장
			r.r = nr;
			r.c = nc;
		}
		
		return newMap;
	}
	
	static void displayMap() {
		for(int i =1 ; i<= n ; i++) {
			for(int j =1 ; j<= n ; j++) {
				System.out.print(display[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	static void printMap() {
		for(int i =1 ; i<= n ; i++) {
			for(int j =1 ; j<= n ; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	static int getDistWithNode(Runner r) {
		return Math.abs(node.r - r.r) + Math.abs(node.c - r.c); //|x1 - x2| + |y1 - y2|로 정의
	}
	static boolean OOB(int r,int c) {
		return r < 1 || r > n || c < 1 || c > n;
	}
	static class Node{
		int r,c,p;
		Node(int r,int c,int p){
			this.r=r;
			this.c=c;
			this.p=p;
		}
	}
	static class Runner{
		int r,c,d;
		boolean isOut;
		public Runner(int r,int c,int d, boolean isOut) {
			this.r=r;
			this.c=c;
			this.d=d;
			this.isOut=isOut;
		} 
	}
}
