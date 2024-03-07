package workbook_0x19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 민서의응급수술_20955 {
    static int n,m;
    static List<List<Integer>> adjList = new ArrayList<>();
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visited = new boolean[n+1];
        for(int i = 0 ; i <= n ;i++) adjList.add(new ArrayList<>());
        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adjList.get(a).add(b);
            adjList.get(b).add(a);
        }

        int cnt = 0;
        for(int i = 1 ; i <= n ; i++){
            if(visited[i])continue;
            dfs(i);
            cnt++;
        }
        //트리의간선 = n-1 개 인데 지금 m개임
        // 근데 연결요소 개수 -1 개를 더해서 모두일단 연결한다치면 m + cnt-1개임
        // (m+cnt-1) -(n-1) = 트리를 만들기위해 제거해야하는 간선 수
        //따라서 작업수 = (cnt-1) + (m+cnt-1) -(n-1)
        System.out.println((cnt-1) + (m+cnt-1) -(n-1));
    }

    private static void dfs(int cur) {
        visited[cur] =true;
        for(int n : adjList.get(cur)){
            if(visited[n]) continue;
            dfs(n);
        }
    }
}
