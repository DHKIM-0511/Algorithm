package silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 지름길_1446_f {
	static int N,D,ans;
	static int[] distance;
	
	public static class edge implements Comparable<edge>{
		int e , w;
		public edge(int e, int w) {
			super();
			this.e = e;
			this.w = w;
		}
		@Override
		public String toString() {
			return "edge [e=" + e + ", w=" + w + "]";
		}
		@Override
		public int compareTo(edge o) {
			// TODO Auto-generated method stub
			return this.w - o.w;
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N =Integer.parseInt(st.nextToken()); // 지름길 개수
		D =Integer.parseInt(st.nextToken()); // 고속도로 길이
		ans = Integer.MAX_VALUE;
		List<edge>[] adjList = new LinkedList[D+1];
		
		for(int i = 0 ; i < D+1 ; i++) {
			adjList[i] = new LinkedList<>();
			if(i == D) continue;
			adjList[i].add(new edge(i+1, 1));
		}
		
		for(int i = 0 ; i< N ; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			if(e > D) continue;
			adjList[s].add(new edge(e, w));
		}
		
		distance = new int[D+1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[0] = 0;
		
		PriorityQueue<edge> pq = new PriorityQueue<>();
		pq.add(new edge(0, 0));
		while(!pq.isEmpty()) {
			edge cur = pq.poll();
			
			for(edge next : adjList[cur.e]) {
				if((distance[next.e] > distance[cur.e] + next.w)) {
					distance[next.e] = distance[cur.e] + next.w;
					pq.add(new edge(next.e, distance[next.e]));
				}
			}
		}
		System.out.println(distance[D]);
	}
}

