package solutions_0x0C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 부분수열의합_1182 {
    static int N,S,ans;
    static int[] input;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        input = new int[N];

        int idx = 0;
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()){
            input[idx++] = Integer.parseInt(st.nextToken());
        }

        fnc(0,0);

        if(S==0)ans--;
        System.out.println(ans);
    }

    private static void fnc(int sum, int depth) {
        if(depth == N){
            if(sum==S) ans++;
            return;
        }

        fnc(sum + input[depth] , depth+1);
        fnc(sum, depth+1);
    }
}
