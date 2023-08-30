package gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 게리멘더링_17471 {
	static int N,ans;
	static List<Integer>[] adjList;
	static int[] people;
	static boolean[] selected,visited;
	
	static class edge{
		int e;

		public edge(int e) {
			super();
			this.e = e;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		people = new int[N];
		selected = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N ; i++)people[i] = Integer.parseInt(st.nextToken());
		
		adjList = new LinkedList[N];
		for(int i = 0 ; i < N ; i++) adjList[i] = new LinkedList<>();
		
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			
			for(int j = 0 ; j < n ; j++) {
				int e = Integer.parseInt(st.nextToken());
				adjList[i].add(e-1);
			}
		}
		ans = Integer.MAX_VALUE;
		combi(0);
		
		if(ans == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(ans);
	}

	private static void combi(int idx ) {
		if(idx==N) {
			List<Integer> aList = new ArrayList<>();
			List<Integer> bList = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				if (selected[i])
					aList.add(i);
				else
					bList.add(i);
			}
			if (aList.size() == 0 || bList.size() == 0) // 한 지역에 몰빵 X
				return;
			
			if (check(aList) && check(bList)) { // 두 구역이 각각 연결되었는지 확인
				getdiff(); // 인구차 구하기
			}
			return;
		}else {
			selected[idx] = true;
			combi(idx + 1);
			selected[idx] = false;
			combi(idx + 1);
		}
	}

	private static boolean check(List<Integer> list) {
		Queue<Integer> q = new LinkedList<>();
		visited = new boolean[N];
		
		q.offer(list.get(0));
		visited[list.get(0)] = true;
		
		int cnt = 1; // 방문 지역 개수
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			for(int i : adjList[cur]) {
				if(list.contains(i) && !visited[i]) { // 선거구에 해당 , 미방문
					q.offer(i);
					visited[i] = true;
					cnt++;
				}
			}
		}
		if(cnt == list.size()) return true; // 선거구 해당 수 = 방문지역 수
		else return false;
	}

	private static void getdiff() {
		int peopleA = 0 ;
		int peopleB = 0 ;
		
		for(int i = 0 ; i < N ; i++) {
			if(selected[i])
				peopleA += people[i];
			else
				peopleB += people[i];
		}
		int diff = Math.abs(peopleA - peopleB);
		ans = Math.min(ans, diff);
	}
}
