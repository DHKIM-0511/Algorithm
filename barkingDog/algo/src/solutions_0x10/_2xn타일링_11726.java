package solutions_0x10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2xn타일링_11726 {
    static int N;
    static int[] memo = new int[1005];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        memo[1] = 1;
        memo[2] = 2;

        for(int i = 3; i <= N ; i++){
            memo[i] = (memo[i-1]+memo[i-2])%10007;
        }
        System.out.println(memo[N]);
    }
}
