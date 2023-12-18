package solutions_0x09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 토마토_7576 {
    static int N,M,ans;
    static int[] dr ={-1,1,0,0}, dc = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        boolean[][] visited = new boolean[N][M];
        Queue<Node> q = new LinkedList<>();

        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < M ; j++){
                int t = Integer.parseInt(st.nextToken());
                map[i][j] = t;
                if(t == 1){
                    q.offer(new Node(i,j,0));
                    visited[i][j] = true;
                }
            }
        }

        bfs(map,visited, q);
        ans = check(visited, map) ? ans : -1;
        System.out.println(ans);
    }
    static void bfs(int[][] map, boolean[][] visited, Queue<Node> q){
        while (!q.isEmpty()){
            Node cur = q.poll();
            ans = Math.max(cur.t, ans);
            for(int i = 0 ; i < 4 ; i++){
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];

                if(nr >=0 && nr < N && nc >= 0 && nc < M && !visited[nr][nc]){
                    if(map[nr][nc] == 0){
                        q.offer(new Node(nr,nc,cur.t+1));
                        visited[nr][nc] = true;
                    }
                }
            }
        }
    }
    static boolean check(boolean[][] visited, int[][] map){
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < M ; j++){
                if(!visited[i][j] && map[i][j] == 0) return false;
            }
        }
        return true;
    }
    static class Node{
        int r,c,t;
        public Node(int r, int c, int t){
            this.r = r;
            this.c = c;
            this.t = t;
        }
    }
}
