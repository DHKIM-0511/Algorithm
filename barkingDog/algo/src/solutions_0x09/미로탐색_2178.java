package solutions_0x09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 미로탐색_2178 {
    static int[] dr = {-1,1,0,0}, dc= {0,0,-1,1};
    static int N,M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().split(" ");
        N = Integer.parseInt(NM[0]);
        M = Integer.parseInt(NM[1]);
        int[][] map = new int[N][M];
        boolean[][] visited = new boolean[N][M];

        for(int i = 0 ; i < N ; i++){
            String input = br.readLine();
            for(int j = 0 ; j < M ; j++){

                map[i][j] = Integer.valueOf(input.charAt(j)-'0');
            }
        }
        System.out.println(bfs(map, visited, new Node(0,0,1)));
    }
    static int bfs(int[][] map, boolean[][] visited, Node startNode){
        Queue<Node> q = new LinkedList<>();
        q.offer(startNode);
        visited[startNode.r][startNode.c] = true;

        while (!q.isEmpty()){
            Node cur = q.poll();

            if(cur.r == N-1 && cur.c == M-1){
                return cur.t;
            }
            for(int i = 0 ; i < 4 ; i++){
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];

                if(nr >= 0 && nr < N && nc >=0 && nc < M && !visited[nr][nc]){
                    if(map[nr][nc] == 1){
                        q.offer(new Node(nr,nc,cur.t+1));
                        visited[nr][nc] = true;
                    }
                }
            }
        }
        return -1;
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
