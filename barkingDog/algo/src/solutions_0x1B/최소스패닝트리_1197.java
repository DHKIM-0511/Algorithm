package solutions_0x1B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 최소스패닝트리_1197 {
    static int v,e;
    static List<List<Node>> adjList = new ArrayList<>();
    static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        check = new boolean[v+1];
        for(int i = 0 ; i<= v ; i++) adjList.add(new ArrayList<>());
        for(int i = 0 ; i < e ; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            adjList.get(a).add(new Node(b,c));
            adjList.get(b).add(new Node(a,c));
        }

        PriorityQueue<Node> pq= new PriorityQueue<>((o1, o2) -> {
            return o1.w - o2.w;
        });
        check[1] = true;
        for(Node n : adjList.get(1)){
            pq.offer(n);
        }

        int cnt = 0;
        int ans = 0;
        while (cnt < v-1){
            Node cur = pq.poll();

            if(check[cur.e]) continue;
            ans += cur.w;
            check[cur.e] = true;
            cnt++;
            for(Node n : adjList.get(cur.e)){
                if(check[n.e]) continue;
                pq.offer(n);
            }
        }
        System.out.println(ans);
    }
    static class Node{
        int e,w;
        Node(int e, int w){
            this.e=e;
            this.w=w;
        }
    }
}
