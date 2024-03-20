package workbook_0x1D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class 골목대장호석_효율성2_20183 {
    static int n,m,s,e;
    static long c,lo = 1, hi;
    static List<List<Node>> adjList = new ArrayList<>();
    static long[] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        c = Long.parseLong(st.nextToken());

        dist = new long[n+1];
        for(int i = 0 ; i<= n ; i++) adjList.add(new ArrayList<>());
        for(int i = 0 ; i< m ; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            long w = Long.parseLong(st.nextToken());

            adjList.get(u).add(new Node(v,w));
            adjList.get(v).add(new Node(u,w));
            hi = Math.max(hi, w);
        }

        while (lo < hi){
            long mid = (lo+hi)/2;
            if(solve(mid)) hi = mid;
            else lo = mid+1;
        }

        if (solve(lo)) System.out.println(lo);
        else System.out.println(-1);
    }

    private static boolean solve(long l) {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2) -> Long.compare(o1.w, o2.w));
        Arrays.fill(dist, Long.MAX_VALUE);

        dist[s] = 0;
        pq.offer(new Node(s,0));
        while (!pq.isEmpty()){
            Node cur = pq.poll();

            if(dist[cur.e] != cur.w) continue;
            for(Node n : adjList.get(cur.e)){
                long d = n.w;
                if(d > l)continue;
                d += cur.w;
                if(dist[n.e] <= d) continue;
                dist[n.e] = d;
                pq.offer(new Node(n.e, d));
            }
        }
        return dist[e] <= c;
    }

    static class Node{
        int e;
        long w;
        Node(int e, long w){
            this.e =e;
            this.w =w;
        }
    }
}
