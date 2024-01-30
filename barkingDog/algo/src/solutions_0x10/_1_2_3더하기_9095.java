package solutions_0x10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class _1_2_3더하기_9095 {
    static int N;
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int tc = 0 ; tc < T; tc++){
            int cur = Integer.parseInt(br.readLine());
            list.add(cur);
            N = Math.max(cur,N);
        }
        int[] memo = new int[N+1];
        memo[1] = 1; memo[2] = 2; memo[3] = 4;

        for(int i = 4; i <= N; i++){
            memo[i] = memo[i-1] + memo[i-2] + memo[i-3];
        }
        for(int i : list){
            sb.append(memo[i]).append("\n");
        }
        System.out.println(sb);
    }
}
