package workbook;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 뱀_3190 {
    static int n,k,l;
    static int[][] map;
    static HashMap<Integer, String> drive = new HashMap<>();
    static int[] dr = {-1,0,1,0} , dc ={0,1,0,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        map = new int[n+1][n+1];

        StringTokenizer st;
        for(int i = 0 ; i < k ; i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map[r][c] = 1;
        }

        l = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < l ; i++){
            st = new StringTokenizer(br.readLine());
            int sec = Integer.parseInt(st.nextToken());
            String dir = st.nextToken();

            drive.put(sec,dir);
        }
        map[1][1] = -1;
        Deque<int[]> snake = new LinkedList<>();
        snake.offer(new int[]{1,1});

        gameStart(snake,0, 1);
    }

    private static void gameStart(Deque<int[]> snake, int time, int dir) {
        if(drive.containsKey(time)){
            if(drive.get(time).equals("L")){
                dir += 3;
                dir %= 4;
            }else if (drive.get(time).equals("D")){
                dir++;
                dir %= 4;
            }
            drive.remove(time);
        }

        int[] headIdx = snake.getFirst();
        int nr = headIdx[0] + dr[dir];
        int nc = headIdx[1] + dc[dir];

        if(nr < 1 || nr > n || nc < 1 || nc > n || map[nr][nc] == -1){
            System.out.println(time+1);
            return;
        }

        if(map[nr][nc] == 1) {
            map[nr][nc] = -1;
            snake.offerFirst(new int[]{nr,nc});
            gameStart(snake,time+1,dir);
        }else {
            map[nr][nc] = -1;
            snake.offerFirst(new int[]{nr,nc});
            int[] tailIdx = snake.pollLast();
            map[tailIdx[0]][tailIdx[1]] = 0;
            gameStart(snake, time+1, dir);
        }
    }
}
