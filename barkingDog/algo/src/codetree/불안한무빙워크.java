package codetree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 불안한무빙워크 {
    static Plate[] u,d;
    static int n, k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        u = new Plate[n];
        d = new Plate[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n ; i++){
            u[i] = new Plate(Integer.parseInt(st.nextToken()), false);
        }
        for(int i = 0 ; i < n ; i++){
            d[i] = new Plate(Integer.parseInt(st.nextToken()), false);
        }

        int turn = 0;
        while (!isFinish()) {
            // 무빙워크 회전
            rotate();

            // 사람 이동
            moveAll();

            // 사람 추가
            add();

            //내림처리
            if(u[n - 1].isUsed) move(n - 1);
            turn++;
        }
        System.out.println(turn);
    }

    private static void add() {
        // 안정성이 0보다 크고 사람이 없는 경우
        if(u[0].s > 0 && !u[0].isUsed) u[0] = new Plate(u[0].s - 1, true);
    }

    private static void moveAll() {
        for(int i = n - 1; i >= 0; i--) {
            if(u[i].isUsed && canGo(i + 1)){
                move(i);
            }
        }
    }

    private static void move(int idx) {
        u[idx] = new Plate(u[idx].s, false);

        // 밖이 아니면 다시 추가
        if(idx + 1 < n) {
            u[idx + 1] = new Plate(u[idx + 1].s - 1, true);
        }
    }

    private static boolean canGo(int idx) {
        if(idx == n) return true;

        // 안정성이 0보다 크면서 사람이 없는 경우에만
        // 이동이 가능합니다.
        return u[idx].s > 0 && !u[idx].isUsed;
    }

    private static void rotate() {
        Plate tmp = u[n-1];
        for(int i = n-1 ; i >= 1 ; i--){
            u[i] = u[i-1];
        }
        u[0] = d[n-1];
        for(int i = n-1 ; i >= 1 ; i--){
            d[i] = d[i-1];
        }
        d[0] = tmp;
    }

    static boolean isFinish() {
        int cnt = 0;
        for(int i = 0 ; i < n ; i++){
            if(u[i].s == 0) cnt++;
            if(d[i].s == 0) cnt++;
        }
        return cnt >= k;
    }
    static class Plate{
        int s;
        boolean isUsed;
        Plate(int s,boolean b){
            this.s=s;
            this.isUsed = b;
        }
    }
}
