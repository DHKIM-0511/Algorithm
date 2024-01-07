package workbook_0x0D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
public class 뱀_3190 {
    static int N,K,L;
    static int[] dr = {0,1,0,-1}, dc = {1,0,-1,0};
    static int[][] map = new int[101][101];
    static int[][] apples = new int[101][2];
    static RotData[] rot = new RotData[101];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < K ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map[r-1][c-1] = 1;
        }

        L = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < L ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            char c = st.nextToken().charAt(0);
            rot[i] = new RotData(x,c);
        }
        Snake snake = new Snake(new LinkedList<>(),0);
        snake.body.add(new int[]{0,0});

        moveSnake(0,0, snake, 1);

    }

    private static void moveSnake(int time, int rotIdx, Snake snake, int l) {
        if(rotIdx < L && time == rot[rotIdx].x){
            rotate(snake, rot[rotIdx].c);
            rotIdx++;
        }
        int nr = snake.body.get(0)[0] + dr[snake.dir];
        int nc = snake.body.get(0)[1] + dc[snake.dir];

        if(nr < 0 || nr >= N || nc < 0 || nc >= N || check(snake,nr,nc)){
            System.out.println(time+1);
            return;
        }

        snake.body.add(0, new int[]{nr,nc});

        if(map[nr][nc] == 0){
            snake.body.remove(l);
            moveSnake(time+1, rotIdx, snake, l);
        }else{
            map[nr][nc] = 0; //사과 먹으면 치우기
            moveSnake(time+1, rotIdx,snake,l+1);
        }
    }

    private static boolean check(Snake snake,int r,int c) {
        for(int[] arr : snake.body){
            if(arr[0] == r && arr[1] == c)return true;
        }
        return false;
    }

    private static void rotate(Snake snake, char c) {
        if(c == 'L'){
            snake.dir = (snake.dir+3) % 4;
        }else{
            snake.dir = (snake.dir+1) % 4;
        }
    }
    static class Snake{
        List<int[]> body = new LinkedList<>();
        int dir;

        public Snake(List<int[]> body, int dir){
            this.body = body;
            this.dir = dir;
        }
    }
    static class RotData{
        int x;
        char c; // 왼쪽 L, 오른쪽 D
        public RotData(int x, char c){
            this.x=x;
            this.c=c;
        }
    }
}
