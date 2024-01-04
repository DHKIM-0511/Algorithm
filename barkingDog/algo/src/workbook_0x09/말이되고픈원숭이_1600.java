package workbook_0x09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 말이되고픈원숭이_1600 {
    static int K,W,H;
    static int[][]map;
    static boolean[][][]visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H][W];

        for(int i = 0 ; i < H ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < W ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(bfs());

    }

    static int bfs() {
        Queue<Node> q = new LinkedList<>();
        visited = new boolean[K+1][H][W];
        q.offer(new Node(0,0,0,0));
        visited[0][0][0] = true;

        while (!q.isEmpty()){
            Node cur = q.poll();
            if(cur.r == H-1 && cur.c == W-1){
                return cur.t;
            }

            if(cur.h < K){
                moveLikeHorse(cur, q);
            }
            moveLikeMonkey(cur, q);
        }
        return -1;
    }

    private static void moveLikeHorse(Node cur, Queue<Node> q) {
        int[] drH = {-2,-1,1,2,2,1,-1,-2}, dcH = {1,2,2,1,-1,-2,-2,-1};
        for(int i = 0 ; i < 8; i++){
            int nr = cur.r+drH[i];
            int nc = cur.c+dcH[i];

            if(outOfBound(nr,nc) || visited[cur.h][nr][nc] || map[nr][nc] == 1) continue;
            q.offer(new Node(nr,nc, cur.t+1, cur.h+1));
            visited[cur.h+1][nr][nc] =true;
        }
    }

    private static void moveLikeMonkey(Node cur, Queue<Node> q) {
        int[] drM = {-1,1,0,0} , dcM = {0,0,-1,1};
        for(int i = 0 ; i < 4; i++){
            int nr = cur.r+drM[i];
            int nc = cur.c+dcM[i];

            if(outOfBound(nr,nc) || visited[cur.h+1][nr][nc] || map[nr][nc] == 1) continue;
            q.offer(new Node(nr,nc, cur.t+1, cur.h));
            visited[cur.h][nr][nc] =true;
        }
    }

    static boolean outOfBound(int nr, int nc) {
        if(nr < 0 || nr >= H || nc <0 || nc >= W) return true;
        return false;
    }

    static class Node{
        int r,c,t,h;
        public Node(int r,int c,int t,int h){
            this.r=r;
            this.c=c;
            this.t=t;
            this.h=h;
        }
    }
}
