package solutions_0x10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RGB거리_1149 {
    static int N;
    static int[][] price = new int[1005][3];
    static int[][] memo = new int[1005][3];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for(int i = 1 ; i <= N ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            price[i][0] = Integer.parseInt(st.nextToken());
            price[i][1] = Integer.parseInt(st.nextToken());
            price[i][2] = Integer.parseInt(st.nextToken());
        }
        memo[1][0] = price[1][0];memo[1][1] = price[1][1];memo[1][2] = price[1][2];
        for(int i =2 ; i <= N ; i++){
            memo[i][0] = Math.min(memo[i-1][1], memo[i-1][2])+price[i][0];
            memo[i][1] = Math.min(memo[i-1][0], memo[i-1][2])+price[i][1];
            memo[i][2] = Math.min(memo[i-1][1], memo[i-1][0])+price[i][2];
        }
        System.out.println(Math.min(memo[N][0],Math.min(memo[N][1], memo[N][2])));
    }
}
