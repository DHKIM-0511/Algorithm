package codetree;

import java.io.*;
import java.util.*;

public class 루돌프의반란 {
	static int n,m,p,c,d;
	static int[][] map;
	static Santa[] santas;
	static boolean[] isOut;
	static Rudolph rudolph;
	static int[] dr= {-1,0,1,0}, dc= {0,1,0,-1};
	
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
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
    	for(int i = 1 ; i <= p ; i++) {
    		st = new StringTokenizer(br.readLine());
    		int sn = Integer.parseInt(st.nextToken());
    		int sr = Integer.parseInt(st.nextToken());
    		int sc = Integer.parseInt(st.nextToken());
    		
    		santas[sn] = new Santa(sr, sc, 0, 0);
    		map[sr][sc]= sn;
    	}
    	
    	//게임 시작
    	for(int turn = 0 ; turn < m ; turn++) {
    		
    		//모두 탈락시 break;
    		if(isFinish()) break;
    		
    		//1-1 루돌프 이동: 가장 가까운 산타 찾기
    		int minDist = Integer.MAX_VALUE;
    		int targetIdx = -1;
    		
    		for(int i = 1; i<= p ;i++) {
    			if(isOut[i]) continue;
    			Santa s = santas[i];
    			
    			int dist = getDist(rudolph.r, rudolph.c, s.r, s.c);
    			if(dist < minDist) {
    				minDist = dist;
    				targetIdx = i;
    			}else if( dist == minDist ) {
    				Santa o = santas[targetIdx];
    				if(o.r == s.r) {
    					if(o.c < s.c) targetIdx = i;
    				}else if(o.r < s.r){
    					targetIdx = i;
    				}
    			}
    		}
    		
    		//1-2 루돌프 이동: 대상 산타 방향으로 이동
    		Santa target = santas[targetIdx];
    		int rdr = 0;
    		int rdc = 0;
    		
    		if(target.r < rudolph.r) rdr = -1;
    		else if(target.r > rudolph.r)rdr = 1;
    		
    		if(target.c < rudolph.c) rdc = -1;
    		else if(target.c > rudolph.c) rdc = 1;
    		
    		map[rudolph.r][rudolph.c] = 0;
    		rudolph.r += rdr;
    		rudolph.c += rdc;
    		map[rudolph.r][rudolph.c] = -1;
    		
    		//1-3 루돌프 이동: 루돌프와 산타가 충돌한 경우 밀리는 처리
    		if(rudolph.r == target.r && rudolph.c == target.c) {
    			target.score += c;
    			target.up = turn+2;
    			santaMove(targetIdx, target.r, target.c, rdr, rdc, c );
    		}
    		
    		//2 산타이동: 기절하지 않고 살아있는 산타 이동
    		for(int i =1 ; i<= p ;i++) {
    			if(santas[i].up > turn || isOut[i]) continue;
    			Santa s = santas[i];
    			
    			int mnDist = getDist(rudolph.r, rudolph.c, s.r, s.c);
    			int dir = -1;
    			int nextR = s.r;
    			int nextC = s.c;
    			for(int j = 0 ; j < 4 ; j++) {
    				int nr = s.r + dr[j];
    				int nc = s.c + dc[j];
    				
    				if(OOB(nr,nc) || map[nr][nc] > 0) continue; // 밖이나 산타가있는 칸으로는 못감
    				int dist = getDist(rudolph.r, rudolph.c, nr, nc);
    				
    				if(dist < mnDist) {
    					mnDist = dist;
    					nextR = nr;
    					nextC = nc;
    					dir = j;
    				}
    			}
    			
    			//이동할곳 없음
    			if(dir == -1) continue;
    			
        		//2-1 루돌프와 충돌 처리
    			if(nextR == rudolph.r && nextC == rudolph.c) {
    				s.score += d;
    				s.up = turn+2;
    				map[s.r][s.c] = 0;
    				
    				santaMove(i, nextR, nextC, -dr[dir], -dc[dir], d);
    			}else {
    				map[s.r][s.c] = 0;
    				map[nextR][nextC] = i;
    				s.r = nextR;
    				s.c = nextC;
    			}
    		}
    		
    		//살아있는 산타 점수 획득
    		for(int i =1 ; i<= p ;i++) {
    			if(isOut[i]) continue;
    			santas[i].score++;
    		}
    	}
    	
    	StringBuilder sb = new StringBuilder();
    	for(int i = 1; i<= p ;i++) {
    		sb.append(santas[i].score).append(" ");
    	}
    	System.out.println(sb);
    }
    static void santaMove(int cur, int r,int c,int dr, int dc, int mul ) {
    	Queue<int[]> q = new LinkedList<>();
    	q.offer(new int[] {cur, r,c,mul});
    	
    	while (!q.isEmpty()) {
    		int[] current = q.poll();
    		Santa curS = santas[current[0]];
    		mul = current[3];
    		
    		int nr = current[1] + dr * mul;
    		int nc = current[2] + dc * mul;
    		
    		if(OOB(nr,nc)) {
    			isOut[current[0]] = true;
    			return;
    		}else {
    			if(map[nr][nc] > 0) {
        			q.offer(new int[] {map[nr][nc], nr,nc, 1});
        			map[nr][nc] = current[0];
        			curS.r = nr;
        			curS.c = nc;
        		}else if(map[nr][nc] == 0){
        			map[nr][nc] = current[0];
        			curS.r = nr;
        			curS.c = nc;
        			return;
        		}
    		}
		}
    }
    static boolean isFinish() {
    	for(int i = 1; i<= p ;i++) {
    		if(!isOut[i]) return false;
    	}
    	return true;
    }
    
    static boolean OOB(int r, int c) {
    	return r < 1 || r > n || c < 1 || c > n;
    }
    static int getDist(int r, int c , int r2, int c2) {
    	return (r-r2)*(r-r2) + (c-c2)*(c-c2);
    }
    
    static class Santa{
    	int r,c,up,score;
    	Santa(int r,int c, int up, int score) {
    		this.r=r;
    		this.c=c;
    		this.up=up;
    		this.score=score;
		}
    }
    
    static class Rudolph{
    	int r,c;
    	public Rudolph(int r,int c) {
			this.r =r;
			this.c =c;
		}
    }
}
