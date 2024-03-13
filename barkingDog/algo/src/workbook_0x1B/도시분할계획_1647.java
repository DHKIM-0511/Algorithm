package workbook_0x1B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 도시분할계획_1647 {
    static int n,m;
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

        boolean[] isMST = new boolean[n+1];
        PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2) -> o1.w-o2.w);

        isMST[1] = true;
        for(Node n : adjList.get(1)) pq.offer(n);

        int cnt = 0;
        int ans = 0;
        int max = 0;
        while (cnt < n-1){
            Node cur = pq.poll();

            if(isMST[cur.e]) continue;
            isMST[cur.e] =true;
            cnt++;
            ans += cur.w;
            max = Math.max(max, cur.w);
            for(Node n : adjList.get(cur.e)){
                if(isMST[n.e]) continue;
                pq.offer(n);
            }
        }
        System.out.println(ans-max);
    }
    static class Node{
        int e,w;
        Node(int e, int w){
            this.e = e;
            this.w = w;
        }
    }
}
