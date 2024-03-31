package workbook;

import java.io.*;
import java.util.*;

public class 효율적인해킹_1325 {
    static int n,m,max;
    static List<List<Integer>> adjList = new ArrayList<>();
    static boolean[] visited;
    static int[] cntArr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for(int i = 0 ; i <= n ; i++) adjList.add(new ArrayList<>());
        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adjList.get(a).add(b);
        }

        cntArr = new int[n+1];
        for(int i = 1 ; i <= n ;i++){
           visited = new boolean[n+1];
           dfs(i);
        }

        for(int i = 1; i <= n ; i++) max = Math.max(max, cntArr[i]);

        for(int i =1 ; i <= n ; i++) {
            if(cntArr[i] == max)bw.write(i+" ");
        }
        bw.flush();
        bw.close();
    }

    private static void dfs(int cur) {
        visited[cur] =true;

        for(int n : adjList.get(cur)){
            if(visited[n]) continue;
            cntArr[n]++;
            dfs(n);
        }
    }
}
