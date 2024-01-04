package workbook_0x09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 벽부수고이동하기_2206 {
    static int N,M,ans;
    static int[] dr = {-1,1,0,0} , dc = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        int[][] map = new int[N][M];

        for(int i = 0 ; i < N ; i++){
            String tmp = br.readLine();
            for(int j = 0 ; j < M ; j++){
                map[i][j] = tmp.charAt(j) - '0';
            }
        }
        ans = Integer.MAX_VALUE;
        System.out.println(bfs(map));
    }

    private static int bfs(int[][] map) {
        boolean[][][] visited = new boolean[2][N][M];
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0,0,0,0));
        visited[0][0][0] = true;

        while (!q.isEmpty()){
            Node cur = q.poll();
            if(cur.r == N-1 && cur.c == M-1){
                ans = Math.min(ans,cur.t+1);
                return ans;
            }
            for(int i = 0 ; i < 4; i++){
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];

                if(nr < 0 || nr >= N || nc < 0 || nc >= M || visited[cur.isCrash][nr][nc]) continue;

                if(cur.isCrash == 0){
                    if(map[nr][nc] == 1){
                        q.offer(new Node(nr,nc, cur.t+1, 1));
                        visited[1][nr][nc] = true;
                    }else{
                        q.offer(new Node(nr,nc, cur.t+1, 0));
                        visited[0][nr][nc] = true;
                    }
                }else{
                    if(map[nr][nc] == 1)continue;

                    q.offer(new Node(nr,nc, cur.t+1, 1));
                    visited[1][nr][nc] = true;
                }
            }
        }
        return -1;
    }
    static class Node{
        int r,c,t,isCrash;
        public Node(int r, int c, int t, int isCrash){
            this.r=r;
            this.c=c;
            this.t=t;
            this.isCrash=isCrash;
        }
    }
}
