package gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 최단경로_1753 {
	static int V,E,K;
	static List<edge>[] adjList;
	static boolean[] visited;
	static int[] distance;
	
	public static class edge implements Comparable<edge>{
		int  end , value;

		public edge( int end, int value) {
			super();
			this.end = end;
			this.value = value;
		}

		@Override
		public int compareTo(edge o) {
			// TODO Auto-generated method stub
			return this.value - o.value;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());
		
		adjList = new LinkedList[V+1];
		for(int i = 0 ; i < V+1 ; i++) adjList[i] = new LinkedList<>();
		
		for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            adjList[s].add(new edge(e, w));
        }
		
		distance = new int[V+1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[K] = 0;
		
		visited = new boolean[V+1];
		
		PriorityQueue<edge> pq = new PriorityQueue<>();
		pq.add(new edge(K, 0));
		
		while(!pq.isEmpty()) {
			edge cur = pq.poll();
			
			if(visited[cur.end]) continue;
			visited[cur.end] = true;
			
			 for (edge next : adjList[cur.end]) {
	                if (distance[next.end] > distance[cur.end] + next.value) {
	                    distance[next.end] = distance[cur.end] + next.value;
	                    pq.add(new edge(next.end, distance[next.end]));
	                }
			 }
		}
		for(int i=1 ; i <=V;i++ ) {
			if(distance[i] == Integer.MAX_VALUE) System.out.println("INF");
			else System.out.println(distance[i]);
		}
	}
}
