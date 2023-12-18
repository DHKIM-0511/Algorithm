package solutions_0x09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 불1_4179 { //불!_4179
    static int[] dr = {-1,1,0,0}, dc ={0,0,-1,1};
    static int R,C,ans;
    static boolean[][] visitedJ,visitedF;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] RC = br.readLine().split(" ");
        R = Integer.parseInt(RC[0]);
        C = Integer.parseInt(RC[1]);

        char[][] map = new char[R][C];
        visitedJ = new boolean[R][C];
        visitedF = new boolean[R][C];

        Queue<Node> q = new LinkedList<>();
        Node J = null;
        for(int i = 0 ; i < R; i ++){
            String str = br.readLine();
            for(int j = 0 ; j < C ; j++){
                map[i][j] = str.charAt(j);
                if(map[i][j] == 'J'){
                   J = new Node(i,j,0,'J');
                    visitedJ[i][j] = true;
                }
                if(map[i][j] == 'F'){
                    q.offer(new Node(i,j,0,'F'));
                    visitedF[i][j] = true;
                }
            }
        }
        q.offer(J);
        bfs(map, q);
    }
    static void bfs(char[][] map,  Queue<Node> q ){

        while (!q.isEmpty()){
            Node cur = q.poll();
            if(isJiHoonEdge(cur)){
                System.out.println(cur.t+1);
            }
            for(int i = 0 ; i < 4 ; i++){
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];

                if(nr < 0 || nr >= R || nc < 0 || nc >= C) continue;

                if(cur.v == 'J') {
                    if(map[nr][nc] == '.' && !visitedJ[nr][nc]){
                        q.offer(new Node(nr,nc,cur.t+1,'J'));
                        visitedJ[nr][nc] = true;
                    }
                }else{
                    if(map[nr][nc]!='#'&& !visitedF[nr][nc]){
                        q.offer(new Node(nr,nc,cur.t+1,'F'));
                        visitedF[nr][nc] = true;
                        map[nr][nc] = 'F';
                    }
                }
            }
        }
        System.out.println("IMPOSSIBLE");
    }
    static boolean isJiHoonEdge(Node node){
        if(node.v == 'F') return false;
        if(node.r == 0) return true;
        if(node.r == R-1) return true;
        if(node.c == 0) return true;
        if(node.c == C-1) return true;
        return false;
    }
    static class Node {
        int r, c, t, v;
        public Node(int r, int c, int t, char v){
            this.r = r;
            this.c = c;
            this.t = t;
            this.v = v;
        }
    }
}
