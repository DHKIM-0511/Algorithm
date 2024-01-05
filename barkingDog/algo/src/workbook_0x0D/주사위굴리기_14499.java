package workbook_0x0D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 주사위굴리기_14499 {
    static int N,M,X,Y,K;
    static int[] dr = {0,0,-1,1} , dc={1,-1,0,0};
    static int[][] map = new int[20][20];
    static int[] orders = new int[1000]; // 동 서 북 남
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < M ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < K ; i++) orders[i] = Integer.parseInt(st.nextToken());

        Dice dice = new Dice(X,Y);
        for(int i = 0 ; i < K ; i++){
            roll(dice, i);
        }

        System.out.println(sb);
    }

    private static void roll(Dice cur, int idx) {
        int dir = orders[idx] - 1;
        int nr = cur.r + dr[dir];
        int nc = cur.c + dc[dir];

        if(nr < 0 || nr >= N || nc < 0 || nc >= M) return;
        cur.move(dir, nr, nc);
        sb.append(cur.value[1]).append("\n");

        if(map[nr][nc] != 0){
            cur.value[6] = map[nr][nc];
            map[nr][nc] = 0;
        }else{
            map[nr][nc] = cur.value[6];
        }
//출력문
//        System.out.print("dir: "+dir+" dice: ");
//        for (int i : cur.value) {
//            System.out.print(i+" ");
//        }
//        System.out.println();
//        for(int i = 0 ; i < N ; i++){
//            for(int j = 0 ; j < M ; j++){
//                System.out.print(map[i][j]+" ");
//            }
//            System.out.println();
//        }
//        System.out.println("top: "+ cur.value[1]);
//        System.out.println();
    }

    static class Dice{
        int r,c;
        int[] value;

        public Dice(int r,int c){
            this.r=r;
            this.c=c;
            this.value = new int[7];
        }
        public void move(int dir, int nr, int nc){
            //동서북남
            int tmp = 0;
            if(dir == 0){
                tmp = this.value[1];
                this.value[1] = this.value[4];
                this.value[4] = this.value[6];
                this.value[6] = this.value[3];
                this.value[3] = tmp;
            }else if(dir == 1){
                tmp = this.value[1];
                this.value[1] = this.value[3];
                this.value[3] = this.value[6];
                this.value[6] = this.value[4];
                this.value[4] = tmp;
            }else if(dir == 2){
                tmp = this.value[1];
                this.value[1] = this.value[5];
                this.value[5] = this.value[6];
                this.value[6] = this.value[2];
                this.value[2] = tmp;
            }else{
                tmp = this.value[1];
                this.value[1] = this.value[2];
                this.value[2] = this.value[6];
                this.value[6] = this.value[5];
                this.value[5] = tmp;
            }
            this.r = nr;
            this.c = nc;
        }
    }
}
