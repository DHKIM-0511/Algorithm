package workbook_0x0D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 사다리조작_15684 {
    static int N,M,H;
    static boolean[][] ladder = new boolean[32][12];
    static List<int[]> coords = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            ladder[r][c] = true;
        }
        for(int i =1 ; i <= H ; i++){
            for(int j = 1; j < N ; j++){
                if(ladder[i][j-1] || ladder[i][j] || (j < N-1 && ladder[i][j+1])) continue;
                coords.add(new int[] {i,j});
            }
        }
        if(check()){
            System.out.println(0);
            return;
        }
        int ans = Integer.MAX_VALUE;
        int size = coords.size();

        for(int i = 0 ; i < size ; i++){
            int[] cur = coords.get(i);
            ladder[cur[0]][cur[1]] = true;
            if(check()) ans = Math.min(ans, 1);
            for(int j = i +1 ; j < size ; j++){
                int[] cur2 = coords.get(j);
                ladder[cur2[0]][cur2[1]] = true;
                if(check()) ans = Math.min(ans, 2);
                for(int k = j+1; k < size ; k++){
                    int[] cur3 = coords.get(k);
                    ladder[cur3[0]][cur3[1]] = true;
                    if(check())ans = Math.min(ans,3);
                    ladder[cur3[0]][cur3[1]] = false;
                }
                ladder[cur2[0]][cur2[1]] = false;
            }
            ladder[cur[0]][cur[1]] = false;
        }
        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }

    private static boolean check() {
        for(int j = 1 ; j <= N ; j++){
            int cur = j;
            for(int i = 1; i <= H ; i ++){
                if(cur > 1 && ladder[i][cur-1]) cur--;
                else if(cur < N && ladder[i][cur])cur++;
            }
            if(cur != j) return false;
        }
        return true;
    }
}
