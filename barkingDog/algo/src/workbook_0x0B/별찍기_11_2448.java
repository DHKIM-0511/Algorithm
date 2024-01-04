package workbook_0x0B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 별찍기_11_2448 {
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        map = new char[N][N*2-1];

        drawingStar(0,N-1,N);

        StringBuilder sb= new StringBuilder();
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < N * 2 -1 ; j++){
                if(map[i][j] == '*')sb.append(map[i][j]);
                else sb.append(' ');
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void drawingStar(int r, int c, int size) {
        if(size == 3){
            fillStars(r,c);

        }else{
            int d = size/2;
            drawingStar(r, c, d);
            drawingStar(r + d, c - d, d);
            drawingStar(r + d, c + d, d);
        }
    }

    private static void fillStars(int r, int c) {
        map[r][c] = '*';
        map[r+1][c-1] = '*';
        map[r+1][c+1] = '*';

        for(int i = c-2; i <= c+2 ; i++){
            map[r+2][i] ='*';
        }
    }
}
