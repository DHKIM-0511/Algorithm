package solutions_0x19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 트리의부모찾기_11725 {
    static int n;
    static List<List<Integer>> edge = new ArrayList<>();
    static int[] ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        ans = new int[n+1];
        for(int i = 0 ; i <= n ; i++) edge.add(new ArrayList<>());

        StringTokenizer st;
        for(int i = 0 ; i < n-1 ; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            edge.get(a).add(b);
            edge.get(b).add(a);
        }
        bfs();
        StringBuilder sb = new StringBuilder();
        for(int i =2 ; i <= n ; i++) sb.append(ans[i]).append("\n");
        System.out.println(sb);
    }

    private static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n+1];

        q.offer(1);
        visited[1] = true;
        while (!q.isEmpty()){
            int cur = q.poll();

            for(int n : edge.get(cur)){
                if(visited[n]) continue;
                ans[n] = cur;
                q.offer(n);
                visited[n] = true;
            }
        }
    }
}
