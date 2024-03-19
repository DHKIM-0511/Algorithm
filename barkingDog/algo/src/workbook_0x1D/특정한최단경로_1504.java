package workbook_0x1D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 특정한최단경로_1504 {
    static final int INF = 0x3f3f3f3f;
    static int n,m,v1,v2;
    static List<List<Node>> adjList = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for(int i = 0 ; i <= n ; i++) adjList.add(new ArrayList<>());

        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            adjList.get(a).add(new Node(b,c));
            adjList.get(b).add(new Node(a,c));
        }
        st = new StringTokenizer(br.readLine());
        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());

        long d1 = getDist(1,v1) + getDist(v1,v2) + getDist(v2,n);
        long d2 = getDist(1,v2) + getDist(v2,v1) + getDist(v1,n);
        long ans = Math.min(d1,d2);
        if(ans >= INF) ans = -1;
        System.out.println(ans);
    }

    private static long getDist(int s, int e) {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2) -> o1.w-o2.w);
        int[] dist = new int[n+1];
        Arrays.fill(dist, INF);
        dist[s] = 0;
        pq.offer(new Node(s,0));

        while (!pq.isEmpty()){
            Node cur = pq.poll();

            if(cur.w > dist[cur.e]) continue;
            for(Node n : adjList.get(cur.e)){
                if(dist[cur.e] + n.w < dist[n.e]){
                    dist[n.e] = dist[cur.e] + n.w;
                    pq.offer(new Node(n.e, dist[n.e]));
                }
            }
        }

        return dist[e];
    }

    static class Node{
        int e, w;
        Node(int e,int w){
            this.e = e;
            this.w = w;
        }
    }
}
