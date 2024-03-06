package workbook_0x18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class 회장뽑기_2660 {
    static int n;
    static List<List<Integer>> adjList = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for(int i = 0 ; i <= n ; i++) adjList.add(new ArrayList<>());

        StringTokenizer st;
        while (true){
            st = new StringTokenizer(br.readLine());
            int a  = Integer.parseInt(st.nextToken());
            int b  = Integer.parseInt(st.nextToken());
            if(a == -1) break;
            adjList.get(a).add(b);
            adjList.get(b).add(a);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int value = bfs(1);
        pq.offer(1);
        for(int i =2 ; i <=n ; i++){
            int tmp = bfs(i);
            if( value > tmp){
                value = tmp;
                pq.clear();
                pq.offer(i);
            }else if (value == tmp){
                pq.offer(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(value).append(" ").append(pq.size()).append("\n");
        while (!pq.isEmpty()) sb.append(pq.poll()).append(" ");
        System.out.println(sb);
    }

    private static int bfs(int start) {
        Queue<Node> q = new LinkedList<>();
        boolean[] visited = new boolean[n+1];

        q.offer(new Node(start,0));
        visited[start] = true;
        int max = 0;
        while (!q.isEmpty()){
            Node cur = q.poll();
            max = max < cur.cnt ? cur.cnt : max;

            for(int n : adjList.get(cur.v)){
                if(visited[n]) continue;
                q.offer(new Node(n, cur.cnt+1));
                visited[n] =true;
            }
        }
        return max;
    }
    static class Node{
        int v,cnt;
        Node(int v, int cnt){
            this.v=v;
            this.cnt=cnt;
        }
    }
}
