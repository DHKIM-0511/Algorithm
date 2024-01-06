package workbook_0x0D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Maaaaaaaaaze_16985 {
    static int[][][] maze = new int[5][5][5]; //1 = 빈칸, 0 = 벽
    static int[][][] copyMaze = new int[5][5][5];
    static int[] dr = {-1,1,0,0,0,0}, dc = {0,0,-1,1,0,0}, dd = {0,0,0,0,-1,1};
    static boolean[] isUsed = new boolean[5];
    static int[] order = new int[5];
    static int[] rot = new int[5];
    static int ans = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0 ; i < 5 ; i++){
            for(int j = 0 ; j < 5 ; j++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int k = 0 ; k < 5 ; k++){
                    maze[i][j][k] = Integer.parseInt(st.nextToken());
                }
            }
        }
        setOrder(0);
        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }
    //미로 조합 순서 정하기
    private static void setOrder(int cnt) {
        if(cnt == 5){
            buildMaze(0);
            return;
        }
        for(int i = 0 ; i < 5; i++){
            if(isUsed[i]) continue;
            isUsed[i] = true;
            order[cnt] = i;
            setOrder(cnt+1);
            isUsed[i] = false;
        }
    }
    //돌리는 순서 정하기
    private static void buildMaze(int cnt) {
        if(cnt == 5){
            for(int i = 0 ; i < 5 ; i++){
                rotate(i);
            }
            if(copyMaze[0][0][0] == 1 && copyMaze[4][4][4] == 1) bfs();
            return;
        }

        for(int i = 0 ; i < 4 ; i++){
            rot[cnt] = i;
            buildMaze(cnt +1);
        }
    }
    //돌리기
    private static void rotate(int idx){
        int dir = rot[idx];
        int orderIdx = order[idx];
        if(dir == 0){
            for(int i = 0 ; i < 5 ; i++){
                for(int j = 0 ; j < 5 ; j++){
                    copyMaze[idx][i][j] = maze[orderIdx][i][j];
                }
            }
        }else if( dir == 1 ){
            //90도
            for(int i = 0 ; i < 5 ; i++){
                for(int j = 0 ; j < 5 ; j++){
                    copyMaze[idx][i][j] = maze[orderIdx][4-j][i];
                }
            }
        }else if(dir == 2){
            //180도
            for(int i = 0 ; i < 5 ; i++){
                for(int j = 0 ; j < 5 ; j++){
                    copyMaze[idx][i][j] = maze[orderIdx][4-i][4-j];
                }
            }
        }else{
            //270도
            for(int i = 0 ; i < 5 ; i++){
                for(int j = 0 ; j < 5 ; j++){
                    copyMaze[idx][i][j] = maze[orderIdx][j][4-i];
                }
            }
        }
    }
    private static void bfs() {
        Queue<Node> q = new LinkedList<>();
        boolean[][][] visited = new boolean[5][5][5];

        q.offer(new Node(0,0,0,0));
        visited[0][0][0] = true;

        while (!q.isEmpty()){
            Node cur = q.poll();
            if(cur.d ==4 && cur.r == 4 && cur.c == 4){
                ans = Math.min(ans, cur.t);
                return;
            }

            if(cur.t >= ans)return;

            for(int i = 0 ; i < 6 ; i++){
                int nd = cur.d + dd[i];
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];

                if(nd < 0 || nd>= 5 || nr<0 || nr >=5 || nc < 0 || nc >=5)continue;
                if(copyMaze[nd][nr][nc] == 0 || visited[nd][nr][nc]) continue;

                q.offer(new Node(nd,nr,nc,cur.t+1));
                visited[nd][nr][nc] = true;
            }
        }
    }
    static class Node{
        int d,r,c,t;
        public Node(int d, int r, int c, int t){
            this.d = d;
            this.r = r;
            this.c = c;
            this.t = t;
        }
    }
}
