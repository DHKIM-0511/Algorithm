package workbook_0x0D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 인싸들의가위바위보_16986 {
    static int N,K,지우win, 경희win, 민호win;
    static int[][] map = new int[15][15];
    static int[] 경희 = new int[20], 민호 = new int[20];
    static boolean[] 지우 = new boolean[10];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for(int i = 1 ; i <= N ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1 ; j <= N ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < 20 ; i++) 경희[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < 20 ; i++) 민호[i] = Integer.parseInt(st.nextToken());

        fnc(0, 0);
    }

    private static void fnc(int cnt, int player) {
        if(cnt > N){
            return;
        }
        if( 경희win == K || 민호win == K|| 지우win == K){
            return;
        }
        for(int i = 1 ; i <= N ; i++){
            if(지우[i]) continue;
            지우[i] =true;
            if(cnt%2 == 0){ // 경희
                if(map[i][경희[cnt/2]] == 2) {
                    지우win++;
                    fnc(cnt+1,0);
                }else{
                    경희win++;
                    fnc(cnt+1,1);
                }
            }else{//민호
                if(map[i][민호[cnt/2]] == 2){
                    지우win++;
                    fnc(cnt+1,0);
                }else{
                    민호win++;
                    fnc(cnt+1,1);
                }
            }
            지우[i] =false;
        }
    }
}
