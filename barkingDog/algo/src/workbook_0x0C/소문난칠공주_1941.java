package workbook_0x0C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 소문난칠공주_1941 {
    static int ans;
    static char[][] map = new char[5][5];
    static boolean[][] 칠공주 = new boolean[5][5];
    static int[] dr = {-1,1,0,0} , dc = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 0 ; i < 5; i++){
            map[i] = br.readLine().toCharArray();
        }
        combination(0,0,0, 0,new Node[7]);
        System.out.println(ans);
    }

    private static void combination(int last, int cnt, int dsCnt, int dyCnt, Node[] selected) {
        if(dyCnt >= 4) return;

        if(cnt == 7){
            if(bfs(selected)) ans++;
            return;
        }

        for(int i = last ; i < 25 ; i++){
            Node cur = new Node(i / 5, i % 5);
            selected[cnt] = cur;
            if(map[cur.r][cur.c] == 'S') combination(i+1, cnt+1, dsCnt+1, dyCnt, selected);
            else combination(i+1, cnt+1, dsCnt, dyCnt+1, selected);
        }
    }

    private static boolean bfs(Node[] selected) {
        Queue<Node> q = new LinkedList<>();
        boolean[][] visited = new boolean[5][5];

        int cnt = 1;
        q.offer(selected[0]);

        for(int i = 1; i < 7 ; i++){
            Node n = selected[i];
            visited[n.r][n.c] = true;
        }

        while (!q.isEmpty()){
            Node cur = q.poll();

            for(int i = 0 ; i < 4; i++){
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];

                if(nr < 0 || nr >= 5 || nc < 0 || nc >=5 || !visited[nr][nc]) continue;
                q.offer(new Node(nr,nc));
                visited[nr][nc] = false;
                cnt++;
            }
        }
        if(cnt == 7){
            return true;
        }
        return false;
    }

    static class Node{
        int r,c;
        public Node(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
}
