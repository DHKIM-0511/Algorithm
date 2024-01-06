package workbook_0x0D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 로봇청소기_14503 {
    static int N,M,ans;
    static int[] dr = {-1,0,1,0}, dc = {0,1,0,-1}; // 북동남서
    static int[][] map = new int[51][51];
    static boolean[][] visited = new boolean[51][51];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < M ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        clean(new Robot(r,c,d));
        System.out.println(ans);
    }

    private static void clean(Robot robot) {

        if(map[robot.r][robot.c] == 0 && !visited[robot.r][robot.c]) ans++;
        visited[robot.r][robot.c] = true;
        if(check(robot.r, robot.c)){
            robot.d = (robot.d + 3) % 4;
            int nr =robot.r + dr[robot.d];
            int nc =robot.c + dc[robot.d];
            if(map[nr][nc] == 0 && !visited[nr][nc]){
                robot.r = nr;
                robot.c = nc;
            }
            clean(robot);
        }else{
            if(robot.후진()){
                clean(robot);
            }
        }
    }

    private static boolean check(int r,int c) {
        for(int i = 0 ; i < 4 ; i++){
            int nr = r + dr[i];
            int nc = c + dc[i];

            if(map[nr][nc] == 0 && !visited[nr][nc]) return true;
        }
        return false;
    }

    static class Robot{
        int r,c,d;
        public Robot(int r, int c, int d){
            this.r =r;
            this.c =c;
            this.d =d; // 0 부터 북동남서
        }
        public boolean 후진(){
            int dir = (this.d + 2) % 4;
            int nr = this.r + dr[dir];
            int nc = this.c + dc[dir];

            if(map[nr][nc] == 0){
                this.r = nr;
                this.c = nc;
                return true;
            }
            return false;
        }
    }
}
