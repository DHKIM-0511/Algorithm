package workbook_0x10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 피보나치함수_1003 {
    static int[][] memo = new int[45][2];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        memo[0][0] = 1; memo[1][1] = 1;
        for(int i = 2; i <= 40 ; i++){
            memo[i][0] = memo[i-1][0] + memo[i-2][0];
            memo[i][1] = memo[i-1][1] + memo[i-2][1];
        }

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0){
            int N = Integer.parseInt(br.readLine());
            sb.append(memo[N][0]).append(" ").append(memo[N][1]).append("\n");
        }
        System.out.println(sb);
    }
}
