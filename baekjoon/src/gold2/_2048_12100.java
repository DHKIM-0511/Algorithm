package gold2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _2048_12100 {
	static int N,ans;
	static int[][] map;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine()); 
		map = new int[N][N];
		for(int i = 0 ; i < N ; i++) {
		StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j< N ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		ans = Integer.MIN_VALUE;
		moveBoard(0);
		
		System.out.println(ans);
	}
	private static void moveBoard(int cnt) {
		if(cnt == 5) {
			for(int i = 0 ; i < N ; i++) {
				for(int j = 0 ; j< N ; j++) {
					ans = Math.max(map[i][j], ans);
				}
			}
			return;
		}
		int copy[][] = new int[N][N];
		for(int i = 0 ; i< N ; i++) copy[i] = map[i].clone();
		
		moveUp();
		moveBoard(cnt+1);
		for(int i = 0 ; i< N ; i++) map[i] = copy[i].clone();
		
		moveLeft();
		moveBoard(cnt+1);
		for(int i = 0 ; i< N ; i++) map[i] = copy[i].clone();
		
		moveRight();
		moveBoard(cnt+1);
		for(int i = 0 ; i< N ; i++) map[i] = copy[i].clone();
		
		moveDown();
		moveBoard(cnt+1);
		for(int i = 0 ; i< N ; i++) map[i] = copy[i].clone();
		
		
	}
	private static void moveUp() {
		Queue<Integer> q = new LinkedList<>();
		
		for(int i = 0 ; i< N ; i++) {
			for(int j = 0 ; j < N ;j++) {
				if(map[j][i] != 0) {
					q.add(map[j][i]);
					map[j][i] = 0;
				}
			}
			if(q.size()>2) {
				int n = q.size();
				while(n-2 > 0) {
					int a = q.poll();
					int b = q.poll();
					if( a == b ) {
						q.add(a+b);
					}else {
						q.add(a);
						q.add(b);
					}
					n-=2;
				}
			}
			
			for(int j = 0 ; j < N ;j++) {
				map[j][i] = q.poll();
			}
		}
	}
	private static void moveLeft() {//
		Queue<Integer> q = new LinkedList<>();
		for(int i = 0 ; i< N ; i++) {
			for(int j = 0 ; j < N ;j++) {
				if(map[i][j] != 0) {
					q.add(map[j][i]);
					map[j][i] = 0;
				}
			}
			if(q.size()>2) {
				int n = q.size();
				while(n-2 > 0) {
					int a = q.poll();
					int b = q.poll();
					if( a == b ) {
						q.add(a+b);
					}else {
						q.add(a);
						q.add(b);
					}
					n-=2;
				}
			}
			
			for(int j = 0 ; j < N ;j++) {
				map[i][j] = q.poll();
			}
		}
	}
	private static void moveRight() {
		Queue<Integer> q = new LinkedList<>();
		for(int i = 0 ; i< N ; i++) {
			for(int j = N-1 ; j >=0 ;j--) {
				if(map[i][j] != 0) {
					q.add(map[j][i]);
					map[i][j] = 0;
				}
			}
			if(q.size()>2) {
				int n = q.size();
				while(n-2 > 0) {
					int a = q.poll();
					int b = q.poll();
					if( a == b ) {
						q.add(a+b);
					}else {
						q.add(a);
						q.add(b);
					}
					n-=2;
				}
			}
			
			for(int j = N-1 ; j >=0 ;j--) {
				map[i][j] = q.poll();
			}
		}
	}
	private static void moveDown() {
		Queue<Integer> q = new LinkedList<>();
		for(int i = 0 ; i< N ; i++) {
			for(int j = N-1 ; j >=0 ;j--) {
				if(map[j][i] != 0) {
					q.add(map[j][i]);
					map[j][i] = 0;
				}
			}
			if(q.size()>2) {
				int n = q.size();
				while(n-2 > 0) {
					int a = q.poll();
					int b = q.poll();
					if( a == b ) {
						q.add(a+b);
					}else {
						q.add(a);
						q.add(b);
					}
					n-=2;
				}
			}
			
			for(int j = N-1 ; j >=0 ;j--) {
				map[j][i] = q.poll();
			}
		}
	}
}
