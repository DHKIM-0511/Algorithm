package silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 트리의부모찾기_11725 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		List<Integer>[] adjList = new LinkedList[N+1];
		for(int i = 0 ; i< N+1 ; i++) adjList[i] = new LinkedList<>();
		
		for(int i = 1 ; i < N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adjList[a].add(b);
			adjList[b].add(a);
		}
		
		int[] ans = new int[N+1];
		boolean[] visited = new boolean[N+1];
		
		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		visited[1] = true;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			for(int next : adjList[cur]) {
				if(!visited[next]) {
					ans[next] = cur;
					q.add(next);
					visited[next] = true;
				}
			}
		}
		for(int i = 2; i < N+1 ; i++) {
			System.out.println(ans[i]);
		}
	}
}
