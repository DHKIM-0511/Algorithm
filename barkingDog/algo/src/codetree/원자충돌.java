package codetree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 원자충돌 {
    static int n,m,k;
    static LinkedList<Atomic>[][] map;
    static int[] dr={-1,-1,0,1,1,1,0,-1} , dc={0,1,1,1,0,-1,-1,-1}; // 0246 상하좌우 or 1357
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new LinkedList[n+1][n+1];

        for(int i = 1 ; i <= n ; i++){
            for(int j = 1 ; j <= n ; j++){
                map[i][j] = new LinkedList<>();
            }
        }

        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            map[r][c].add(new Atomic(m,s,d));
        }
        // init 끝

        // k 초간 실험
        while (k-- > 0 ){
            //1. 1초마다 모든 원자는 고유 속도와 방향으로 이동
            move();

            //2. 충돌
            crash();
        }
        printAns();
    }

    private static void printAns() {
        int ans = 0;
        for(int i =1 ; i<= n ; i++){
            for(int j = 1 ; j <= n ; j++){
                if(map[i][j].isEmpty()) continue;

                for(Atomic a : map[i][j]){
                    ans += a.m;
                }
            }
        }
        System.out.println(ans);
    }

    private static void crash() {
        for(int i =1 ; i<= n ; i++){
            for(int j = 1; j<= n ;j++){
                if(map[i][j].size() < 2) continue;

                int cnt = map[i][j].size();
                int sumM = 0;
                int sumS = 0;
                boolean flag = false; // 모두 상하 좌우 이거나 대각선인지
                for(Atomic a : map[i][j]){
                    sumS += a.s;
                    sumM += a.m;
                    if(!flag && (map[i][j].get(0).dir % 2) != (a.dir % 2)){
                        flag = true; // 하나라도 다르다
                    }
                }

                map[i][j].clear();
                int k = flag ? 1 : 0;
                int newM = sumM/5;
                int newS = sumS/cnt;

                if(newM <= 0) continue;
                for(; k < 8 ; k+=2){
                    map[i][j].add(new Atomic(newM, newS, k));
                }
            }
        }


    }

    private static void move() {
        LinkedList<Atomic>[][] newMap = new LinkedList[n+1][n+1];

        for(int i = 1 ; i <= n ; i++){
            for(int j = 1 ; j <= n ; j++){
                newMap[i][j] = new LinkedList<>();
            }
        }

        for(int i = 1 ; i <= n ; i++){
            for(int j = 1; j <= n ; j++){
                if(map[i][j].isEmpty()) continue;

                for(Atomic a : map[i][j]){
                    int speed  = a.s % n;
                    int nr = i;
                    int nc = j;
                    for(int k = 0 ; k < speed ; k++){
                         nr += dr[a.dir];
                         nc += dc[a.dir];

                         if(OOB(nr,nc)){
                             if(nr < 1) nr = n;
                             else if(nr > n) nr = 1;

                             if(nc < 1) nc = n;
                             else if(nc > n) nc = 1;
                         }
                    }
                    newMap[nr][nc].add(a);
                }
            }
        }

        for(int i = 1 ; i <= n ; i++){
            for(int j = 1; j <= n ; j++){
                map[i][j] = newMap[i][j];
            }
        }

    }

    static boolean OOB(int r,int c){
        return r < 1 || r > n || c < 1 || c > n;
    }
    static class Atomic{
        int m,s,dir;
        Atomic(int m,int s,int dir){
            this.m=m;
            this.s=s;
            this.dir=dir;
        }
    }
}
