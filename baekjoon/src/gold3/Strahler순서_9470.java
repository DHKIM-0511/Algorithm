package gold3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Strahler순서_9470 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		for(int tc = 1 ; tc <= t ; tc++) {
			st = new StringTokenizer(br.readLine());
			
			int K = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken()); // 노드 수
			int P = Integer.parseInt(st.nextToken()); // 간선 수
			
			int[] InDegree = new int[M+1]; // 우선순위
			int[] shr = new int[M+1]; // shr순서
			int[] cnt = new int[M+1]; // 연결된 강의 수
			
			List<Integer>[] adjList = new LinkedList[M+1];
			for(int i = 1 ; i<=M ; i++) adjList[i] = new LinkedList<>();
			
			for(int i = 1 ; i <= P ; i++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				
				adjList[s].add(e);
				InDegree[e]++;
			}
			
			int ans = 0;
			Queue<Integer> q = new LinkedList<>();
			for(int i = 1 ; i<= M ; i++) {
				if(InDegree[i] == 0) {
					q.add(i);
					shr[i]++; 
					cnt[i]++;
				}
			}
			
			while(!q.isEmpty()) {
				int cur = q.poll();
				// 유입 강이 2개 이상이면 순서 증가
				if(cnt[cur] >= 2) shr[cur]++; 
				ans = Math.max(ans, shr[cur]);
				
				for(int next : adjList[cur]) {
					InDegree[next]--;
					if(InDegree[next] == 0) q.add(next);
					// 동일 순서 방문시 강의 수 증가
					if(shr[next] == shr[cur]) cnt[next]++;
					// shr순서 = 최대값 갱신
					else if(shr[next] < shr[cur]) {
						shr[next] = shr[cur];
						cnt[next] = 1;
					}
				}
				
			}
			System.out.println(K+" "+ans);
		}
	}
}
