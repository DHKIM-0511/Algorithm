package solutions_0x1D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 최단경로_1753 {
    static int v,e,k;
    static List<List<Node>> adjList = new ArrayList<>();
    static int[] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(br.readLine());

        dist = new int[v+1];
        for(int i = 0 ; i <= v ; i++){
            adjList.add(new ArrayList<>());
            dist[i] = Integer.MAX_VALUE;
        }

        for(int i = 0 ; i < e ; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            adjList.get(a).add(new Node(b,c));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2) -> o1.w-o2.w);
        dist[k] = 0;
        pq.offer(new Node(k,0));

        while (!pq.isEmpty()){
            Node cur = pq.poll();

            if(dist[cur.e] != cur.w) continue;
            for(Node next : adjList.get(cur.e)){
                if(next.w + dist[cur.e]< dist[next.e]){
                    dist[next.e] = next.w + dist[cur.e];
                    pq.offer(new Node(next.e, dist[next.e]));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i =1 ; i <= v ; i++){
            if(dist[i] == Integer.MAX_VALUE)sb.append("INF");
            else sb.append(dist[i]);
            sb.append("\n");
        }
        System.out.println(sb);
    }
    static class Node{
        int e,w;
        Node(int e,int w){
            this.e=e;
            this.w=w;
        }
    }
}
