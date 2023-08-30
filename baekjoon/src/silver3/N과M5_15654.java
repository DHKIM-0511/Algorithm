package silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N과M5_15654 {
	static int N,M;
	static int[] num;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		boolean[] visited = new boolean[N];
		num = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i< N ; i++) num[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(num);
		
		getNum(0,0,visited , new int[M]);
		System.out.println(sb);
	}
	private static void getNum(int cnt , int idx, boolean[] visited, int[] sel) {
		if(cnt == M) {
			for(int a : sel) sb.append(a).append(" ");
			sb.append("\n");
			return;
		}
		for(int i = 0 ; i < N ; i++) {
			if(!visited[i]){
				visited[i] = true;
				sel[cnt] = num[i];
				getNum(cnt+1, i+1, visited, sel);
				visited[i] = false;
			}
		}
	}
}
