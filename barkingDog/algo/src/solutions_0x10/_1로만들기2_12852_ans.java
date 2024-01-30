package solutions_0x10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1로만들기2_12852_ans {
    static int N;
    static int[] memo = new int[1000005];
    static int[] pre = new int[1000005];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i =2 ; i <= N ; i++){
            memo[i] = memo[i-1]+1;
            pre[i] = i-1;
            if(i % 2 == 0 && memo[i] > memo[i/2]+1){
                memo[i] = memo[i/2]+1;
                pre[i] = i/2;
            }
            if(i % 3 == 0 && memo[i] > memo[i/3]+1){
                memo[i] = memo[i/3]+1;
                pre[i] = i/3;
            }
        }
        sb.append(memo[N]).append("\n");

        int cur = N;
        while (true){
            sb.append(cur).append(" ");
            if(cur == 1) break;
            cur = pre[cur];
        }
        System.out.println(sb);
    }
}
