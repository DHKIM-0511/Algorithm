package codetree;

import java.util.*;
import java.io.*;

public class 메이즈러너 {
	static int n,m,k;
	static int[][] map;
	static Node[] people;
	static Node exit;
	static boolean[] isOut;
	static int[] dist;
	static int[] dr = {-1,1,0,0}, dc= {0,0,-1,1};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		map = new int[n+1][n+1];
		
		for(int i = 1; i<= n ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j =1 ;j<= n ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		people = new Node[m];
		isOut = new boolean[m];
		dist = new int[m];
		for(int i = 0 ; i < m ;i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			people[i] = new Node(r,c);
		}
		st = new StringTokenizer(br.readLine());
		int exitR = Integer.parseInt(st.nextToken());
		int exitC = Integer.parseInt(st.nextToken());
		exit = new Node(exitR, exitC);
		map[exitR][exitC] = -1;
		
		for(int time = 0 ; time < k ; time++) {
			//참가자 이동
			//모두 동시에 이동, 출구와 가까워지는 방향으로
			// 상, 하 우선, 움직일 수 없으면 가만히
			// 한칸에 여러명 가능
			for(int i = 0 ; i < m ; i++) {
				if(isOut[i]) continue;
				Node p = people[i];

				int minDist = getDist(p.r,p.c,exit.r,exit.c);
				int flag = minDist;
				int nextR = p.r;
				int nextC = p.c;
				for(int j = 0 ; j < 4 ; j++) {
					int nr = p.r + dr[j];
					int nc = p.c + dc[j];
					
					if(OOB(nr, nc) || map[nr][nc] > 0) continue;
					int dist = getDist(nr, nc, exit.r, exit.c);
					
					if(dist < minDist) {
						minDist = dist;
						nextR = nr;
						nextC = nc;
					}
				}
				if(minDist == flag)continue;
				p.r = nextR;
				p.c = nextC;

				dist[i]++;
				if(exit.r == p.r && exit.c == p.c) isOut[i] = true;
			}
			
			// 모두 탈출시 즉시 break
			if(isFinish()) break;
			
			//미로의 회전
			//최소 한명의 참가자와 출구를 포함한 가장 작은 정사각형
			//거리가 같으면 좌상단 r이작은거, r도 같으면 c도 작은거
			// 해당 사각형 범위 90도회전, 벽 내구 --;

			int[] shapeInfo = getShape();
			rotate(shapeInfo);

		}
		// 모든 참가자 이동거리의 합 + "\n" + 출구의 Idx 출력
		int ans = 0;
		for(int i : dist) ans += i;
		System.out.println(ans +"\n"+exit.r +" "+exit.c);
	}
	static void rotate(int[] shapeInfo) {
		int r = shapeInfo[0];
		int c = shapeInfo[1];
		int dist = shapeInfo[2]+1;
		
		int[][] shape = new int[dist][dist];
		
		//인덱스에 맵 정보 추가
		for(int i = 0; i < dist ; i++) {
			for(int j = 0 ; j < dist ; j++) {
				shape[i][j] = map[r+i][c+j] > 0 ? map[r+i][c+j] -1 : map[r+i][c+j];
			}
		}
		
		//90도 회전
		for(int i = 0 ; i < dist ; i++) {
			for(int j = 0 ; j < dist ; j++) {
				map[r+i][c+j] = shape[dist - j - 1][i];
				if(map[r+i][c+j] == -1) {
					exit.r = r+i;
					exit.c = c+j;
				}
			}
		}
		
		List<Integer>[][] tmp = new LinkedList[dist][dist];
		List<Integer>[][] newTmp = new LinkedList[dist][dist];
		for(int i = 0; i < dist ; i++) {
			for(int j = 0 ; j < dist ; j++) {
				tmp[i][j] = new LinkedList<>();
				newTmp[i][j] = new LinkedList<>();
			}
		}
		
		// 범위 내 사람들 추가
		for(int i = 0 ; i < m ; i++) {
			if(isOut[i]) continue;
			Node p = people[i];
			
			if(p.r < r || p.r >= r + dist || p.c < c || p.c >= c+dist) continue;
			tmp[p.r-r][p.c-c].add(i);
		}
		
		//90도 회전
		for(int i = 0 ; i < dist ; i++) {
			for(int j = 0 ; j < dist ; j++) {
				newTmp[i][j] = tmp[dist - j - 1][i];
			}
		}
		
		for(int i = 0 ; i < dist ; i++) {
			for(int j = 0 ; j < dist ; j++) {
				for(int k = 0 ; k < newTmp[i][j].size() ; k++) {
					int idx = newTmp[i][j].get(k);
					people[idx].r = i+r;
					people[idx].c = j+c;
				}
				
			}
		}
		
	}
	
	static int[] getShape() {
		//최대한 왼쪽 위로 그려야함
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)->{
			if(o1[2] == o2[2]) {
				if(o1[0] == o2[0]) return o1[1] - o2[1];
				return o1[0] - o2[0];
			}
			return o1[2] - o2[2];
		});
		
		for(int i = 0 ; i < m ; i++) {
			if(isOut[i]) continue;
			Node p = people[i];
			
			//출구보다 왼쪽 위에 있을떄
			if(p.r < exit.r && p.c < exit.c) {
				int maxDist = Math.max(exit.r - p.r, exit.c - p.c);
				
				int lr = exit.r;
				int lc = exit.c;
				for(int j = 0 ; j < maxDist ; j++) {
					if(lr-1 >= 1) lr--;
					if(lc-1 >= 1) lc--;
				}
				pq.offer(new int[] {lr,lc,maxDist,i});
				
			}else if(p.r < exit.r && p.c > exit.c){
				//오른쪽 위에 있을때
				int maxDist = Math.max(exit.r - p.r, p.c - exit.c);
				
				int lr = exit.r;
				int lc = p.c;
				for(int j = 0 ; j < maxDist ; j++) {
					if(lr-1 >= 1) lr--;
					if(lc-1 >= 1) lc--;
				}
				pq.offer(new int[] {lr,lc,maxDist,i});
				
			}else if(p.r > exit.r && p.c < exit.c) {
				//좌 하에 있을때
				int maxDist = Math.max(p.r - exit.r, exit.c - p.c);
				
				int lr = p.r;
				int lc = exit.c;
				for(int j = 0 ; j < maxDist ; j++) {
					if(lr-1 >= 1) lr--;
					if(lc-1 >= 1) lc--;
				}
				pq.offer(new int[] {lr,lc,maxDist,i});
				
			}else if(p.r > exit.r && p.c > exit.c) {
				//우 하 에 있을때
				int maxDist = Math.max(p.r - exit.r, p.c - exit.c);
				
				int lr = p.r;
				int lc = p.c;
				for(int j = 0 ; j < maxDist ; j++) {
					if(lr-1 >= 1) lr--;
					if(lc-1 >= 1) lc--;
				}
				pq.offer(new int[] {lr,lc,maxDist,i});
			}else if(p.r == exit.r || p.c == exit.c) {
				//행열이 같을때
				int maxDist = getDist(exit.r, exit.c, p.r, p.c);
				
				int lr = Math.max(exit.r, p.r);
				int lc = Math.max(exit.c, p.c);
				for(int j = 0 ; j < maxDist ; j++) {
					if(lr-1 >= 1) lr--;
					if(lc-1 >= 1) lc--;
				}
				pq.offer(new int[] {lr,lc,maxDist,i});
			}
		}
		return pq.poll();
	}
	
	static boolean isFinish() {
		for(boolean b : isOut) {
			if(!b) return false;
		}
		return true;
	}
	static boolean OOB(int r, int c) {
		return r < 1 || r > n || c < 1 ||c > n;
	}
	static int getDist(int r,int c,int r2, int c2) {
		return Math.abs(r-r2) + Math.abs(c-c2);
	}
	
	
	static class Node{
		int r,c;
		public Node(int r,int c) {
			this.r=r;
			this.c=c;
		}
	}
}
