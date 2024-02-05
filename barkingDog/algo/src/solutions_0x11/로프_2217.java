package solutions_0x11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class 로프_2217 {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        Integer[] w = new Integer[N];
        for(int i = 0 ; i < N ; i++){
            w[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(w, Collections.reverseOrder());
        int ans = 0;
        for(int i = 0 ; i < N ; i++){
            ans = Math.max(ans, w[i] * (i+1));
        }
        System.out.println(ans);
    }
}
