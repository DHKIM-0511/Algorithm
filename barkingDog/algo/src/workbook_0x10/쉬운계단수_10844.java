package workbook_0x10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 쉬운계단수_10844 {
    static int N;
    static long[][] memo = new long[105][10]; // 마지막 자리수 0 ~ 9
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N =Integer.parseInt(br.readLine());

        for(int i = 1 ; i < 10 ; i++) memo[1][i] = 1;

        for(int i = 2; i <= N ; i++){
            for(int j = 0 ; j < 10 ; j++){
                if(j != 0) memo[i][j] += memo[i-1][j-1];
                if(j != 9) memo[i][j] += memo[i-1][j+1];
                memo[i][j] %= 1000000000;
            }
        }

        long ans = 0;
        for(int i = 0 ; i < 10 ; i++){
            ans += memo[N][i];
        }
        ans %= 1000000000;
        System.out.println(ans);
    }
}
