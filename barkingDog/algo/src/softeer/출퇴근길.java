package softeer;

import java.io.*;
import java.util.*;

public class 출퇴근길 {
    static int N,M,home,company;
    static List<Integer>[] adjList;
    static List<Integer>[] reverseAdjList;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adjList = new LinkedList[N+1];
        reverseAdjList = new LinkedList[N+1];
        for(int i = 0 ; i < N+1 ; i++){
            adjList[i] = new LinkedList<>();
            reverseAdjList[i] = new LinkedList<>();
        }

        for(int i = 0 ; i< M ; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            adjList[x].add(y);
            reverseAdjList[y].add(x);
        }

        st = new StringTokenizer(br.readLine());
        home = Integer.parseInt(st.nextToken()); company = Integer.parseInt(st.nextToken());

        boolean[] fromH = new boolean[N+1];
        fromH[company] = true;
        dfs(home, adjList,fromH ); // 출근길에 도달할 수 있는 정점

        boolean[] fromC = new boolean[N+1];
        fromC[home] = true;
        dfs(company, adjList, fromC); // 퇴근길에 도달할 수 있는 정점

        boolean[] toH = new boolean[N+1];
        dfs(home, reverseAdjList, toH); // 정점에서 집을 갈 수 있는지

        boolean[] toC = new boolean[N+1];
        dfs(company, reverseAdjList, toC); // 정점에서 회사를 갈 수 있는지

        int ans = 0;
        for(int i = 1; i < N+1 ; i++){
            if(fromH[i] && fromC[i] && toH[i] && toC[i]) ans++;
        }
        System.out.println(ans-2);
    }

    private static void dfs(int cur, List<Integer>[] adjList, boolean[] visited) {
        if(visited[cur]) return;
        visited[cur] = true;

        for(int next : adjList[cur]){
            dfs(next,adjList,visited);
        }
    }
}
