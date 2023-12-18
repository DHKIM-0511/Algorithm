package workbook_0x09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 나이트의이동_7562 {
    static int I,ans;
    static int[] dr = {-2,-1,1,2,2,1,-1,-2}, dc ={1,2,2,1,-1,-2,-2,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int tc = 0 ; tc < T; tc++){
            I = Integer.parseInt(br.readLine());
            int[][] map = new int[I][I];

            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] startIdx = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            st = new StringTokenizer(br.readLine());
            int[] endIdx = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};

            bfs(map,startIdx,endIdx);
            System.out.println(ans);
        }
    }

    static void bfs(int[][] map, int[] startIdx, int[] endIdx) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(startIdx);
        map[startIdx[0]][startIdx[1]] = 1;

        while (!q.isEmpty()){
            int[] cur= q.poll();

            if(cur[0] == endIdx[0] && cur[1] == endIdx[1]){
                ans = map[cur[0]][cur[1]]-1;
                return;
            }
            for(int i = 0 ; i < 8 ; i++){
                int nr = cur[0] + dr[i];
                int nc = cur[1] + dc[i];

                if(nr < 0 || nr >= I || nc < 0 ||nc >= I || map[nr][nc] != 0) continue;

                q.offer(new int[]{nr,nc});
                map[nr][nc] = map[cur[0]][cur[1]]+1;
            }
        }
    }
}
