package solutions_0x10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 계단오르기_2579 {
    static int N;
    static int[] step = new int[305];
    static int[][] memo = new int[305][3];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for(int i = 1 ; i <= N ; i++){
            step[i] = Integer.parseInt(br.readLine());
        }
        if (N == 1) {
            System.out.println(step[1]);
            return;
        }
        memo[1][1] = step[1]; memo[1][2] = 0;
        memo[2][1] = step[2]; memo[2][2] = step[2]+step[1];
        for(int i = 3 ; i <= N ; i++){
            memo[i][1] = Math.max(memo[i-2][1], memo[i-2][2]) + step[i];
            memo[i][2] = memo[i-1][1] + step[i];
        }
        System.out.println(Math.max(memo[N][1], memo[N][2]));
    }
}
