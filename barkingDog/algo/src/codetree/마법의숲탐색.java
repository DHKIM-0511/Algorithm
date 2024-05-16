package codetree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 마법의숲탐색 {
    static int r,c,k,ans;
    static int[][] map;
    static int[] dr = {-1,0,1,0}, dc={0,1,0,-1}; // 상우하좌
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new int[r+1][c+1];

        for(int i = 1 ; i <=  k ; i ++){
            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            startTravel(i,c,d);
        }

        System.out.println(ans);
    }

    private static void startTravel(int num, int col, int d) {
        Node node = new Node(-2,col);

        int lCnt = 0;
        int rCnt = 0;
        while (true){
            int nr = node.r + 1;
            int nc = node.c;

            //남쪽으로 이동 가능하면 이동 하고 컨티뉴
            if(check(nr,nc)){
                node.r = nr;
                continue;
            }

            nr = node.r;
            nc = node.c - 1;
            //좌, 하 로 이동 가능하면 이동하고 컨티뉴
            if(check(nr,nc)){
                nr++;
                if(check(nr,nc)){
                    node.r = nr;
                    node.c = nc;
                    lCnt++;
                    continue;
                }
            }

            //우, 하 로 이동 가능하면 이동하고 컨티뉴
            nr = node.r;
            nc = node.c + 1;
            //좌, 하 로 이동 가능하면 이동하고 컨티뉴
            if(check(nr,nc)){
                nr++;
                if(check(nr,nc)){
                    node.r = nr;
                    node.c = nc;
                    rCnt++;
                    continue;
                }
            }

            //움직이지 않을때 맵 밖이면 맵 초기화하고 리턴, 아니면 break
            if(node.r <= 1){
                map = new int[r+1][c+1];
                return;
            }
            break;
        }
        //출구 계산
        int cnt = rCnt - lCnt;
        if( cnt < 0 ) {
            for(int i = 0 ; i < Math.abs(cnt) ; i++){
                d= d - 1 < 0 ? 3 : d-1;
            }
        }else {
            d += cnt;
            d %= 4;
        }

        //골렘 표시
        map[node.r][node.c] = num;
        for(int i = 0 ; i < 4 ; i++){
            int nr = node.r + dr[i];
            int nc = node.c + dc[i];

            map[nr][nc] = num;
            if(i == d) map[nr][nc] *= -1;
        }
        printMap();
        //점수 계산
        getScore(node);
        System.out.println(ans);

    }


    private static void getScore(Node node) {
        Queue<Node> q = new LinkedList<>();
        boolean[][] vis = new boolean[r+1][c+1];

        q.offer(node);
        vis[node.r][node.c] = true;

        int tmp = 0;
        while (!q.isEmpty()){
            Node cur = q.poll();

            tmp = Math.max(cur.r , tmp);

            for(int i = 0 ; i < 4 ; i++){
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];

                if(OOB(nr,nc) || map[nr][nc] == 0 || vis[nr][nc]) continue;
                if(map[cur.r][cur.c] > 0){
                    //현재 골렘 출구이거나, 현재 골렘내부면 이동 가능
                    if(map[nr][nc] != map[cur.r][cur.c]){
                        if(map[cur.r][cur.c] * -1 != map[nr][nc]) continue;
                    }
                }
                q.offer(new Node(nr,nc));
                vis[nr][nc] = true;
            }

        }
        ans += tmp;
    }
    private static void printMap(){
        for(int i = 1; i <= r ; i++){
            for(int j = 1; j <= c ; j++){
                System.out.print(map[i][j]+"  ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static boolean check(int nr, int nc) {
        for(int i = 0 ; i < 4 ; i++){
            int nextR = nr + dr[i];
            int nextC = nc + dc[i];

            if(nextR < 1) continue;
            if(OOB(nextR, nextC) || map[nextR][nextC] != 0) return false;
        }
        return true;
    }

    static boolean OOB(int r1, int c1){
        return r1 < 1 || r1 > r || c1 < 1 || c1 > c;
    }
    static class Node{
        int r,c;
        Node(int r,int c){
            this.r=r;
            this.c=c;
        }
    }
}
