package workbook_0x09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 적록색약_10026 {
    static int[] dr = {-1,1,0,0}, dc={0,0,-1,1};
    static int N, ans1, ans2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        char[][] map = new char[N][N];
        boolean[][][] visited = new boolean[2][N][N];

        for(int i = 0 ; i < N ; i++){
            map[i] = br.readLine().toCharArray();
        }

        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < N ; j++){
                if(!visited[0][i][j]){
                    bfs(map,visited,new int[]{i,j}, true);
                    ans1++;
                }
                if(!visited[1][i][j]){
                    bfs(map,visited,new int[]{i,j}, false);
                    ans2++;
                }
            }
        }
        System.out.println(ans1+" "+ans2);
    }
    static void bfs(char[][] map, boolean[][][] visited, int[] startIdx, boolean isNormal){
        Queue<int[]> q = new LinkedList<>();
        q.offer(startIdx);
        if(isNormal){
            visited[0][startIdx[0]][startIdx[1]] = true;
        }else{
            visited[1][startIdx[0]][startIdx[1]] = false;
        }

        while (!q.isEmpty()){
            int[] cur = q.poll();

            for(int i = 0 ; i < 4 ; i++){
                int nr = cur[0]+dr[i];
                int nc = cur[1]+dc[i];

                if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;

                if(isNormal){
                    if(visited[0][nr][nc] || map[nr][nc] != map[cur[0]][cur[1]]) continue;
                    q.offer(new int[]{nr,nc});
                    visited[0][nr][nc] = true;
                }else{
                    if(visited[1][nr][nc]) continue;

                    if(map[cur[0]][cur[1]] == 'R' || map[cur[0]][cur[1]] == 'G'){
                        if(map[nr][nc] != 'B'){
                            q.offer(new int[]{nr,nc});
                            visited[1][nr][nc] = true;
                        }
                    }else{
                        if(map[nr][nc] == map[cur[0]][cur[1]]){
                            q.offer(new int[]{nr,nc});
                            visited[1][nr][nc] = true;
                        }
                    }
                }
            }
        }
    }
}
