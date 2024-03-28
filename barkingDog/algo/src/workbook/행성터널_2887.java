package workbook;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 행성터널_2887 {
    static int n;
    static Node[] input;
    static List<List<Edge>> adjList = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        input = new Node[n];
        StringTokenizer st;
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            input[i] = new Node(i,x,y,z);
        }
        for(int i = 0 ; i < n ; i++) adjList.add(new ArrayList<>());
        for(int i = 0 ; i < 3; i++) addEdge(i);

        PriorityQueue<Edge> pq = new PriorityQueue<>((o1,o2)-> Long.compare(o1.w,o2.w));
        boolean[] isMST = new boolean[n];
        isMST[0] = true;
        for(Edge e : adjList.get(0)) pq.offer(e);
        long sum = 0;
        int cnt =0;
        while (cnt < n-1){
            Edge cur = pq.poll();

            if(isMST[cur.e]) continue;
            isMST[cur.e] = true;
            cnt++;
            sum += cur.w;
            for(Edge e : adjList.get(cur.e)){
                if(isMST[e.e]) continue;
                pq.offer(e);
            }
        }
        System.out.println(sum);
    }

    //각 기준으로 정렬한 상태에서 거리만 고려
    private static void addEdge(int flag) {
        if(flag == 0) {
            Arrays.sort(input,((o1, o2) -> o1.x-o2.x));
        }else if(flag == 1){
            Arrays.sort(input,((o1, o2) -> o1.y-o2.y));
        }else {
            Arrays.sort(input,((o1, o2) -> o1.z-o2.z));
        }

        for(int i = 1 ; i < n ; i++){
            Node u = input[i-1];
            Node v = input[i];
            long d = flag==0 ? Math.abs(u.x-v.x) : flag == 1 ? Math.abs(u.y-v.y) : Math.abs(u.z-v.z);
            adjList.get(u.p).add(new Edge(v.p,d));
            adjList.get(v.p).add(new Edge(u.p,d));
        }
    }

    static class Node{
        int p,x,y,z;
        Node(int p,int x,int y,int z){
            this.p=p;
            this.x=x;
            this.y=y;
            this.z=z;
        }
    }
    static class Edge{
        int e;
        long w;
        Edge(int e,long w){
            this.e=e;
            this.w=w;
        }
    }
}
