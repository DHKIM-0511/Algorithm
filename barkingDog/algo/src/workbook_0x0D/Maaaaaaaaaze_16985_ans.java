package workbook_0x0D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Maaaaaaaaaze_16985_ans {
    static int[][][][] board = new int[4][5][5][5];
    static int[][][] maze = new int[5][5][5];

    static int[] dx = {1, 0, 0, 0, 0, -1};
    static int[] dy = {0, 1, -1, 0, 0, 0};
    static int[] dz = {0, 0, 0, 1, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int k = 0; k < 5; k++) {
                    board[0][i][j][k] = Integer.parseInt(st.nextToken());
                }
            }

            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    board[1][i][j][k] = board[0][i][4 - k][j];
                }
            }

            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    board[2][i][j][k] = board[1][i][4 - k][j];
                }
            }

            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    board[3][i][j][k] = board[2][i][4 - k][j];
                }
            }
        }

        int[] order = {0, 1, 2, 3, 4};
        int ans = 9999;
        do {
            for (int tmp = 0; tmp < 1024; tmp++) {
                int brute = tmp;
                for (int i = 0; i < 5; i++) {
                    int dir = brute % 4;
                    brute /= 4;
                    for (int j = 0; j < 5; j++) {
                        for (int k = 0; k < 5; k++) {
                            maze[i][j][k] = board[dir][order[i]][j][k];
                        }
                    }
                }
                ans = Math.min(ans, solve());
            }
        } while (nextPermutation(order));

        if (ans == 9999) ans = -1;
        System.out.println(ans);
    }
    static int solve() {
        int[][][] dist = new int[5][5][5];
        if (maze[0][0][0] == 0 || maze[4][4][4] == 0) return 9999;

        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0, 0, 0));
        dist[0][0][0] = 1;

        while (!q.isEmpty()) {
            Node cur = q.poll();
            for (int dir = 0; dir < 6; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];
                int nz = cur.z + dz[dir];
                if (0 > nx || nx >= 5 || 0 > ny || ny >= 5 || 0 > nz || nz >= 5) continue;
                if (maze[nx][ny][nz] == 0 || dist[nx][ny][nz] != 0) continue;
                if (nx == 4 && ny == 4 && nz == 4)
                    return dist[cur.x][cur.y][cur.z];
                dist[nx][ny][nz] = dist[cur.x][cur.y][cur.z] + 1;
                q.offer(new Node(nx, ny, nz));
            }
        }
        return 9999;
    }

    static boolean nextPermutation(int[] array) {
        int i = array.length - 1;
        while (i > 0 && array[i - 1] >= array[i]) i--;
        if (i <= 0) return false;

        int j = array.length - 1;
        while (array[j] <= array[i - 1]) j--;

        int temp = array[i - 1];
        array[i - 1] = array[j];
        array[j] = temp;

        j = array.length - 1;
        while (i < j) {
            temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            i++;
            j--;
        }
        return true;
    }


    static class Node {

        int x, y, z;
        public Node(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

    }
}
