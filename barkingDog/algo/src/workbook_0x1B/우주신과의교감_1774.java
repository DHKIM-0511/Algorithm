package workbook_0x1B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 우주신과의교감_1774 {
    static int n,m;
    static List<List<Node>> adjList = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=  new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for(int i = 0 ; i <= n ; i++) adjList.add(new ArrayList<>());
        int[][] idx = new int[n+1][2];
        for(int i = 1 ; i <= n ; i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            idx[i] = new int[]{r, c};
        }

        PriorityQueue<int[]> passage = new PriorityQueue<>(((o1, o2) -> {
            if(o1[0]==o2[0])return o1[1]-o2[1];
            return o1[0]-o2[0];
        }));

        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(a>b){
                int tmp = 0;
                tmp=a;
                a=b;
                b=tmp;
            }
            passage.offer(new int[]{a,b});
        }

        for(int i = 1 ; i < n ; i++){
            for(int j = i+1 ; j <= n ; j++){
                double d = 0;
                int[] cur = passage.peek();
                if(cur!=null && cur[0] == i && cur[1] == j) {
                    passage.poll();
                }else {
                    d = Math.sqrt(Math.pow(idx[i][0] - idx[j][0],2)+ Math.pow(idx[i][1] - idx[j][1],2));
                }
                adjList.get(i).add(new Node(j, d));
                adjList.get(j).add(new Node(i, d));
            }
        }

        boolean[] isMST = new boolean[n+1];
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Double.compare(o1.w,o2.w));

        isMST[1] = true;
        for(Node n : adjList.get(1)) pq.offer(n);

        int cnt = 0;
        double ans = 0.0;
        while (cnt < n-1){
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
        System.out.println(String.format("%.2f",ans));
    }
    static class Node{
        int e;
        double w;
        Node(int e,double w){
            this.e=e;
            this.w=w;
        }
    }
}
