package workbook_0x10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 암호코드 {
    static int N, mod= 1000000;
    static int[] num = new int[5005];
    static int[] memo = new int[5005];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        N = input.length();

        for(int i = 1 ; i <= N ; i++) num[i] = input.charAt(i-1)-'0';
        memo[0] = 1;

        for(int i = 1 ; i <= N ; i++){
            if(num[i] > 0 ) memo[i] = (memo[i] + memo[i-1]) % mod;
            int tmp = num[i-1] * 10 + num[i];
            if(tmp >= 10 && tmp <= 26) memo[i] = (memo[i] + memo[i-2]) % mod;
        }
        System.out.println(memo[N]);
    }
}
