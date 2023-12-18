package workbook_0x09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 유기농배추_1012 {
    static int[] dr ={-1,1,0,0} , dc ={0,0,-1,1};
    static int N,M,ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for(int tc = 0 ; tc < T ; tc++){
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[][] map = new int[N][M];
            boolean[][] visited = new boolean[N][M];

            for(int i = 0 ; i < K ; i++){
                st = new StringTokenizer(br.readLine());
                int C = Integer.parseInt(st.nextToken());
                int R = Integer.parseInt(st.nextToken());

                map[R][C] = 1;
            }

            for(int i = 0 ; i < N ; i++){
                for(int j = 0 ; j < M ; j++){
                    if(map[i][j]==1 && !visited[i][j]){
                        bfs(map,visited, new int[] {i,j});
                        ans++;
                    }
                }
            }
            System.out.println(ans);
            ans =0;
        }
    }
    static void bfs(int[][] map, boolean[][] visited, int[] startIdx){
        Queue<int[]> q = new LinkedList<>();
        q.offer(startIdx);
        visited[startIdx[0]][startIdx[1]] = true;

        while (!q.isEmpty()){
            int[] cur = q.poll();

            for(int i = 0 ; i < 4 ; i++){
                int nr = cur[0] + dr[i];
                int nc = cur[1] + dc[i];

                if(nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc]) continue;
                if(map[nr][nc] == 0) continue;

                q.offer(new int[]{nr,nc});
                visited[nr][nc] = true;
            }
        }
    }
}
