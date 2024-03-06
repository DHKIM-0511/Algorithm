package workbook_0x18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 구슬찾기_2617 {
    static int n,m;
    static List<List<Integer>> adjListLight = new ArrayList<>();
    static List<List<Integer>> adjListHeavy = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for(int i = 0 ; i <= n ; i++){
            adjListLight.add( new ArrayList<>() );
            adjListHeavy.add( new ArrayList<>() );
        }
        for(int i = 0 ; i < m; i ++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adjListLight.get(a).add(b);
            adjListHeavy.get(b).add(a);
        }
        int ans = 0;
        int t = n/2+1;
        for(int i = 1; i <= n ; i++){
            if( bfs(i) >= t) ans++;
        }
        System.out.println(ans);
    }

    private static int bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n+1];

        q.offer(start);
        visited[start] = true;

        int max = 0;
        int cnt = 0;
        while (!q.isEmpty()){
            int cur = q.poll();
            if(cur != start) cnt++;
            max = max < cnt ? cnt : max;
            for(int n : adjListLight.get(cur)){
                if(visited[n]) continue;
                q.offer(n);
                visited[n] = true;
            }
        }
        q = new LinkedList<>();
        Arrays.fill(visited, false);

        q.offer(start);
        visited[start] = true;
        cnt = 0;
        while (!q.isEmpty()){
            int cur = q.poll();
            if(cur != start) cnt++;
            max = max < cnt ? cnt : max;
            for(int n : adjListHeavy.get(cur)){
                if(visited[n]) continue;
                q.offer(n);
                visited[n] = true;
            }
        }
        return max;
    }
}
