package solutions_0x0D;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 감시_15683_practice {
    static int N,M;
    static int[][] map = new int[10][10], copyMap = new int[10][10];
    static int[] dr = {1, 0, -1, 0}, dc ={0,1,0,-1};
    static List<Cctv> cctvList = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int ans = 0;
        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < M ; j++){
                int tmp = Integer.parseInt(st.nextToken());
                map[i][j] = tmp;

                if(tmp == 6) continue;
                else if(tmp == 0) ans++;
                else cctvList.add(new Cctv(i,j));
            }
        }
        //각 4가지 방향으로 분할
        int total = 1;
        for(int i = 0 ; i < cctvList.size() ; i++){
            total *= 4;
        }

        for(int i = 0 ; i < total ; i ++){
            copyMap();

            int tmp = i;
            for(int j = 0 ; j < cctvList.size() ; j++){
                int dir = tmp %4;
                tmp /= 4;

                int r = cctvList.get(j).r;
                int c = cctvList.get(j).c;

                if(map[r][c] == 1){
                    upd(r,c,dir);
                } else if (map[r][c] == 2) {
                    upd(r,c,dir);
                    upd(r,c,dir+2);
                } else if (map[r][c] == 3) {
                    upd(r,c,dir);
                    upd(r,c,dir+1);
                }else if(map[r][c] == 4){
                    upd(r,c,dir);
                    upd(r,c,dir+1);
                    upd(r,c,dir+2);
                }else{
                    upd(r,c,dir);
                    upd(r,c,dir+1);
                    upd(r,c,dir+2);
                    upd(r,c,dir+3);
                }
            }
            ans = Math.min(ans, getCnt());
        }
        System.out.println(ans);
    }

    private static int getCnt() {
        int cnt = 0;

        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < M ; j++){
                if(copyMap[i][j] ==0)cnt++;
            }
        }
        return cnt;
    }

    private static void upd(int r, int c, int dir) {
         dir %=4;

         while (true){
            r += dr[dir];
            c += dc[dir];

            if(r < 0 ||r >= N || c < 0 || c >= M || copyMap[r][c] == 6) return;
            if(copyMap[r][c] != 0) continue;
            copyMap[r][c] = 7;
         }
    }

    private static void copyMap() {
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < M ; j++){
                copyMap[i][j] = map[i][j];
            }
        }
    }

    static class Cctv{
        int r,c;
        public Cctv(int r, int c){
            this.r =r;
            this.c =c;
        }
    }
}
