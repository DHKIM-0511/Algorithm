package gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

//같은 깊이 노드 - 형제 노드
public class 사촌_9489 {
	static int n,k,ans;
	static List<Integer>[] adjList;
	static class idx{
		int node , d;

		public idx(int node, int d) {
			super();
			this.node = node;
			this.d = d;
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n= Integer.parseInt(st.nextToken()); //노드 수
			k= Integer.parseInt(st.nextToken()); // k기준 사촌수 = ans
			boolean[] visited = new boolean[1001];
			
			if(n==0 && k ==0) break;
			ans = 0;
			int[] node = new int[n];
			
			st = new StringTokenizer(br.readLine());
			int root = Integer.parseInt(st.nextToken());
			node[0] = root;
			
			adjList = new LinkedList[1001];
			for(int i = 0 ; i < 1001 ; i++) adjList[i] = new LinkedList<>();
			
			int pIdx = 0;
			int sCnt = 0; // k의 형제의 수
			int cnt=0;
			boolean flag = false; //k만남여부
			
			for(int i = 0 ; i < n-1 ; i++) {
				int next = Integer.parseInt(st.nextToken());
				node[i+1] = next;
				if(next == k) flag = true;
				
				if(next - node[i] ==1) {
					//연속 = 형제
					adjList[node[pIdx]].add(next);
					adjList[next].add(node[pIdx]);
					sCnt++;
				}else {
					//사촌 = p를 다음 노드로 옮기고 간선 추가
					pIdx++;
					adjList[node[pIdx]].add(next);
					adjList[next].add(node[pIdx]);
					
					if(flag)cnt=sCnt;
					else sCnt=0;
				}
			}
			List<Integer> sameDepth = new ArrayList<>();
			Queue<idx> q = new LinkedList<>();
			q.add(new idx(root, 0));
			visited[root] = true;
			boolean check = false;
			int depth=0;
			while(!q.isEmpty()) {
				idx cur = q.poll();
				if(cur.node == k) check = true;
				if(check && cur.d > depth) break;
				if(!check && cur.d > depth) {
					depth++;
					sameDepth.clear();
				}
				System.out.println("de"+depth);
				for(int next : adjList[cur.node]) {
					if(!visited[next]) {
						q.add(new idx(next, cur.d+1));
						sameDepth.add(next);
					}
				}
			}
			System.out.println(sameDepth.size());
			System.out.println(cnt);
			System.out.println("----------------");
			System.out.println(sameDepth.size()-1-cnt);
		}
	}
}
