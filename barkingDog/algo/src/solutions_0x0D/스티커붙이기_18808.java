package solutions_0x0D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 스티커붙이기_18808 {
    static int N,M,K,ans;
    static int[][] map = new int[42][42];
    static List<Sticker> stickers = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for(int i = 0 ; i < K ; i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            int[][] shape = new int[r][c];
            for(int j = 0 ; j < r ; j++){
                st = new StringTokenizer(br.readLine());
                for(int k = 0 ; k < c ; k++){
                    shape[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            stickers.add(new Sticker(r,c,shape));
        }
        putStickers(0,0, false);
        System.out.println(ans);
    }

    private static void putStickers(int idx, int retryCnt, boolean isRotate) {
        if(idx >= stickers.size()){
            ans = getCnt();
            return;
        }
        if(retryCnt >= 4){
            putStickers(idx+1, 0, false);
            return;
        }
        Sticker cur = stickers.get(idx);
        if(isRotate) cur = cur.rotate();

        for(int i = 0; i <= N - cur.r; i++){
            for(int j = 0 ; j <= M - cur.c; j++){
                if(check(cur, new int[] {i,j})){
                    //붙였어
                    putStickers(idx+1, 0, false);
                    return;
                }
            }
        }
        putStickers(idx, retryCnt+1, true);
    }

    private static boolean check(Sticker cur, int[] idx) {
        for(int i = 0 ; i < cur.r ; i++){
            for(int j = 0 ; j < cur.c ; j++){
                if(map[i + idx[0]][j + idx[1]] == 1 && cur.shape[i][j] == 1) return false;
            }
        }

        for(int i = 0 ; i < cur.r ; i++){
            for(int j = 0 ; j < cur.c ; j++){
                if(cur.shape[i][j] == 1) map[i + idx[0]][j + idx[1]] = 1;
            }
        }

        return true;
    }

    private static int getCnt() {
        int cnt =0;
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < M ; j++){
                cnt += map[i][j];
            }
        }
        return cnt;
    }

    static class Sticker{
        int r,c;
        int[][] shape;
        public Sticker(int r, int c, int[][] shape){
            this.r =r;
            this.c =c;
            this.shape = copy(shape);
        }
        private int[][] copy(int[][] shape) {
            int[][] tmp = new int[this.r][this.c];

            for(int i = 0 ; i < this.r ; i++){
                for(int j = 0 ; j < this.c ; j++){
                    tmp[i][j] = shape[i][j];
                }
            }
            return tmp;
        }
        public Sticker rotate() {
            int[][] newShape = new int[this.c][this.r];

            for (int i = 0; i < this.r; i++) {
                for (int j = 0; j < this.c; j++) {
                    newShape[j][this.r - i - 1] = this.shape[i][j];
                }
            }
            this.r = newShape.length;
            this.c = newShape[0].length;
            this.shape = newShape;
            return this;
        }
    }
}