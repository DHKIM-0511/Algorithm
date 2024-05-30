package codetree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 종전 {
    static int[][] map;
    static int n,total, ans = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        StringTokenizer st;
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < n ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                total += map[i][j];
            }
        }

        for(int x = 0 ; x < n ; x++) {
            for(int y = 0 ; y < n ; y++) {
                for(int d1= 1 ; d1 < n-1 ; d1++) {
                    for(int d2 = 1 ; d2 < n-1 ; d2++) {
                        if(x + d1+ d2 >= n ) continue;
                        if(y-d1 < 0 || y+d2 >= n) continue;

                        fnc(x,y,d1,d2);
                    }
                }
            }
        }
        System.out.println(ans);
    }

    private static void fnc(int x, int y, int d1, int d2) {
        boolean[][] border = new boolean[n][n];
        System.out.println("x,y,d1,d2: " +x +" " + y + " "+ d1+" "+d2);
        for(int i = 0 ; i <= d1 ; i++) {
            border[x+i][y-i] = true;
            border[x+d2+i][y+d2-i] = true;
        }
        for(int i = 0 ; i <= d2 ; i++) {
            border[x+i][y+i] = true;
            border[x+d1+i][y-d1+i] = true;
        }
        pringMap(border);

        int[] people = new int[5];
        for(int i = 0 ; i < x+d1 ; i++) {
            for(int j = 0 ; j <= y ; j++) {
                if(border[i][j]) break;
                people[0] += map[i][j];
            }
        }

        for(int i = 0 ; i <= x+d2 ; i++) {
            for(int j = n-1 ; j > y ; j--) {
                if(border[i][j]) break;
                people[1] += map[i][j];
            }
        }

        for(int i = x+d1 ; i < n ; i++) {
            for(int j = 0 ; j < y-d1+d2 ; j++) {
                if(border[i][j]) break;
                people[2] += map[i][j];
            }
        }

        for(int i = x+d2+1 ; i < n ; i++) {
            for(int j = n-1 ; j >= y+d2-d1 ; j--) {
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

    private static void pringMap(boolean[][] map) {

        for(int i = 0 ;i  <n ; i++){
            for(int j = 0 ; j < n ; j++){
                if (map[i][j]) {
                    System.out.print(1+" ");
                }else {
                    System.out.print(0+" ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
