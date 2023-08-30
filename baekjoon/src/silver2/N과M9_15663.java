package silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class N과M9_15663 {
	static int N,M;
	static int[] num;
	static boolean[] visited;
	static LinkedHashSet<String> set = new LinkedHashSet<>();

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		visited = new boolean[N];
		num = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i< N ; i++) num[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(num);
		
		getNums(0,new int[M]);
		
		set.forEach(System.out::println);
	}
	private static void getNums(int cnt, int[] sel) {
		if(cnt ==  M) {
			StringBuilder sb = new StringBuilder();
			
			for(int a : sel) sb.append(a).append(" ");
			
			set.add(sb.toString());
		}else {
			for(int i = 0 ; i< N ;i++) {
				if(visited[i]) continue;
				visited[i] = true;
				sel[cnt] = num[i];
				getNums(cnt+1,sel);
				visited[i] = false;
			}
		}
	}
}