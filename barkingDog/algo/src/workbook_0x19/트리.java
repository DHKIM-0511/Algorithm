package workbook_0x19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 트리 {
    static boolean isTree;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb =  new StringBuilder();
        StringTokenizer st;
        int idx = 1;
        while (true){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            if(n == 0 && m == 0) break;
            visited = new boolean[n+1];
            List<List<Integer>> adjList = new ArrayList<>();
            for(int i = 0 ; i <= n ; i++) adjList.add(new ArrayList<>());

            for(int i = 0 ; i < m ; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                adjList.get(a).add(b);
                adjList.get(b).add(a);
            }

            int cnt = 0;
            for(int i = 1 ; i<= n ; i++){
                if(visited[i]) continue;
                visited[i] = true;
                isTree = true;
                dfs(i,-1, adjList);
                if(isTree) cnt++;
            }

            sb.append("Case ").append(idx);
            if(cnt > 1){
                sb.append(": A forest of ").append(cnt).append(" trees.\n");
            }else if(cnt == 1){
                sb.append(": There is one tree.\n");
            }else {
                sb.append(": No trees.\n");
            }
            idx++;
        }
        System.out.println(sb);
    }

    private static void dfs(int cur, int p, List<List<Integer>> adjList) {
        for(int n : adjList.get(cur)){
            if(n == p) continue;
            if(visited[n]){
                isTree = false;
                continue;
            }
            visited[n] = true;
            dfs(n, cur, adjList);
        }
    }
}
