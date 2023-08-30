package gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class 트리의지름_1967 {
	static int N,ans;
	static List<edge>[] adjList;
	static boolean[] visited;
	static class edge{
		int e,d;

		public edge(int e, int d) {
			super();
			this.e = e;
			this.d = d;
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		visited = new boolean[N+1];
		adjList = new LinkedList[N+1];
		for(int i = 0 ; i < N+1 ; i++) adjList[i] = new LinkedList<>();
		
		for(int i = 0 ; i < N-1 ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			adjList[s].add(new edge(e, d));
		}
		
		DFS();
		System.out.println(ans);
	}
	private static void DFS() {
		
		
	}
}




