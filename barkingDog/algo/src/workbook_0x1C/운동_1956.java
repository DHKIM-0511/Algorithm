package workbook_0x1C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 운동_1956 {
    static final int INF=0x3f3f3f3f;
    static int v,e;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        map = new int[v+1][v+1];
        for(int i = 1 ; i <= v ; i++){
            Arrays.fill(map[i], INF);
            map[i][i] = 0;
        }
        for(int i = 0 ; i < e; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            map[a][b] =c;
        }

        for(int k = 1; k <= v ; k++){
            for(int i =1 ; i <= v ; i++){
                for(int j =1 ; j <= v ; j++){
                    int d = map[i][k] + map[k][j];
                    if(map[i][j] > d){
                        map[i][j] = d;
                    }
                }
            }
        }

        int ans = INF;
        for(int i =1 ; i <= v ; i++){
            for(int j = i +1 ; j <= v ; j++){
                ans = Math.min(ans, map[i][j] + map[j][i]);
            }
        }
        if(ans == INF) ans = -1;
        System.out.println(ans);
    }
}
