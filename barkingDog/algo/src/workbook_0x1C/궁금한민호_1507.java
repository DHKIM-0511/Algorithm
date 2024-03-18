package workbook_0x1C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 궁금한민호_1507 {
    static final int INF = 2501;
    static int n;
    static int[][] map = new int[22][22];
    static boolean[][] b = new boolean[22][22];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i = 1 ; i <= n ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j =1 ; j <= n ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i =1 ; i <= n ; i++){
            for(int j =1 ; j <= n ; j++){
                boolean flag = true;
                for(int k = 1 ; k <= n ; k++){
                    if ( k == i || k == j) continue;
                    int tmp = map[i][k] + map[k][j];
                    if(tmp < map[i][j]){
                        System.out.println(-1);
                        return;
                    }else if(tmp == map[i][j]) flag = false;
                }
                if (flag){
                    b[i][j] = true;
                    b[j][i] = true;
                }
            }
        }

        int ans = 0;
        for(int i = 1 ; i<= n ; i++){
            for(int j = i + 1; j <= n ; j++){
                if(b[i][j]) ans += map[i][j];
            }
        }
        System.out.println(ans);
    }
}
