package workbook_0x0D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class PuyoPuyo_11559 {
    static char[][] map = new char[12][6];
    static int ans;
    static int[] dr ={-1,1,0,0}, dc ={0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 0 ; i < 12 ; i++){
            String input = br.readLine();
            map[i] = input.toCharArray();
        }

        while (true){
            if(check()){
                ans++;
            }else{
                break;
            }
        }

        System.out.println(ans);
    }

    private static boolean check() {
        List<Puyo> puyoList = new ArrayList<>();

        for(int i = 11 ; i >= 0 ; i--){
            for(int j = 0 ; j < 6 ; j++){
                if(map[i][j] == '.')continue;

                Queue<Puyo> q = new LinkedList<>();
                boolean[][] visited = new boolean[12][6];
                List<Puyo> checkPuyo = new ArrayList<>();

                char target = map[i][j];
                q.offer(new Puyo(i,j));
                visited[i][j] = true;
                checkPuyo.add(new Puyo(i,j));

                while (!q.isEmpty()){
                    Puyo cur = q.poll();
                                
                    for(int k = 0 ; k < 4; k++){
                        int nr = cur.r + dr[k];
                        int nc = cur.c + dc[k];
                        
                        if(nr < 0 || nr >= 12 || nc < 0 || nc >= 6 || visited[nr][nc]) continue;
                        if(map[nr][nc] == target){
                            Puyo nextPuyo = new Puyo(nr,nc);
                            q.offer(nextPuyo);
                            checkPuyo.add(nextPuyo);
                            visited[nr][nc] = true;
                        }
                    }
                }
                if(checkPuyo.size() >= 4){
                    for(Puyo p : checkPuyo) puyoList.add(p);
                }
            }
        }

        if(puyoList.size() >= 4){
            destroy(puyoList);
            return true;
        }
        return false;
    }

    private static void destroy(List<Puyo> puyoList) {
        Set<Integer> set = new HashSet<>();
        for(Puyo p : puyoList){
            map[p.r][p.c] = '.';
            set.add(p.c);
        }

        //중력
        for(int col : set){
            int idx = 11;
            char[] tmp = new char[12];
            Arrays.fill(tmp, '.');

            for(int i = 11 ; i >= 0  ; i--){
                if(map[i][col] == '.') continue;
                tmp[idx--] = map[i][col];
            }

            for(int i = 11 ; i >= 0  ; i--){
                map[i][col] = tmp[i];
            }
        }
    }

    static class Puyo{
        int r,c;
        public Puyo(int r, int c){
            this.r=r;
            this.c=c;
        }
    }
}
