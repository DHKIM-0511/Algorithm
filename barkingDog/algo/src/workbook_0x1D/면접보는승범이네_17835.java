package workbook_0x1D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 면접보는승범이네_17835 {
    static int n,m,k;
    static List<List<Node>> adjList = new ArrayList<>();
    static long[] dist;
    static PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2) -> Long.compare(o1.w,o2.w));
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        if(n == k){
            System.out.println(1);
            System.out.println(0);
            return;
        }

        dist = new long[n+1];
        Arrays.fill(dist, Long.MAX_VALUE);
        for(int i = 0 ; i <= n ; i++) adjList.add(new ArrayList<>());

        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            adjList.get(b).add(new Node(a,c));
        }

        st = new StringTokenizer(br.readLine());
        while (k-- >0){
            int cur = Integer.parseInt(st.nextToken());
            dist[cur] = 0;
            pq.offer(new Node(cur,0));
        }
        fnc();
        int idx = 0;
        long max = 0;
        for(int i = 1; i<= n ; i++){
            if(max < dist[i]){
                max = dist[i];
                idx = i;
            }
        }
        System.out.println(idx+"\n"+max);
    }

    private static void fnc() {
        while (!pq.isEmpty()){
            Node cur = pq.poll();

            if(cur.w > dist[cur.e])continue;
            for(Node n : adjList.get(cur.e)){
                if(dist[cur.e] + n.w < dist[n.e]){
                    dist[n.e]= dist[cur.e] + n.w;
                    pq.offer(new Node(n.e, dist[n.e]));
                }
            }
        }
    }

    static class Node{
        int e; long w;
        Node(int e,long w){
            this.e=e;
            this.w=w;
        }
    }
}
