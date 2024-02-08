package solutions_0x12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 이항계수2_11051 {
    static int[][] memo = new int[1002][1002];
    static int mod = 10007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        for(int i =1 ; i <= 1000 ; i++){
            memo[i][0] = memo[i][i] = 1;
            for(int j = 1; j < i ; j++){
                memo[i][j] = (memo[i-1][j] + memo[i-1][j-1])%mod;
            }
        }
        System.out.println(memo[n][k]);
    }
}
