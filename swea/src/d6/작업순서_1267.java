package d6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 작업순서_1267 {
	static class edge{
		int e,rank;

		public edge(int e,int rank) {
			super();
			this.e = e;
			this.rank = rank;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc = 1 ; tc <= 10 ; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			
			List<Integer>[] adjList = new LinkedList[V+1];
			for(int i = 1 ; i< V+1 ; i++)adjList[i] = new LinkedList<>();
			
			int[] inDegree = new int[V+1];
			int[] ans = new int[V+1];
			
			boolean[] visited = new boolean[V+1];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0 ; i< E ; i++) {
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				adjList[s].add(e);
				inDegree[e]++;
			}
			
			Queue<Integer> q = new LinkedList<>();
			StringBuilder sb = new StringBuilder();
			
			int cnt = 1;
			
			for(int i = 1 ; i<V+1 ; i++) {
				if(inDegree[i] == 0) 
					q.offer(i);
			}
			
			while(!q.isEmpty()) {
				
				int cur_e = q.poll();
				
				if(visited[cur_e]) continue;
				visited[cur_e] = true;
				
				sb.append(cur_e).append(" ");
				
				for(int next : adjList[cur_e]) {
					inDegree[next]--;
					if(inDegree[next] == 0) q.offer(next);
				}
			}
			System.out.println("#"+tc+" "+sb);
		}
	}
}
