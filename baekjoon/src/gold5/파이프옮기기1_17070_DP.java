package gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 파이프옮기기1_17070_DP {
    static int N;
    static int[][] map;
    static int[][][] dp;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new int[N][N][3];
        
        dp[0][1][0] = 1;
        
        for (int i = 0; i < N; i++) {
            for (int j = 2; j < N; j++) {
                if (map[i][j] == 1) {
                    continue;
                }

                // 가로
                // 이전 지점서 가로인 경우 + 대각선인 경우
                dp[i][j][0] = dp[i][j - 1][0] + dp[i][j-1][1];
                
                // 대각
                // 맵에서 세로 위 대각 쪽이 다 뚫려있는 경우에만 진행
                if (i-1>=0 && map[i][j - 1] == 0 && map[i - 1][j] == 0) {
                    dp[i][j][1] = dp[i - 1][j - 1][0] + dp[i - 1][j - 1][1] + dp[i-1][j-1][2];
                }

                // 세로
                if(i - 1 >= 0) {
                    dp[i][j][2] = dp[i - 1][j][1] + dp[i-1][j][2];
                }
            }
        }

        System.out.println(dp[N - 1][N - 1][0] + dp[N - 1][N - 1][1] + dp[N - 1][N - 1][2]);
    }
}

