package gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class 트리_1068 {
	static List<Integer>[] adjList;
	static boolean[] visited;
	static int N,del,ans;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		visited= new boolean[N];
		adjList = new LinkedList[N];
		for(int i = 0 ; i < N ; i++) adjList[i] = new LinkedList<>();
		
		int root = 0;
		StringTokenizer st= new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N ; i++) {
			int parent = Integer.parseInt(st.nextToken());
			if(parent != -1){
				adjList[i].add(parent);
				adjList[parent].add(i);
            } else {
                root = i;
            }
		}
		
		del = Integer.parseInt(br.readLine());
		ans = 0;
		
		if(del == root) System.out.println(0);
		else { 
			DFS(root);
			System.out.println(ans);
		}
	}
	private static void DFS(int num) {
		visited[num] = true;
        int cnt = 0;
        for(int i : adjList[num]){
            if(!visited[i] && i != del){
            	cnt++;
                DFS(i);
            }
        }
        if(cnt == 0){
            ans++;
        }
	}
}
