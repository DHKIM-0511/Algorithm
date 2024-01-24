package workbook_0x0D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 인구이동_16234 {
    static int N,L,R,ans;
    static int[][] map = new int[51][51];
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (true) {
            boolean[][] visited = new boolean[105][105];
            Queue<Node> q = new LinkedList<>();

            boolean flag = false;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {

                    if (!visited[i][j]) q.add(new Node(i, j));
                    int sum = 0;
                    List<Node> tmp = new ArrayList<>();

                    while (!q.isEmpty()) {
                        Node cur = q.poll();

                        for (int dir = 0; dir < 4; dir++) {
                            int nr = cur.r + dx[dir];
                            int nc = cur.c + dy[dir];
                            if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
                            int diff = Math.abs(map[cur.r][cur.c] - map[nr][nc]);

                            if (diff >= L && diff <= R) {
                                flag = true;
                                if (!visited[cur.r][cur.c]) {
                                    tmp.add(new Node(cur.r, cur.c));
                                    sum += map[cur.r][cur.c];
                                    visited[cur.r][cur.c] = true;
                                }
                                if (!visited[nr][nc]) {
                                    tmp.add(new Node(nr, nc));
                                    sum += map[nr][nc];
                                    visited[nr][nc] = true;
                                    q.add(new Node(nr, nc));
                                }
                            }
                        }
                    }
                    for (Node p : tmp)
                        map[p.r][p.c] = sum / tmp.size();
                }
            }
            if (!flag) break;
            ans++;
        }
        System.out.println(ans);
    }
    static class Node {
        int r, c;
        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
