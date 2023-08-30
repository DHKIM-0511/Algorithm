package gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 숫자고르기_2668 {
	static List<Integer> ansList;
    static boolean[] visited;
    static int[] input;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		input = new int[N+1];
		visited = new boolean[N+1];
		for(int i = 1 ; i <= N ; i++) {
			input[i] = Integer.parseInt(br.readLine());
		}
		
		ansList = new ArrayList<>();
		for(int i = 1; i <= N ; i++) {
			visited[i] = true;
			DFS(i,i);
			visited[i] = false;
		}
		Collections.sort(ansList);
		int size = ansList.size();
		System.out.println(size);
		for(int i = 0 ; i < size ; i++) {
			System.out.println(ansList.get(i));
		}
	}
	private static void DFS(int cur, int target) {
		if(!visited[input[cur]]) {
			visited[input[cur]] = true;
			DFS(input[cur], target);
			visited[input[cur]] = false;
		}
		if(input[cur] == target) ansList.add(target);
	}
}
