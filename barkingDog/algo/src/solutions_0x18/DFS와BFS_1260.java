package solutions_0x18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class DFS와BFS_1260 {
    static int n,m,v;
    static List<List<Integer>> adjList = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    static boolean[] visited1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        visited1 = new boolean[n+1];
        for(int i = 0 ; i <= n ; i++) adjList.add(new ArrayList<>());

        for(int i = 0 ; i < m ; i++) {
            st = new StringTokenizer(br.readLine());
            int a= Integer.parseInt(st.nextToken());
            int b= Integer.parseInt(st.nextToken());
            adjList.get(a).add(b);
            adjList.get(b).add(a);
        }
        for(int i = 1 ; i <= n ; i++) Collections.sort(adjList.get(i));
        dfs(v);
        bfs();
        System.out.println(sb);
    }

    private static void dfs(int cur) {
        if(visited1[cur]) return;
        visited1[cur] = true;
        sb.append(cur).append(" ");
        for(int next : adjList.get(cur)){
            if(visited1[next]) continue;
            dfs(next);
        }
    }
    private static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n+1];
        q.offer(v);
        visited[v] = true;
        sb.append("\n");
        while (!q.isEmpty()){
            int cur = q.poll();
            sb.append(cur).append(" ");
            for(int next : adjList.get(cur)){
                if(visited[next]) continue;
                q.offer(next);
                visited[next] = true;
            }
        }
    }
}
