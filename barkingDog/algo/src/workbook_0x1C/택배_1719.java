package workbook_0x1C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 택배_1719 {
    static final int INF = 0x3f3f3f3f;
    static int n,m;
    static int[][] map;
    static int[][] next;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n+1][n+1];
        next = new int[n+1][n+1];
        for(int i = 1; i <= n ; i++){
            Arrays.fill(map[i], INF);
            map[i][i] = 0;
        }

        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            map[a][b] = c;
            map[b][a] = c;
            next[a][b] = b;
            next[b][a] = a;
        }

        for(int k = 1; k <= n ; k++){
            for(int i = 1 ; i <= n ; i++){
                for(int j =1 ; j<= n ; j++){
                    int d = map[i][k] + map[k][j];
                    if(d < map[i][j]){
                        map[i][j] = d;
                        next[i][j] = next[i][k];
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1 ; i <= n ; i++){
            for(int j = 1 ; j <= n ; j++){
                if( next[i][j] == 0 )sb.append("-");
                else sb.append(next[i][j]);
                sb.append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
