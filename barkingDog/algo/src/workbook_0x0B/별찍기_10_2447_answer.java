package workbook_0x0B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 별찍기_10_2447_answer {
    static char[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        map = new char[N][N];

        for(int i = 0 ; i< N ; i++) Arrays.fill(map[i],' ');

        drawingStar(0,0,N);

        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < N; i ++){
            for(int j = 0 ; j < N; j ++){
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void drawingStar(int r, int c, int size) {
        if(size == 1){
            map[r][c] = '*';
            return;
        }

        for(int i = 0 ; i < 3; i++){
            for(int j = 0 ; j < 3; j++){
                if(i == 1 && j == 1) continue;
                drawingStar( r + size/3 * i, c + size/3 * j,size/3);
            }
        }
    }
}
