package workbook_0x0D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 테트로미노_14500 {
    static int N,M,ans;
    static int[][] map;
    static int[] sel = new int[4];
    static List<List<int[]>> mino = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < M ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        setMino(0, 0);
        getScore();
        System.out.println(ans);
    }

    private static void getScore() {
        for(int i = 0 ;i <= N-4 ; i++){
            for(int j = 0 ; j <= M-4 ; j++){
                for(List<int[]> shape : mino){
                    int total = 0;

                    for(int[] idx : shape){
                        total += map[i + idx[0]][j + idx[1]];
                    }
                    ans = Math.max(total, ans);
                }
            }
        }
    }

    private static void setMino(int cnt, int last) {
        if(cnt == 4){
            List<int[]> shape = new ArrayList<>();
            for(int i : sel){
                shape.add(new int[] {i/4, i%4});
            }

            if(isConnected(shape)) mino.add(shape);
            return;
        }
        //이전 idx는 필요 없음
        for(int i = last ; i < 16 ; i++){
            sel[cnt] = i;
            setMino(cnt+1, i+1);
        }
    }

    private static boolean isConnected(List<int[]> shape) {
        boolean flag = false;
        for(int i = 0 ; i < 4; i++){
            int cnt = 0;
            for(int j = 0 ; j < 4; j++){
                if(isAdj(shape.get(i), shape.get(j)))cnt++;
            }
            if(cnt == 0) return false;
            if(cnt >= 2) flag = true;
        }
        return flag;
    }

    private static boolean isAdj(int[] idx1, int[] idx2) {
        return Math.abs(idx1[0] - idx2[0]) + Math.abs(idx1[1] - idx2[1]) == 1;
    }
}
