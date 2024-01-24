package workbook_0x0D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 미세먼지안녕_17144 {
    static int R,C,T,ans;
    static int[][] map = new int[51][51];
    static int[] dr = {-1,0,1,0}, dc= {0,1,0,-1}; // 상 부터 시계방향
    static int[] airCleaner = new int[2];
    static List<int[]> dust = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        int tmp = 0;
        for(int i = 0 ; i < R ; i ++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < C ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == -1){
                    airCleaner[tmp++] = i;
                }else if(map[i][j] >= 5){
                    dust.add(new int[]{i,j});
                }
            }
        }

        while (T-- > 0){
            spreadDust();
            startAirCleaner();
            dustInit();
        }
        getAns();
        System.out.println(ans);
    }

    private static void dustInit() {
        dust.clear();
        for(int i = 0 ; i < R ; i++){
            for(int j = 0 ; j < C ; j++){
                if(map[i][j] >= 5) dust.add(new int[]{i,j});
            }
        }
    }
    private static void startAirCleaner() {
        //위쪽 공청기
        int upR = airCleaner[0];
        for(int i = upR-1 ; i >= 0 ; i--){ //첫열 순환
            if(i+1 == upR){
                map[i][0] =0;
            }else{
                map[i+1][0] = map[i][0];
                map[i][0] = 0;
            }
        }
        for(int i = 1 ; i < C ; i++){
            map[0][i-1] = map[0][i];
            map[0][i] = 0;
        }
        for(int i = 1 ; i <= upR ; i++){
            map[i-1][C-1] = map[i][C-1];
            map[i][C-1] = 0;
        }
        for(int i =C-2 ; i >= 1 ; i--){
            map[upR][i+1] = map[upR][i];
            map[upR][i] = 0;
        }

        //아래쪽 공청기
        int downR = airCleaner[1];
        for(int i = downR+1 ; i < R ; i++){ //첫열 순환
            if(i-1 == downR){
                map[i][0] = 0;
            }else{
                map[i-1][0] = map[i][0];
                map[i][0] = 0;
            }
        }
        for(int i = 1 ; i < C ; i++){
            map[R-1][i-1] = map[R-1][i];
            map[R-1][i] = 0;
        }
        for(int i = R-2 ; i >= downR; i--){
            map[i+1][C-1] = map[i][C-1];
            map[i][C-1] = 0;
        }
        for(int i =C-2 ; i >= 1 ; i--){
            map[downR][i+1] = map[downR][i];
            map[downR][i] = 0;
        }
    }

    private static void spreadDust() {
        int[][] dummy = new int[51][51];

        for(int i = 0 ; i < dust.size() ; i++){
            int[] cur = dust.get(i);

            int cnt = 0;
            int v = map[cur[0]][cur[1]]/5;
            for(int j = 0 ; j < 4; j++){
                int nr = cur[0] + dr[j];
                int nc = cur[1] + dc[j];

                if(nr < 0 || nr >= R || nc < 0 || nc >= C || map[nr][nc] == -1) continue;
                dummy[nr][nc] += v;
                cnt++;
            }
            map[cur[0]][cur[1]] -= v*cnt;
        }
        for(int i = 0 ; i < R ; i++){
            for(int j = 0 ; j < C ; j++){
                map[i][j] += dummy[i][j];
            }
        }
    }

    private static void getAns() {
        for(int i = 0 ; i < R ; i++){
            for(int j = 0 ; j < C ; j ++){
                if(map[i][j] != -1) ans += map[i][j];
            }
        }
    }
}
