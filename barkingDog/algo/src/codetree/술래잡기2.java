package codetree;

import java.io.*;
import java.util.*;


public class 술래잡기2 {
	static Queue<Integer>[][] map;
	static boolean[][] trees;
	static Runner[] runners;
	static Node node;
	static int n,m,h,k,ans;
	static int[] dr = {-1,0,1,0} , dc= {0,1,0,-1};
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		map = new LinkedList[n+1][n+1];
		for(int i =1; i<= n ; i++) {
			for(int j =1 ; j <= n ; j++) {
				map[i][j] = new LinkedList<>();
			}
		}
		
		node = new Node((n+1)/2, (n+1)/2);
		
		runners = new Runner[m+1];
		for(int i = 1; i<= m ; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			runners[i] = new Runner(r, c, d, false);
			map[r][c].offer(i);
		}
		trees = new boolean[n+1][n+1];
		for(int i = 0 ; i < h ; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			trees[r][c] = true;
		}
		
		int cnt = 0;
		int dir = 0;
		int max = 1;
		int flag = 1;
		int plus = 1;
		
//		int[][] nodeMap = new int[n+1][n+1];
//		int displayNum = 1;
		
		//술래잡기 시작
		for(int turn =1 ; turn <= k ; turn++) {
			
			//1 도망자 움직임
			Queue<Integer>[][] mapInfo = runnerMove();
			for(int i = 1; i<= n ; i++) {
				for(int j = 1; j <= n ;j++) {
					map[i][j] = mapInfo[i][j];
				}
			}
			
			//조회용			
			//nodeMap[node.r][node.c] = displayNum++;
			
			//2 술래 움직임
			cnt++;
			node.r+=dr[dir];
			node.c+=dc[dir];
			
			if(node.r == 1 && node.c == 1) { //안쪽으로 들어오는 나선형
				max = n;
				cnt = 1;
				plus = -1;
				flag = 0;
				dir= 2;
			}else if(node.r == (n+1)/2 && node.c == (n+1)/2) { //밖으로 나가는 나선형
				max = 1;
				cnt = 0;
				plus = 1;
				flag = 1;
				dir= 0;
			}else { // 그외
				if(max == cnt) { //방향 전환
					cnt = 0;
					dir = (dir+plus < 0 ? 3 : dir+plus) % 4;
					
					if(flag == 1) {
						flag = 0;
					}else if(flag == 0) {
						flag = 1;
						max += plus;
					}
				}
			}
			
//			//조회용 술래 움직임
//			for(int i = 1 ; i<= n ; i++) {
//				for(int j =1 ; j <= n ; j++) {
//					System.out.print(nodeMap[i][j]+" ");
//				}
//				System.out.println();
//			}
//			System.out.println();

			//술래가 관측한 도망자 잡기
			for(int i = 0 ; i < 3; i++) {
				int nr = node.r + dr[dir]*i;
				int nc = node.c + dc[dir]*i;
				
				if(OOB(nr,nc) || trees[nr][nc]) continue;
				ans += turn * map[nr][nc].size();
				
				while (!map[nr][nc].isEmpty()) {
					Runner r = runners[map[nr][nc].poll()];
					r.isOut = true;
				}
			}
			
			//조회용 도망자 움직임
//			for(int i = 1 ; i<= n ; i++) {
//				for(int j =1 ; j <= n ; j++) {
//					System.out.print(map[i][j]+" ");
//				}
//				System.out.println();
//			}
//			System.out.println();
		}
		
		//ans == 술래의 포인트
		System.out.println(ans);
	}
	
	static Queue<Integer>[][] runnerMove(){
		Queue<Integer>[][] newMap = new LinkedList[n+1][n+1];
		for(int i =1; i<= n ; i++) {
			for(int j =1 ; j <= n ; j++) {
				newMap[i][j] = new LinkedList<>();
			}
		}
		
		for(int i = 1 ; i <= m ; i++) {
			if(runners[i].isOut || getDistWithNode(runners[i]) > 3) continue;
			
			Runner r = runners[i];
			int nr = r.r + dr[r.d];
			int nc = r.c + dc[r.d];
			
			if(OOB(nr,nc)) {
				r.d  = (r.d+2) % 4;
				nr = r.r + dr[r.d];
				nc = r.c + dc[r.d];
			}
			
			//술래 있다
			if(nr == node.r && nc == node.c) {
				newMap[r.r][r.c].offer(i);
				continue;
			}
			//술래 없다
			newMap[nr][nc].offer(i);
			r.r = nr;
			r.c = nc;
		}
		return newMap;
	}
	static int getDistWithNode(Runner r) {
		return Math.abs(node.r - r.r) + Math.abs(node.c - r.c);  // |x1 - x2| + |y1 - y2|로 정의
	}
	static boolean OOB(int r,int c) {
		return r < 1 || r > n || c < 1 || c > n;
	}
	
	static class Node{
		int r,c;
		Node(int r,int c){
			this.r=r;
			this.c=c;
		}
	}
	static class Runner{
		int r,c,d;
		boolean isOut;
		Runner(int r,int c,int d, boolean isOut){
			this.r=r;
			this.c=c;
			this.d=d;
			this.isOut=isOut;
		}
	}
}
