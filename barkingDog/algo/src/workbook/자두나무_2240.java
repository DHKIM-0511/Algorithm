package workbook;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 자두나무_2240 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int t = Integer.parseInt(input[0]);
        int w = Integer.parseInt(input[1]);

        int[] a = new int[t+1];
        for(int i = 1; i <= t ; i++) a[i] = Integer.parseInt(br.readLine());

        int[][][] d = new int[t+1][w+1][3]; // 시간, 움직임, 나무 번호 경우의 수 저장

        for(int i =1 ; i <= t ; i++){
            d[i][0][1] = d[i-1][0][1] + (a[i] == 1? 1: 0);

            for(int j = 1; j <= w ; j++){
                if(i<j) break;
                if(a[i] == 1){
                    d[i][j][1] = Math.max(d[i-1][j-1][2], d[i-1][j][1])+1;
                    d[i][j][2] = Math.max(d[i-1][j-1][1], d[i-1][j][2]);
                }else {
                    d[i][j][1] = Math.max(d[i-1][j-1][2], d[i-1][j][1]);
                    d[i][j][2] = Math.max(d[i-1][j-1][1], d[i-1][j][2])+1;

                }
            }
        }

        int ans = 0;
        for(int i = 0 ; i <= w; i++){
            ans = Math.max(ans, Math.max(d[t][i][1], d[t][i][2]));
        }
        System.out.println(ans);
    }
}
