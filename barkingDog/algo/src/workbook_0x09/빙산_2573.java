package workbook_0x09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 빙산_2573 {
    static int N,M,ans;
    static int[] dr ={-1,1,0,0}, dc ={0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];

        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < M ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int year = 0;
        while (true){
            //시간을 1년씩 보냄
            afterOneYear(map);
            year++;

            //갯수를세고 탈출 조건 확인.
            int cnt = checkCnt(map);
            if( cnt >= 2 || cnt ==0){
                if(cnt >= 2) ans = year;
                break;
            }
        }
        System.out.println(ans);
    }
    static int checkCnt(int[][] map) {
        int cnt = 0;
        boolean[][] check = new boolean[N][M];

        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < M ; j++){
                if(map[i][j] > 0 && !check[i][j]){
                    cnt++;
                    bfs(map, check, new Node(i,j));
                }
            }
        }
        return cnt;
    }

    static void bfs(int[][] map, boolean[][] check, Node startNode) {
        Queue<Node> q = new LinkedList<>();
        q.offer(startNode);
        check[startNode.r][startNode.c]= true;

        while (!q.isEmpty()){
            Node cur = q.poll();

            for(int i = 0 ; i < 4; i++){
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];

                if(nr < 0 || nr >= N || nc < 0 || nc >= M || check[nr][nc]) continue;
                if(map[nr][nc] > 0){
                    q.offer(new Node(nr,nc));
                    check[nr][nc] = true;
                }
            }
        }
    }

    static void afterOneYear(int[][] map) {
        boolean[][] ice = new boolean[N][M];
        Queue<Node> q = new LinkedList<>();
        addNodes(map, q, ice);

        while (!q.isEmpty()){
            Node cur = q.poll();

            int cnt = 0;
            for(int i = 0 ; i < 4 ; i++){
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];
                //바다 수 셈
                if(nr < 0 || nr >= N || nc < 0 || nc >= M || ice[nr][nc]) continue;
                cnt++;
            }
            map[cur.r][cur.c] -= cnt;
        }
    }

    static void addNodes(int[][] map, Queue<Node> q, boolean[][] ice) {
        //전체 빙하 추가
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < M ; j++){
                if(map[i][j] > 0){
                    q.offer(new Node(i,j));
                    ice[i][j] = true;
                }
            }
        }
    }

    static class Node{
        int r,c;
        public Node(int r, int c){
            this.r =r;
            this.c =c;
        }
    }

}
