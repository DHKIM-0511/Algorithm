package silver2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 촌수계산_2644 {
	static int end, answer = -1;
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> adjList = new ArrayList<>(); 
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        visited = new boolean[n + 1];
        for (int i = 0; i <= n; i++) adjList.add(new ArrayList<>());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            adjList.get(from).add(to);
            adjList.get(to).add(from);
        }
        dfs(start, 0);
        System.out.println(answer);
    }

    private static void dfs(int cur, int cnt) {
        visited[cur] = true;
        for (int x : adjList.get(cur)) {
            if (!visited[x]) { 
                if (x == end) { //end에 도달하면
                    answer = cnt + 1;
                    return;
                }
                dfs(x, cnt + 1);
            }
        }
    }
}
