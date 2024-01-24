package workbook_0x0D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class 미세먼지안녕_17144_ans {
    static int[] dx = {0, 1, 0, -1}; // 시계
    static int[] dy = {1, 0, -1, 0};

    static int[] cdx = {0, -1, 0, 1}; // 반시계
    static int[] cdy = {1, 0, -1, 0};
    static int r, c, t;
    static int[][] room;
    static int machine_bottom;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        room = new int[r][c];

        for(int i = 0; i < r; ++i) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < c; ++j) {
                room[i][j] = Integer.parseInt(st.nextToken());
                if(room[i][j] == -1)
                    machine_bottom = i;
            }
        }

        while(t-- > 0) {
            dust_spread();
            air_cleaner();
        }

        System.out.println(dust_sum());
    }
    static void air_cleaner() {
        int x2 = machine_bottom;
        int x1 = x2 - 1;

        counter_clockwise_wind(x1, 1, 0, 0);
        clockwise_wind(x2, 1, 0, 0);
    }
    static void clockwise_wind(int i, int j, int dir, int prev_dust) {
        if(room[i][j] == -1) return;

        int move_dust = room[i][j];
        room[i][j] = prev_dust;
        int x = i + dx[dir];
        int y = j + dy[dir];
        if(x < 0 || y < 0 || x >= r || y >= c) {
            dir++;
            x = i + dx[dir];
            y = j + dy[dir];
            clockwise_wind(x, y, dir, move_dust);
        }
        else
            clockwise_wind(x, y, dir, move_dust);
    }
    static void counter_clockwise_wind(int i, int j, int dir, int prev_dust) {
        if(room[i][j] == -1) return;

        int move_dust = room[i][j];
        room[i][j] = prev_dust;
        int x = i + cdx[dir];
        int y = j + cdy[dir];
        if(x < 0 || y < 0 || x >= r || y >= c) {
            dir++;
            x = i + cdx[dir];
            y = j + cdy[dir];
            counter_clockwise_wind(x, y, dir, move_dust);
        }
        else
            counter_clockwise_wind(x, y, dir, move_dust);
    }
    static void dust_spread() {
        int[][] dummy = new int[55][55];
        int[][] dummy2 = new int[55][55];
        for(int i = 0; i < r; ++i) {
            for(int j = 0; j < c; ++j) {
                if(room[i][j] <= 0) continue;
                dummy2[i][j] = room[i][j];
                for(int dir = 0; dir < 4; ++dir) {
                    int x = i + dx[dir];
                    int y = j + dy[dir];
                    if(x < 0 || y < 0 || x >= r || y >= c) continue;
                    if(room[x][y] == -1) continue;
                    dummy[x][y] += room[i][j] / 5;
                    dummy2[i][j] -= room[i][j] / 5;
                }
            }
        }
        for(int i = 0; i < r; ++i) {
            for(int j = 0; j < c; ++j) {
                if(room[i][j] == -1) continue;
                room[i][j] = dummy[i][j] + dummy2[i][j];
            }
        }
    }

    static int dust_sum() {
        int sum = 0;
        for(int i = 0; i < r; ++i) {
            for(int j = 0; j < c; ++j) {
                if(room[i][j] == -1) continue;
                sum += room[i][j];
            }
        }
        return sum;
    }
}
