package 모의;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 벽돌깨기_5657 {

    static int N, W, H, ans;
    static int[][] map, inDegree;
    static int[] dr = { -1, 0, 1, 0 };
    static int[] dc = { 0, 1, 0, -1 };

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= t; tc++) {
            String[] input = br.readLine().split(" ");
            N = Integer.parseInt(input[0]);
            W = Integer.parseInt(input[1]);
            H = Integer.parseInt(input[2]);

            map = new int[H][W];
            inDegree = new int[H][W];

            for (int i = 0; i < H; i++) {
                input = br.readLine().split(" ");
                for (int j = 0; j < W; j++) {
                    map[i][j] = Integer.parseInt(input[j]);
                    if (map[i][j] > 0) {
                        inDegree[i][j] = countRemain(i, j);
                    }
                }
            }

            ans = Integer.MAX_VALUE;
            setPosition(0, 0);

            System.out.println("#" + tc + " " + ans);
        }
    }

    private static void setPosition(int cnt, int bricksDestroyed) {
        if (cnt == N) {
            ans = Math.min(ans, bricksDestroyed);
            return;
        }

        int[][] mapCopy = copyMap();
        int[][] inDegreeCopy = copyMap(inDegree);
        for (int i = 0; i < W; i++) {
            dropBrick(i);
            setPosition(cnt + 1, getBricksDestroyed());
            map = copyMap(mapCopy);
            inDegree = copyMap(inDegreeCopy);
        }
    }

    private static void dropBrick(int col) {
        for (int row = 0; row < H; row++) {
            if (map[row][col] > 0) {
                destroyBrick(row, col);
                moveBricks();
                break;
            }
        }
    }

    private static void destroyBrick(int row, int col) {
        int range = map[row][col];
        map[row][col] = 0;
        inDegree[row][col] = 0;

        if (range == 1) {
            return;
        }

        for (int i = 1; i < range; i++) {
            for (int j = 0; j < 4; j++) {
            	int nr = row + dr[j] * i;
            	int nc = col + dc[j] * i;
                if (nr >= 0 && nr < H && nc >= 0 && nc < W && map[nr][nc] > 0) {
                    if (inDegree[nr][nc] > 0) {
                        inDegree[nr][nc]--;
                    }
                    if (inDegree[nr][nc] == 0) {
                        destroyBrick(nr, nc);
                    }
                }
            }
        }
    }

    private static void moveBricks() {
        for (int col = 0; col < W; col++) {
            int[] temp = new int[H];
            int idx = H - 1;
            for (int row = H - 1; row >= 0; row--) {
                if (map[row][col] > 0) {
                    temp[idx--] = map[row][col];
                }
            }
            for (int i = 0; i < H; i++) {
                map[i][col] = temp[i];
                if (map[i][col] > 0) {
                    inDegree[i][col] = countRemain(i, col);
                } else {
                    inDegree[i][col] = 0;
                }
            }
        }
    }

    private static int countRemain(int row, int col) {
        int cnt = 0;
        int range = map[row][col];

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        for (int i = 1; i < range; i++) {
            for (int j = 0; j < 4; j++) {
                int nr = row + dr[j] * i;
                int nc = col + dc[j] * i;

                if (nr >= 0 && nr < H && nc >= 0 && nc < W && map[nr][nc] > 0) {
                    cnt++;
                }
            }
        }

        return cnt;
    }

    private static int[][] copyMap() {
        int[][] newMap = new int[H][W];
        for (int i = 0; i < H; i++) {
            newMap[i] = Arrays.copyOf(map[i], W);
        }
        return newMap;
    }

    private static int[][] copyMap(int[][] original) {
        int[][] newMap = new int[H][W];
        for (int i = 0; i < H; i++) {
            newMap[i] = Arrays.copyOf(original[i], W);
        }
        return newMap;
    }

    private static int getBricksDestroyed() {
        int bricksDestroyed = 0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (map[i][j] == 0) {
                    bricksDestroyed++;
                }
            }
        }
        return bricksDestroyed;
    }
}
