package workbook_0x19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 노드사이의거리_1240 {
    static int n,m,ans;
    static boolean[] visited = new boolean[1005];
    static List<List<Node>> adjList = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for(int i = 0 ; i <= n ; i++) adjList.add(new ArrayList<>());
        for(int i = 0 ; i< n-1; i ++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            adjList.get(a).add(new Node(b,d));
            adjList.get(b).add(new Node(a,d));
        }
        StringBuilder sb =new StringBuilder();
        while (m-- >0){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            getDist(s,e,0);
            sb.append(ans).append("\n");
            Arrays.fill(visited,false);
        }
        System.out.println(sb);
    }

    private static void getDist(int cur, int e, int dist) {
        visited[cur] =true;
        for(Node n : adjList.get(cur)){
            if(visited[n.v]) continue;
            if(n.v == e){
                ans = dist+n.d;
                return;
            }
            getDist(n.v,e,dist+n.d);
        }
    }

    static class Node{
        int v,d;
        Node(int v, int d){
            this.v = v;
            this.d = d;
        }
    }
}
