package workbook;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 횡단보도_24042 {
    static int n,m;
    static List<List<Node>> adjList = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for(int i = 0 ; i <= m ; i++) adjList.add(new ArrayList<>());
        for(int i = 1 ; i <= m ; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            adjList.get(s).add(new Node(i,e));
            adjList.get(e).add(new Node(i,s));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>(((o1, o2) -> o1.order-o2.order));
        boolean[] visited = new boolean[n+1];
        for(Node n : adjList.get(1)) pq.offer(n);

        int loc = 1;
        int ans = 0;
        while (!pq.isEmpty()){
            Node cur = pq.poll();

            if(visited[cur.e]) continue;
            visited[cur.e] =true;
            ans += cur.order;
            if(loc == n){
                break;
            }
            for(Node n : adjList.get(cur.e)){
                if(visited[n.e]) continue;
                pq.offer(new Node(n.order, n.e));
            }
        }

        System.out.println(ans);
    }
    static class Node{
        int order,e;
        Node(int order, int e){
            this.order=order;
            this.e=e;
        }
    }
}
