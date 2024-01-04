package workbook_0x0C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 계란으로계란치기_16987 {
    static int N, ans;
    static Egg[] eggs;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        eggs = new Egg[N];

        StringTokenizer st;
        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            eggs[i] = new Egg(s,w);
        }

        breakEggs(0, 0);
        System.out.println(ans);
    }

    private static void breakEggs(int idx, int sum) {
        if(idx == N){
            ans = Math.max(ans, sum);
            return;
        }
        Egg cur = eggs[idx];

        if(cur.s <= 0 || sum == N - 1){
            breakEggs(idx+1, sum);
            return;
        }
        int cnt = sum;
        for(int i = 0 ; i < N ; i++){
            if( i == idx || eggs[i].s <= 0) continue;

            cur.hit(eggs[i]);

            if ( cur.s <= 0 ) sum++;
            if ( eggs[i].s <= 0 ) sum++;

            breakEggs(idx+1, sum);

            cur.back(eggs[i]);
            sum = cnt;
        }
    }

    static class Egg{
        int s,w;

        public Egg(int s, int w){
            this.s = s;
            this.w = w;
        }

        public void hit(Egg egg){
            this.s -= egg.w;
            egg.s -= this.w;
        }

        public void back(Egg egg){
            this.s += egg.w;
            egg.s += this.w;
        }
    }
}
