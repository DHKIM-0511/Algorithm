package workbook;

import java.io.*;
import java.util.*;

public class 가장긴증가하는부분수열4_14002 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n+1];
        int[] memo = new int[n+1];
        int[] path = new int[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n ; i++){
            a[i] = Integer.parseInt(st.nextToken());
            memo[i] = 1;
        }

        for(int i =1 ; i <= n ; i++){

            for(int j = 1; j < i ; j++){
                if(a[j] < a[i] && memo[i] < memo[j]+1){
                    memo[i] = memo[j]+1;
                    path[i] = j;
                }
            }
        }

        int idx = 1;
        for(int i = 2; i <= n ;i++){
            if(memo[idx] < memo[i]){
                idx = i;
            }
        }
        Deque<Integer> ans = new LinkedList<>();
        int cur = idx;
        while (cur > 0){
            ans.addFirst(a[cur]);
            cur = path[cur];
        }
        StringBuilder sb = new StringBuilder();
        sb.append(ans.size()).append("\n");
        for(int i : ans) sb.append(i).append(" ");
        System.out.println(sb);

    }
}
