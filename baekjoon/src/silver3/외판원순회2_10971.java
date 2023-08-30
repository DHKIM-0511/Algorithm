package silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 외판원순회2_10971 {
	static int n,ans;
	static int[][] map;
	static boolean[] visited;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		for(int i = 0 ; i < n ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < n ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		ans = Integer.MAX_VALUE;
		visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            visited[i] = true;
            back(i, i, 0, 0);
        }
        System.out.println(ans);
    }

    public static void back(int start, int cur, int sum, int cnt) {
        if (cnt == n - 1) { 
            if (map[cur][start] != 0) {
                sum += map[cur][start];
                ans = Math.min(ans, sum);
            }
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i] && map[cur][i] != 0) {
                visited[i] = true;
                back(start, i, sum + map[cur][i], cnt + 1);
                visited[i] = false;
            }
        }
    }
}
