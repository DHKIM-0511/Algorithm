package gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 이분그래프_1707 {
	//인접한 노드는 서로 다른 집합이면 이분그래프
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(br.readLine());
		
		for(int t = 1 ; t <= tc ; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			
			int[] visited = new int[V+1];// 0 = 미방문 , 1 = 1번그룹 , -1 = 2번그룹
			
			List<Integer>[] graph = new ArrayList[V+1];
			for(int i = 0 ; i < V+1 ; i++) graph[i] = new ArrayList<>();
			
			for(int i = 0 ; i < E ; i++) {
				st = new StringTokenizer(br.readLine());
				
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				
				graph[s].add(e);
				graph[e].add(s);//무방향 그래프
			}
			
			boolean check = true; // 이분 그래프
			for(int i = 1 ; i < V+1 ; i++) {
				if(!check) break;
				
				if(visited[i] == 0) {
					Queue<Integer> q = new LinkedList<>();
					q.offer(i);
					visited[i] = 1;
					
					out: while(!q.isEmpty()) {
						int cur = q.poll();
						
						for(int next : graph[cur]) {
							if(visited[next] == 0) {
								q.offer(next);
								visited[next] = visited[cur]*-1;
							}
							
							else if (visited[cur] + visited[next] != 0) {
								check = false;
								break out;
							}
						}
					}
				}
			}
			System.out.println(check ? "YES":"NO");
		}
	}
}
