package workbook_0x10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 정수삼각형_1932 {
    static int[][] map = new int[505][505];
    static int[][] memo = new int[505][505];
    static int N ;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for(int i = 1 ; i <= N ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int j = 1;
            while (st.hasMoreTokens()){
                map[i][j++] = Integer.parseInt(st.nextToken());
            }
        }

        memo[1][1] = map[1][1];
        for(int i = 2 ; i <= N ; i++){
            for(int j = 1 ; j <= i ; j++){
                memo[i][j] = Math.max(memo[i-1][j-1] + map[i][j], memo[i-1][j]+map[i][j]);
            }
        }
        int ans = 0;
        for(int i = 1; i <= N ; i++){
            if(ans < memo[N][i]) ans = memo[N][i];
        }
        System.out.println(ans);
    }
}
