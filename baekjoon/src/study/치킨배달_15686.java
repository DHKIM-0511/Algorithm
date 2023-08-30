package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 치킨배달_15686 {
	static int N,M,ans;
	static int[][] map;
	static boolean[] visited;
	static ArrayList<idx> house,store;
	
	static class idx {
		int r,c;

		public idx(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "idx [r=" + r + ", c=" + c + "]";
		}
		
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		
		house = new ArrayList<>();
		store = new ArrayList<>();
		visited = new boolean[M];
		for(int i=0;i < N ; i++) { // 0 = 빈칸 , 1= 집 , 2 = 치킨집.
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j< N ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) house.add(new idx(i, j));
				if(map[i][j] == 2) store.add(new idx(i, j));
			}
		}
		ans = Integer.MAX_VALUE;
		chooseStore(0,0, new idx[M]);
		
		System.out.println(ans);
	}
	private static void chooseStore(int lastIdx, int cnt, idx[] sel) {
		if(cnt == M) {
			ans = Math.min(ans, getDistance(sel));
		}else {
			for(int i = lastIdx ; i <store.size(); i++) {
				sel[cnt]=store.get(i);
				chooseStore(i+1,cnt+1, sel);
			}
		}
	}
	private static int getDistance(idx[] sel) {
		int sum = 0;
		
		for(idx h : house) {
			
			int tmp = Integer.MAX_VALUE;
			
			for(int i = 0 ; i < M ; i++) {
				idx store = sel[i];
				tmp = Math.min(tmp, Math.abs(store.r - h.r) + Math.abs(store.c-h.c));
			}
			sum+=tmp;
		}
			
		return sum;
	}
}









