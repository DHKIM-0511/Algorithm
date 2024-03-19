package solutions_0x1D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 최소비용구하기2_11779 {
    static int n,m;
    static List<List<Node>> adjList = new ArrayList<>();
    static int[] dist;
    static int[] next;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        dist= new int[n+1];
        next= new int[n+1];
        for(int i = 0 ; i <= n ; i++){
            adjList.add(new ArrayList<>());
            Arrays.fill(dist, Integer.MAX_VALUE);
        }
        StringTokenizer st;
        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            adjList.get(a).add(new Node(b,c));
        }
        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2) -> o1.w - o2.w);
        dist[s] = 0;
        pq.offer(new Node (s,0));

        while (!pq.isEmpty()){
            Node cur = pq.poll();

            if(cur.w != dist[cur.e]) continue;
            for(Node n : adjList.get(cur.e)){
                if(n.w + dist[cur.e] < dist[n.e]){
                    dist[n.e] = n.w + dist[cur.e];
                    next[n.e] = cur.e;
                    pq.offer(new Node(n.e , dist[n.e]));
                }
            }
        }
        ArrayList<Integer> path = new ArrayList<>();
        int idx = e;
        while (idx != s){
            path.add(idx);
            idx = next[idx];
        }
        path.add(idx);
        Collections.reverse(path);

        StringBuilder sb = new StringBuilder();
        sb.append(dist[e]).append("\n");
        sb.append(path.size()).append("\n");
        for(int i : path) sb.append(i).append(" ");

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
