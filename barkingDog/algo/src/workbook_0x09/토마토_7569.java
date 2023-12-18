package workbook_0x09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 토마토_7569 {
    static int N,M,K,ans;
    static int[] dr = {-1,1,0,0,0,0} , dc = {0,0,-1,1,0,0}, dh ={0,0,0,0,1,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int[][][] map = new int[K][N][M];
        Queue<int[]> q= new LinkedList<>();
//        boolean[][][] visited = new boolean[K][N][M];

        for(int i = 0 ; i < K ; i++){
            for(int j = 0 ; j < N ; j++){
                st = new StringTokenizer(br.readLine());
                for(int k = 0 ; k < M ; k++){
                    map[i][j][k] = Integer.parseInt(st.nextToken());
                    if(map[i][j][k] == 1){
                        q.offer(new int[]{i,j,k}); //{h,r,c}
                    }
                }
            }
        }

        bfs(map,q);
        if(check(map)){
            System.out.println(ans-1);
        }else{
            System.out.println(-1);
        }
    }

    private static boolean check(int[][][] map) {
        for(int i = 0 ; i < K ; i++){
            for(int j = 0 ; j < N ; j++){
                for(int k = 0 ; k < M ; k++){
                    if(map[i][j][k] == 0) return false;
                }
            }
        }
        return true;
    }

    static void bfs(int[][][] map, Queue<int[]> q) {

        while (!q.isEmpty()){
            int[] cur = q.poll();
            ans = Math.max(ans, map[cur[0]][cur[1]][cur[2]]);
            for(int i = 0 ; i < 6 ; i++){
                int nh = cur[0] + dh[i];
                int nr = cur[1] + dr[i];
                int nc = cur[2] + dc[i];

                if(nh < 0 || nh >= K || nr <0 || nr >= N || nc < 0 || nc >= M) continue;
                if(map[nh][nr][nc] ==0){
                    q.offer(new int[]{nh,nr,nc});
                    map[nh][nr][nc] = map[cur[0]][cur[1]][cur[2]] + 1;
                }
            }
        }
    }
}
