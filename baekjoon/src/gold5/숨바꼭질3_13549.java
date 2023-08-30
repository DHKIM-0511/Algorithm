package gold5;

import java.util.PriorityQueue;
import java.util.Scanner;

public class 숨바꼭질3_13549 {
	
	static int n,k,ans;
	static boolean[] visited;
	
	public static class edge implements Comparable<edge>{
		int idx;
		int d;
		public edge(int idx,int d) {
			this.idx = idx;
			this.d = d;
		}

		@Override
		public int compareTo(edge o) {
			return this.d - o.d;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		//각 노드간의 거리 (가중치)
		visited = new boolean[100001];
		PriorityQueue<edge> pq = new PriorityQueue<>();
		// 현 위치 pq에 추가
		pq.add(new edge(n,0));
		
		while(!pq.isEmpty()) {
			edge tmp = pq.poll();
			
			if(visited[tmp.idx]) continue;
			
			visited[tmp.idx] = true;
			if(tmp.idx == k) {
				ans = tmp.d;
				break;
			}
			int[] dist = { -1 , 1 , 2};
			for(int i = 0 ; i < 3 ; i++) {
				if(i < 2) {
					if(tmp.idx+dist[i] >= 0 && tmp.idx+dist[i]<= 100000 ) {
						edge temp= new edge(tmp.idx + dist[i], tmp.d+1);
						pq.add(temp);
					}
				}else {
					if(tmp.idx*dist[i] >= 0 && tmp.idx*dist[i]<= 100000 ) {
					edge temp= new edge(tmp.idx * dist[i], tmp.d);
					pq.add(temp);
					}
				}
			}
		}
		System.out.println(ans);
	}
}
