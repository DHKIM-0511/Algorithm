package solutions_0x09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 그림_1926 {
    static int[] dr = {-1,1,0,0}, dc = {0,0,-1,1};
    static int N,M,cnt,ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        boolean[][] visited= new boolean[N][M];

        for(int i = 0 ; i < N ; i++){
             st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < M ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < M ; j++){
                if(!visited[i][j] && map[i][j] == 1){
                    bfs(map, visited, new int[]{i, j});
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
        System.out.println(ans);
    }
    static void bfs(int[][] map, boolean[][] visited, int[] startIdx){
        Queue<int[]> q = new LinkedList<>();
        q.add(startIdx);
        visited[startIdx[0]][startIdx[1]] = true;

        int sum = 1;
        while (!q.isEmpty()){
            int[] cur = q.poll();

            for(int i = 0 ; i < 4 ; i++){
                int nr = cur[0] + dr[i];
                int nc = cur[1] + dc[i];

                if(nr >=0 && nr < N && nc >=0 && nc <M && !visited[nr][nc]){
                    if(map[nr][nc] == 1){
                        q.offer(new int[]{nr,nc});
                        visited[nr][nc] = true;
                        sum++;
                    }
                }
            }
        }
        ans = Math.max(ans, sum);
    }
}
