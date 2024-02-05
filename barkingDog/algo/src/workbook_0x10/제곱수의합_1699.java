package workbook_0x10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 제곱수의합_1699 {
    static int N;
    static int[] memo = new int[100005];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());


        for(int i = 1; i <= N ; i++){
            memo[i] = i;
            for(int j = 1 ; j*j <= i ; j++){
                memo[i] = Math.min(memo[i], memo[i-j*j] + 1);
            }
        }
        System.out.println(memo[N]);
    }
}
