package codetree;

import java.io.*;
import java.util.*;

public class 루돌프의반란2 {
	static int n,m,p,c,d;
	static Santa[] santas;
	static boolean[] isOut;
	static int[][] map;
	static Rudolph rudolph;
	static int[] dr = {-1,0,1,0}, dc= {0,1,0,-1};
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		p = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		map = new int[n+1][n+1];
		
		st = new StringTokenizer(br.readLine());
		int rr = Integer.parseInt(st.nextToken());
		int rc = Integer.parseInt(st.nextToken());
		rudolph = new Rudolph(rr, rc);
		map[rr][rc] = -1;
		
		santas = new Santa[p+1];
		isOut = new boolean[p+1];
		for(int i =1 ; i<= p ; i++) {
			st = new StringTokenizer(br.readLine());
			int sn = Integer.parseInt(st.nextToken());
			int sr = Integer.parseInt(st.nextToken());
			int sc = Integer.parseInt(st.nextToken());
			
			santas[sn] = new Santa(sr, sc, 0, 0);
			map[sr][sc] = sn;
		}
		
		for(int turn = 0 ; turn < m ; turn++) {
			//모두 아웃이면 즉시 종료
			if(isFinish()) break;
			
			//루돌프 이동
			//1-1 가장 가까운 산타찾기 ( isOut == false )
			int minDist = Integer.MAX_VALUE;
			int targetIdx = -1;
			
			for(int i = 1 ; i<= p ;i++) {
				if(isOut[i]) continue;
				Santa s = santas[i];
				
				int dist = getDist(rudolph.r, rudolph.c, s.r, s.c);
				// 거리가 같다면 r이큰 산타, r도 같다면 c가 큰 산타가 대상
				if(dist < minDist) {
					minDist = dist;
					targetIdx = i;
				}else if(dist == minDist) {
					Santa o = santas[targetIdx];
					if(o.r == s.r) {
						if(o.c < s.c) targetIdx = i;
					}else{
						if(o.r < s.r) targetIdx = i;
					}
				}
			}
			
			//1-2 8방향고려, 대상 산타에게 가장 가까워지도록 돌진 1칸
			Santa target = santas[targetIdx];
			
			int rdr = 0;
			int rdc = 0;
			
			if(target.r < rudolph.r) rdr = -1;
			else if ( target.r > rudolph.r) rdr = 1;
			
			if(target.c < rudolph.c) rdc = -1;
			else if ( target.c > rudolph.c) rdc = 1;
			
			map[rudolph.r][rudolph.c] = 0;
			rudolph.r += rdr;
			rudolph.c += rdc;
			map[rudolph.r][rudolph.c] = -1;
			
			//1-3 충돌시c만큼 점수, 루돌프 이동 방향 상호작용 , 산타 기절
			if(rudolph.r == target.r && rudolph.c == target.c) {
				target.score+=c;
				target.up = turn +2;
				sanMove(targetIdx, target.r, target.c, rdr, rdc, c);
			}
			
			
			//산타 이동, 1 ~ p 순차적
			for(int i =1 ; i <= p ; i++) {
				//기절 이거나 out이면 못움직임
				if(isOut[i] || santas[i].up > turn) continue;
				Santa s = santas[i];
				
				int mnDist = getDist(rudolph.r, rudolph.c,s.r,s.c);
				int dir = -1;
				int nextR = s.r;
				int nextC = s.c;
				//루돌프를 향해 이동 4방탐색 ( 상 우 하 좌 )
				for(int j = 0 ; j < 4 ; j++) {
					int nr = s.r + dr[j];
					int nc = s.c + dc[j];
					
					if(OOB(nr,nc) || map[nr][nc] > 0) continue;	//산타가 있거나, OOB이면 못감
					int dist = getDist(nr, nc, rudolph.r, rudolph.c);
					
					if(dist < mnDist) {
						mnDist = dist;
						nextR = nr;
						nextC = nc;
						dir = j;
					}
				}
				
				//가까워질 수 없으면 가만히
				if(dir == -1)  continue;
				
				//충돌시d 만큼 점수, 산타이동 반대방향 중요!,  상호작용, 산타 기절
				if(nextR == rudolph.r && nextC == rudolph.c) {
					s.score+=d;
					s.up = turn+2;
					map[s.r][s.c] = 0;
					sanMove(i, nextR, nextC, -dr[dir], -dc[dir], d);
				}else {
					map[s.r][s.c] = 0;
					map[nextR][nextC] = i;
					s.r = nextR;
					s.c = nextC;
				}
			}
			
			
			//살아있는 산타 점수 ++
			for(int i = 1 ; i <= p ; i++) {
				if(isOut[i]) continue;
				santas[i].score++;
			}
		}
		
		
		//각 산타 점수 출력
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i<= p ; i++) {
			sb.append(santas[i].score).append(" ");
		}
		System.out.println(sb);
		
	}
	
	static void sanMove(int idx ,int r, int c, int dr,int dc,int mul) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {idx, r, c, mul});
		
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			idx = cur[0];
			Santa s = santas[idx];
			mul = cur[3];
			
			int nr = cur[1] + dr * mul;
			int nc = cur[2] + dc * mul;
			
			if(OOB(nr,nc)) {
				isOut[idx] = true;
				return;
			}else {
				if(map[nr][nc] > 0) {
					q.offer(new int[] {map[nr][nc], nr, nc, 1});
					map[nr][nc] = idx;
					s.r = nr;
					s.c = nc;
				}else if(map[nr][nc] == 0) {
					map[nr][nc] = idx;
					s.r = nr;
					s.c = nc;
					return;
				}
			}
		}
	}
	
	static boolean OOB(int r,int c) {
		return r < 1 || r > n || c < 1|| c > n;
	}
	static int getDist(int r,int c,int r2,int c2) {
		return (r-r2)*(r-r2)+(c-c2)*(c-c2); 
	}
	
	static boolean isFinish() {
		for(int i = 1; i<= p ; i++) {
			if(!isOut[i]) return false;
		}
		return true;
	}
	
	static class Santa{
		int r,c,up,score;
		public Santa(int r,int c,int up, int score) {
			this.r =r;
			this.c =c;
			this.up =up;
			this.score =score;
		}
	}
	static class Rudolph{
		int r,c;
		public Rudolph(int r,int c) {
			this.r=r;
			this.c=c;
		}
	}
}
