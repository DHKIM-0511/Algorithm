package workbook_0x10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 연구소_14502 {
    static int n,m,ans;
    static int[][] map,copyMap;
    static List<int[]> virus = new ArrayList<>();
    static int[] dr = {-1,1,0,0} , dc ={0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        copyMap = new int[n][m];
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < m ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2) virus.add(new int[] {i,j});
            }
        }

        build(0,0, new int[3]);
        System.out.println(ans);
    }

    private static void build(int cnt, int last, int[] sel) {
        if(cnt == 3){
            if(check(sel)){
               ans = Math.max(ans, bfs(sel));
            }
            return;
        }
        for(int i = last ; i < n*m ; i++){
            sel[cnt] = i;
            build(cnt+1, i+1, sel);
        }
    }

    private static int bfs(int[] sel) {
        copyMap();
        for(int i : sel){
            int r = i / m;
            int c = i % m;

            copyMap[r][c] = 1;
        }

        Queue<int[]> q = new LinkedList<>();
        boolean[][] vis = new boolean[n][m];

        for(int[] v : virus){
            q.offer(v);
            vis[v[0]][v[1]] = true;
        }

        while (!q.isEmpty()){
            int[] cur = q.poll();

            copyMap[cur[0]][cur[1]] = 2;
            for(int i = 0 ; i <4 ; i++){
                int nr = cur[0] + dr[i];
                int nc = cur[1] + dc[i];

                if(nr <0 || nr >= n || nc < 0 ||nc >=m || vis[nr][nc]) continue;
                if(copyMap[nr][nc] == 0){
                    q.offer(new int[]{nr,nc});
                    vis[nr][nc] = true;
                }
            }
        }

        int cnt = 0;
        for(int[] i : copyMap){
            for(int j: i){
                if( j == 0) cnt++;
            }
        }
        return cnt;
    }

    private static boolean check(int[] sel) {
        for(int i: sel){
            int r = i / m;
            int c = i % m;

            if(map[r][c] != 0) return false;
        }
        return true;
    }
    private static void copyMap(){
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ;j++){
                copyMap[i][j] = map[i][j];
            }
        }
    }
}
