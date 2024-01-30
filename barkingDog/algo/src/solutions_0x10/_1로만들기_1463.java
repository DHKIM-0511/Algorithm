package solutions_0x10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1로만들기_1463 {
    static int N;
    static int[] memo = new int[1000005];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for(int i = 2; i <= N ; i++){
            memo[i] = memo[i-1]+1;
            if(i % 2 == 0) memo[i] = Math.min(memo[i],memo[i/2]+1);
            if(i % 3 == 0) memo[i] = Math.min(memo[i],memo[i/3]+1);
        }
        System.out.println(memo[N]);
    }
}
