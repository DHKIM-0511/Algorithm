package workbook_0x1C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백양로브레이크_11562 {
    static final int INF = 0x3f3f3f3f;
    static int n,m,k;
    static int [][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map= new int[n+1][n+1];
        for(int i = 1 ; i <= n ; i++){
            Arrays.fill(map[i],INF);
            map[i][i] = 0;
        }
        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map[a][b] = 0;
            if(c==0) map[b][a] = 1;
            else map[b][a] = 0;
        }
        for(int p = 1 ; p <= n ; p++){
            for(int i = 1 ; i <= n ; i++){
                for(int j = 1; j <= n ; j++){
                    int d = map[i][p] + map[p][j];
                    if(map[i][j] > d){
                        map[i][j] = d;
                    }
                }
            }
        }

        k = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (k-->0){
            st= new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            sb.append(map[s][e]).append("\n");
        }
        System.out.println(sb);

    }
}
