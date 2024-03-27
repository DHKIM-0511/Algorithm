package workbook;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class 새로운게임_17780 {
    static int n,k,ans;
    static int[][] map;
    static Deque<Integer>[][] nodeMap;
    static Node[] nodes;
    static int[] dr = {0,0,-1,1}, dc = {1,-1,0,0}; // 0 ~ 3 : 우좌상하
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        nodeMap = new ArrayDeque[n][n];

        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < n ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                nodeMap[i][j] = new ArrayDeque<>();
            }
        }

        nodes = new Node[k+1];
        for(int i = 1 ; i <= k ; i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken())-1;
            int dir = Integer.parseInt(st.nextToken())-1;

            nodes[i] = new Node(r,c,dir);
            nodeMap[r][c].offer(i);
        }

        play();
        System.out.println(ans);
    }

    private static void play() {
        int turn = 1;
        while (turn <= 1000){
            for(int i = 1 ; i <= k ; i++){
                Node cur = nodes[i];

                if(nodeMap[cur.r][cur.c].getFirst() != i) continue;

                int nr = cur.r + dr[cur.dir];
                int nc = cur.c + dc[cur.dir];

                if(nr < 0 || nr >= n || nc < 0 || nc >= n || map[nr][nc] == 2){ //blue
                    int newDir = 0;
                    if(cur.dir % 2 == 0) newDir = cur.dir + 1;
                    else newDir = cur.dir-1;

                    cur.dir = newDir;
                    nr = cur.r + dr[newDir];
                    nc = cur.c + dc[newDir];
                    if(nr < 0 || nr >= n || nc < 0 || nc >= n || map[nr][nc] == 2) continue;
                }

                if(map[nr][nc] == 1){ //red
                    redMove(cur, nr, nc);
                }else{ //white
                    whiteMove(cur, nr, nc);
                }

                if(nodeMap[nr][nc].size() >= 4){
                    ans = turn;
                    return;
                }
            }
            turn++;
        }
        ans = -1;
    }

    private static void whiteMove(Node cur, int nr, int nc) {
        while (!nodeMap[cur.r][cur.c].isEmpty()){
            int idx = nodeMap[cur.r][cur.c].pollFirst();
            nodes[idx] = new Node(nr,nc,nodes[idx].dir);
            nodeMap[nr][nc].offerLast(idx);
        }
    }

    private static void redMove(Node cur, int nr, int nc) {
        while (!nodeMap[cur.r][cur.c].isEmpty()) {
            int idx = nodeMap[cur.r][cur.c].pollLast();
            nodes[idx] = new Node(nr,nc,nodes[idx].dir);
            nodeMap[nr][nc].offerLast(idx);
        }
    }

    static class Node{
        int r,c,dir;

        Node(int r,int c,int dir){
            this.r = r;
            this.c = c;
            this.dir = dir;
        }
    }
}
