package workbook_0x19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 회사문화1_14267 {
    static int n,m;
    static List<List<Integer>> adjList = new ArrayList<>();
    static int[] a;
    static int[] ans;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        a = new int[n+1];
        ans = new int[n+1];
        visited = new boolean[n+1];
        for(int i = 0 ; i <= n ; i++) adjList.add(new ArrayList<>());
        st = new StringTokenizer(br.readLine());
        for(int i = 1 ; i <= n ; i++){
            int a = Integer.parseInt(st.nextToken());
            if(a == -1) continue;
            adjList.get(a).add(i);
        }

        while (m-->0){
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            a[i] += w;
        }

        for(int i = 1; i <= n ; i++){
            if(visited[i]) continue;
            dfs(i);
        }
        StringBuilder sb = new StringBuilder();
        for(int i =1 ; i <= n ; i++) sb.append(ans[i]).append(" ");
        System.out.println(sb);
    }

    private static void dfs(int cur) {
        visited[cur] = true;
        ans[cur] += a[cur];
        for(int n : adjList.get(cur)){
            if(visited[n]) continue;
            ans[n] += ans[cur];
            dfs(n);
        }
    }
}
