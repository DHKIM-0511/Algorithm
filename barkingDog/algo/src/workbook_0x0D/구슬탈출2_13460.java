package workbook_0x0D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 구슬탈출2_13460 {
    static int N,M;
    static Marble redMarble, blueMarble;
    static char[][] map = new char[11][11]; // . = 빈칸, # = 벽, O = 구멍, R = 빨간 구슬, B = 파란 구슬
    static int[][][][] dist = new int[11][11][11][11];
    static int[] dr = {0, 1, 0, -1}, dc = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                for (int k = 0; k < 11; k++) {
                    Arrays.fill(dist[i][j][k], -1);
                }
            }
        }

        for(int i = 0 ; i < N ; i++){
            map[i] = br.readLine().toCharArray();
            for(int j = 0 ; j < M ; j ++){
                if(map[i][j] == 'R'){
                    redMarble = new Marble(i,j);
                    map[i][j] = '.';
                }else if (map[i][j] == 'B'){
                    blueMarble = new Marble(i,j);
                    map[i][j] = '.';
                }
            }
        }
        System.out.println(bfs());
    }
    static private int bfs(){
        Queue<Marble[]> q = new LinkedList<>();
        q.offer(new Marble[]{redMarble, blueMarble});
        dist[redMarble.r][redMarble.c][blueMarble.r][blueMarble.c] = 0;

        while (!q.isEmpty()){
            Marble[] cur = q.poll();
            Marble red = cur[0], blue = cur[1];
            int cnt = dist[red.r][red.c][blue.r][blue.c];
            if(cnt >=10) return -1;

            for(int i = 0 ; i < 4; i++){
                int blueNr = blue.r, blueNc = blue.c;
                int redNr = red.r, redNc = red.c;

                while (map[blueNr+dr[i]][blueNc+dc[i]] == '.'){
                    blueNr += dr[i];
                    blueNc += dc[i];
                }
                if(map[blueNr+dr[i]][blueNc+dc[i]] == 'O') continue;

                while (map[redNr+dr[i]][redNc+dc[i]] == '.'){
                    redNr += dr[i];
                    redNc += dc[i];
                }
                if(map[redNr+dr[i]][redNc+dc[i]] == 'O') return cnt+1;

                if(redNr == blueNr && redNc == blueNc){
                    if(i == 0){
                        if(red.c < blue.c) redNc--;
                        else blueNc--;
                    }else if(i == 1){
                        if(red.r < blue.r) redNr--;
                        else blueNr--;
                    }else if(i == 2){
                        if(red.c < blue.c) blueNc++;
                        else redNc++;
                    }else {
                        if (red.r < blue.r) blueNr++;
                        else redNr++;
                    }
                }
                if(dist[redNr][redNc][blueNr][blueNc] != -1) continue;
                q.offer(new Marble[]{new Marble(redNr, redNc), new Marble(blueNr,blueNc)});
                dist[redNr][redNc][blueNr][blueNc] = cnt+1;
            }
        }
        return -1;
    }

    static class Marble{
        int r,c;
        public Marble(int r,int c){
            this.r=r;
            this.c=c;
        }
    }
}
