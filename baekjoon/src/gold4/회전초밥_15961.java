package gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class 회전초밥_15961 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		int[] sushi = new int[N];
		for(int i = 0 ; i< N ; i++) sushi[i] = Integer.parseInt(br.readLine());
		int start = 0;
		int end = k-1;
		HashSet<Integer> set = new HashSet<>();
		int[] visited = new int[d+1];
		//초항 선정
		for(int i = start ; i<= end ; i++) {
			set.add(sushi[i]);
			visited[sushi[i]]++;
		}
		int max = set.size();
		if(!set.contains(c)) max++;
		
		while(start <N) {
			if(visited[sushi[start]] == 1) set.remove(sushi[start]);
			visited[sushi[start]]--;
			start++;
			
			end = (end+1)%N;
			visited[sushi[end]]++;
			set.add(sushi[end]);
			
			int size = set.size();
			if(!set.contains(c)) size++;
			max = Math.max(max,size);
		}
		System.out.println(max);
	}
}
