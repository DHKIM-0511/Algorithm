package workbook_0x1A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class 문제집_1766 {
    static int n,m;
    static int[] indeg;
    static List<List<Integer>> adjList = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        indeg = new int[n+1];
        for(int i = 0 ; i<= n ; i++) adjList.add(new ArrayList<>());
        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adjList.get(a).add(b);
            indeg[b]++;
        }

        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 1 ; i <= n ; i++){
            if(indeg[i] == 0){
                pq.offer(i);
            }
        }

        while (!pq.isEmpty()){
            int cur = pq.poll();

            sb.append(cur).append(" ");
            for(int n : adjList.get(cur)){
                indeg[n]--;
                if(indeg[n] == 0) pq.offer(n);
            }
        }
        System.out.println(sb);
    }
}
