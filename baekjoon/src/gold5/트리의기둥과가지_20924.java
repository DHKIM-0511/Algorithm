package gold5;

import java.io.*;
import java.util.*;

public class 트리의기둥과가지_20924 {
	static int N,R,ans;
	static List<edge>[] adjList;
	static boolean[] visited;
	static class edge{
		int e,l,b;

		public edge(int e, int l, int b) {
			super();
			this.e = e;
			this.l = l;
			this.b = b;
		}

	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		visited = new boolean[N+1];
		adjList = new LinkedList[N+1];
		for(int i = 0 ;i < N +1 ; i++) adjList[i] = new LinkedList<>();
		
		for(int i = 0 ; i < N-1 ; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			
			adjList[s].add(new edge(e, l,0));
			adjList[e].add(new edge(s, l,0));
		}
		
		Stack<edge> stack = new Stack<>();
		stack.push(new edge(R, 0, 0));
		visited[R] = true;
		
		boolean giga = false;
		int trunk = 0;
		int longestBranch = 0;
		
		while(!stack.isEmpty()) {
			edge cur = stack.pop();
			//루트에서 2가지로 바로 뻗는 경우 추가
			if(!giga && (adjList[cur.e].size() >=3 || 
					(adjList[cur.e].size() == 2 && cur.e == R) )) {
				giga = true;
			}
			if(giga && adjList[cur.e].size()==1 ) {
				longestBranch = Math.max(cur.b, longestBranch);
			}
			for(edge next : adjList[cur.e]) {
				if(!visited[next.e]) {
					if(!giga) {
						trunk += next.l;
						stack.push(new edge(next.e, next.l,0));
					}else {
						stack.push(new edge(next.e, next.l,cur.b+next.l));
					}
					visited[next.e] = true;
				}
			}
		}
		System.out.println(trunk +" "+ longestBranch);
	}
}