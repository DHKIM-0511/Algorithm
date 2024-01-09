package workbook_0x0D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 연구소_14502 {//벽은 3개를 세워야함
    static int N,M,ans;
    static int[] dr = {-1,1,0,0} , dc ={0,0,-1,1};
    static int[][] map;
    static int[][] copyMap;
    static List <int[]> virus = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        copyMap = new int[N][M];

        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < M ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2) virus.add(new int[] {i,j});
            }
        }
        buildWall(0,0, new int[3]);
        System.out.println(ans);
    }

    private static void buildWall(int cnt, int last, int[] sel) {
        if(cnt == 3){
            copyMap();
            for(int i : sel){
                int r = i/M;
                int c = i%M;
                if(copyMap[r][c] != 0) return;
                copyMap[r][c] = 1;
            }
            bfs();
            return;
        }
        for(int i = last ; i < N*M ; i++){
            sel[cnt] = i;
            buildWall(cnt +1, i +1, sel);
        }
    }

    private static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];

        for(int[] v : virus){
            q.offer(v);
            visited[v[0]][v[1]] = true;
        }

        while (!q.isEmpty()){
            int[] cur = q.poll();

            for(int i = 0 ; i < 4; i++){
                int nr = cur[0] + dr[i];
                int nc = cur[1] + dc[i];
                if(nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc]) continue;
                if(copyMap[nr][nc] != 0 )continue;

                q.offer(new int[]{nr,nc});
                visited[nr][nc] = true;
                copyMap[nr][nc] = 2;
            }
        }
        ans = Math.max(ans,getZeroCnt());
    }

    private static int getZeroCnt() {
        int sum = 0;
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < M ; j++){
                if(copyMap[i][j] == 0)sum++;
            }
        }
        return sum;
    }

    private static void copyMap() {
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < M ; j++){
                copyMap[i][j] = map[i][j];
            }
        }
    }
}
