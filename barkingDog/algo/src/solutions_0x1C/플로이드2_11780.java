package solutions_0x1C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 플로이드2_11780 {
    static int n,m, INF = 0x3f3f3f3f;
    static int[][] distMap;
    static int[][] nextMap;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        distMap = new int[n+1][n+1];
        nextMap = new int[n+1][n+1];
        for(int i =1 ; i <= n ; i++) Arrays.fill(distMap[i], INF);

        StringTokenizer st;
        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            distMap[a][b] = Math.min(distMap[a][b], c);
            nextMap[a][b] = b;
        }
        for(int i =1 ; i <= n ; i++) distMap[i][i] = 0;

        for(int k = 1; k <= n ; k++){
            for(int i = 1; i <= n ; i++){
                for(int j = 1 ; j <= n ; j++){
                    if(distMap[i][j] <= distMap[i][k] + distMap[k][j]) continue;
                    distMap[i][j] = distMap[i][k] + distMap[k][j];
                    nextMap[i][j] = nextMap[i][k];
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i =1 ; i<= n ; i++){
            for(int j =1 ; j <= n ; j++){
                int d = 0;
                if(distMap[i][j] != INF) d=distMap[i][j];
                sb.append(d).append(" ");
            }
            sb.append("\n");
        }

        for(int i =1 ; i <= n ; i++){
            for(int j = 1; j <= n ; j++){
                if(distMap[i][j] == 0 || distMap[i][j] == INF){
                    sb.append(0).append("\n");
                    continue;
                }
                List<Integer> path = new ArrayList<>();
                int n = i;
                while (n != j){
                    path.add(n);
                    n= nextMap[n][j];
                }
                path.add(j);
                sb.append(path.size()).append(" ");
                for(int p : path) sb.append(p).append(" ");
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}
