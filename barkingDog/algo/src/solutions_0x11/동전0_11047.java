package solutions_0x11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 동전0_11047 {
    static int N,K,ans;
    static int[] coin = new int[12];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);

        for(int i = 0 ; i < N ; i++){
            coin[i] = Integer.parseInt(br.readLine());
        }

        for(int i = N-1 ; i >= 0 ; i--){
            if(K/coin[i]< 1) continue;
            ans +=  K / coin[i];
            K %= coin[i] ;
        }
        System.out.println(ans);
    }
}
