package gold3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 게임개발_1516_A형문제연습 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine()); // 건물 수
		
		List<Integer>[] adjList = new LinkedList[n+1];
		for(int i = 1 ; i < n+1 ; i++) adjList[i] = new LinkedList<>();
		
		int[] inDegree = new int[n+1];
		int[] time = new int[n+1];
		
		for(int i = 1 ; i < n+1 ; i++) {
			st = new StringTokenizer(br.readLine());
			time[i] =Integer.parseInt(st.nextToken());
			
			while(st.hasMoreTokens()) {
				int tmp = Integer.parseInt(st.nextToken());
				if(tmp == -1) break;
				else {
					adjList[tmp].add(i);
					inDegree[i]++;
				}
			}
		}
		
		Queue<Integer> q = new LinkedList<>();
		List<Integer>list = new ArrayList<>();
		
		for(int i = 1 ; i < n+1 ; i++) {
			if(inDegree[i] == 0) {
				q.add(i);
				list.add(i);
			}
		}
		
		int[] plus = new int[n+1];
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			for(int next : adjList[cur]) {
				inDegree[next]--;
//				plus[next] = Math.max(plus[next], plus[cur] + time[cur]);
				plus[next] = plus[cur] + time[cur];
				
				if(inDegree[next] == 0) q.add(next);
			}
		}
		System.out.println(Arrays.toString(time));
		System.out.println(Arrays.toString(plus));
		
		
		for(int i =1 ; i <n+1 ; i++) {
			System.out.println(time[i] + plus[i]);
		}
	}
}
