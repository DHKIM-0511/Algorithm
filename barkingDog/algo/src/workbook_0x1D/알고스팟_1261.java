package workbook_0x1D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class 알고스팟_1261 {
    static final int INF = 0x3f3f3f3f;
    static int n,m;
    static int[] dc = {0,0,-1,1}, dr={-1,1,0,0};
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        m = Integer.parseInt(input[0]);
        n = Integer.parseInt(input[1]);
        map = new int[n+1][m+1];

        for(int i = 1 ; i <= n ; i++){
            String in = br.readLine();
            for(int j =1 ; j <= m ; j++){
                map[i][j] = in.charAt(j-1)-'0';
            }
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2) -> o1.w-o2.w);
        pq.offer(new Node(1,1,0));

        int[][] dist =new int[n+1][m+1];
        for(int i = 1; i<= n ; i++) Arrays.fill(dist[i], INF);
        dist[1][1] = 0;

        boolean[][] visited = new boolean[n+1][m+1];
        while (!pq.isEmpty()){
            Node cur = pq.poll();

            if(cur.w > dist[cur.r][cur.c]) continue;
            if(visited[cur.r][cur.c]) continue;
            visited[cur.r][cur.c] = true;
            for(int i = 0 ; i < 4; i++){
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];

                if(nr < 1 || nr > n || nc < 1 || nc >m) continue;
                if(dist[cur.r][cur.c] + map[nr][nc] <= dist[nr][nc]){
                    dist[nr][nc] =  dist[cur.r][cur.c] + map[nr][nc];
                    pq.offer(new Node(nr,nc,dist[nr][nc]));
                }
            }
        }
        System.out.println(dist[n][m]);
    }
    static class Node{
        int r,c,w;
        Node(int r,int c,int w){
            this.r =r;
            this.c =c;
            this.w =w;
        }
    }
}
