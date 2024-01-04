package workbook_0x0B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 별찍기_10_2447 {
    static char[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        map = new char[N][N];

        drawingStar(0,0,N,false);

        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < N; i ++){
            for(int j = 0 ; j < N; j ++){
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void drawingStar(int r, int c, int size, boolean isBlank) {
        if(isBlank){
            for(int i = r; i < r + size ; i++){
                for(int j = c ; j < c + size ; j++){
                    map[i][j] = ' ';
                }
            }
        }else if(size == 1){
            map[r][c] = '*';
        }else{
            int d = size/3;
            int cnt = 0;

            for(int i = r ; i < r + size ; i += d){
                for(int j = c; j < c + size ; j += d){
                    cnt++;
                    if(cnt == 5){
                        drawingStar(i,j,d,true);
                    }else {
                        drawingStar(i,j,d,false);

                    }
                }
            }
        }
    }
}
