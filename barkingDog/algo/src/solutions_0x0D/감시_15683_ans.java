package solutions_0x0D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import java.util.StringTokenizer;

public class 감시_15683_ans {
    static int n, m;
    static int[][] board1 = new int[10][10];
    static int[][] board2 = new int[10][10];
    static List<Pair> cctv = new ArrayList<>();
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static boolean OOB(int a, int b) {
        return a < 0 || a >= n || b < 0 || b >= m;
    }

    static void upd(int x, int y, int dir) {
        dir %= 4;
        while (true) {
            x += dx[dir];
            y += dy[dir];
            if (OOB(x, y) || board2[x][y] == 6) return;
            if (board2[x][y] != 0) continue;
            board2[x][y] = 7;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int mn = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board1[i][j] = Integer.parseInt(st.nextToken());
                if (board1[i][j] != 0 && board1[i][j] != 6)
                    cctv.add(new Pair(i, j));
                if (board1[i][j] == 0) mn++;
            }
        }

        int total = 1;
        for (int i = 0; i < cctv.size(); i++) {
            total *= 4;
        }
        // (1 << (2 * cctv.size())) == total
        for (int tmp = 0; tmp < total; tmp++) {
            copyMap();
            int brute = tmp;
            for (int i = 0; i < cctv.size(); i++) {
                int dir = brute % 4;
                brute /= 4;
                int x = cctv.get(i).x;
                int y = cctv.get(i).y;

                switch (board1[x][y]) {
                    case 1:
                        upd(x, y, dir);
                        break;
                    case 2:
                        upd(x, y, dir);
                        upd(x, y, dir + 2);
                        break;
                    case 3:
                        upd(x, y, dir);
                        upd(x, y, dir + 1);
                        break;
                    case 4:
                        upd(x, y, dir);
                        upd(x, y, dir + 1);
                        upd(x, y, dir + 2);
                        break;
                    case 5:
                        upd(x, y, dir);
                        upd(x, y, dir + 1);
                        upd(x, y, dir + 2);
                        upd(x, y, dir + 3);
                        break;
                }
            }
            int val = getVal();
            mn = Math.min(mn, val);
        }
        System.out.println(mn);
    }

    private static int getVal() {
        int val = 0;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                val += (board2[i][j] == 0) ? 1 : 0;
            }
        }
        return val;
    }

    private static void copyMap() {
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                board2[i][j] = board1[i][j];
            }
        }
    }

    static class Pair {
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
