package workbook;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 허들넘기_23286 {
    static final int INF = 0x3f3f3f3f;
    static int n,m,t;
    static int[][] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        dist = new int[n+1][n+1];
        for(int i = 0 ; i < n+1 ; i++){
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }
        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            dist[a][b] = c;
        }

        for(int k = 1 ; k < n+1 ; k++){
            for(int i = 1 ; i < n+1 ; i++){
                for(int j = 1 ; j < n+1 ; j++){
                    int max = Math.max(dist[i][k], dist[k][j]);
                    if(dist[i][j] > max){
                        dist[i][j] = max;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while (t-- >0){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int v = dist[r][c];
            if(v == INF) v = -1;
            sb.append(v).append("\n");
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
