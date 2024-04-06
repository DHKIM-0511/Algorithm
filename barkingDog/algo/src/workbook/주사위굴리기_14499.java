package workbook;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 주사위굴리기_14499 {
    static int n,m,x,y,k;
    static int[][] map;
    static int[] dr ={0,0,0,-1,1}, dc={0,1,-1,0,0}; // 0, 동,서,북,남
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < m ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        Dice dice = new Dice();
        int curX = x;
        int curY = y;
        while (k-- >0){
            int dir = Integer.parseInt(st.nextToken());
            int nr = curX + dr[dir];
            int nc = curY + dc[dir];

            if(nr < 0 || nr >= n || nc < 0 || nc >= m) continue;

            dice.move(dir);
            if(map[nr][nc] == 0){
                map[nr][nc] = dice.side[2];
            }else {
                dice.side[2] = map[nr][nc];
                map[nr][nc] = 0;
            }
            sb.append(dice.side[0]).append("\n");
            curX = nr;
            curY = nc;
        }
        System.out.println(sb);
    }
    static class Dice{
        int[] side = new int[6]; // 위, 앞, 바닥, 뒤, 왼, 오

        void move(int dir){
            int tmp;
            if(dir == 1){ // 동
                tmp = side[0];
                side[0] = side[4];
                side[4] = side[2];
                side[2] = side[5];
                side[5] = tmp;
            }else if(dir == 2){ // 서
                tmp = side[0];
                side[0] = side[5];
                side[5] = side[2];
                side[2] = side[4];
                side[4] = tmp;
            }else if(dir == 3){ // 북
                tmp = side[0];
                side[0] = side[1];
                side[1] = side[2];
                side[2] = side[3];
                side[3] = tmp;
            }else { // 남
                tmp = side[0];
                side[0] = side[3];
                side[3] = side[2];
                side[2] = side[1];
                side[1] = tmp;
            }
        }
    }
}
