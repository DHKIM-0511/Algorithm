package workbook_0x0B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 색종이만들기_2630 {
    static int[][] map;
    static int[] ans = new int[2];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for(int i = 0 ; i < N ; i++){
            StringTokenizer st= new StringTokenizer(br.readLine());
            for(int j = 0 ; j < N ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        fnc(0,0,N);
        Arrays.stream(ans).forEach(System.out::println);
    }

    private static void fnc(int r, int c, int size) {
        if(size == 1 || check(r,c,size)){
            if(map[r][c] == 0) ans[0]++;
            else ans[1]++;
        }else{
            int d = size/2;

            fnc(r,c,d);
            fnc(r,c + d,d);

            fnc(r + d,c,d);
            fnc(r + d,c + d,d);
        }
    }

    private static boolean check(int r, int c, int size) {
        int cur = map[r][c];

        for(int i = r ; i < r + size; i++){
            for(int j = c ; j < c + size; j++){
                if(map[i][j] != cur) return false;
            }
        }
        return true;
    }
}
