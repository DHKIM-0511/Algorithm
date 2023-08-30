package Level2;

import java.util.*;

public class 게임맵최단거리 {
	public static void main(String[] args) {
		int[][] maps = {
				{1,0,1,1,1},
				{1,0,1,0,1},
				{1,0,1,1,1},
				{1,1,1,0,1},
				{0,0,0,0,1}
				};
		System.out.println(Solution.solution(maps));
	}
	public static class Solution {
	    public static class idx{
	        int r,c,cnt;
	        public idx(int r,int c,int cnt){
	            this.r = r;
	            this.c = c;
	            this.cnt = cnt;
	        }
	        public String toString() {
	        	return "r :"+this.r+", c :"+this.c;
	        }
	    }
	    public static int solution(int[][] maps) {
	        int n = maps.length;
	        int m = maps[0].length;
	        System.out.println("n : "+n);
	        System.out.println("m : "+m);
	        
	        int[] dr = {-1,1,0,0};
	        int[] dc = {0,0,-1,1};
	        Queue<idx> q = new LinkedList<>();
	        q.add(new idx(0,0,0));
	        // boolean[][] visited = new boolean[n][m];
	        
	        while(!q.isEmpty()){
	            idx cur = q.poll();
	            if(cur.r == n-1 && cur.c == m-1){
	                return cur.cnt+1;
	            }
	            maps[cur.r][cur.c] = 0;
	            System.out.println(cur.toString());
	            for(int i = 0 ; i < 4 ; i++){
	                int nr = cur.r + dr[i];
	                int nc = cur.c + dc[i];
	                
	                if(nr >= 0 && nr < n && nc >= 0 && nc < m){
	                    if(maps[nr][nc] == 1)
	                        q.add(new idx(nr,nc,cur.cnt+1));
	                }
	            }
	        }
	        return -1;
	    }
	}
}
