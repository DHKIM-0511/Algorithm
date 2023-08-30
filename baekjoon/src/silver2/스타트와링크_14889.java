package silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 스타트와링크_14889 {
	static int n,ans;
	static int[][] map;
	static boolean[] visited;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine()); // 짝수
		map = new int[n][n];
		visited = new boolean[n];
		for(int i = 0 ; i < n ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < n ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		ans = Integer.MAX_VALUE;
		DFS(0 ,0);
		
		System.out.println(ans);
	}
	private static void DFS(int idx, int d) {
		
		if(d == n/2) {
			
			diff();
		}else {
			
			for(int i = idx ; i < n ; i++) {
				if(!visited[i]) {
					visited[i] = true;
					DFS(i+1 ,d+1);
					visited[i] = false;
				}
			}
		}
		
	}
	private static void diff() {
		int startCoun = 0;
		int linkCoun = 0;
		
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				// i 번째 사람과 j 번째 사람이 true라면 스타트팀으로 점수 플러스 
				if (visited[i] == true && visited[j] == true) {
					startCoun += map[i][j];
					startCoun += map[j][i];
				}
				// i 번째 사람과 j 번째 사람이 false라면 링크팀으로 점수 플러스 
				else if (visited[i] == false && visited[j] == false) {
					linkCoun += map[i][j];
					linkCoun += map[j][i];
				}
			}
		}
		
		int dif = Math.abs(startCoun - linkCoun);
		
		ans = Math.min(dif, ans);
	}
}
