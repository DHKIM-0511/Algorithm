package solutions_0x0D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 감시_15683 {
    static int N,M,ans;
    static int[][] map, copyMap;
    static int[] dr = {1,0,-1,0}, dc ={0,1,0,-1};
    static List<Cctv> cctvList = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M]; copyMap = new int[N][M];

        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < M ; j++){
                int tmp = Integer.parseInt(st.nextToken());
                map[i][j] = tmp;
                copyMap[i][j] = 81;
                if(tmp == 6 ) continue;
                if(tmp == 0 ) ans++;
                cctvList.add(new Cctv(i,j,tmp));
            }
        }
        backtracking(0);
        System.out.println(ans);
    }

    private static void backtracking(int cnt) {
        if(cnt == cctvList.size()){
            ans = Math.min(getZeroCnt(), ans);
            return;
        }

        Cctv cur = cctvList.get(cnt);
        if(cur.k == 1){
            for(int dir = 0 ; dir < 4 ; dir++){
                move(cur.r, cur.c, dir, true);
                backtracking(cnt+1);
                move(cur.r, cur.c, dir, false);
            }
        }else if(cur.k == 2){
            for(int dir = 0 ; dir < 2 ; dir++){
                move(cur.r,cur.c,dir,true);
                move(cur.r,cur.c,dir+2,true);
                backtracking(cnt+1);
                move(cur.r,cur.c,dir,false);
                move(cur.r,cur.c,dir+2,false);
            }
        }else if(cur.k == 3){
            for(int dir=0;dir<4;dir++){
                int newDir = dir+1;
                if(newDir==4) newDir = 0;
                move(cur.r,cur.c,dir,true);
                move(cur.r,cur.c,newDir,true);
                backtracking(cnt+1);
                move(cur.r,cur.c,dir,false);
                move(cur.r,cur.c,newDir,false);
            }
        }else if(cur.k == 4){
            move(cur.r,cur.c,0,true);
            move(cur.r,cur.c,1,true);
            move(cur.r,cur.c,2,true);
            move(cur.r,cur.c,3,true);
            for(int dir=0;dir<4;dir++){
                move(cur.r,cur.c,dir,false);
                backtracking(cnt+1);
                move(cur.r,cur.c,dir,true);
            }
            move(cur.r,cur.c,0,false);
            move(cur.r,cur.c,1,false);
            move(cur.r,cur.c,2,false);
            move(cur.r,cur.c,3,false);
        }else {
            move(cur.r,cur.c,0,true);
            move(cur.r,cur.c,1,true);
            move(cur.r,cur.c,2,true);
            move(cur.r,cur.c,3,true);
            backtracking(cnt+1);
            move(cur.r,cur.c,0,false);
            move(cur.r,cur.c,1,false);
            move(cur.r,cur.c,2,false);
            move(cur.r,cur.c,3,false);
        }
    }

    private static void move(int r, int c, int dir, boolean b) {
        int nr = r;
        int nc = c;
        while (true){
            nr += dr[dir];
            nc += dc[dir];

            if(nr < 0 || nr >= N || nc < 0 || nc >= M || map[nr][nc] == 6) return;
            if(map[nr][nc] != 0) continue;

            if(b) copyMap[nr][nc]++;
            else {
                if(copyMap[nr][nc] > 0) copyMap[nr][nc]--;
            }
        }
    }

    private static int getZeroCnt() {
        int cnt = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(copyMap[i][j]==0) cnt++;
            }
        }
        return cnt;
    }
    static class Cctv{
        int r,c,k;
        public Cctv(int r, int c,int k){
            this.r = r;
            this.c = c;
            this.k = k;
        }
    }
}
