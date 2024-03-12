package workbook_0x1A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 음악프로그램_2623 {
    static int n,m;
    static List<List<Integer>> adjList = new ArrayList<>();
    static int[] indeg;
    static List<Integer> ans = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for(int i = 0 ; i<= n ; i++) adjList.add(new ArrayList<>());
        indeg = new int[n+1];

        for(int i = 0 ;i < m; i++){
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());

            int pre = 0;
            for(int j = 0 ; j < num ; j++){
                int cur = Integer.parseInt(st.nextToken());
                if( j == 0){
                    pre = cur;
                }else {
                    adjList.get(pre).add(cur);
                    indeg[cur]++;
                    pre=cur;
                }
            }
        }
        setOrder();
        if(ans.size() != n){
            System.out.println(0);
            return;
        }
        StringBuilder sb = new StringBuilder();
        for(int i : ans){
            sb.append(i).append("\n");
        }
        System.out.println(sb);
    }

    private static void setOrder() {
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1 ; i <= n ; i++) if(indeg[i] == 0) q.offer(i);

        while (!q.isEmpty()){
            int cur = q.poll();
            ans.add(cur);
            for(int n : adjList.get(cur)){
                indeg[n]--;
                if(indeg[n] == 0) q.offer(n);
            }
        }
    }
}
