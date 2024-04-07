package workbook;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 낚시왕_17143 {
    static int r,c,m,ans;
    static Shark[] sharks;
    static boolean[] isDead;
    static int kingIdx = 0;
    static int[][] map;
    static int[] dr = {0,-1,1,0,0}, dc={0,0,0,1,-1}; // 1부터 상 하 우 좌
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[r+1][c+1];
        sharks = new Shark[m+1];
        isDead = new boolean[m+1];

        for(int i = 1 ; i <= m ; i++){
            st = new StringTokenizer(br.readLine());
            int sr = Integer.parseInt(st.nextToken());
            int sc = Integer.parseInt(st.nextToken());
            int speed = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());
            int size = Integer.parseInt(st.nextToken());

            sharks[i] = new Shark(sr,sc,speed,dir,size);
            map[sr][sc] = i;
        }


        while (true){
            //우측 한칸 이동
            kingIdx++;
            if(kingIdx == c+1){
                break;
            }
            //같은 열의 상어중에서 행이 가장 작은 상어 수확, 상어 map에서 삭제
            for(int i = 1 ; i <= r ; i++){
                if(map[i][kingIdx] > 0){
                    Shark s = sharks[map[i][kingIdx]];
                    ans += s.size;
                    isDead[map[i][kingIdx]] = true;
                    map[i][kingIdx] = 0;
                    break;
                }
            }
            //상어 이동
            for(int i = 1; i<= m ; i++){
                if(isDead[i]) continue;

                Shark s = sharks[i];
                int speed = s.speed;
                if(s.dir <= 2){
                    speed %= (2*(r-1));
                } else  {
                    speed %= (2*(c-1));
                }

                for(int j = 0 ; j < speed ; j++){
                    int nr = s.r + dr[s.dir];
                    int nc = s.c + dc[s.dir];

                    if(OOB(nr, nc)){ // 0 상 하 우 좌
                        if(s.dir % 2 == 0)s.dir --;
                        else s.dir++;

                        nr = s.r + dr[s.dir];
                        nc = s.c + dc[s.dir];
                    }
                    s.r = nr;
                    s.c = nc;
                }
            }

            int[][] newMap = new int[r+1][c+1];
            for(int i = 1; i<= m ; i++){
                if(isDead[i]) continue;

                Shark s = sharks[i];
                if(newMap[s.r][s.c] == 0){
                    newMap[s.r][s.c] = i;
                }else {
                    int cur = newMap[s.r][s.c];
                    Shark curShark = sharks[cur];
                    if( curShark.size > s.size){
                        isDead[i] = true;
                    }else {
                        newMap[s.r][s.c] = i;
                        isDead[cur] = true;
                    }
                }
            }

            for(int i = 1; i <= r ; i++){
                for(int j = 1; j <= c ; j++){
                    map[i][j] = newMap[i][j];
                }
            }

        }
        System.out.println(ans);
    }


    static boolean OOB(int r1,int c1){
        return r1 < 1 || r1 > r || c1 < 1 || c1 > c;
    }
    static class Shark{
        int r,c,speed,dir,size;
        Shark(int r,int c,int speed, int dir, int size){
            this.r=r;
            this.c=c;
            this.speed=speed;
            this.dir=dir;
            this.size=size;
        }
    }
}
