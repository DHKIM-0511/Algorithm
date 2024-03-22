package workbook;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 연구소2_17141 {
    static int n,m,ans = Integer.MAX_VALUE;
    static int[][] map;
    static boolean[] isUsed;
    static List<int[]> virus = new ArrayList<>();
    static int[] dr = {0,0,-1,1}, dc={-1,1,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][n];

        for(int i = 0 ; i < n ; i ++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < n ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2){
                    virus.add(new int[]{i,j});
                }
            }
        }
        isUsed = new boolean[virus.size()];
        fnc(0,0, new int[m]);
        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }

    private static void fnc(int last, int cnt, int[] sel) {
        if(cnt == m){
            bfs(sel);
            return;
        }
        for(int i = last ; i < virus.size() ; i++){
            if(isUsed[i]) continue;
            isUsed[i] =true;
            sel[cnt] = i;
            fnc(i+1,cnt+1, sel);
            isUsed[i] =false;
        }
    }

    private static void bfs(int[] sel) {
        Queue<Node> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];

        for(int i : sel){
            int[] cur = virus.get(i);
            q.offer(new Node(cur[0],cur[1],0));
            visited[cur[0]][cur[1]] = true;
        }
        int max = 0;
        while (!q.isEmpty()){
            Node cur = q.poll();

            max = Math.max(max, cur.cnt);

            for(int i = 0 ; i < 4; i++){
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];

                if(nr < 0 || nr >= n || nc < 0 || nc >= n || visited[nr][nc]) continue;
                if(map[nr][nc] == 1) continue;
                q.offer(new Node(nr,nc,cur.cnt+1));
                visited[nr][nc] = true;
            }
        }
        if(check(visited)){
            return;
        }
        ans = Math.min(ans,max);
    }

    private static boolean check(boolean[][] visited) {
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
               if(visited[i][j] || map[i][j] == 1) continue;
               return true;
            }
        }
        return false;
    }

    static class Node{
        int r,c,cnt;
        Node(int r, int c, int cnt){
            this.r=r;
            this.c=c;
            this.cnt=cnt;
        }
    }
}
