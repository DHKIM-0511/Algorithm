package workbook;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 케빈베이컨의6단계법칙_1389 {
    static final int INF = 0x3f3f3f3f;
    static int n,m;
    static int[][] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        dist = new int[n+1][n+1];
        for(int i = 1 ; i <= n ; i++){
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }

        for(int i = 0 ; i<m ; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            dist[u][v] = 1;
            dist[v][u] = 1;
        }

        for(int k = 1 ; k <= n ; k++){
            for(int i = 1 ; i <=n ; i++){
                for(int j =1 ; j <= n ; j++){
                    if(dist[i][j] > dist[i][k] + dist[k][j]){
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
        int max = INF;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 1; i <= n ; i++){
            int sum = 0;
            for(int j = 1; j <= n ;j++){
                sum += dist[i][j];
            }
            if(sum > max) continue;
            if( sum < max){
                list.clear();
                max = sum;
            }
            list.add(i);
        }
        System.out.println(list.get(0));
    }
}
