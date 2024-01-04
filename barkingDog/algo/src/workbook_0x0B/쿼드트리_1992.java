package workbook_0x0B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 쿼드트리_1992 {
    static int[][] map;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for(int i = 0 ; i < N ; i++){
            String input = br.readLine();
            for(int j = 0 ; j < N ; j++){
                map[i][j] = input.charAt(j) - '0';
            }
        }
        fnc(0,0,N,0);
        System.out.println(sb);
    }

    private static void fnc(int r, int c, int size, int cnt) {
        if(size == 1 || check(r,c,size)){
            if(map[r][c] == 0) sb.append(0);
            else sb.append(1);
        }else{
            int d = size / 2;
            cnt += 1;
            sb.append("(");

            fnc(r,c,d,cnt);
            fnc(r,c+d,d,cnt);

            fnc(r+d,c,d,cnt);
            fnc(r+d,c+d,d,cnt);

            for(int i = cnt ; i >= cnt ; i--) sb.append(")");
        }
    }

    private static boolean check(int r, int c, int size) {
        int cur = map[r][c];

        for(int i =r ; i  < r + size ; i++){
            for(int j = c ; j < c + size ; j++){
                if(map[i][j] != cur) return false;
            }
        }
        return true;
    }
}
