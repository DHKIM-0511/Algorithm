package workbook_0x1B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 학교탐방하기_13418 {
    static int n,m;
    static List<List<Node>> adjList = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for(int i = 0 ;i <= n ; i++) adjList.add(new ArrayList<>());
        for(int i = 0 ; i < m+1 ; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            adjList.get(a).add(new Node(b,c));
            adjList.get(b).add(new Node(a,c));
        }

        System.out.println(getValue(true)-getValue(false));
    }

    private static long getValue(boolean isMax) {
        boolean[] isMST = new boolean[n+1];
        PriorityQueue<Node> pq;
        if(isMax) pq = new PriorityQueue<>((o1, o2) -> o1.w-o2.w);
        else pq = new PriorityQueue<>((o1, o2) -> o2.w-o1.w);

        isMST[0] = true;
        for(Node n : adjList.get(0)) pq.offer(n);

        int res = 0;
        int cnt = 0;
        while (cnt < n){
            Node cur = pq.poll();

            if(isMST[cur.e])continue;
            isMST[cur.e] = true;
            cnt++;
            if(cur.w == 0){
                res++;
            }
            for(Node n : adjList.get(cur.e)){
                if(isMST[n.e]) continue;
                pq.offer(n);
            }
        }
        return res*res;
    }

    static class Node{
        int e,w;
        Node(int e, int w){
            this.e=e;
            this.w=w;
        }
    }
}
