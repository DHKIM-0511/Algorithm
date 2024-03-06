package workbook_0x18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class 결혼식_5567 {
    static int n,m;
    static List<List<Integer>> adjList = new ArrayList<>();
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        visited = new boolean[n+1];
        for(int i = 0 ;i <= n ; i++) adjList.add(new ArrayList<>());

        StringTokenizer st;
        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adjList.get(a).add(b);
            adjList.get(b).add(a);
        }

        if(adjList.get(1).size() == 0){
            System.out.println(0);
            return;
        }

        System.out.println(getCnt()-1);
    }

    private static int getCnt() {
        Set<Integer> set = new HashSet<>();
        for(int i : adjList.get(1)){
            set.add(i);
            for(int j : adjList.get(i)){
                set.add(j);
            }
        }
        return set.size();
    }
}
