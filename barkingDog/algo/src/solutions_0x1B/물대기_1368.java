package solutions_0x1B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 물대기_1368 {
    static int n;
    static List<List<Node>> adjList = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for(int i = 0 ; i <= n ; i++) adjList.add(new ArrayList<>());

        for(int i = 1 ; i <= n ; i ++){
            int c = Integer.parseInt(br.readLine());
            adjList.get(0).add(new Node(i,c));
            adjList.get(i).add(new Node(0,c));
        }

        StringTokenizer st;
        for(int i = 1 ; i <= n ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n ; j++){
                int c = Integer.parseInt(st.nextToken());
                if(j <= i) continue;
                adjList.get(i).add(new Node(j,c));
                adjList.get(j).add(new Node(i,c));
            }
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.w-o2.w);
        boolean[] isMST = new boolean[n+1];
        isMST[0] = true;
        for(Node n : adjList.get(0))pq.offer(n);

        int cnt = 0;
        int ans = 0;
        while (cnt < n){
            Node cur = pq.poll();

            if(isMST[cur.e]) continue;
            isMST[cur.e] = true;
            cnt++;
            ans += cur.w;
            for(Node n : adjList.get(cur.e)){
                if(isMST[n.e]) continue;
                pq.offer(n);
            }
        }
        System.out.println(ans);
    }
    static class Node{
        int e,w;
        Node(int e, int w){
            this.e =e;
            this.w =w;
        }
    }
}
