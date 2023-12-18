package workbook_0x09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 불_5427 {
    static int W,H,ans;
    static int[] dr = {-1,1,0,0} , dc = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc = 0 ; tc < T ; tc++){
            String input = br.readLine();
            W = Integer.parseInt(input.split(" ")[0]);
            H = Integer.parseInt(input.split(" ")[1]);

            char[][] map = new char[H][W];
            Queue<Node> q = new LinkedList<>();

            Node sang = null;
            for(int i = 0 ; i < H ; i++){
                map[i] = br.readLine().toCharArray();
                for(int j = 0 ; j < W ; j++){
                    if(map[i][j] == '@'){
                        sang = new Node(i,j,0,'@');
                    }
                    if(map[i][j] == '*'){
                        q.offer(new Node(i,j,0,'*'));
                    }
                }
            }
            q.offer(sang);
            if(bfs(map,q)){
                System.out.println(ans);
            }else{
                System.out.println("IMPOSSIBLE");
            }
        }
    }
    static boolean bfs(char[][] map, Queue<Node> q) {

        while (!q.isEmpty()){
            Node cur = q.poll();

            if(isSangEdge(cur)){
                ans = cur.t+1;
                return true;
            }
            for(int i = 0 ; i < 4 ; i++){
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];

                if(nr < 0 || nr >= H || nc < 0 ||nc >= W) continue;

                if(cur.v == '@'){
                    if(map[nr][nc] != '.' ) continue;
                    q.offer(new Node(nr, nc, cur.t+1, '@'));
                    map[nr][nc] = '@';
                }else {
                    if(map[nr][nc] == '#' || map[nr][nc] == '*' ) continue;
                    q.offer(new Node(nr, nc, cur.t+1, '*'));
                    map[nr][nc] = '*';
                }
            }
        }
        return false;
    }

    private static boolean isSangEdge(Node cur) {
        if(cur.v == '*')return false;
        if(cur.r == 0) return true;
        if(cur.r == H-1) return true;
        if(cur.c == 0) return true;
        if(cur.c == W-1) return true;
        return false;
    }

    static class Node{
        int r,c,t;
        char v;
        public Node(int r, int c, int t, char v){
            this.r =r;
            this.c =c;
            this.t =t;
            this.v =v;
        }
    }
}
