package gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 선발명단_3980 {
	static int ans;
	static int[][] map = new int[11][11];
	static boolean[] visited;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= tc ; t++) {
			for(int i = 0 ; i < 11 ; i ++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0 ; j <11 ; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			ans = Integer.MIN_VALUE;
			visited = new boolean[11];
			back(0 , 0);
			System.out.println(ans);
		}
	}
	private static void back(int cur, int status) {
		if(cur == 11) {
			ans = Math.max(status, ans);
			return;
		}
		
		for(int i = 0 ; i < 11 ; i++) {
			if(map[cur][i] != 0 && !visited[i]) {
				visited[i] = true;
				back(cur+1, status + map[cur][i]);
				visited[i] = false;
			}
		}
	}
}
