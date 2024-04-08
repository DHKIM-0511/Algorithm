package workbook;

import java.io.*;
import java.util.*;


public class 게리맨더링2_17779 {
    static int n,total,ans= Integer.MAX_VALUE;
    static int[][] map;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n+1][n+1];

        StringTokenizer st;
        for(int i = 1 ; i <= n ; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1 ; j <= n ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                total += map[i][j];
            }
        }

        for(int x = 1 ; x <= n ; x++) {
            for(int y = 1 ; y <= n ; y++) {
                for(int d1= 1 ; d1 < n ; d1++) {
                    for(int d2 = 1 ; d2 < n ; d2++) {
                        if(x + d1+ d2 > n ) continue;
                        if(y-d1 < 1 || y+d2 > n) continue;

                        fnc(x,y,d1,d2);
                    }
                }
            }
        }
        System.out.println(ans);
    }

    private static void fnc(int x, int y, int d1, int d2) {
        //경계선 만들기
        boolean[][] border = new boolean[n+1][n+1];

        for(int i = 0 ; i <= d1 ; i++) {
            border[x+i][y-i] = true;
            border[x+d2+i][y+d2-i] = true;
        }
        for(int i = 0 ; i <= d2 ; i++) {
            border[x+i][y+i] = true;
            border[x+d1+i][y-d1+i] = true;
        }

        int[] people = new int[5];

        for(int i = 1 ; i < x+d1 ; i++) {
            for(int j = 1 ; j <= y ; j++) {
                if(border[i][j]) break;
                people[0] += map[i][j];
            }
        }

        for(int i = 1 ; i <= x+d2 ; i++) {
            for(int j = n ; j > y ; j--) {
                if(border[i][j]) break;
                people[1] += map[i][j];
            }
        }

        for(int i = x+d1 ; i <= n ; i++) {
            for(int j = 1 ; j < y-d1+d2 ; j++) {
                if(border[i][j]) break;
                people[2] += map[i][j];
            }
        }

        for(int i = x+d2+1 ; i <= n ; i++) {
            for(int j = n ; j >= y+d2-d1 ; j--) {
                if(border[i][j]) break;
                people[3] += map[i][j];
            }
        }

        people[4] = total;
        for(int i = 0 ; i < 4 ; i++) people[4] -= people[i];

        Arrays.sort(people);
        int min = people[4] - people[0];
        ans = Math.min(ans, min);

    }
}

