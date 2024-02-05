package workbook_0x10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 가장큰정사각형_1915 {
    static int N,M;
    static int[][] map = new int[1005][1005];
    static int[][] memo = new int[1005][1005];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().split(" ");
        N = Integer.parseInt(NM[0]);
        M = Integer.parseInt(NM[1]);

        for(int i = 1 ; i <= N ; i++){
            String input= br.readLine();
            for(int j = 1 ; j <= M ; j++){
                map[i][j] = input.charAt(j-1) - '0';
            }
        }

        int ans = 0;
        for(int i = 1; i <= N ; i++){
            for(int j = 1; j <= M ; j++){
                if(map[i][j] >= 1){
                    memo[i][j] = Math.min(memo[i-1][j], Math.min(memo[i][j-1], memo[i-1][j-1])) +1;
                    ans = Math.max(ans, memo[i][j]);
                }
            }
        }
        System.out.println(ans * ans);
    }
}
