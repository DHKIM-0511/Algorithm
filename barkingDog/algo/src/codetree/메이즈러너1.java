package codetree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class 메이즈러너1 {
    static int n,m,k,tot;
    static int [][] map;
    static int[] dr={-1,1,0,0} , dc={0,0,-1,1};
    static int[][] people;
    static boolean[] isOut;
    static int[] exit = new int[2];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new int[n+1][n+1];
        people= new int[m+1][2];
        isOut = new boolean[m+1];

        for(int i = 1 ; i <=n ; i++){
            st= new StringTokenizer(br.readLine());
            for(int j = 1 ; j <=n ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 1 ; i <= m ; i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            people[i][0] = r;
            people[i][1] = c;
        }

        st = new StringTokenizer(br.readLine());
        exit[0] = Integer.parseInt(st.nextToken());
        exit[1] = Integer.parseInt(st.nextToken());

        while (k-- >0){
            //이동
            peopleMove();
            if(isFinish()) break;

            //미로 회전
            rotateMap();
        }
        System.out.println(tot+"\n"+exit[0]+" "+exit[1]);
    }

//    private static void printMap() {
//        for(int i = 1; i<= n ; i++){
//            for(int j = 1; j<= n ; j++){
//                System.out.print(map[i][j]+" ");
//            }
//            System.out.println();
//        }
//        System.out.println();
//    }
//    static void printPIdx(){
//        for(int i = 0 ; i< m ; i++){
//            System.out.println(Arrays.toString(people[i]));
//        }
//    }

    private static boolean isFinish() {
        for(int i = 1 ; i< m+1 ; i++) if(!isOut[i]) return false;
        return true;
    }

    private static void rotateMap() {
        int[] info = getInfo();
        int r = info[0];
        int c = info[1];
        int size = info[2];

        System.out.println("info: "+ r+" "+ c+" "+size );
        int[][] newMap = new int[size][size];

        for(int i = 0 ; i < size ; i++){
            for(int j = 0 ; j < size ; j++){
                newMap[i][j] = map[i+r][j+c] > 0 ? map[i+r][j+c]-1 : map[i+r][j+c];
            }
        }
        for(int i = 0 ; i < size ; i++){
            for(int j = 0 ; j < size ; j++){
                map[r+i][c+j] = newMap[size - j - 1][i];
            }
        }

        //참가자 회전

        for(int i = 1; i<= m ;i++){
            if(isOut[i]) continue;
            int pr = people[i][0];
            int pc = people[i][1];

            if(r <= pr && pr < r + size && c <= pc && pc < c + size){
                int or = pr - r , oc = pc - c;

                int rr = oc , rc = size - or - 1;
                people[i][0] = rr + r;
                people[i][1] = rc + c;
            }
        }

        int er = exit[0];
        int ec = exit[1];
        if(r <= er && er < r + size && c <= ec && ec < c + size){
            int or = er - r , oc = ec - c;

            int rr = oc , rc = size - or - 1;
            exit[0] = rr + r;
            exit[1] = rc + c;
        }

    }

    private static int[] getInfo() {

        for(int size = 2 ; size <= n ; size++){
            for(int i = 1; i<= n - size +1 ; i++){
                for(int j = 1; j <= n-size+1 ; j++){

                    int i2 = i + size-1;
                    int j2 = j + size-1;

                    if(isIn(i,j,i2,j2)){
                        return new int[]{i,j,size};
                    }
                }
            }
        }
        return new int[]{-1,-1,-1};
    }

    private static boolean isIn(int r1,int c1,int r2,int c2) {
        if(!(r1 <= exit[0] && exit[0] <= r2 && c1 <= exit[1] && exit[1] <= c2)) {
            return false;
        }

        for(int i = 1; i <= m ; i++){
            if(isOut[i]) continue;

            int[] cur = people[i];
            if(r1 <= cur[0] && cur[0] <= r2 && c1 <= cur[1] && cur[1] <= c2) {
                return true;
            }
        }
        return false;
    }

    private static void peopleMove() {

        for(int i = 1 ; i <= m ; i++){
            if(isOut[i]) continue;

            int[] cur = people[i];
            int minDist = getDist(exit[0],exit[1],cur[0],cur[1]);
            int[] next = null;

            for(int dir = 0 ; dir < 4 ; dir++){
                int nr = cur[0] + dr[dir];
                int nc = cur[1] + dc[dir];

                if(OOB(nr,nc) || map[nr][nc] > 0) continue;
                int d = getDist(nr,nc,exit[0],exit[1]);
                if(d < minDist){
                    minDist = d;
                    next = new int[]{nr,nc};
                }
            }
            if(next == null) continue;

            cur[0] = next[0];
            cur[1] = next[1];
            tot++;

            if(cur[0] == exit[0] && cur[1] == exit[1]){
                isOut[i] = true;
            }
        }
    }

    static int getDist (int r1,int c1,int r2,int c2){
        return Math.abs(r1-r2) + Math.abs(c1-c2);
    }
    static boolean OOB(int r,int c){
        return r < 1 || r > n || c < 1 || c > n;
    }
}
