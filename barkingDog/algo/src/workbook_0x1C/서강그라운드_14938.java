package workbook_0x1C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 서강그라운드_14938 {
    static final int INF=0x3f3f3f3f;
    static int n,m,r;
    static int[] items;
    static boolean[] visited;
    static int[][] map, next;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        visited = new boolean[n+1];
        items = new int[n+1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n ; i++) items[i] = Integer.parseInt(st.nextToken());

        map = new int[n+1][n+1];
        next = new int[n+1][n+1];
        for(int i = 1 ; i <= n ; i++){
            Arrays.fill(map[i], INF);
            map[i][i] = 0;
        }

        for(int i = 0 ; i < r; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            map[a][b] = c;
            map[b][a] = c;
            next[a][b] = b;
            next[b][a] = a;
        }

        for(int k = 1 ; k <= n ; k++){
            for(int i =1 ; i <= n ; i++){
                for(int j = 1; j<= n ; j++){
                    int dist= map[i][k] + map[k][j];
                    if(map[i][j] > dist){
                        map[i][j] = dist;
                        next[i][j] = next[i][k];
                    }
                }
            }
        }
        int max = 0;
        for(int i = 1 ; i<= n ; i++){
            int tmp = 0;
            Arrays.fill(visited, false);
            for(int j =1 ; j <= n ;j++){
                if(map[i][j] > m)continue;
                visit(i,j);
            }
            for(int j = 1 ; j <= n ; j++) if(visited[j]) tmp += items[j];
            max = Math.max(max, tmp);
        }
        System.out.println(max);
    }

    private static void visit(int i, int j) {
        int cur = i;
        while (cur != j){
            visited[cur] = true;
            cur = next[cur][j];
        }
        visited[j] = true;
    }
}
