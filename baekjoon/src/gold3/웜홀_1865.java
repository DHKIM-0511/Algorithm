package gold3;

import java.io.*;
import java.util.*;

public class 웜홀_1865 {
	static int N,M,W;
	static int[] distance;
	static List<node>[] road;
	static class node{
		int e,w;

		public node(int e, int w) {
			super();
			this.e = e;
			this.w = w;
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(br.readLine());
		
		for(int t = 1 ; t <= tc ; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			
			distance = new int[N+1];
			road = new LinkedList[N+1];
			
			for(int i = 0 ; i < N+1 ; i++) {
				distance[i] = Integer.MAX_VALUE;
				road[i] = new LinkedList<>();
			}
			
			for(int i = 0 ; i < M ; i++) {
				st = new StringTokenizer(br.readLine());
				
				int S = Integer.parseInt(st.nextToken());
				int E = Integer.parseInt(st.nextToken());
				int T = Integer.parseInt(st.nextToken()); // 양수 시간
				
				road[S].add(new node(E, T));
				road[E].add(new node(S, T));
			}
			
			for(int i = 0 ; i < W; i++) {
				st = new StringTokenizer(br.readLine());
				
				int S = Integer.parseInt(st.nextToken());
				int E = Integer.parseInt(st.nextToken());
				int T = Integer.parseInt(st.nextToken()); // 음수 시간
				
				road[S].add(new node(E, T));
			}
			
			if(bellmanFord()) {
				System.out.println("YES");
			}else {
				System.out.println("NO");
			}
		}
	}
	private static boolean bellmanFord() {
		distance[1] = 0;
		boolean update = false;
		
		for(int i = 1 ; i < N ; i++) {
			update = false;
			
			for(int j = 1 ; j < N+1 ; j++) {
				for(node n : road[j]) {
					if(distance[j] == Integer.MAX_VALUE) break;
					
					if(distance[n.e] > distance[j] + n.w) {
						distance[n.e] = distance[j] + n.w;
						update = true;
					}
				}
			}
			//더이상 초기화가 안일어나면 break
			if(!update) break;
		}
		
		if(update) {
			for(int i = 1; i < N+1 ; i++) {
				for(node n : road[i]) {
					if(distance[i] == Integer.MAX_VALUE) break;
					
					if(distance[n.e] > distance[i] + n.w) return true;
				}
			}
		}
		return false;
	}
}
