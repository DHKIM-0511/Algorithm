package gold4;

import java.io.*;
import java.util.*;

public class 타임머신_11657 {
	static int N,M;
	static List<node>[] adjList;
	static long[] distance;
	static class node {
		int B,C;

		public node(int b, int c) {
			B = b;
			C = c;
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		adjList = new LinkedList[N+1];
		distance = new long[N+1];
		for(int i = 0 ; i < N+1 ; i++) { 
			adjList[i] = new LinkedList<>();
			distance[i] = Long.MAX_VALUE;
		}
		
		for(int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			adjList[a].add(new node(b, c));
		}
		
		StringBuilder sb = new StringBuilder();
		if(bellmanFord()) {
			sb.append("-1\n");
		}else {
			for(int i = 2 ; i < N+1 ; i++) {
				if(distance[i] == Long.MAX_VALUE) {
					sb.append("-1\n");
				}else {
					sb.append(distance[i]+"\n");
				}
			}
		}
		System.out.println(sb);
	}
	private static boolean bellmanFord() {
		//시작점
		distance[1] = 0;
		boolean update = false;
		
		// (정점의 개수 - 1)번 동안 최단거리 초기화 작업을 반복함.
		for(int i = 1 ; i < N ; i++) {
			update = false;
			
			for(int j = 1; j < N+1 ; j++) {
				for(node n : adjList[j]) {
					if(distance[j] == Long.MAX_VALUE) break;
					
					//다음 행선지 가중치 = 현위치 가중치 + 간선 가중치
					if(distance[n.B] > distance[j] + n.C) {
						distance[n.B] = distance[j] + n.C;
						update = true;
					}
				}
			}
			
			if(!update) break;
		}
		
		if(update) {
			for(int i = 1; i < N+1 ; i++) {
				for(node n : adjList[i]) {
					if(distance[i] == Long.MAX_VALUE) break;
					
					if(distance[n.B] > distance[i] + n.C) return true;
				}
			}
		}
		return false;
	}
}





















