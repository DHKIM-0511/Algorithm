package codetree;

import java.io.*;
import java.util.*;

public class 정육면체한번더굴리기 {
	static int n,m;
	static int[][] map;
	static Dice dice = new Dice(1, 1);
	static int dir = 1;
	static int[] dr = {-1,0,1,0} , dc= {0,1,0,-1}; // 상 우 하 좌
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n+1][n+1];
		
		for(int i = 1 ; i <= n ;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= n ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//주사위를 m번 굴린다
		int ans = 0;
		for(int turn = 0 ; turn < m ; turn++) {
			//이동시 마다 점수 획득
			dice.move();
			ans += getPoint();
			
			if(dice.downSide > map[dice.r][dice.c]) {
				//시계로 90 도 꺾음
				dir = (dir+1) %4;
				
			}else if(dice.downSide < map[dice.r][dice.c]) {
				//반시계로 90도 꺾음
				dir--;
				dir = dir < 0 ? 3 : dir;
			}
		}
		
		System.out.println(ans);
	}
	static int getPoint() {
		// 해당 칸의 값과 이어진 수들의 합을 점수로 얻는다
		Queue<int[]> q = new LinkedList<>();
		boolean[][] vis = new boolean[n+1][n+1];
		
		q.offer(new int[] {dice.r, dice.c});
		vis[dice.r][dice.c] = true;
		int sum = 0;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int cv = map[cur[0]][cur[1]];
			sum += cv;
			
			for(int i = 0 ; i < 4; i++) {
				int nr = cur[0] + dr[i];
				int nc = cur[1] + dc[i];
				
				if(OOB(nr,nc) || vis[nr][nc] || cv != map[nr][nc]) continue;
				q.offer(new int[] {nr,nc});
				vis[nr][nc] = true;
			}
		}
		System.out.println("회전 후 diceIdx: " + dice.r+" "+dice.c);
		System.out.println("sum: " + sum);
		return sum;
	}
	static boolean OOB(int r,int c) {
		return r < 1 || r > n || c < 1 || c > n;
	}
	
	static class Dice{
		int r,c;
		int upSide = 1;
		int downSide = 6;
		int leftSide = 4;
		int rightSide = 3;
		int frontSide = 2;
		int backSide = 5;
		
		Dice(int r, int c){
			this.r = r;
			this.c = c;
		}
		
		public void move() {
			// 상 우 하 좌
			int nr = r + dr[dir];
			int nc = c + dc[dir];
			
			if(OOB(nr,nc)) {
				dir = (dir+2)%4;
				nr = r + dr[dir];
				nc = c + dc[dir];
			}
			r = nr;
			c = nc;
			
			int tmp;
			if(dir == 0 ) {
				tmp = upSide;
				upSide = frontSide;
				frontSide = downSide;
				downSide = backSide;
				backSide = tmp;
			}else if(dir == 1 ) {
				tmp = upSide;
				upSide = leftSide;
				leftSide = downSide;
				downSide = rightSide;
				rightSide = tmp;
			}else if(dir == 2 ) {
				tmp = upSide;
				upSide = backSide;
				backSide = downSide;
				downSide = frontSide;
				frontSide = tmp;
			}else {
				tmp = upSide;
				upSide = rightSide;
				rightSide = downSide;
				downSide = leftSide;
				leftSide = tmp;
			}
			System.out.println("회전 전 diceIdx: " + dice.r+" "+dice.c);
			System.out.println();
			System.out.println("dir: " +dir);
			System.out.println("up: " +upSide);
			System.out.println("down: " +downSide);
			System.out.println("left: " +leftSide);
			System.out.println("right: " +rightSide);
			System.out.println("front: " +frontSide);
			System.out.println("back: " +backSide);
			

		}
	}
}
