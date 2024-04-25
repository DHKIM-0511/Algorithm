package workbook;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 숨바꼭질_6118 {
    static int n,m;
    static List<List<Integer>> adjList = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for(int i = 0 ; i <= n ; i++) adjList.add(new ArrayList<>());

        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine());
            int a= Integer.parseInt(st.nextToken());
            int b= Integer.parseInt(st.nextToken());

            adjList.get(a).add(b);
            adjList.get(b).add(a);
        }

        Queue<int[]> q = new LinkedList<>();
        boolean[] visited = new boolean[n+1];
        int[] dist = new int[n+1];

        q.offer(new int[]{1,0});
        visited[1] = true;

        while (!q.isEmpty()){
            int[] cur = q.poll();

            dist[cur[0]] = cur[1];
            for(int n : adjList.get(cur[0])){
                if(visited[n]) continue;
                q.offer(new int[]{n,cur[1]+1});
                visited[n] = true;
            }
        }
        int idx = 0;
        int tmp = 0;
        int cnt = 0;
        for(int i = 0 ; i <= n ; i++){
            if(dist[i] > tmp){
                idx = i;
                cnt = 1;
                tmp = dist[i];
            }else if(dist[i] == tmp){
                cnt++;
            }
        }

        System.out.println(idx+" "+tmp+" "+cnt);
    }
}
