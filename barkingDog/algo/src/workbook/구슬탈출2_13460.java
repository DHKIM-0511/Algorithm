package workbook;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 구슬탈출2_13460 {
    static int n,m;
    static char[][] map;
    static Node blue, red;
    static int[][][][] visited;
    static int[] dr = {-1,1,0,0}, dc ={0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        map = new char[n][m];
        visited = new int[n][m][n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < n; k++) {
                    Arrays.fill(visited[i][j][k], -1);
                }
            }
        }

        for(int i = 0 ; i < n ; i++){
            String str = br.readLine();
            for(int j = 0 ; j < m ; j++){
                map[i][j] = str.charAt(j);
                if(map[i][j] == 'R'){
                    red = new Node(i,j);
                    map[i][j]='.';
                }
                else if(map[i][j] == 'B'){
                    blue = new Node(i,j);
                    map[i][j]='.';
                }
            }
        }
        bfs();
    }

    private static void bfs() {
        Queue<Node[]> q = new LinkedList<>();
        q.offer(new Node[] {red, blue});
        visited[red.r][red.c][blue.r][blue.c] = 0;
        int T = 0;
        while (!q.isEmpty()){
            Node[] cur = q.poll();
            Node curRed = cur[0];
            Node curBlue = cur[1];
            T = visited[curRed.r][curRed.c][curBlue.r][curBlue.c];
            if(T >= 10){
                System.out.println(-1);
                return;
            }
            //상하좌우 움직임
            for(int dir = 0 ; dir < 4; dir++){
                int blueNR = curBlue.r;
                int blueNC = curBlue.c;
                int redNR = curRed.r;
                int redNC = curRed.c;

                while (map[blueNR+dr[dir]][blueNC+dc[dir]] == '.'){
                    blueNR+= dr[dir];
                    blueNC+= dc[dir];
                }
                if(map[blueNR+dr[dir]][blueNC+dc[dir]] == 'O') continue;

                while (map[redNR+dr[dir]][redNC+dc[dir]] == '.'){
                    redNR+= dr[dir];
                    redNC+= dc[dir];
                }
                if(map[redNR+dr[dir]][redNC+dc[dir]] == 'O'){
                    System.out.println(T+1);
                    return;
                }
                //기존 위치고려
                if(blueNR == redNR && blueNC == redNC){
                    if(dir == 0){ // 상
                        if(curBlue.r < curRed.r) redNR++;
                        else blueNR++;
                    }else if (dir == 1){ // 하
                        if(curBlue.r > curRed.r) redNR--;
                        else blueNR--;
                    }else if(dir == 2){//좌
                        if(curBlue.c < curRed.c) redNC++;
                        else blueNC++;
                    }else {
                        if(curBlue.c > curRed.c)redNC--;
                        else blueNC--;
                    }
                }
                if(visited[redNR][redNC][blueNR][blueNC] != -1) continue;

                Node nextRed = new Node(redNR,redNC);
                Node nextBlue = new Node(blueNR,blueNC);
                q.offer(new Node[] {nextRed, nextBlue});
                visited[redNR][redNC][blueNR][blueNC] = T+1;

            }
        }
        System.out.println(-1);
    }
    static class Node{
        int r,c;
        Node(int r, int c){
            this.r =r;
            this.c =c;
        }
    }
}
