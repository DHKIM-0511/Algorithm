package workbook_0x19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 트리와쿼리_15681 {
    static int n,r,q;
    static List<List<Integer>> adjList = new ArrayList<>();
    static boolean[] visited = new boolean[100005];
    static int[] ans = new int[100005];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        for(int i = 0 ; i <= n ; i++) adjList.add(new ArrayList<>());
        for(int i = 0 ; i < n - 1; i ++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adjList.get(a).add(b);
            adjList.get(b).add(a);
        }
        countSubtree(r);
        StringBuilder sb = new StringBuilder();
        while (q-->0){
            int idx = Integer.parseInt(br.readLine());
            sb.append(ans[idx]).append("\n");
        }
        System.out.println(sb);
    }

    private static int countSubtree(int cur) {
        visited[cur] = true;
        for(int n : adjList.get(cur)){
            if(visited[n]) continue;
            ans[cur] += countSubtree(n);
        }
        ans[cur]++;
        return ans[cur];
    }
}
