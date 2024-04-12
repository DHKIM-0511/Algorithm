package codetree;

import java.util.*;
import java.io.*;

public class 싸움땅 {
	static PriorityQueue<Integer>[][] map;
	static int n,m,k;
	static User[] users;
	static int[] dr = {-1,0,1,0}, dc= {0,1,0,-1}; // 상 우 하 좌
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		map = new PriorityQueue[n+1][n+1];
		
		for(int i = 1 ; i <= n ; i++) {
			for(int j = 1; j <= n ; j++) {
				map[i][j] = new PriorityQueue<>((o1,o2) -> o2-o1);
			}
		}
		
		for(int i = 1 ; i <= n ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= n ; j++) {
				int v = Integer.parseInt(st.nextToken());
				if(v ==0) continue;
				map[i][j].offer(v);
			}
		}
		
		users = new User[m+1];
		for(int i = 1 ; i <= m ; i++) {
			st = new StringTokenizer(br.readLine());
			int ur = Integer.parseInt(st.nextToken());
			int uc = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			
			users[i] = new User(i, ur, uc, d, s, 0, 0);
		}
		
		for(int round = 1 ; round <= k ; round++) {
			//첫번째 플레이어부터 이동
			for(int i = 1; i <= m ; i++) {
				User u = users[i];
				int nr = u.r + dr[u.d];
				int nc = u.c + dc[u.d];
				
				if(OOB(nr,nc)) {
					u.d+=2;
					u.d%=4;
					nr = u.r + dr[u.d];
					nc = u.c + dc[u.d];
				}
				
				int findIdx = findUser(nr, nc);
				u.r = nr;
				u.c = nc;
				
				if(findIdx == 0) {
					//다음칸에 user가 없다면 총획득
					if(map[nr][nc].size() > 0) {
						//내총 보다 강하면 바꿔간다
						if(u.wp < map[nr][nc].peek()) {
							map[nr][nc].offer(u.wp);
							u.wp = map[nr][nc].poll();
						}
					}
					continue;
				}

				//다음칸에 user가 있다면 싸움
				int[] info = getFightInfo(findIdx, i);
				User winner = users[info[0]];
				User loser = users[info[1]];
				
				//승자는 status 차이만큼 포인트 획득하고 해당 구역 차지
				winner.p += Math.abs((winner.s+winner.wp) - (loser.s+loser.wp));
				winner.r = nr;
				winner.c = nc;
				
				//패자는 가진 총을 내려놓음
				if(loser.wp > 0) {
					map[nr][nc].offer(loser.wp);
					loser.wp = 0;
				}
				
				//OOB가 아니고 사람이 없을때까지 90도 회전 및 이동
				for(int j = 0 ; j <4 ; j++) {
					int ndir = (loser.d+j) %4;
					int nx = nr + dr[ndir];
					int ny = nc + dc[ndir];
					if(OOB(nx, ny) || findUser(nx, ny) > 0) continue;
					loser.d = ndir;
					loser.r= nx;
					loser.c= ny;
					break;
				}
				
				//각각 해당 칸 총 획득
				if(map[loser.r][loser.c].size() > 0) {
					loser.wp += map[loser.r][loser.c].poll();
				}
				if(map[winner.r][winner.c].size() > 0) {
					if(winner.wp < map[winner.r][winner.c].peek()) {
						map[winner.r][winner.c].offer(winner.wp);
						winner.wp = map[winner.r][winner.c].poll();
					}
				}
			}
		}
		//각 유저의 포인트 출력
		StringBuilder sb = new StringBuilder();
		for(int i =1 ; i<= m ; i++) {
			sb.append(users[i].p).append(" ");
		}
		System.out.println(sb);
	}
	
	static int[] getFightInfo(int idx1, int idx2) {
		User u1 = users[idx1];
		User u2 = users[idx2];
		
		int status1 = u1.s + u1.wp;
		int status2 = u2.s + u2.wp;
		
		//승패 결정
		if(status1 == status2) {
			if(u1.s > u2.s)  return new int[] {idx1, idx2};// 능력치만 비교
			else return new int[] {idx2, idx1};
			
		}
		if( status1 > status2) return new int[] {idx1, idx2};
		else return new int[] {idx2, idx1};
	}
	
	
	static int findUser(int r,int c) {
		for(int i = 1 ; i <= m ; i++) {
			if(users[i].r == r && users[i].c ==c) return i;
		}
		return 0;
	}
	
	static boolean OOB(int r,int c) {
		return r < 1 || r  > n || c < 1 || c > n;
	}
	
	static class User{
		int idx,r,c,d,s,p,wp;
		User(int idx, int r,int c,int d,int s,int p,int wp){
			this.idx=idx;
			this.r=r;
			this.c=c;
			this.d=d;
			this.s=s;
			this.p=p;
			this.wp=wp;
		}
	}
}
