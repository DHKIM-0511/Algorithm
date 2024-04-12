package codetree;

import java.util.*;
import java.io.*;

public class 왕실의기사대결2 {
	static int l,n,q;
	static int[] dr = {-1,0,1,0}, dc= {0,1,0,-1};
	static int[][] map;
	static Unit[] units;
	static boolean[] isDead;
	static int[] hp;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		l = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		q = Integer.parseInt(st.nextToken());
		
		//mapInit()
		map = new int[l+2][l+2];
		for(int i = 0 ; i < l+2 ; i++) {
			Arrays.fill(map[i], 2);
		}
		
		for(int i = 1 ; i <= l ; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j = 1 ; j <= l ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		units = new Unit[n+1];
		isDead = new boolean[n+1];
		hp = new int[n+1];
		for(int i = 1 ; i <= n ; i++) {
			st = new StringTokenizer(br.readLine());
			int ur = Integer.parseInt(st.nextToken());
			int uc = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
			units[i] = new Unit(ur, uc, h, w, k);
			hp[i] = k;
		}
		
		for(int i = 0 ; i < q ; i++) {
			st = new StringTokenizer(br.readLine());
			int unitIdx = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());
			
			if(isDead[unitIdx]) continue;
			bfs(unitIdx, dir);
		}
		
		int ans = 0;
		for(int i = 1; i <= n ; i++) {
			if(isDead[i]) continue;
			ans += hp[i] - units[i].k;
		}
		System.out.println(ans);
	}
	static void bfs(int start, int dir) {
		Queue<Integer> q = new LinkedList<>();
		Set<Integer> pushSet = new HashSet<>();
		int[] damage = new int[units.length+1];
		
		q.offer(start);
		pushSet.add(start);
		
		while (!q.isEmpty()) {
			int idx = q.poll();
			Unit cur = units[idx];
			
			//명령받은 방향으로 진행
			int nr = cur.r + dr[dir];
			int nc = cur.c + dc[dir];
			
			// 벽이면 리턴, 함정이면 데미지 계산
			for(int i = nr ; i < nr+ cur.h ; i++) {
				for(int j = nc ; j < nc + cur.w ; j++) {
					if(map[i][j] == 2) return;
					if(map[i][j] == 1) damage[idx]++; 
				}
			}
			
			//겹치면 q에 삽입
			for(int i = 1 ; i <= n ;i++) {
				if(isDead[i]) continue;
				if(pushSet.contains(i)) continue;
				
				Unit o = units[i];
				//겹치나?
				if(nr >= o.r + o.h || nr + cur.h <= o.r || nc + cur.w <= o.c || nc >= o.c + o.w ) continue;
				q.offer(i);
				pushSet.add(i);
			}
		}
		
		
		//민 기사는 데미지 없음
		damage[start] = 0;
		
		for(int i : pushSet) {
			if(isDead[i]) continue;
			Unit u = units[i];
			
			if( u.k <= damage[i]) {
				isDead[i] = true;
			}else {
				u.r += dr[dir];
				u.c += dc[dir];
				u.k -= damage[i];
			}
		}
		
	}
	
	
	static class Unit{
		int r,c,h,w,k;
		Unit(int r,int c,int h, int w, int k){
			this.r=r;
			this.c=c;
			this.h=h;
			this.w=w;
			this.k=k;
		}
	}
}
