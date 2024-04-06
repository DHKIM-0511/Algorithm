package workbook;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 테트로미노_14500 {
    static int n,m,ans;
    static int[][] map;
    static boolean[] isUsed = new boolean[16];
    static int[] dr = {-1,1,0,0} , dc = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < m ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        getShape(0, new int[4]);
        System.out.println(ans);
    }

    private static void getShape(int cnt, int[] sel) {
        if(cnt == 4){
            if(check(sel)){
                ans = Math.max(ans,getAns(sel));
            }
            return;
        }
        for(int i = 0 ;i < 16 ; i++){
            if(isUsed[i]) continue;
            isUsed[i] = true;
            sel[cnt] = i;
            getShape(cnt+1, sel);
            isUsed[i] = false;
        }
    }

    private static int getAns(int[] sel) {
        int total = 0;
        for(int i = 0 ; i <= n - 4 ; i++){
            for(int j = 0 ; j <= m - 4 ; j++){
                int sum = 0;
                for(int k = 0 ; k < 4 ; k++){
                    int r = sel[k]/4 + i;
                    int c = sel[k]%4 + j;
                    sum += map[r][c];
                }
                total = Math.max(total, sum);
            }
        }

        return total;
    }

    private static boolean check(int[] sel) {
        int[][] copyMap = new int[4][4];
         for (int i : sel){
             int r = i/4;
             int c = i%4;

             if(r < 0 || r >= 4 || c < 0 || c>= 4) return false;
             copyMap[r][c] = 1;
         }

         Queue<int[]> q = new LinkedList<>();
         boolean[][] vis = new boolean[4][4];
         int sr = sel[0]/4;
         int sc = sel[0]%4;
         q.offer(new int[]{sr,sc});
         vis[sr][sc] = true;

         while (!q.isEmpty()){
             int[] cur = q.poll();

             for(int i = 0 ; i < 4; i++){
                 int nr = cur[0] + dr[i];
                 int nc = cur[1] + dc[i];

                 if(nr < 0 || nr >= 4 || nc < 0 || nc>=4 || vis[nr][nc]) continue;
                 if(copyMap[nr][nc] == 0) continue;

                 q.offer(new int[]{nr,nc});
                 vis[nr][nc] =true;
             }
         }

        for (int i : sel){
            int r = i/4;
            int c = i%4;

            if(vis[r][c] == false) return false;
        }

         return true;
    }
}
