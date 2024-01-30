package workbook_0x10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 파도반수열_9461 {
    static long[] memo = new long[105];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int max = 0;
        List<Integer> list = new ArrayList<>();
        for(int tc = 0 ; tc < T ; tc++){
            int cur = Integer.parseInt(br.readLine());
            max = Math.max(cur, max);
            list.add(cur);
        }
        memo[1] = 1;memo[2] = 1;memo[3] = 1;
        for(int i =4 ; i <= max ; i++) memo[i] = memo[i-2] + memo[i-3];

        StringBuilder sb = new StringBuilder();
        for(int i : list) sb.append(memo[i]).append("\n");
        System.out.println(sb);
    }
}
