package workbook_0x09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 다리만들기_2146 {
    static int N;
    static int[] dr = {-1,1,0,0} , dc = {0,0,-1,1};
    static int[][] map;
    static boolean[][] visited;
    static Queue<Node> q;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        q = new LinkedList<>();

        for(int i = 0 ; i < N ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < N ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //섬 번호 등록
        int island = 1;
        for(int i = 0 ; i < N ; i++) {
            for (int j = 0; j < N; j++) {
                if(!visited[i][j] && map[i][j] != 0){
                    changeMap(new Node(i,j), island++);
                }
            }
        }

        int ans = Integer.MAX_VALUE;
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < N ; j++){
                if(map[i][j] > 0){
                    visited = new boolean[N][N];
                    int res = getMinBridgeLength(new Node(i,j));

                    if( res == -1 ) continue;
                    ans = Math.min(ans, res);
                }
            }
        }
        System.out.println(ans);
    }

    static int getMinBridgeLength(Node startNode) {
        q = new LinkedList<>();

        q.offer(startNode);
        visited[startNode.r][startNode.c] = true;
        int island = map[startNode.r][startNode.c];

        while (!q.isEmpty()){
            Node cur = q.poll();

            if(map[cur.r][cur.c] != 0 && map[cur.r][cur.c] != island){
                return cur.l;
            }
            for(int i = 0 ; i < 4 ; i++){
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];

                if(nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc]) continue;
                if(map[nr][nc] == island) continue;

                if(map[nr][nc] == 0) {
                    q.offer(new Node(nr,nc,cur.l +1));
                    visited[nr][nc] = true;
                }else{
                    q.offer(new Node(nr,nc,cur.l));
                    visited[nr][nc] = true;
                }
            }
        }
        return -1;
    }

    static void changeMap(Node startNode, int island) {
        q.offer(startNode);
        visited[startNode.r][startNode.c] = true;

        while (!q.isEmpty()){
            Node cur = q.poll();
            map[cur.r][cur.c] = island;

            for(int k = 0 ; k < 4; k++){
                int nr = cur.r + dr[k];
                int nc = cur.c + dc[k];

                if( nr < 0 || nr >= N || nc <0 || nc >= N|| visited[nr][nc]) continue;
                if(map[nr][nc] == 1){
                    q.offer(new Node(nr,nc));
                    visited[nr][nc] = true;
                }
            }
        }
    }

    static class Node{
        int r,c,l;
        public Node(int r, int c, int l){
            this.r = r;
            this.c = c;
            this.l = l;
        }
        public Node(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
}
