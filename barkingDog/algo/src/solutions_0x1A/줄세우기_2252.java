package solutions_0x1A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 줄세우기_2252 {
    static int n,m;
    static List<List<Integer>> adjList = new ArrayList<>();
    static int[] indeg;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        indeg = new int[n+1];
        for(int i = 0 ; i <= n ; i++) adjList.add(new ArrayList<>());
        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adjList.get(a).add(b);
            indeg[b]++;
        }

        StringBuilder sb = new StringBuilder();
        Queue<Integer> q = new LinkedList<>();
        for(int i =1 ; i <= n ;i++){
            if(indeg[i] == 0) q.offer(i);
        }

        while (!q.isEmpty()){
            int cur = q.poll();

            sb.append(cur).append(" ");
            for(int n : adjList.get(cur)){
                indeg[n]--;
                if(indeg[n] == 0) q.offer(n);
            }
        }
        System.out.println(sb);
    }
}
