package gold5;

import java.io.*;
import java.util.*;

public class 나무위의빗물_17073 {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		
		List<Integer>[] adjList = new LinkedList[N+1];
		for(int i = 0 ; i < N+1 ; i++) adjList[i] = new LinkedList<>();
		
		for(int i = 0 ; i < N-1 ; i++) {
			st = new StringTokenizer(br.readLine());
			
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			adjList[u].add(v);
			adjList[v].add(u);
		}
		
		int leaf = 0;
		for(int i = 2 ; i < N+1 ; i++) {
			if(adjList[i].size() == 1) leaf++;
		}
		double ans = (double)W/leaf;
		System.out.println(ans);
	}
}
