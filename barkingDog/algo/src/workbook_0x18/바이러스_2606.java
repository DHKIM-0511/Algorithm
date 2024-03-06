package workbook_0x18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 바이러스_2606 {
    static int n,m,ans;
    static List<List<Integer>> adjList = new ArrayList<>();
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        visited = new boolean[n+1];
        for(int i = 0 ; i <= n ; i++) adjList.add(new ArrayList<>());

        StringTokenizer st;
        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine());
            int a= Integer.parseInt(st.nextToken());
            int b= Integer.parseInt(st.nextToken());
            adjList.get(a).add(b);
            adjList.get(b).add(a);
        }

        dfs(1);
        System.out.println(ans-1);
    }

    private static void dfs(int cur) {
        if(visited[cur]) return;
        visited[cur] = true;
        ans++;

        for(int n : adjList.get(cur)){
            if(visited[n]) continue;
            dfs(n);
        }
    }
}
