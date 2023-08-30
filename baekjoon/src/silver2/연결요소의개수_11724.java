package silver2; 

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 연결요소의개수_11724 {
    static int n, m;
    static boolean[] checked;
    static int[][] node;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());//노드 개수
        m = Integer.parseInt(st.nextToken());//간선 개수
        node = new int[n + 1][n + 1]; // 2차원 배열 노드연결
        checked = new boolean[n + 1]; // 노드의 방문 배열

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            node[a][b] = 1;
            node[b][a] = 1;
        }

        int cnt = 0;
        for (int i = 1; i <= n; i++) { // 노드 순회
            if (!checked[i]) {
                bfs(i);
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    private static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start); 
        checked[start] = true;

        while (!q.isEmpty()) {
            int x = q.poll();
            for (int i = 1; i <= n; i++) {
            	if (node[x][i] == 1 && !checked[i]) {
            		q.offer(i);
            		checked[i] = true;
            	}
            }
        }
    }
}