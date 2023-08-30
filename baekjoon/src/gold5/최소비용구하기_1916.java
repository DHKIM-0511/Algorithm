package gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 최소비용구하기_1916 {
	
	public static class edge implements Comparable<edge>{
		int e,w;

		public edge(int e, int w) {
			super();
			this.e = e;
			this.w = w;
		}

		@Override
		public int compareTo(edge o) {
			return this.w - o.w;
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		List<edge>[] adjList = new LinkedList[N+1];
		for(int i = 0 ; i < N+1 ; i++) adjList[i] = new LinkedList<>();
		
		for(int i= 0 ; i < M ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			adjList[s].add(new edge(e, w));
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int start = Integer.parseInt(st.nextToken()); // 시작 도시
		int end = Integer.parseInt(st.nextToken()); // 끝 도시
		
		int[] distance = new int[N+1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[start] = 0;
		
		boolean[] visited = new boolean[N+1];
		
		PriorityQueue<edge> pq = new PriorityQueue<>();
		
		pq.add(new edge(start,0));
		
		while(!pq.isEmpty()) {
			edge cur = pq.poll();
			
			if(visited[cur.e]) continue;
			visited[cur.e] = true;
			
			for(edge next : adjList[cur.e]) {
				if(distance[next.e] > distance[cur.e] + next.w) {
					distance[next.e] = distance[cur.e] + next.w;
					pq.add(new edge(next.e, distance[next.e]));
				}
			}
		}
		System.out.println(distance[end]);
	}
}
