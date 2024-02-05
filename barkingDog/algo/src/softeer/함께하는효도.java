package softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 함께하는효도 {
    static int N,M,ans;
    static int[] dr = {-1,1,0,0}, dc = {0,0,-1,1};
    static int[][] map = new int[22][22];
    static List<int[]> friends = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < N ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken())-1;
            friends.add(new int[]{i,r,c});
        }
        fnc(0, new int[M]);

        System.out.println(ans);
    }

    private static void fnc(int cnt, int[] sel) {
        if(cnt == M){
            getAns(sel);
            return;
        }
        for(int j = 0 ; j < 64; j++){
            sel[cnt] = j;
            fnc(cnt+1, sel);
        }
    }

    private static void getAns(int[] sel) {
        List<int[]> dirList = new ArrayList<>();
        for(int i = 0 ; i < M ; i++){
            int dir = sel[i];
            dirList.add(new int[]{dir/16%4,dir/4%4,dir%4});
        }
        int sum = 0;
        for(int[] cur : friends){
            int[] d = dirList.get(cur[0]);
            int r = cur[1];
            int c = cur[2];
            for(int i = 0 ; i < 3 ; i ++){
                int nr = r+dr[d[i]];
                int nc = c+dc[d[i]];
                if(nr >= N || nr < 0 || nc >= N || nc < 0) return;

                sum += map[r+dr[d[i]]][c+dc[d[i]]];
                r = r+dr[d[i]];
                c = c+dc[d[i]];
            }
        }
        ans = Math.max(sum, ans);
    }
}
