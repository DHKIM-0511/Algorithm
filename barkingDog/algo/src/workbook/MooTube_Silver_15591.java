package workbook;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class MooTube_Silver_15591 {
    static int n,q;
    static List<List<Node>> adjList = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        for(int i = 0 ; i <= n ; i++) adjList.add(new ArrayList<>());
        for(int i = 0 ; i < n-1 ; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            adjList.get(a).add(new Node(b,c));
            adjList.get(b).add(new Node(a,c));
        }

        StringBuilder sb = new StringBuilder();
        while (q-->0){
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            sb.append(bfs(k,v)).append("\n");
        }
        System.out.println(sb);
    }

    private static int bfs(int k,int start) {
        Queue<Node> q= new LinkedList<>();
        for(Node n : adjList.get(start)){
            q.offer(n);
        }

        boolean[] visited= new boolean[n+1];
        visited[start] = true;

        int cnt = 0;
        while (!q.isEmpty()){
            Node cur = q.poll();

            if(visited[cur.e]) continue;
            visited[cur.e] = true;

            if(cur.v >= k)cnt++;

            for(Node n : adjList.get(cur.e)){
                if(visited[n.e]) continue;
                q.offer(new Node(n.e, Math.min(n.v, cur.v)));
            }
        }
        return cnt;
    }

    static class Node{
        int e, v;
        Node(int e, int v){
            this.e=e;
            this.v=v;
        }
    }
}
