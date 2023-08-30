package gold3;

import java.io.*;
import java.util.*;

public class ACMCraft_1005 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		
		int t = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= t ; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			List<Integer>[] adjList = new LinkedList[N+1];
			for(int i = 0 ; i < N+1 ; i++) adjList[i] = new LinkedList<>();
			
			int[] inDegree = new int[N+1];
			int[] time = new int[N+1];
			boolean[] visited = new boolean[N+1];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 1 ; i < N+1 ; i++)
				time[i] = Integer.parseInt(st.nextToken());
			
			
			for(int i = 0 ; i< K ; i++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				adjList[s].add(e);
				inDegree[e]++;
			}
			int vic = Integer.parseInt(br.readLine());
			
			Queue<Integer> q = new LinkedList<>();
			for(int i = 1 ; i <N+1 ; i++) if(inDegree[i] == 0) q.add(i);
			
			
			//건물의 기본소요시간 복사
			int[] res = new int[N+1];
			for(int i=1; i<N+1; i++) res[i] = time[i];
			
 			while(!q.isEmpty()) {
				int cur = q.poll();
				for(int next : adjList[cur]) {
					//총소요시간 = 이전 소요시간 + 건물 소요시간
					res[next] = Math.max(res[next], res[cur]+time[next]);
					inDegree[next]--;
					
					if(inDegree[next] == 0 ) {
						q.add(next);
					}
				}
			}
 			System.out.println(res[vic]);
		}
	}
}
