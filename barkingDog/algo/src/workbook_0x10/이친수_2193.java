package workbook_0x10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 이친수_2193 {
    static int N;
    static long[][] memo = new long[95][2];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        memo[1][1] =1;
        for(int i = 2 ; i <= N ;i++){
            memo[i][0] = memo[i-1][0]+memo[i-1][1]; //0으로끝나는 i자리 경우의수 = i-1자리 0으로 끝나는 경우의수 + 1로 끝나는 경우의수
            memo[i][1] = memo[i-1][0]; //1로끝나는 i자리 경우의수 = i-1 자리 0ㅇ으로 끝나는 수
        }
        System.out.println(memo[N][0] + memo[N][1]);
    }
}
