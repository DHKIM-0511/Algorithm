package gold3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 줄세우기_2252 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		List<Integer>[] adjList = new LinkedList[N+1];
		for(int i = 1 ; i < N+1 ; i++) adjList[i] = new LinkedList<>();
		
		int[] inDegree = new int[N+1];
		boolean[] visited = new boolean[N+1];
		
		for(int i = 0 ; i < M ; i ++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			adjList[s].add(e);
			inDegree[e]++;
		}
		
		Queue<Integer> q = new LinkedList<>();
		
		for(int i = 1 ; i < N+1 ; i++) {
			if(inDegree[i] == 0) q.add(i);
		}
		StringBuilder sb = new StringBuilder();
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			if(visited[cur]) continue;
			visited[cur] = true;
			
			sb.append(cur+" ");
			
			for(int next : adjList[cur]) {
				inDegree[next]--;
				if(inDegree[next] == 0) q.add(next);
			}
		}
		
		System.out.print(sb);
		
	}
}
