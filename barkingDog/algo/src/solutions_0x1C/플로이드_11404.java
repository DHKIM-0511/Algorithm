package solutions_0x1C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 플로이드_11404 {
    static int n,m;
    static final int INF = 0x3f3f3f3f;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        int[][] map = new int[n+1][n+1];
        for(int i = 1 ; i <= n ; i++) Arrays.fill(map[i],INF);

        StringTokenizer st;
        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            map[a][b] = Math.min(map[a][b], c);
        }
        for(int i = 1 ; i <= n ; i++) map[i][i] = 0;

        updateMinDis(map);
        printMap(map);
    }

    private static void updateMinDis(int[][] map) {
        for(int k = 1 ; k <= n ; k++){
            for(int i =1 ; i <= n ; i++){
                for(int j = 1 ; j <= n ; j++){
                    map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
                }
            }
        }
    }

    private static void printMap(int[][] map) {
        StringBuilder sb = new StringBuilder();
        for(int i = 1 ; i <= n ; i++){
            for(int j = 1; j <= n ; j++){
                int d = map[i][j];
                if( d == INF) d=0;
                sb.append(d).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static class Node{
        int e,w;
        Node(int e,int w){
            this.e=e;
            this.w=w;
        }
    }
}
