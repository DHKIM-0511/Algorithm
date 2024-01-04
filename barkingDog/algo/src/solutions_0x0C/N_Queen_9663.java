package solutions_0x0C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class N_Queen_9663 {
    static int N,ans;
    static boolean[] isUsed1 = new boolean[30], isUsed2 = new boolean[30], isUsed3 = new boolean[30]; // 열, 상승 대각선, 하강 대각선
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        fnc(0);
        System.out.println(ans);
    }

    private static void fnc(int cnt) {
        if(cnt == N){
            ans++;
            return;
        }

        for(int i = 0 ; i < N ; i++){
            if(isUsed1[i] || isUsed2[i + cnt] || isUsed3[cnt - i + N - 1]) continue;

            isUsed1[i] = true;
            isUsed2[i+cnt] = true;
            isUsed3[cnt-i+N-1] = true;

            fnc(cnt+1);

            isUsed1[i] = false;
            isUsed2[i+cnt] = false;
            isUsed3[cnt-i+N-1] = false;
        }
    }
}
