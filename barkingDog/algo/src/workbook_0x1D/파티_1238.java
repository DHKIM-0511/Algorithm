package workbook_0x1D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 파티_1238 {
    static int n,m,x;
    static List<List<Node>> adjList = new ArrayList<>();
    static int[] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        dist = new int[n+1];
        for(int i = 0 ; i <= n ; i++){
            adjList.add(new ArrayList<>());
        }
        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine());
            int a= Integer.parseInt(st.nextToken());
            int b= Integer.parseInt(st.nextToken());
            int c= Integer.parseInt(st.nextToken());

            adjList.get(a).add(new Node(b,c));
        }
        int ans = 0;
        for(int i =1 ; i <= n ; i++){
            ans = Math.max(getDist(i,x) + getDist(x,i), ans);

        }
        System.out.println(ans);
    }

    private static int getDist(int s, int e) {
        Arrays.fill(dist,Integer.MAX_VALUE);
        PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2) -> o1.w-o2.w);
        dist[s] = 0;
        pq.offer(new Node(s,0));

        while (!pq.isEmpty()){
            Node cur = pq.poll();

            if(cur.w  !=  dist[cur.e])continue;
            for(Node n : adjList.get(cur.e)){
                if(n.w + dist[cur.e] < dist[n.e]){
                    dist[n.e] = n.w + dist[cur.e];
                    pq.offer(new Node(n.e, dist[n.e]));
                }
            }
        }

        return dist[e];
    }

    static class Node{
        int e,w;
        Node(int e, int w){
            this.e=e;
            this.w=w;
        }
    }
}
